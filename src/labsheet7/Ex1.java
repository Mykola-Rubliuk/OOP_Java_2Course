package labsheet7;

import javax.swing.*;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int[] first5Numbers = new int[5];
        int[] luckyStars = new int[2];
        boolean[] alreadyPickedFirst5 = new boolean[51];
        boolean[] alreadyPickedLuckyStars = new boolean[13];
        generateFirst5Numbers(first5Numbers, alreadyPickedFirst5);
        generate2LuckyStars(luckyStars, alreadyPickedLuckyStars);
        Arrays.sort(first5Numbers);
        Arrays.sort(luckyStars);
        JOptionPane.showMessageDialog(null,
                String.format("Winning numbers are: \n\n%s\nLucky Stars: %s", Arrays.toString(first5Numbers), Arrays.toString(luckyStars)));
    }

    private static void generateFirst5Numbers(int[] first5Numbers, boolean[] alreadyPickedFirst5) {
        int number;
        for (int i = 0; i < first5Numbers.length; i++) {
            number = (int) (Math.random() * 50) + 1;
            if (!alreadyPickedFirst5[number]) {
                alreadyPickedFirst5[number] = true;
                first5Numbers[i] = number;
            }
        }
    }

    private static void generate2LuckyStars(int[] luckyStars, boolean[] alreadyPickedLuckyStars) {
        int number;
        for (int i = 0; i < luckyStars.length; i++) {
            number = (int) (Math.random() * 12) + 1;
            if (!alreadyPickedLuckyStars[number]) {
                alreadyPickedLuckyStars[number] = true;
                luckyStars[i] = number;
            }
        }
    }
}
