package library.model;
import library.service.Printable;

public class Book extends LibraryResource implements Printable {
    
    public Book(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5.0; // Rs. 5/day
    }

    @Override
    public void printDetails() {
        System.out.println("[Book]");
        printBaseDetails(); // Calling protected method from parent
    }
}
