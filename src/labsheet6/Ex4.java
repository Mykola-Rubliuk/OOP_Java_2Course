package labsheet6;

import javax.swing.JOptionPane;

public class Ex4 {
    public static void main(String[] args) {
        double[] array = {22.3, 45.6, 27.4, 56.6, 73.2, 11.5, 87.4, 23.8};
        double largestValue = largest(array);
        double averageValue = average(array);
        String aboveAverageValue = aboveAverage(array, averageValue);

        JOptionPane.showConfirmDialog(
                null,
                String.format("""
                        The largest value in the array is %.2f
                        The average value in the array is %.2f
                        The list of values above the average is: %s""", largestValue, averageValue, aboveAverageValue),
                "Array Stats",
                JOptionPane.DEFAULT_OPTION);
    }

    private static double largest(double[] array) {
        double maxValue = Double.NEGATIVE_INFINITY;
        for (double v : array) {
            if (maxValue < v) {
                maxValue = v;
            }
        }
        return maxValue;
    }

    private static double average(double[] array) {
        int len = array.length;
        double total = 0.0;
        for (double v : array) {
            total += v;
        }
        return total / len;
    }

    private static String aboveAverage(double[] array, double average) {
        String strAboveAvg = "";
        for (double v : array) {
            if (average < v) {
                strAboveAvg += String.format("%s, ", v);
            }
        }
        return strAboveAvg.substring(0, strAboveAvg.length()-2);
    }
}
