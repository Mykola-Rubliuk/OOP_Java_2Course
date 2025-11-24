package labsheet2;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        System.out.print("Please enter a single keyboard character: ");
        line = scanner.nextLine();

        if (line.length() != 1) {
            System.out.print("Error! The value entered must contain exactly one character");
            return;
        }
        char ch = line.charAt(0);
        if (Character.isUpperCase(ch)) {
            System.out.println("The character is uppercase.");
        } else if (Character.isLowerCase(ch)) {
            System.out.println("The character is lowercase.");
        } else if (Character.isDigit(ch)) {
            System.out.println("The character is a digit.");
        } else if (ch == '£' || ch == '$' || ch == '€') {
            System.out.println("The character is a currency symbol.");
        } else if (ch == '"' || ch == '\'' || ch == '!' || ch == '?' || ch == '.' ||
                ch == ',' || ch == ':' || ch == ';') {
            System.out.println("The character is a punctuation symbol.");
        } else if (ch == '\n' || ch == '\t' || Character.isWhitespace(ch)) {
            System.out.println("The character is a whitespace character.");
        } else {
            System.out.println("The character is unidentified.");
        }

    }
}
