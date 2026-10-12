package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.util.InputValidator;
import library.service.Printable;

public class Main {
    public static void main(String[] args) {
        // ii. store them in an array
        LibraryResource[] resources = new LibraryResource[5];

        // i. create at least five objects
        resources[0] = new Book(101, "Introduction to Algorithms", "Thomas H. Cormen");
        resources[1] = new Book(102, "Database System Concepts", "Abraham Silberschatz");
        resources[2] = new DigitalResource(103, "Advanced C++ Data Structures (E-Journal)", "Bjarne Stroustrup");
        resources[3] = new Book(104, "Operating System Principles", "Peter Galvin");
        resources[4] = new DigitalResource(105, "Data Science with R (PDF)", "Hadley Wickham");

        System.out.println("==============================================");
        System.out.println("   " + LibraryResource.libraryName + "   ");
        System.out.println("==============================================");
        
        LibraryResource.displayTotalResources();
        System.out.println("----------------------------------------------");

        double totalFineCollection = 0.0;
        
        // Simulating overdue days for each resource (0 means no fine)
        int[] overdueDaysPerResource = {4, 0, 7, -2, 2}; // -2 is included to test the validator

        // iii. display complete details and iv. calculate total fine
        for (int i = 0; i < resources.length; i++) {
            LibraryResource res = resources[i];
            int days = overdueDaysPerResource[i];

            if (InputValidator.validateResourceId(res.getResourceId())) {
                
                // Polymorphism: Checking interface implementation
                if (res instanceof Printable) {
                    ((Printable) res).printDetails();
                }
                
                if (InputValidator.validateFineDays(days)) {
                    double fine = res.calculateFine(days);
                    System.out.println("Overdue Days: " + days + " | Calculated Fine: Rs. " + fine);
                    totalFineCollection += fine;
                } else {
                    System.out.println("Notice: Invalid overdue days provided (" + days + "). Fine cannot be calculated.");
                }
                System.out.println("----------------------------------------------");
            }
        }
        
        System.out.println("TOTAL FINE TO COLLECT: Rs. " + totalFineCollection);
        System.out.println("==============================================");
    }
}
