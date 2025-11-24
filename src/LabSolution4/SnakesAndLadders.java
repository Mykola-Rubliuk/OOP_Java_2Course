package LabSolution4;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class SnakesAndLadders {
    public static void main(String[] args) {
        String[] board = new String[100];
        String player1 = "Human";
        String player2 = "Computer";
        String winner = "";

        int humanPos = 0;
        int computerPos = 0;
        int round = 1;

        boolean gameOn = true;

        generateInitialBoard(board);
        displayBoard(board);

        JOptionPane.showMessageDialog(null,
                "On the game-board the human player will have the symbol ⏹ " +
                        "while the computer player will have the symbol ⏺");

        do {
            generateInitialBoard(board);

            String prevPos1 = board[humanPos];
            humanPos = diceRoll(player1, round, humanPos, board);
            board[humanPos] = "⏹";

            String prevPos2 = board[computerPos];
            computerPos = diceRoll(player2, round, computerPos, board);
            board[computerPos] = "⏺";

            displayBoard(board);

            board[humanPos] = prevPos1;
            board[computerPos] = prevPos2;

            if (humanPos >= board.length - 1) {
                winner = "human";
                gameOn = false;
            } else if (computerPos >= board.length - 1) {
                winner = "computer";
                gameOn = false;
            }

            round++;

        } while (gameOn);
        
        JOptionPane.showMessageDialog(null,
                "The winner is: " + winner,
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE);


    }

    public static void generateInitialBoard(String[] board) {
        Arrays.fill(board, "⬜");
        replaceSomeValues(board);
    }

    private static void replaceSomeValues(String[] board) {
        for (int i = 0; i < board.length; i++) {
            if (i == 8 || i == 20 || i == 23 || i == 28 || i == 31 || i == 42 || i == 53 || i == 60 || i == 67 || i == 74 || i == 81 || i == 86) {
                board[i - 1] = "⯆";
            }
            if (i == 12 || i == 17 || i == 24 || i == 34 || i == 39 || i == 51 || i == 58 || i == 69 || i == 76 || i == 85 || i == 90 || i == 93 || i == 99) {
                board[i - 1] = "⯅";
            }
        }
    }

    public static void displayBoard(String[] board) {
        JTextArea area = new JTextArea(11, 25);
        area.setFont(new Font("Monospaced", Font.PLAIN, 20));
        area.setLineWrap(true);

        for (int i = 0; i < board.length; i++) {
            if ((i != 0) && (i % 10) == 0) {
                area.append("\n");
            }
            area.append(board[i] + " ");
        }
        JOptionPane.showMessageDialog(null, area, "Game Board", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int diceRoll(String playerType, int round, int position, String[] board) {
        String messageDialog = "Round %d - %s's\n\nThrow the dice to generate a number between 2 and 12 inclusive";
        JOptionPane.showMessageDialog(null, String.format(messageDialog, round, playerType.toLowerCase()), "Dice Throw", JOptionPane.INFORMATION_MESSAGE);

        int dice = (int) (Math.random() * 10) + 2;
        JOptionPane.showMessageDialog(null, String.format("You rolled a %d", dice), "Result of Throw", JOptionPane.INFORMATION_MESSAGE);

        position += dice;
        if (position >= board.length) {
            position = board.length - 1;
        }

        while (board[position].equals("▼")) {
            JOptionPane.showMessageDialog(null, playerType + " hit a down-triangle at " + position + "!", "Info", JOptionPane.INFORMATION_MESSAGE);
            position += 10;
            if (position >= board.length) {
                position = board.length - 1;
                break;
            }
        }
        while (board[position].equals("⯅")) {
            JOptionPane.showMessageDialog(null, playerType + " hit a up-triangle at " + position + "!", "Info", JOptionPane.INFORMATION_MESSAGE);
            position -= 10;
            if (position >= board.length) {
                position = board.length - 1;
                break;
            }
        }

        return position;
    }
}