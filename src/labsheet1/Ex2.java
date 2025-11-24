package labsheet1;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String formatLine = "*".repeat(25);

        float orbitalSpeed = 13.07367f;
        String planetName;
        int numOfMoons;

        System.out.print("Please enter the name of the planet: ");
        planetName = scanner.nextLine();
        System.out.print("Please enter the number of moons of the planet: ");
        numOfMoons = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\n\n");

        System.out.printf("%40s\n", formatLine);
        System.out.printf("%33s\n", "Planet data");
        System.out.printf("%40s\n\n", formatLine);

        System.out.printf("%-20s %s\n", "Planet name:", planetName);
        System.out.printf("%-20s %.3f %1s\n", "Orbital Speed:", orbitalSpeed, "km/s");
        System.out.printf("%-20s %d\n", "Number of Moons:", numOfMoons);
    }
}
