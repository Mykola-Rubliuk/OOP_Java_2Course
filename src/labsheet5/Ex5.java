package labsheet5;

import javax.swing.JOptionPane;

public class Ex5 {
    public static void main(String[] args) {
        String hexNum = JOptionPane.showInputDialog(null, "Please enter your value");
        if (!isValidHexadecimal(hexNum)) {
            JOptionPane.showMessageDialog(null, "The value entered is not a 6-character hexadecimal number", "Program result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, String.format("The decimal equivalent of %s is %d", hexNum, hexToDecimal(hexNum)), "Program result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isValidHexadecimal(String hexNum) {
        hexNum = hexNum.toUpperCase();
        if (hexNum.length() != 6) return false;

        for (int i = 0; i < hexNum.length() - 1; i++) {
            if (!(Character.isDigit(hexNum.charAt(i)) ||
                    (hexNum.charAt(i) >= 'A' && hexNum.charAt(i) <= 'F')))
                return false;
        }
        return true;

    }

    private static int hexToDecimal(String hexNum) {
        hexNum = hexNum.toUpperCase();
        int decimalNum = 0;
        char ch;
        int len = hexNum.length() - 1;
        for (int i = 0; i <= len; i++) {
            ch = hexNum.charAt(i);
            if (Character.isDigit(ch)) {
                decimalNum += (int) (Character.getNumericValue(hexNum.charAt(i)) * Math.pow(16, len - i));
            } else if (ch == 'A') {
                decimalNum += (int) (10 * Math.pow(16, len - i));
            } else if (ch == 'B') {
                decimalNum += (int) (11 * Math.pow(16, len - i));
            } else if (ch == 'C') {
                decimalNum += (int) (12 * Math.pow(16, len - i));
            } else if (ch == 'D') {
                decimalNum += (int) (13 * Math.pow(16, len - i));
            } else if (ch == 'E') {
                decimalNum += (int) (14 * Math.pow(16, len - i));
            } else {
                decimalNum += (int) (15 * Math.pow(16, len - i));
            }
        }
        return decimalNum;
    }

}