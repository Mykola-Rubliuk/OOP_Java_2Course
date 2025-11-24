package labsheet9.ex5;

import javax.swing.*;
import java.awt.*;

public class TestBook {
    public static void main(String[] args) {
        String favTitle = JOptionPane.showInputDialog(null,
                "Please enter the title of your favourite book");
        double favPrice = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Please enter the priceStr of your favourite book"));
        String favISBN = JOptionPane.showInputDialog(null,
                "Please enter the ISBN of your favourite book");
        int favPages = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Please enter the number of pagesStr of your favourite book"));

        Book favouriteBook = new Book(favTitle, favPrice, favISBN, favPages);


        String leastTitle = JOptionPane.showInputDialog(null,
                "Please enter the title of your least favourite book");
        double leastPrice = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Please enter the priceStr of your least favourite book"));
        String leastISBN = JOptionPane.showInputDialog(null,
                "Please enter the ISBN of your least favourite book");
        int leastPages = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Please enter the number of pagesStr of your least favourite book"));

        Book leastBook = new Book(leastTitle, leastPrice, leastISBN, leastPages);
        JTextArea textArea = getjTextArea(favouriteBook, leastBook);

        JOptionPane.showMessageDialog(null, textArea);


    }

    private static JTextArea getjTextArea(Book favouriteBook, Book leastBook) {
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        textArea.append(String.format("%-40s%-12s%-20s%-10s\n\n", "Title", "Price", "ISBN", "Pages"));
        textArea.append(String.format("%-40s%-12s%-20s%-10s\n\n", favouriteBook.getTitle(), favouriteBook.getPrice(), favouriteBook.getISBN(), favouriteBook.getPages()));
        textArea.append(String.format("%-40s%-12s%-20s%-10s\n\n", leastBook.getTitle(), leastBook.getPrice(), leastBook.getISBN(), leastBook.getPages()));
        return textArea;
    }
}
