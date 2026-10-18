import java.util.Optional;

public class Q2_StudentEmailManager {
    public static void main(String[] args) {
        // 1. Create an Optional containing an email address
        Optional<String> emailOpt = Optional.of("student123@example.com");

        // 2. Create an empty Optional
        Optional<String> emptyEmailOpt = Optional.empty();

        // 3. Display the email using ifPresent()
        System.out.print("Displaying present email: ");
        emailOpt.ifPresent(email -> System.out.println(email));

        // 4. Use orElse() to provide a default email address if empty
        String resolvedEmail = emptyEmailOpt.orElse("default.student@example.com");
        System.out.println("Email using orElse(): " + resolvedEmail);

        // 5. Use orElseThrow() to handle a missing email value with an exception
        try {
            String missingEmail = emptyEmailOpt.orElseThrow(() -> 
                new IllegalStateException("Critical Error: Email address is missing!")
            );
            System.out.println(missingEmail);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}