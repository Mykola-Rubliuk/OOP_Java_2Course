package labsheet4;

import javax.swing.*;
import java.awt.*;

public class Ex6 {
    public static void main(String[] args) {
        String name, t_number, course, avg_mark;
        JTextArea textArea = new JTextArea(12, 50);
        Font font = new Font("monospaced", Font.PLAIN, 20);
        textArea.setFont(font);
        textArea.setText(String.format("%-30s%-25s%-40s%-10s\n%-30s%-25s%-40s%-10s\n", "Name", "T-Number", "Course", "Avg mark", "====", "====", "====", "===="));
        int index = 1;
        while (index < 2) {
            name = JOptionPane.showInputDialog(String.format("Please enter the name of student %d", index));
            t_number = JOptionPane.showInputDialog(String.format("Please enter the t-number of student %d", index));
            course = JOptionPane.showInputDialog(String.format("Please enter the course of student %d", index));
            avg_mark = JOptionPane.showInputDialog(String.format("Please enter the average mark of student %d", index));
            index++;
            textArea.append(String.format("%-30s%-25s%-40s%-10s\n", name, t_number, course, avg_mark));
        }
        JOptionPane.showMessageDialog(null, textArea);
    }
}
