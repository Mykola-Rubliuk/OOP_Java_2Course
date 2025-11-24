package CAs.FirstCA;

import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 4};
        int[] ar = {0, 2};
        System.out.println("The AVG num in this array: " + findAvgFromArray(array));
        System.out.println("The reverse array: " + Arrays.toString(reverseArray(array)));
        System.out.println("The unique array: " + Arrays.toString(findUniqueElement(array)));
        System.out.println("The random array: " + Arrays.toString(createRandomArray()));
        System.out.println("Gather to arrays: " + Arrays.toString(gatherTwoArrays(array, ar)));
    }

    private static double findAvgFromArray(int[] array) {
        double total = 0f;
        for (int num : array) {
            total += num;
        }
        return total / array.length;
    }

    private static int[] reverseArray(int[] array) {
        int[] tempArray = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            tempArray[i] = array[array.length - 1 - i];
        }

        return tempArray;
    }

    private static int[] findUniqueElement(int[] array) {
        int[] tempArray = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == tempArray[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                tempArray[count] = array[i];
                count++;
            }

        }

        return Arrays.copyOf(tempArray, count);
    }

    private static int[] createRandomArray() {
        int[] tempArray = new int[10];
        for (int i = 0; i < 10; i++) {
            tempArray[i] = (int) (Math.random() * 100) + 1;
        }
        return tempArray;
    }

    private static int[] gatherTwoArrays(int[] a, int[] b) {
        int len = a.length + b.length;
        int[] tempArray = new int[len];
        for (int i = 0; i < a.length; i++) {
            tempArray[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            tempArray[a.length + i] = b[i];
        }
        return tempArray;
    }
}
