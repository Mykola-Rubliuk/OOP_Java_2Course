package labsheet6;

import javax.swing.JOptionPane;

public class Ex2 {
    public static void main(String[] args) {
        int index = 1;
        while (true) {
            String email = JOptionPane.showInputDialog(
                    null,
                    String.format("Loop %d -Please enter an email value", index));
            if (isValidEmail(email).equals("Valid")) break;
            index++;
        }
    }

    private static String isValidEmail(String email) {
        int len = email.length();

        if (len < 7 || len > 322) return "Len";
        System.out.println("len");
        if (email.indexOf('@') == -1) return "Missing @";
        System.out.println("@");
        int index = email.indexOf('@');

        //email must endswith “.org”, “.com”, “.net” or “.ie”
        if (!(email.endsWith(".org") ||
                email.endsWith(".com") ||
                email.endsWith(".net") ||
                email.endsWith(".ie"))) {
            return "topLevelDomain";
        }
        System.out.println("topLevelDomain");
        String recipient = email.substring(0, index);
        String domain = email.substring(index + 1);

        if (!isRecipientNameValid(recipient)) return "Recipent";
        System.out.println("Recipent");
        if (!isDomainNameValid(domain)) return "Domain";
        System.out.println("Domain");

        return "Valid";
    }

    private static boolean isRecipientNameValid(String recipient) {
        int len = recipient.length();
        if (len < 1 || len > 64) return false; // стандарт RFC 5321: max 64 символа

        for (int i = 0; i < len; i++) {
            char ch = recipient.charAt(i);
            if (!Character.isAlphabetic(ch) && !Character.isDigit(ch) && ch != '.' && ch != '-' && ch != '_') {
                return false; // найден недопустимый символ
            }
        }
        return true; // все символы корректные
    }

    private static boolean isDomainNameValid(String domain) {
        int len = domain.length();
        if (len < 2 || len > 253) return false; // стандарт RFC: max 253 символа

        for (int i = 0; i < len; i++) {
            char ch = domain.charAt(i);
            if (!Character.isAlphabetic(ch) && !Character.isDigit(ch) && ch != '.' && ch != '-') {
                return false; // недопустимый символ в домене
            }
        }
        return true;
    }
}
