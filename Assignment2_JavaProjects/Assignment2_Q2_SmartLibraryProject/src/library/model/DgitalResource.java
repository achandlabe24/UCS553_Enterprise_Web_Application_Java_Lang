package library.model;
import library.service.Printable;

public class DigitalResource extends LibraryResource implements Printable {
    
    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0; // Rs. 2/day
    }

    @Override
    public void printDetails() {
        System.out.println("[Digital Resource]");
        printBaseDetails(); // Calling protected method from parent
    }
}
