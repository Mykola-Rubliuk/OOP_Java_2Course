package labsheet13.exercise2;

public class Validator {
    public static boolean isValidRegistrationNumber(String registrationNumber) {
        if (registrationNumber.length() > 12 || registrationNumber.length() < 6) {
            System.out.println("Registration number is too short or too long");
            return false;
        }
        String subString = registrationNumber.substring(0, 2);
        for (char c : subString.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("First and second characters are not digit");
                return false;
            }
        }
        char thirdChar = registrationNumber.charAt(2);
        if (thirdChar != '-') {
            System.out.println("Third characters are not dash");
            return false;
        }

        int dashIndex = -1;
        char c4 = registrationNumber.charAt(3);  // 4th character
        char c5 = registrationNumber.charAt(4);  // 5th character
        char c6 = registrationNumber.charAt(5);  // 6th character

        //case A
        if (Character.isAlphabetic(c4) && Character.isAlphabetic(c5)
                && Character.isUpperCase(c4) && Character.isUpperCase(c5)) {
            if (c6 != '-') {
                System.out.println("Case A not valid");
                return false;
            } else dashIndex = 5;
        }

        //case B
        if (Character.isAlphabetic(c4) && c5 == '-') {
            if (!Character.isDigit(c6)) {
                System.out.println("Case B not valid");
                return false;
            } else dashIndex = 4;
        }

        System.out.println("Dash Index: " + dashIndex);

        String subString2 = registrationNumber.substring(dashIndex + 1);
        for (int i = 0; i < subString2.length(); i++) {
            if (!Character.isDigit(subString2.charAt(i))) {
                System.out.println(subString2.charAt(i));
                System.out.println("Remain characters are not digit");
                return false;
            }
            if (i > 6) {
                System.out.println("Remain characters are too long");
                return false;
            }

        }

        return true;
    }
}
