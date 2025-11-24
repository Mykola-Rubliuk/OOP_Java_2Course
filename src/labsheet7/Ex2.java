package labsheet7;

import javax.swing.*;
import java.awt.*;

public class Ex2 {
    public static void main(String[] args) {
        String[] names = {"James Maye", "Joe Bloggs", "Jane Doe", "Teresa Coughlan", "Sam Stewart"};
        double[] gpa = {3.56, 2.47, 3.12, 2.55, 2.78};
        selectionSort(gpa, names);
        displayResults(gpa, names);

        JOptionPane.showMessageDialog(null, String.format("The Average GPA is %.0f", averageGPA(gpa)), "Average GPA", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, String.format("The standard deviation of the GPAs is %.3f", standardDeviationGPA(gpa)), "Standard Deviation", JOptionPane.INFORMATION_MESSAGE);

    }

    private static void selectionSort(double[] gpa, String[] names) {
        for (int i = 0; i < gpa.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < gpa.length; j++) {
                if (gpa[j] > gpa[maxIndex]) {
                    maxIndex = j;
                }
            }
            double tempGpa = gpa[i];
            gpa[i] = gpa[maxIndex];
            gpa[maxIndex] = tempGpa;

            String tempName = names[i];
            names[i] = names[maxIndex];
            names[maxIndex] = tempName;
        }
    }

    private static void displayResults(double[] gpa, String[] names) {
        TextArea textArea = new TextArea(10, 25);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

        textArea.append(String.format("%-20s%s\n", "Name", "GPA"));
        textArea.append(String.format("%-20s%s\n", "----", "----"));
        textArea.append("\n");

        for (int i = 0; i < gpa.length; i++) {
            textArea.append(String.format("%-20s%.2f\n", names[i], gpa[i]));
        }

        JOptionPane.showMessageDialog(null, textArea, "Sorted Results", JOptionPane.INFORMATION_MESSAGE);
    }

    private static double averageGPA(double[] gpa) {
        double total = 0;
        int len = gpa.length;

        for (double el : gpa) {
            total += el;
        }

        return total / len;
    }

    private static double standardDeviationGPA(double[] gpa) {
        double total = 0.0;
        double avg = averageGPA(gpa);

        for (double v : gpa) {
            total += Math.pow(v - avg, 2);
        }
        return Math.sqrt(1 / 5.0 * total);
    }
}
