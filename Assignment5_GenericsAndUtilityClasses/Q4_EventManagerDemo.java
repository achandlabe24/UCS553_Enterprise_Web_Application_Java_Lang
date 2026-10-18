import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

class Event {
    private String eventName;
    private LocalDate eventDate;
    private LocalTime startTime;
    private Optional<String> venueName; // 6. Optional venue name

    public Event(String eventName, LocalDate eventDate, LocalTime startTime, String venue) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.venueName = Optional.ofNullable(venue);
    }

    public void displayEventDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        
        // 5. Calculate event's end time if it lasts for two hours
        LocalTime endTime = startTime.plusHours(2);
        System.out.println("End Time (2 hours duration): " + endTime);

        // 6. Display venue or fallback message
        System.out.println("Venue: " + venueName.orElse("Venue not specified"));

        // 3. Check whether the event date is in the future, today, or in the past
        LocalDate today = LocalDate.now();
        if (eventDate.isEqual(today)) {
            System.out.println("Status: The event is today!");
        } else if (eventDate.isAfter(today)) {
            // 4. Calculate number of days remaining until the event
            long daysRemaining = ChronoUnit.DAYS.between(today, eventDate);
            System.out.println("Status: Event is upcoming. Days remaining: " + daysRemaining);
        } else {
            System.out.println("Status: The event date has already passed.");
        }
    }
}

public class Q4_EventManagerDemo {
    public static void main(String[] args) {
        // Test with a future date and a specified venue
        Event futureEvent = new Event("Java Concurrency Seminar", LocalDate.now().plusDays(4), LocalTime.of(14, 0), "Auditorium B");
        System.out.println("--- Event 1 Details ---");
        futureEvent.displayEventDetails();

        System.out.println();

        // Test with a missing venue
        Event venueLessEvent = new Event("Coding Hackathon", LocalDate.now().plusDays(10), LocalTime.of(9, 30), null);
        System.out.println("--- Event 2 Details ---");
        venueLessEvent.displayEventDetails();
    }
}