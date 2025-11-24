package labsheet2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        double timeAmount;
        double totalMoney = 0;
        Scanner scanner = new Scanner(System.in);
        String decorLine = "=".repeat(38);

        System.out.println(decorLine + "\n\t\tCar Park Calculator\n" + decorLine);
        System.out.println();

        System.out.print("Please enter the amount of time in hours you spent parking: ");
        timeAmount = scanner.nextDouble();

        if (timeAmount <= 0) {
            System.out.println("Error: you have entered an invalid time value ... exiting program");
            return;
        }

        if (timeAmount > 0) {
            totalMoney += Math.min(timeAmount, 1) * 60;
        }
        if (timeAmount > 1) {
            totalMoney += Math.min(timeAmount - 1, 2) * 50;
        }

        if (timeAmount > 3) {
            totalMoney += Math.min(timeAmount - 3, 3) * 40;
        }

        System.out.printf("Total cost of parking for %.2f hours is $%.2f\n", timeAmount, totalMoney / 100);
    }
}
