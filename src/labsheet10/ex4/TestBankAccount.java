package labsheet10.ex4;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

class TestBankAccount {
    public static void main(String[] args) {
        String text = "";
        BankAccount bankAccount1 = new BankAccount();
        text += "Calling the no-argument BankAccount constructor. The first BankAccount object details are: \n\n" + bankAccount1;
        BankAccount bankAccount2 = new BankAccount("Richy Rich", 234578, 0.75);
        text += "Calling the multi-argument BankAccount constructor. The second BankAccount object details are: \n\n" + bankAccount2;

        BankAccount.setInterestRate(0.5);
        text += "Now calling the setInterestRate() method to change the interest rate to 0.5.\n\n";
        text += "The first BankAccount object details are: \n\n" + bankAccount1;
        text += "The second BankAccount object details are: \n\n" + bankAccount2;

        JOptionPane.showMessageDialog(null, text, "BankAccount Object Data", JOptionPane.INFORMATION_MESSAGE);


    }
}
