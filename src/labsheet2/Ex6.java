package labsheet2;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        int fiveDigit;
        int choice;
        Scanner scanner = new Scanner(System.in);
        double resultDouble;

        System.out.print("Please enter a 5-digit positive whole number: ");
        fiveDigit = scanner.nextInt();
        if (fiveDigit < 10_000 || fiveDigit > 99_999) {
            System.out.println("You have entered a valid 5 digit number... exiting the program");
            return;
        }
        System.out.println("\n\n\n\t1.Determine 1.25% of the number");
        System.out.println("\t1.Determine if the number exceeds 50_000 and contains all the same digits");
        System.out.println("\t1.Determine if the number os odd or even");
        System.out.println("\t1.Determine the first digit in the number");

        System.out.print("Please enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                resultDouble = fiveDigit * 0.0125;
                System.out.printf("1.25%% of the number is %.0f", resultDouble);
                break;
            case 2:
                if (fiveDigit > 50_000) {
                    if (String.valueOf(fiveDigit).charAt(0) == String.valueOf(fiveDigit).charAt(4) &&
                            String.valueOf(fiveDigit).charAt(1) == String.valueOf(fiveDigit).charAt(3) &&
                            String.valueOf(fiveDigit).charAt(3) == String.valueOf(fiveDigit).charAt(4)) {
                        System.out.println("The number you entered does exceeds 50_000 and contains all the same digits");
                    } else {
                        System.out.println("The number you entered does not exceeds 50_000 and contains all the same digits");
                    }
                }
                break;
            case 3:
                if ((fiveDigit % 2f) == 1) {
                    System.out.println("The number you entered is odd");
                } else {
                    System.out.println("The number you entered is even");
                }
                break;
            case 4:
                System.out.printf("The first digit in the number is %s", String.valueOf(fiveDigit).charAt(0));
                break;
            default:
                System.out.println("Error");
                break;
        }

    }
}
