package library.model;

public abstract class LibraryResource {
    // Private variables as requested
    private int resourceId;
    private String title;
    private String author;
    
    // Static variables for library name and object counting
    public static String libraryName = "Central Smart Library";
    private static int totalResources = 0;

    // Constructor
    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResources++; // Maintain static object counter
    }

    // Abstract method for fine calculation
    public abstract double calculateFine(int overdueDays);

    // Static method to display total resources created
    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + totalResources);
    }

    // Public getters to access private variables securely
    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    // Protected method used to share base printing logic with child classes
    protected void printBaseDetails() {
        System.out.println("ID: " + resourceId + " | Title: " + title + " | Author: " + author);
    }
}
