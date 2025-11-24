package labsheet9.ex2;
import javax.swing.*;

public class TestComputer {
    public static void main(String[] args) {
        String output = "";
        Computer c1 = new Computer();

        output += "Calling the no-argument Computer constructor. " + "The first Computer object details are: \n\n" + c1;
//        Computer c2 = new Computer("Dell", "Laptop", 3.25, 16, 550.99);
//        c2.setSpeed(-3.15);
//        output += "\n\nCalling the multi-argument Computer constructor. " + "The second Computer object details are: \n\n" + c2;
//        Computer c3 = new Computer("Apple", "Desktop", 2.9, -12, -865.00);
//        output += "\n\nCalling the multi-argument Computer constructor. " + "The third Computer object details are: \n\n" + c3;
        JOptionPane.showMessageDialog(null, output, "Computer Object Data", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}