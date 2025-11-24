package labsheet7;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        String[] tNumber = new String[10];
        String[] courses = new String[10];

        populateArrays(tNumber, courses);

        JOptionPane.showMessageDialog(null, String.format("Before sorting, the contents of the t-number and course names arrays are:\n\n%s\n%s",
                Arrays.toString(tNumber), Arrays.toString(courses)));

        selectionSort(tNumber, courses);
        JOptionPane.showMessageDialog(null, String.format("After sorting, the contents of the t-number and course names arrays are:\n\n%s\n%s",
                Arrays.toString(tNumber), Arrays.toString(courses)));

        String studentNumber = JOptionPane.showInputDialog(null, "Enter the t-number of the student you seek");
        int found = binarySearch(tNumber, studentNumber);
        if (found != -1) {
            JOptionPane.showMessageDialog(null, String.format("The t-number you sought was found in the array and the corresponding course name for this student is %s", courses[found]), "Found!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The t-number you sought was not found in the array", "Not Found!", JOptionPane.INFORMATION_MESSAGE);
        }


        showInfo(tNumber, courses);


    }

    public static void populateArrays(String[] tNumber, String[] courses) {
        int size = 10;

        for (int i = 0; i < size; i++) {
            tNumber[i] = JOptionPane.showInputDialog(null, String.format("Enter t-number for student %d", i));
            courses[i] = JOptionPane.showInputDialog(null, String.format("Enter course name for student %d", i));
        }
    }

    public static void selectionSort(String[] tNumber, String[] courses) {
        for (int i = 0; i < tNumber.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < tNumber.length; j++) {
                if (tNumber[smallest].compareTo(tNumber[j]) < 0) {
                    smallest = j;
                }
            }
            String tempNumber = tNumber[i];
            tNumber[i] = tNumber[smallest];
            tNumber[smallest] = tempNumber;

            String tempCourse = courses[i];
            courses[i] = courses[smallest];
            courses[smallest] = tempCourse;
        }
    }

    public static int binarySearch(String[] tNumber, String input) {
        int left = 0, right = tNumber.length - 1, midIndex;
        while (left <= right) {
            midIndex = (left + right) / 2;

            if (input.compareTo(tNumber[midIndex]) < 0) right = midIndex - 1;
            else if (input.compareTo(tNumber[midIndex]) > 0) left = midIndex + 1;
            else return midIndex;


        }
        return -1;
    }

    public static void showInfo(String[] tNumber, String[] courses) {
    int numsOfTNumber = 0;
    int numsOfCourseHealth = 0;
    int totalComputing = 0;
    int from36Computing = 0;

    TextArea textArea = new TextArea();
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

    textArea.append(String.format("%-15s%s\n", "T-Number", "Course"));
    textArea.append(String.format("%-15s%s\n\n", "--------", "------"));

    for (int i = 0; i < tNumber.length; i++) {
        if (tNumber[i].startsWith("t003"))
            numsOfTNumber++;

        if (courses[i].equalsIgnoreCase("Health & Leisure") ||
                courses[i].equalsIgnoreCase("Chemistry"))
            numsOfCourseHealth++;

        if (courses[i].equalsIgnoreCase("Computing")) {
            totalComputing++;
            if (tNumber[i].startsWith("t00036"))
                from36Computing++;
        }

        if (courses[i].equalsIgnoreCase("Mechatronics") ||
                courses[i].equalsIgnoreCase("Early Childcare") ||
                courses[i].equalsIgnoreCase("Computing")) {
            textArea.append(String.format("%-15s%s\n", tNumber[i], courses[i]));
        }
    }

    int percentageOfCourseComp = 0;
    if (totalComputing > 0)
        percentageOfCourseComp = (from36Computing * 100) / totalComputing;

    JOptionPane.showMessageDialog(null, String.format("""
            The number of students whose t-number begins with "t003" is %d
            The number of students whose course name is either "Health & Leisure" or "Chemistry" is %d
            The percentage of students taking the "Computing" course whose t-number is from "t00036" onwards is %d%%

            The list of t-numbers/courses names for students taking "Mechatronics", "Early Childcare" or "Computing":

            %s
            """, numsOfTNumber, numsOfCourseHealth, percentageOfCourseComp, textArea.getText()));
}


}
