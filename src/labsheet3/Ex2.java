package labsheet3;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sentence terminated with a full_stop or exclamation mark: ");
        String line = scanner.nextLine();
        int index = 0;
        int characters = 0, specialSymbols = 0, vowels = 0, digits = 0, oddDigits = 0, timesConsecutively = 0, len;
        char prevCh;
        String decorLine = "=".repeat(40);
        while (index <= line.length() - 1) {
            char ch = line.charAt(index);
            if (index >= 1) {
                prevCh = line.charAt(index - 1);
                if (prevCh == ch) timesConsecutively++;
            }

            if (ch == '!' || ch == '.') specialSymbols++;

            if (ch == 'a' || ch == 'o' || ch == 'i' || ch == 'u' || ch == 'e') vowels++;

            if (Character.isDigit(ch)) {
                digits++;
                if (ch % 2 == 1) oddDigits++;
            }
            index++;
        }
        len = line.length() - specialSymbols;
        System.out.println(specialSymbols);
        System.out.println(decorLine + "\n\t\t" + "Sentence Analysis" + "\n" + decorLine);
        System.out.println();
        System.out.println("Total characters: " + len);
        System.out.println("Total vowels: " + vowels);
        System.out.println("Total digits: " + digits);
        System.out.println("Total odd number character: " + oddDigits);
        System.out.println("Times a character appears consecutively: " + timesConsecutively);


    }
}
