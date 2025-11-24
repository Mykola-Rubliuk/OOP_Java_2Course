package labsheet11.ex1;

import javax.swing.*;

public class TestPerson {
    public static void main(String[] args) {
        String text = "";
        text += "*****Person Class Tester*****\n";
        Person person1 = new Person();
        text += "\nCalling the Person() constructor...\n" + person1;
        String firstName = JOptionPane.showInputDialog(null, "Please enter the first name of the second person");
        String lastName = JOptionPane.showInputDialog(null, "Please enter the last name of the second person");
        Person person2 = new Person(firstName, lastName);
        text += "\nCalling the Person(String, String) constructor after getting user-supplied values... \n" + person2;
        JOptionPane.showMessageDialog(null, text);

    }
}
