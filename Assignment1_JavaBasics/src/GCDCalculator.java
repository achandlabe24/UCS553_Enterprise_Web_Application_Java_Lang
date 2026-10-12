import java.util.Scanner;

public class GCDCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = scanner.nextInt();

        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is a factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }

        System.out.println("GCD of " + n1 + " and " + n2 + " is " + gcd);
        scanner.close();
    }
}