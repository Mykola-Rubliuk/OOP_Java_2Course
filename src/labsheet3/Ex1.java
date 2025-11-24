package labsheet3;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        double fahrenheitTemp;
        Scanner scanner = new Scanner(System.in);
        String line = "=".repeat(40);
        String firstQuestion = "Please enter the first Fahrenheit temperature (below -459.67 to exit): ";
        String anotherQuestion = "Please enter another Fahrenheit temperature (below -459.67 to exit): ";
        String answer = "The equivalent Celsius temperature is %.2f";
        String info = "Program Results";
        int count = 0;
        double totalTemp = 0;
        int celsiusMore30 = 0, celsiusLess10 = 0;
        double celsiusMoreEqual20 = 0;
        System.out.print(firstQuestion);
        fahrenheitTemp = scanner.nextDouble();
        while (true) {
            if (fahrenheitTemp < -459.67) {
                System.out.println("No conversions were performed...Goodbye");
                break;
            }

            double celsiusTemp = fromFahrToCelc(fahrenheitTemp);

            if (celsiusTemp > 30) {
                celsiusMore30++;
            }
            if (celsiusTemp < 10) {
                celsiusLess10++;
            }
            if (celsiusTemp >= 20) {
                celsiusMoreEqual20++;
            }
            totalTemp += celsiusTemp;
            System.out.printf(answer, celsiusTemp);
            System.out.println();

            System.out.println(anotherQuestion);
            fahrenheitTemp = scanner.nextDouble();
            count++;
        }

        System.out.println(line + "\n\t\t" + info + "\n" + line);
        System.out.printf("Total conversions performed: %d\n", count);
        System.out.printf("Average Celsius temperatures: %.3fC\n", totalTemp / count);
        System.out.printf("Total Celsius temperature > 30C: %d\n", celsiusMore30);
        System.out.printf("Total Celsius temperature < 10C: %d\n", celsiusLess10);
        System.out.printf("Total Celsius temperature >= 20C: %.2f%%\n", celsiusMoreEqual20 / count * 100);

    }

    private static double fromFahrToCelc(double fahr) {
        return 5 / 9f * (fahr - 32);
    }

}
