package labsheet3;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        String number;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a  piece of text: ");
        number = scanner.nextLine();
        boolean isNumber = true;


        while (index <= number.length()-1) {
            char ch = number.charAt(index);
            if (!Character.isDigit(ch)) {
                isNumber = false;
                break;
            }
            index++;
        }
        if (isNumber) {
            System.out.println("\nYou entered a positive whole number");
        } else {
            System.out.println("\nYou did not enter a positive whole number");
        }
    }
}
