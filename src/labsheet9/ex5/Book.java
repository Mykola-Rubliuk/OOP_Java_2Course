package labsheet9.ex5;

import java.util.Objects;

public class Book {
    private String title;
    private double price;
    private String ISBN;
    private int pages;


    public Book() {
        this("Title Not Available", 0.00, "ISBN Not Available", 0);
    }

    public Book(String title, double price, String ISBN, int pages) {
        setTitle(title);
        setPrice(price);
        setISBN(ISBN);
        setPages(pages);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Objects.requireNonNullElse(title, "No Valid Title Supplied");

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0 || price >= 50000) {
            this.price = 0;
        } else {
            this.price = price;
        }

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {

        this.ISBN = Objects.requireNonNullElse(ISBN, "No Valid Title Supplied");
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages < 0 || pages >= 4000) {
            this.pages = 0;
        } else {
            this.pages = pages;
        }
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " Price: " + this.price + " ISBN: " + this.ISBN + " Number of Pages: " + this.pages;
    }
}
