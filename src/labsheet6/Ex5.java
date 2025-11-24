package labsheet6;

import javax.swing.JOptionPane;

public class Ex5 {
    public static void main(String[] args) {
        int size = 5;
        String[] names = new String[size];
        String[] phoneNumbers = new String[size];
        populateArrays(names, phoneNumbers, size);
        String nameInArray;
        nameInArray = JOptionPane.showInputDialog(
                null,
                "Whose phone number do you seek?"
        );
        String foundNUmber = findPhoneNumber(names, phoneNumbers, nameInArray);
        JOptionPane.showConfirmDialog(null, foundNUmber, "Phone Number", JOptionPane.DEFAULT_OPTION
        );

    }

    private static String findPhoneNumber(String[] names, String[] phoneNumbers, String name) {
        String phoneNumber = "Name not found!";
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                phoneNumber = String.format("The phone number is %s", phoneNumbers[i]);
            }
        }
        return phoneNumber;
    }

    private static void populateArrays(String[] names, String[] phoneNumbers, int size) {
        for (int i = 0; i < size; i++) {
            names[i] = JOptionPane.showInputDialog(
                    null,
                    String.format("Please enter the name of person %d", i + 1)
            );
            phoneNumbers[i] = JOptionPane.showInputDialog(
                    null,
                    String.format("Please enter the phone-number of person %d", i + 1)
            );
        }
    }
}
