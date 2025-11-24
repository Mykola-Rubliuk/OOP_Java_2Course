package labsheet7;

import javax.swing.*;
import java.awt.*;

public class Ex4 {
    public static void main(String[] args) {
        int[] array = new int[100];
        populateArray(array);
        displayArray(array);
        sortArray(array);
        displayArray(array);
        int values = over100(array);
        JOptionPane.showMessageDialog(null, String.format("The percentage of values that exceed 100 is %d%%", values), "% over 100", JOptionPane.INFORMATION_MESSAGE);
        String input = JOptionPane.showInputDialog(null, "Please enter the number for which you wish to check its existence within the array");
        boolean found = binarySearch(array, input);
        if (!found){
            JOptionPane.showMessageDialog(null, String.format("%s was found in the array", input));
        }else {
            JOptionPane.showMessageDialog(null, String.format("%s was not found in the array", input ));
        }
    }

    private static boolean binarySearch(int[] array, String seek) {
        int left = 0, right = array.length - 1, midIndex;
        int target = Integer.parseInt(seek);
        while (left <= right) {
            midIndex = (left + right) / 2;

            if (target < array[midIndex]) right = midIndex - 1;
            else if (target > array[midIndex]) left = midIndex + 1;
            else return true;
        }
        return false;
    }

    private static int over100(int[] array) {
        int over100 = 0;
        for (int element : array) {
            if (element > 100) over100++;
        }
        return over100;
    }

    private static void sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[smallest] > array[j]) {
                    smallest = j;
                }
            }
            int temp = array[smallest];
            array[smallest] = array[i];
            array[i] = temp;
        }
    }

    private static void displayArray(int[] array) {
        TextArea textArea = new TextArea(11, 36);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        for (int i = 0; i < 100; i++) {
            textArea.append(String.format("%-5d", array[i]));
            if ((i + 1) % 10 == 0) textArea.append("\n");
        }
        JOptionPane.showMessageDialog(null, textArea, "Array Contents", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000) + 1;
        }
    }
}
