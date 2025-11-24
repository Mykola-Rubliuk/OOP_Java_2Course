package labsheet4;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a piece of text: ");
        String binaryNumber = scanner.nextLine();

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '1' && binaryNumber.charAt(i) != '0') {
                System.out.println("You did not enter a binary number");
                return;
            }
        }
        System.out.println("Good");
    }
}
