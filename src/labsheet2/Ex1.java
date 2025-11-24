package labsheet2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        double volOfBattery;
        int firstResistor, secondResistor;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the voltage of the battery: ");
        volOfBattery = scan.nextDouble();
        scan.nextLine();
        if (volOfBattery <= 0){
            System.out.println("Error! The voltage of the battery must be positive ... now quiting program");
            return;
        }

        System.out.print("\nPlease enter the resistance of the first resistor: ");
        firstResistor = scan.nextInt();
        scan.nextLine();

        System.out.print("Please enter the resistance of the second resistor: ");
        secondResistor = scan.nextInt();
        scan.nextLine();


        double totalElectrical = (volOfBattery * (firstResistor + secondResistor)) / (secondResistor * firstResistor);
        System.out.printf("The total current flowing in the circuit is %.0f Amps", totalElectrical);

    }
}
