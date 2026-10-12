import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long num = scanner.nextLong();

        int count = 0;
        // Use Math.abs to handle negative numbers properly
        long temp = Math.abs(num);

        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp /= 10;
                ++count;
            }
        }

        System.out.println("Number of digits in " + num + " is " + count);
        scanner.close();
    }
}