package labsheet5;

import javax.swing.JOptionPane;

public class Ex3 {
    public static void main(String[] args) {
        int gamesPlayed = 0, computerWin = 0, playerWin = 0, draw = 0;
        String statsMessage = String.format("""
                Games played: %d
                Computer Wins: %d
                Player Wins: %d
                Draws: %d
                """, gamesPlayed, computerWin, playerWin, draw);
        String result = JOptionPane.showInputDialog(null, "Would you like to play a game of the roll the dice? (yes or no)");
        while (result.equalsIgnoreCase("yes")) {
            gamesPlayed++;
            char winner = rollTheDice();
            if (winner == 'c') {
                computerWin++;
            } else if (winner == 'p') {
                playerWin++;
            } else {
                draw++;
            }
            JOptionPane.showMessageDialog(null, statsMessage, "Game Info", JOptionPane.INFORMATION_MESSAGE);

            result = JOptionPane.showInputDialog(null, "Would you like to play a game of the roll the dice? (yes or no)");

        }
        JOptionPane.showMessageDialog(null, "Thanks for playing the game!", "Farewell", JOptionPane.INFORMATION_MESSAGE);


    }


    private static char rollTheDice() {
        int computerRoll, playerRoll;
        computerRoll = (int) (Math.random() * 11) + 2;
        playerRoll = (int) (Math.random() * 11) + 2;
        JOptionPane.showMessageDialog(
                null,
                String.format("The computer roll generated the value %d\n" + "... now hit return to see the player roll", computerRoll), "Computer Roll", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                String.format("The player roll generated the value %d\n", playerRoll), "Player Roll", JOptionPane.INFORMATION_MESSAGE);

        if (computerRoll > playerRoll) {
            return 'c';
        } else if (computerRoll < playerRoll) {
            return 'p';
        }
        return 'd';
    }
}
