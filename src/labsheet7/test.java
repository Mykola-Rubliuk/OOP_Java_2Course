package labsheet7;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        double[] array = {1.23, 1.43, 4, 4.04, 0.34};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(double[] gpa) {
        for (int i = 0; i < gpa.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < gpa.length; j++) {
                if (gpa[j] < gpa[minIndex]) {
                    minIndex = j;
                }
            }
            double tempGpa = gpa[i];
            gpa[i] = gpa[minIndex];
            gpa[minIndex] = tempGpa;
        }
    }
}
