package labsheet1;

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final BigDecimal G = new BigDecimal("9.81");

        System.out.print("Please enter the mass of planet Earth: ");
        BigInteger mass1 = new BigInteger(scanner.nextLine());

        System.out.print("Please enter the radius of planet Earth: ");
        BigInteger radius1 = new BigInteger(scanner.nextLine());

        System.out.print("Please enter the mass of the other planet: ");
        BigInteger mass2 = new BigInteger(scanner.nextLine());

        System.out.print("Please enter the radius of the other planet: ");
        BigInteger radius2 = new BigInteger(scanner.nextLine());

        // Преобразуем BigInteger в BigDecimal для вычислений
        BigDecimal m1 = new BigDecimal(mass1);
        BigDecimal r1 = new BigDecimal(radius1);
        BigDecimal m2 = new BigDecimal(mass2);
        BigDecimal r2 = new BigDecimal(radius2);

        // Вычисляем ускорение
        BigDecimal numerator = G.multiply(m1).multiply(r1).multiply(r1);
        BigDecimal denominator = m2.multiply(r2).multiply(r2);
        BigDecimal acceleration = numerator.divide(denominator, 5, BigDecimal.ROUND_HALF_UP);

        System.out.printf("\n\nThe acceleration due to gravity on the other planet is %.5f m/s²", acceleration);
    }
}
