package labsheet1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        final float GAS = 8.3145F;
        Scanner scan = new Scanner(System.in);
        String equal = "=".repeat(7);

        System.out.println(equal + "Volume Calculator" + equal + "\n\n\n");

        System.out.print("PLease enter the temperature of the gas: ");
        float temperature = scan.nextFloat();
        scan.nextLine();

        System.out.print("Please enter thr number of the moles of thr gas: ");
        int moles = scan.nextInt();
        scan.nextLine();

        System.out.print("Please enter the pressure of the gas: ");
        float pressure = scan.nextFloat();
        scan.nextLine();

        char cube = (char) 179;
        float result;
        result = (moles * GAS * temperature) / pressure;
        System.out.printf("\nThe volume of the gas is %.3f m%s", result, cube);

    }

}
