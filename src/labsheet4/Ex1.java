package labsheet4;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\t\t\t============Length Converter============");
            System.out.println("\t\t\t1.\tConvert Inches to Feet and Inches");
            System.out.println("\t\t\t2.\tConvert Metres to Feet ");
            System.out.println("\t\t\t3.\tQuit");
            System.out.print("\n\t\t\tPlease enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            while (!(choice >= 1 && choice <= 3)) {
                System.out.print("Invalid choice! Must be 1, 2 or 3. Please re-enter:");
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    int num;
                    System.out.print("Please enter a quantity in inches: ");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    while (num < 0) {
                        System.out.print("Invalid quantity! Must be at least zero. Please re-enter: ");
                        num = scanner.nextInt();
                        scanner.nextLine();
                    }
                    convertInchesToFeet(num);
                    break;
                case 2:
                    double num1;
                    System.out.print("Please enter a quantity in metres: ");
                    num1 = scanner.nextDouble();
                    scanner.nextLine();
                    convertMetresToFeet(num1);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void convertInchesToFeet(int inch) {
        int feet, inches;
        feet = inch / 12;
        inches = inch % 12;
        System.out.printf("\n%d inches is equivalent to %d feet %d inches\n\n\n", inch, feet, inches);
    }

    private static void convertMetresToFeet(double metres) {
        double feet;
        feet = metres * 3.281;
        System.out.printf("\n%.2f metres is equivalent to %.3f feet\n\n\n", metres, feet);
    }

}