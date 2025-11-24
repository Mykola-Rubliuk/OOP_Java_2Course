package labsheet10.ex5;

import javax.swing.*;

class TestBankAccount {
    public static void main(String[] args) {
        String text = "";
        System.out.println(BankAccount.getCount());
        BankAccount bankAccount1 = new BankAccount();
        text += "Calling the no-argument BankAccount constructor. The first BankAccount object details are: \n\n" + bankAccount1;
        System.out.println("after b1" + BankAccount.getCount());
        BankAccount bankAccount2 = new BankAccount("Richy Rich", 0.75);
        System.out.println("after b2" + BankAccount.getCount());

        text += "Calling the multi-argument BankAccount constructor. The second BankAccount object details are: \n\n" + bankAccount2;
        System.out.println("before setInt" + BankAccount.getCount());
        BankAccount.setInterestRate(0.5);
        System.out.println("after setInt" + BankAccount.getCount());
        text += "Now calling the setInterestRate() method to change the interest rate to 0.5.\n\n";
        text += "The first BankAccount object details are: \n\n" + bankAccount1;
        text += "The second BankAccount object details are: \n\n" + bankAccount2;

        text += "The number of Bank Account objects created is: " + BankAccount.getCount();

        JOptionPane.showMessageDialog(null, text, "BankAccount Object Data", JOptionPane.INFORMATION_MESSAGE);
    }
}
