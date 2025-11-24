package labsheet9.ex3;

import javax.swing.*;

public class TestBook {
    public static void main(String[] args) {
        String text = "";
        Book book1 = new Book();
        text += "Calling the no-argument Book constructor. The first Book object details are: \n\n";
        text += book1.toString();
        Book book2 = new Book("The Davinci Code", 19.99, "345678934", 345);
        text += "\n\nCalling the multi-argument Book constructor. The second Book object details are: \n\n";
        text += book2.toString();

        JOptionPane.showMessageDialog(null, text, "Book Object Data", JOptionPane.INFORMATION_MESSAGE);
    }
}
