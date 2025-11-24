package labsheet5;

import javax.swing.JOptionPane;

public class Ex2 {
    public static void main(String[] args) {
        String answer;
        char ch;
        ch = JOptionPane.showInputDialog("Please enter any character").charAt(0);
        if (!Character.isDigit(ch)) {
            answer = "You did not enter a digit";
        } else {
            answer = "You entered a digit";
        }
        JOptionPane.showConfirmDialog(null, answer, "Digit test", JOptionPane.OK_CANCEL_OPTION);
    }
}
