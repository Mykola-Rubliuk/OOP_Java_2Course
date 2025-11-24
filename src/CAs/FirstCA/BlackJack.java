package CAs.FirstCA;

import javax.swing.*;
import java.awt.*;

public class BlackJack {
    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
        int[] shuffledDeck = shuffleDeck(deck);

        int[] humanCards = new int[9];
        int[] computerCards = new int[9];

        int humanCardCount = 2;
        int computerCardCount = 2;
        int cardsDealt = 4;

        displayNumericDeck(shuffledDeck);
        displayRankAndSuitCards(shuffledDeck);
        dealInitialHands(shuffledDeck, humanCards, computerCards);

        while (true) {
            char winner = checkForWinner(humanCards, computerCards);
            if (winner != 'n') {
                displayWinner(winner);
                break;
            }

            int option = JOptionPane.showConfirmDialog(null, "Would you like to stick?", "Select an Option", JOptionPane.YES_NO_OPTION);

            while (option == JOptionPane.CLOSED_OPTION) {
                option = JOptionPane.showConfirmDialog(null, "You must make a choice! Would you like to stick?", "Select an Option", JOptionPane.YES_NO_OPTION);
            }

            if (option == JOptionPane.YES_OPTION) {
                break;
            } else if (option == JOptionPane.NO_OPTION) {
                humanCards[humanCardCount] = shuffledDeck[cardsDealt];
                humanCardCount++;
                cardsDealt++;
            }

            displayRankAndSuitHands(humanCards, computerCards);

            winner = checkForWinner(humanCards, computerCards);
            if (winner != 'n') {
                displayWinner(winner);
                break;
            }

            int humanValue = handValue(humanCards);
            int computerValue = handValue(computerCards);

            while (computerValue <= humanValue && computerValue < 20) {
                computerCards[computerCardCount] = shuffledDeck[cardsDealt];
                computerCardCount++;
                cardsDealt++;
                JOptionPane.showMessageDialog(null, "Computer drew a card.", "Computer Turn", JOptionPane.INFORMATION_MESSAGE);
                computerValue = handValue(computerCards);
            }

            displayRankAndSuitHands(humanCards, computerCards);

            // Проверка победителя после хода компьютера
            winner = checkForWinner(humanCards, computerCards);
            if (winner != 'n') {
                displayWinner(winner);
                break;
            }
        }
    }


    private static int[] shuffleDeck(int[] array) {
        int[] tempArray = new int[52];
        boolean[] alreadyPicked = new boolean[53];
        int count = 0;
        int card;


        while (count < 52) {
            card = (int) (Math.random() * 52);
            if (!alreadyPicked[card]) {
                alreadyPicked[card] = true;
                tempArray[count] = array[card];
                count++;
            }
        }
        return tempArray;
    }

    private static void displayRankAndSuitHands(int[] humanCards, int[] computerCards) {
        JTextArea textArea = initialiseTextArea();
        textArea.append(String.format("%-18s", "Human Hand: "));
        for (int i = 0; i < humanCards.length && humanCards[i] != 0; i++) {
            textArea.append(String.format("%-4s", mapNumericCardToRankAndSuitCard(humanCards[i])));
        }
        textArea.append(String.format("\n\n%-18s", "Computer Hand: "));
        for (int i = 0; i < computerCards.length && computerCards[i] != 0; i++) {
            textArea.append(String.format("%-4s", mapNumericCardToRankAndSuitCard(computerCards[i])));
        }
        JOptionPane.showMessageDialog(null, textArea);
    }

    private static String mapNumericCardToRankAndSuitCard(int card) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"♡", "♢", "♣", "♠"};
        int suitIndex = ((card - 1) / 13);
        int rankIndex = ((card - 1) % 13);

        return ranks[rankIndex] + suits[suitIndex];

    }


    private static void displayNumericHands(int[] humanCards, int[] computerCards) {
        System.out.println("\n\nHuman Hand: ");
        for (int humanCard : humanCards) {
            if (humanCard != 0) System.out.print(humanCard + "\t");
        }
        System.out.println("Hand value " + handValue(humanCards));
        System.out.println("\n\nComputer Hand: ");
        for (int i = 0; i < humanCards.length; i++) {
            if (computerCards[i] != 0) System.out.print(computerCards[i] + "\t");
        }
        System.out.println("Hand value " + handValue(computerCards));
    }

    private static void displayNumericDeck(int[] shuffledDeck) {
        System.out.println("Shuffled numeric deck values:");
        for (int j : shuffledDeck) System.out.print(j + " ");
    }

    private static JTextArea initialiseTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
        return textArea;
    }

    private static void displayRankAndSuitCards(int[] cards) {
        JTextArea textArea = initialiseTextArea();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != 0) {
                textArea.append(String.format("%-4s", mapNumericCardToRankAndSuitCard(cards[i])));
                if ((i + 1) % 13 == 0 && i != cards.length - 1) textArea.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, textArea);
    }

    private static char checkForWinner(int[] humanCards, int[] computerCards) {
        int humanHand = handValue(humanCards);
        int computerHand = handValue(computerCards);

        if (humanHand > 21 && computerHand > 21) {
            return 't'; // оба перебрали → ничья
        } else if (humanHand > 21) {
            return 'c'; // человек перебрал
        } else if (computerHand > 21) {
            return 'h'; // компьютер перебрал
        }

        if ((humanHand == 20 && computerHand == 20) || (humanHand == 21 && computerHand == 21)) {
            return 't';
        }
        if (computerHand == 21) {
            return 'c';
        } else if (humanHand == 21) {
            return 'h';
        }


        return 'n';
    }

    private static void displayWinner(char winner) {
        if (winner == 'c')
            JOptionPane.showMessageDialog(null, "You are busted! Computer player wins", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        else if (winner == 'h')
            JOptionPane.showMessageDialog(null, "Computer player is busted! You win", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        else if (winner == 't')
            JOptionPane.showMessageDialog(null, "Game was tied. Both players had 20 or 21!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);

    }

    private static int handValue(int[] cards) {
        int total = 0;
        for (int j : cards) {
            if (j == 0) break; // пустой слот в массиве
            int rank = (j - 1) % 13; // 0–12: 2–A

            if (rank >= 0 && rank <= 8) {       // 2–10
                total += rank + 2;
            } else if (rank >= 9 && rank <= 11) { // J, Q, K
                total += 10;
            } else if (rank == 12) {           // A
                total += 11;
            }
        }
        return total;
    }


    private static void dealInitialHands(int[] shuffledDeck, int[] humanCards, int[] computerCards) {
        for (int i = 0; i < 2; i++) {
            humanCards[i] = shuffledDeck[i];
            computerCards[i] = shuffledDeck[i + 2];
        }

        displayNumericHands(humanCards, computerCards);
        displayRankAndSuitHands(humanCards, computerCards);
    }
}