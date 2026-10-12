import java.util.Scanner;

public class NumberReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        long num = scanner.nextLong();

        long reversed = 0;
        long temp = num;

        while (temp != 0) {
            long digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.println("Reversed Number: " + reversed);
        scanner.close();
    }
}