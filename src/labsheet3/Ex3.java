package labsheet3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your line of text: ");
        String line = scanner.nextLine();
        String decorLine = "=".repeat(50);
        String info = "Lexical Analysis of Your Text";
        int len = line.length(), letters = 0, digits = 0, words = 0,
                sentences = 0, punctuationSymbols = 0;


        int index = 0;
        while (index <= line.length() - 1) {
            char ch = line.charAt(index);
            if (Character.isDigit(ch)) {
                digits++;
            }
            if (Character.isAlphabetic(ch)) {
                letters++;
            }
            if (ch == '"' || ch == '\'' || ch == '!' || ch == '?' || ch == '.' ||
                    ch == ',' || ch == ':' || ch == ';' || Character.isSpaceChar(ch)) {
                punctuationSymbols++;
            }
            if (ch == '.' || ch == '!' || ch == '?') {
                sentences++;
            }
            if (Character.isSpaceChar(ch) || ch == '\'') {
                words++;
            }
            index++;
        }
        System.out.println();
        System.out.println(decorLine + "\n\t\t" + info + "\n" + decorLine);
        System.out.printf("Characters: %d\n", len);
        System.out.printf("Letters: %d\n", letters);
        System.out.printf("Digits: %d\n", digits);
        System.out.printf("Words: %d\n", words);
        System.out.printf("Sentences: %d\n", sentences);
        System.out.printf("Punctuation symbols: %d", punctuationSymbols);

    }
}
