package labsheet6;

import javax.swing.JOptionPane;

public class Ex1 {
    public static void main(String[] args) {
        String ISBNString;
        String validISBNs = "";
        String validISBNStartWith865 = "";
        String prompt = "Please enter an ISBN (return to exit)";
        String result;

        do {
            ISBNString = JOptionPane.showInputDialog(null, prompt);
            if (ISBNString == null || ISBNString.isEmpty()) break;

            result = validISBN(ISBNString);

            if (result.equals("Good")) {
                validISBNs += ISBNString + '\n';

                if (ISBNString.startsWith("865"))
                    validISBNStartWith865 += ISBNString + '\n';

                prompt = "Please enter an ISBN (return to exit)";
            } else {
                prompt = result;
            }

        } while (true);



        if (!validISBNs.isEmpty()) {
            if (!validISBNStartWith865.isEmpty()) {
                JOptionPane.showMessageDialog(null, String.format("The valid ISBNs entered are:\n\n%s\n\nThe ISBNs that begins with 865 are:\n\n%s", validISBNs, validISBNStartWith865));
            } else {
                JOptionPane.showMessageDialog(null, String.format("The valid ISBNs entered are:\n\n%s\n\n", validISBNs));
            }
        } else {
            JOptionPane.showMessageDialog(null, "You entered no valid ISBNs ...thanks for using the system", "No valid ISBNs", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static String validISBN(String isbnStr) {
        if (isbnStr.length() != 10) return "Invalid! ISBN must have exactly 10 characters. PLease re-enter";

        for (int i = 0; i < isbnStr.length() - 1; i++) {
            if (!Character.isDigit(isbnStr.charAt(i)))
                return "Invalid! First 9 characters must be digits. PLease re-enter";
        }

        char lastCh = isbnStr.charAt(isbnStr.length() - 1);
        if (!(Character.toLowerCase(lastCh) == 'x' || Character.isDigit(lastCh)))
            return "Invalid! Last character must be a digit, an 'X' or an 'x'. PLease re-enter";


        if (!isSatisfyGoldenRule(isbnStr)) return "Invalid! ISBN fails the golden rule. Please re-enter.";

        return "Good";
    }


    private static boolean isSatisfyGoldenRule(String isbnStr) {
        int total = 0, reminder;
        int len = isbnStr.length();
        int lastCh;
        if (Character.toLowerCase(isbnStr.charAt(len - 1)) == 'x') {
            lastCh = 10;
        } else {
            lastCh = Character.getNumericValue(isbnStr.charAt(len - 1));
        }

        for (int i = 0; i < len - 1; i++) {
            total += Character.getNumericValue(isbnStr.charAt(i)) * (len - i);
            System.out.println(total);
        }

        reminder = total % 11;
        System.out.println(reminder);
        return (11 - reminder) == lastCh;
    }
}
