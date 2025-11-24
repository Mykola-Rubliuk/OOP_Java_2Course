package labsheet4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What number do you wish to display the times-table for?");
        int num = scanner.nextInt();
        while (num <= 0 || num >= 13) {
            System.out.print("Invalid. You must enter a value from 1-12. Please re-enter:");
            num = scanner.nextInt();
        }
        System.out.printf("\n\n\n=====The %d times table=====\n", num);

        for (int i = 0; i <= 12; i++) {
            System.out.printf("%d times %d is %d\n", num, i, num * i);
        }

    }
}
