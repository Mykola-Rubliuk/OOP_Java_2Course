package labsheet2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        final double ratePerLitre = 0.224;
        final int freeAllowLitre = 30_000;
        final double annualFee = 212.00;
        char waterSupplyAnswer, septicTankAnswer, waterMeterAnswer;
        int numberOfLitres;
        double annualBill = 0.00;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you have a private water supply (y or n)?: ");
        waterSupplyAnswer = scanner.nextLine().charAt(0);

        System.out.print("Do you have a septic tank (y or n)?: ");
        septicTankAnswer = scanner.nextLine().charAt(0);

        if (septicTankAnswer == 'y' && waterSupplyAnswer == 'y') {
            System.out.print("You are not a customer of Irish Water so your bill is $0.00");
            return;
        }
        System.out.print("Do you have a water meter installed (y or no)?: ");
        waterMeterAnswer = scanner.nextLine().charAt(0);
        if (waterMeterAnswer == 'y') {
            System.out.print("Please enter the number of litres used last year: ");
            numberOfLitres = scanner.nextInt();
            if (numberOfLitres > freeAllowLitre) {
                numberOfLitres = -freeAllowLitre;
                annualBill = numberOfLitres * ratePerLitre / 100;
                System.out.printf("Your Annual Bill for Irish Water services is €%.2f", annualBill);
            } else {
                System.out.printf("Your Annual Bill for Irish Water services is €%.2f", annualBill);
            }
        } else {
            System.out.printf("Your Annual Bill for Irish Water services is €%.2f", annualFee);
        }

    }
}
