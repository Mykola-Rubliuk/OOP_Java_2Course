package labsheet2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        final double G = 6.67428E-11;
        double PI = 3.142;
        double periodOfRotation, secondsInDays, massOfSun;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the radius of the planet's orbit around the sun: ");
        double radius = scanner.nextDouble();

        System.out.print("Please enter the period of rotation for the planet in days: ");
        periodOfRotation = scanner.nextDouble();

        secondsInDays = periodOfRotation * 24 * 60 * 60;
        massOfSun = 4 * (Math.pow(PI, 2) * Math.pow(radius, 3)) / (G * (Math.pow(secondsInDays, 2)));
        System.out.printf("There are %.0f seconds in %.2f days\n", secondsInDays, periodOfRotation);
        System.out.printf("The approx mass of the sun is %.0f kg", massOfSun);


    }
}
