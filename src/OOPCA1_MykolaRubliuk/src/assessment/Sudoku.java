/*This program simulates a simplified Sudoku game
 * Our goal to fill all empty cells with correct values, which program validates
 * When all empty cells are filled, program displays that puzzle completed*/

package OOPCA1_MykolaRubliuk.src.assessment;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static javax.swing.JOptionPane.showMessageDialog;

public class Sudoku {
    public static void main(String[] args) {
        int[] solution = {
                4, 3, 5, 2, 6, 9, 7, 8, 1,
                6, 8, 2, 5, 7, 1, 4, 9, 3,
                1, 9, 7, 8, 3, 4, 5, 6, 2,
                8, 2, 6, 1, 9, 5, 3, 4, 7,
                3, 7, 4, 6, 8, 2, 9, 1, 5,
                9, 5, 1, 7, 4, 3, 6, 2, 8,
                5, 1, 9, 3, 2, 6, 8, 7, 4,
                2, 4, 8, 9, 5, 7, 1, 3, 6,
                7, 6, 3, 4, 1, 8, 2, 5, 9
        }; //ready grid
        int round = 36; // number of digits given to the player
        String[] grid = new String[81];
        generateInitialGrid(grid);
        do {
            displayGrid(grid);

            String guess = JOptionPane.showInputDialog(null, """
                    Please enter your guess in the form CR N where
                    
                    
                    C is thw column value, from A to I
                    R is the column value, from 1 to 9
                    N is the number value, from 1 to 9
                    """);
            String infoMsg = isValidGuess(guess, solution, grid);
            while (!infoMsg.equalsIgnoreCase("valid")) {
                guess = JOptionPane.showInputDialog(null,
                        infoMsg +
                                "\n\nPlease enter your guess in the form CR N where\n\n\n" +
                                "C is thw column value, from A to I\n" +
                                "R is the column value, from 1 to 9\n" +
                                "N is the number value, from 1 to 9\n");
                infoMsg = isValidGuess(guess, solution, grid);
            }
            round++; // incremented each time a valid guess
            if (round == 81) {
                displayGrid(grid);
                showMessageDialog(
                        null,
                        "Congratulations, you have completed the puzzle!");
                System.exit(1);
                // or just break;
            }
        } while (true); //infinity loop; if puzzle complete, the program will terminate

    }

    private static void displayGrid(String[] grid) {
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Courier New", Font.BOLD, 20));
        for (int i = 0; i < grid.length; i++) {
            textArea.append(String.format("%-3s", grid[i]));
            if ((i + 1) % 9 == 0) {
                textArea.append("\n\n");
            }
        }
        showMessageDialog(null, textArea, "Sudoku Game", JOptionPane.INFORMATION_MESSAGE);

    }

    private static String isValidGuess(String playerGuess, int[] solution, String[] grid) {
        String errorMsg = "Invalid input! ";
        if (playerGuess == null) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want close this program?", "Exit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for using this program. Bye");
                System.exit(1);
            }
            // if user want to terminate program before completing puzzle
        }
        if (playerGuess == null || playerGuess.length() != 4) {
            return errorMsg + "The input must have exactly 4 characters";
        }
        char column = playerGuess.charAt(0); //first element
        if (!(Character.toLowerCase(column) >= 'a' && Character.toLowerCase(column) <= 'i')) {
            return errorMsg + "The column name must be between A and I inclusive";
        }

        int row = playerGuess.charAt(1); //second element
        if (!(row >= '1' && row <= '9')) {
            return errorMsg + "The row value must be between 1 and 9 inclusive";
        }
        char thirdChar = playerGuess.charAt(2); //third element
        if (!Character.isSpaceChar(thirdChar)) {
            return errorMsg + "The 3rd character must be a space";
        }
        char number = playerGuess.charAt(3); //4-th element
        if (!(number >= '1' && number <= '9')) {
            return errorMsg + "The number value must be between 1 and 9 inclusive";
        }

        int cellIndex = (Character.getNumericValue(Character.toLowerCase(column)) - 10) * 9 + Character.getNumericValue(row) - 1;
        //because arrays start from 0, not 1, so we need to make indexing correct
        // a = 11, so (11-10) equal to 0 row in array

        String squareBox = "⬜";
        if (!grid[cellIndex].equals(squareBox)) {
            return errorMsg + "The grid already has a number in this cell";
        }

        int numInCell = solution[cellIndex]; //number in cell[index] from solution array
        if (Character.getNumericValue(number) != numInCell) {
            return errorMsg + "The number you entered is incorrect";
        }
        grid[cellIndex] = String.valueOf(number); // if everything is fine, program modifies the grid array

        return "valid";
    }

    private static void generateInitialGrid(String[] grid) {
        String squareBox = "⬜";
        /*
        for (int i = 0; i < grid.length; i++) {
            grid[i] = squareBox;
        }
        */ // the same code as in line 130
        Arrays.fill(grid, squareBox); //look shorter and clearly
        grid[3] = "2";
        grid[4] = "6";
        grid[6] = "7";
        grid[8] = "1";
        grid[9] = "6";
        grid[10] = "8";
        grid[13] = "7";
        grid[16] = "9";
        grid[18] = "1";
        grid[19] = "9";
        grid[23] = "4";
        grid[24] = "5";
        grid[27] = "8";
        grid[28] = "2";
        grid[30] = "1";
        grid[34] = "4";
        grid[38] = "4";
        grid[39] = "6";
        grid[41] = "2";
        grid[42] = "9";
        grid[46] = "5";
        grid[50] = "3";
        grid[52] = "2";
        grid[53] = "8";
        grid[56] = "9";
        grid[57] = "3";
        grid[61] = "7";
        grid[62] = "4";
        grid[64] = "4";
        grid[67] = "5";
        grid[70] = "3";
        grid[71] = "6";
        grid[72] = "7";
        grid[74] = "3";
        grid[76] = "1";
        grid[77] = "8";
    }
}
