package labsheet1;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String firstInvestor, secondInvestor;
        int firstPurchased, secondPurchased;
        float firstPrice, secondPrice;

        String formatLine = "=".repeat(30);
        String info = "Investment Details";

        System.out.print("PLease enter the type of the first investment: ");
        firstInvestor = scanner.nextLine();
        System.out.print("Please enter the number of shares purchased: ");
        firstPurchased = scanner.nextInt();
        System.out.print("Please enter the share price: ");
        firstPrice = scanner.nextFloat();
        System.out.print("\n\n");
        scanner.nextLine();


        System.out.print("PLease enter the type of the second investment: ");
        secondInvestor = scanner.nextLine();
        System.out.print("Please enter the number of shares purchased: ");
        secondPurchased = scanner.nextInt();
        System.out.print("Please enter the share price: ");
        secondPrice = scanner.nextFloat();

        System.out.printf("\n\n\n%50s\n%45s\n%50s\n\n", formatLine, info, formatLine);

        System.out.printf("%-20s%-15s%s\n", "Investment Type", "Shares", "Share Price");
        System.out.printf("%-20s%-15s%s\n", "---------------", "------", "-----------");
        System.out.printf("%-20s%-15s%s\n", firstInvestor , firstPurchased, firstPrice);
        System.out.printf("%-20s%-15s%s\n",  secondInvestor , secondPurchased, secondPrice);

    }
}
