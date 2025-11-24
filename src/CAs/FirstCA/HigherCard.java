package CAs.FirstCA;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class HigherCard {
    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
//        int[] deck = {
//                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
//                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
//                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
//                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
//        };

        int[] shuffledDeck;

        int[] playerCards = new int[5];
        int[] computerCards = new int[5];
        int humanWins = 0, computerWins = 0;
        int humanHand, computerHand;
        int round = 1;

        do {
            Arrays.fill(playerCards, 0);
            Arrays.fill(computerCards, 0);
            int cards = 1;

            shuffledDeck = shuffleDeck(deck);

            dealInitHands(shuffledDeck, playerCards, computerCards);
            displayRankAndSuitHands(playerCards, computerCards, round);

            humanHand = handValue(playerCards);
            computerHand = handValue(computerCards);

            char winner = checkForWinnerRound(humanHand, computerHand);
            while (winner == 't') {
                JOptionPane.showMessageDialog(null, "New card added", "Extra card handed", JOptionPane.INFORMATION_MESSAGE);
                cards += 1;

                dealHands(shuffledDeck, playerCards, computerCards, cards);
                displayRankAndSuitHands(playerCards, computerCards, round);

                humanHand = handValue(playerCards);
                computerHand = handValue(computerCards);

                winner = checkForWinnerRound(humanHand, computerHand);

                if (cards == 5) {
                    JOptionPane.showMessageDialog(null, "Its DRAW", "INFO", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }

            }
            if (winner == 'c') computerWins++;
            if (winner == 'h') humanWins++;
            displayWinnerRound(winner, round, computerWins, humanWins);
            round++;

        } while (computerWins < 3 && humanWins < 3);

        char winner = checkForWinner(computerWins);
        displayWinner(winner);

    }

    private static void displayWinner(char winner) {
        if (winner == 'c') {
            JOptionPane.showMessageDialog(null, "Unlucky, Computer Win", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Congratulations, You Win", "Game Over", JOptionPane.INFORMATION_MESSAGE);


    }

    private static char checkForWinner(int computerWins) {
        if (computerWins == 3) return 'c';
        return 'h';
    }


    private static void displayWinnerRound(char winner, int round, int cW, int hW) {
        String stat = String.format("\n\nHuman's wins: %d\n\nComputer's wins: %d", hW, cW);
        if (winner == 'c')
            JOptionPane.showMessageDialog(null, "Computer player wins" + stat, String.format("Round %d Over!", round), JOptionPane.INFORMATION_MESSAGE);
        else if (winner == 'h')
            JOptionPane.showMessageDialog(null, "You win" + stat, String.format("Round %d Over!", round), JOptionPane.INFORMATION_MESSAGE);

    }

    private static char checkForWinnerRound(int humanHand, int computerHand) {
        if (humanHand > computerHand) return 'h';
        else if (humanHand < computerHand) {
            return 'c';
        }
        return 't';
    }

    private static int handValue(int[] deck) {
        int total = 0;
        int card;
        for (int j : deck) {
            if (j == 0) continue;
            card = (j - 1) % 13;
            if (card >= 1 && card <= 7) {
                total += card + 2;
            } else if (card >= 8 && card < 12) {
                total += 10;
            } else if (card == 12) {
                total += 11;
            }
        }
        return total;
    }

    private static void dealInitHands(int[] shuffleDeck, int[] playerCards, int[] computerCards) {
        for (int i = 0; i < 1; i++) {
            playerCards[i] = shuffleDeck[i];
            computerCards[i] = shuffleDeck[shuffleDeck.length - (i + 1)];

        }
    }

    private static void dealHands(int[] shuffleDeck, int[] playerCards, int[] computerCards, int cards) {
        for (int i = 1; i < cards; i++) {
            playerCards[i] = shuffleDeck[i];
            computerCards[i] = shuffleDeck[shuffleDeck.length - (i + 1)];

        }
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

    private static String mapNumericCardToRankAndSuitCard(int card) {
        char[] suitDeck = {'♡', '♢', '♣', '♠'};
        String[] numberDeck = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int suitIndex = (card - 1) / numberDeck.length;
        int numberIndex = (card - 1) % numberDeck.length;

        return suitDeck[suitIndex] + numberDeck[numberIndex];


    }

    private static JTextArea initialiseTextArea() {
        JTextArea textArea = new JTextArea(6, 5);
        textArea.setFont(new Font("Monospaced", Font.BOLD, 12));
        return textArea;
    }

    private static int[] shuffleDeck(int[] array) {
        int[] shuffleDeck = new int[52];
        boolean[] usedCard = new boolean[52];
        int count = 0;
        int index;

        while (count < 52) {
            index = (int) (Math.random() * array.length);
            if (!usedCard[index]) {
                usedCard[index] = true;
                shuffleDeck[count] = array[index];
                ++count;
            }
        }
        return shuffleDeck;
    }

    private static void displayNumericHands(int[] humanCards, int[] computerCards) {

        System.out.println("\n\nHuman Hand:   ");

        for (int humanCard : humanCards) {
            if (humanCard != 0) System.out.print(humanCard + "\t");
        }
        System.out.println("\n\nHuman Hand:   " + handValue(humanCards));

        System.out.println("\n\nComputer Hand:   ");

        for (int computerCard : computerCards) {
            if (computerCard != 0) System.out.print(computerCard + "\t");
        }
        System.out.println("\n\nComputer Hand:   " + handValue(computerCards));

    }

    private static void displayRankAndSuitHands(int[] humanCards, int[] computerCards, int round) {

        JTextArea textArea = initialiseTextArea();

        textArea.setText(String.format("Round %d\n\n", round));
        textArea.append(String.format("%-18s", "Human Hand:   "));

        for (int i = 0; i < humanCards.length && humanCards[i] != 0; i++) {
            textArea.append(String.format("%-4s", mapNumericCardToRankAndSuitCard(humanCards[i])));
        }

        textArea.append(String.format("\n\n%-18s", "Computer Hand:   "));

        for (int i = 0; i < computerCards.length && computerCards[i] != 0; i++) {
            textArea.append(String.format("%-4s", mapNumericCardToRankAndSuitCard(computerCards[i])));
        }

        JOptionPane.showMessageDialog(null, textArea);
    }


}
