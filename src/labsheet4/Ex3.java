package labsheet4;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        int maxInt;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the upper limit: ");
        maxInt = scanner.nextInt();
        System.out.println("The sum of the first 20 positive integers is " + sumOf20Int(maxInt));

    }

    private static int sumOf20Int(int maxInt) {
        int sum = 0;
        for (int i = 1; i <= maxInt; i++) {
            sum += i;
        }
        return sum;
    }
}
