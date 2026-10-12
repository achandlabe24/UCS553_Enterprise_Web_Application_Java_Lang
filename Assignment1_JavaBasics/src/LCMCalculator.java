import java.util.Scanner;

public class LCMCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = scanner.nextInt();

        // LCM is always greater than or equal to the largest of the two numbers
        int lcm = (n1 > n2) ? n1 : n2;

        while (true) {
            if (lcm % n1 == 0 && lcm % n2 == 0) {
                System.out.println("LCM of " + n1 + " and " + n2 + " is " + lcm);
                break;
            }
            ++lcm;
        }

        scanner.close();
    }
}