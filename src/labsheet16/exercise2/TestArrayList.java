package labsheet16.exercise2;

//TestArrayList.java
/*A driver (test) class that contains the main() method for
testing the functionality of the LineItem and Product classes but this time
an array-list is used for maintaining a collection of LineItem objects and
a separate collection of Product objects. The driver is also testing out
the functionality of the ArrayList class*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayList {
    public static void main(String[] args) {
        String mes = "Please enter your choice:";

        Product p1 = new Product(1, "Red Pen", "This is a red pen");
        Product p2 = new Product(2, "Pencil", "This is a pencil");
        Product p3 = new Product(3, "Ruler", "This is a ruler");
        Product p4 = new Product(4, "Black Marker", "This is a black permanent marker");
        Product p5 = new Product(5, "Compass", "This is a mathematical compass");
        Product p6 = new Product(6, "Protractor", "This is a protractor");
        Product p7 = new Product(7, "Refill Pad", "This is a 150 page refill pad");
        Product p8 = new Product(8, "Eraser", "This is an eraser");
        Product p9 = new Product(9, "Tippex", "This is tippex");
        Product p10 = new Product(10, "Stapler", "This is a stapler");
        Product p11 = new Product(11, "Black Pen", "This is a black pen");
        Product p12 = new Product(12, "Blue Pen", "This is a blue pen");
        Product p13 = new Product(13, "Red Marker", "This is a red permanent marker");
        Product p14 = new Product(14, "Blue Marker", "This is a blue permanent marker");
        Product p15 = new Product(15, "Calculator", "This is a Casio scientific calculator");

        //Create an array-list of Product objects
        ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));
        while (true) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add Product\n2. Amend Product\n3. Remove Product\n4. Display All Products\n5.Quit\n\n" + mes));
            while (choice < 1 || choice > 5) {
                mes = "Invalid choice";
                choice = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add Product\n2. Amend Product\n3. Remove Product\n4. Display All Products\n5.Quit\n\n" + mes));
            }

            switch (choice) {
                case 1 -> addProduct(allProducts);
                case 2 -> amendProduct(allProducts);
                case 3 -> removeProduct(allProducts);
                case 4 -> viewProducts(allProducts);
                case 5 -> {
                    JOptionPane.showMessageDialog(null, "Thanks for using the system!");
                    return;
                }

            }
        }


    }

    public static void addProduct(ArrayList<Product> allProducts) {
        String productID = JOptionPane.showInputDialog(null, "Enter Product ID");
        String productName = JOptionPane.showInputDialog(null, "Enter Product Name");
        String productDescription = JOptionPane.showInputDialog(null, "Enter Product Description");

        if (!productID.isEmpty() && !productName.isEmpty() && !productDescription.isEmpty()) {
            allProducts.add(new Product(Integer.parseInt(productID), productName, productDescription));
            JOptionPane.showMessageDialog(null, "Product now created successfully");
        }
    }


    public static void amendProduct(ArrayList<Product> allProducts) {
        String productsToChange = "";
        String productName = JOptionPane.showInputDialog(null, "Enter the  Name of the product you wish to amend");
        while (productName.isEmpty()) {
            productName = JOptionPane.showInputDialog(null, "Error! Enter the  Name of the product you wish to amend");
        }
        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(productName)) {
                productsToChange += product;
            }
        }

        System.out.println(productsToChange);

        if (!productsToChange.isEmpty()) {
            String productID = JOptionPane.showInputDialog(null, "The following products matched your search phrase\n\n" + productsToChange + "\n\nEnter the ID of the one do you want to amend");
            while (productID.isEmpty()) {
                productID = JOptionPane.showInputDialog(null, "Error! The following products matched your search phrase\n\n" + productsToChange + "\n\nEnter the ID of the one do you want to amend");
            }
            for (Product product : allProducts) {
                if (product.getId() == Integer.parseInt(productID)) {
                    String choice = JOptionPane.showInputDialog(null, "The details of the product you wish to amend are: \n\n" + product + "1. Amend Name\n2. Amend Description\n3. Cancel Amendment\n\nPlease enter your choice");
                    while (choice.isEmpty() && !(Integer.parseInt(choice) == 1 || Integer.parseInt(choice) == 2 || Integer.parseInt(choice) == 3)) {
                        choice = JOptionPane.showInputDialog(null, "The details of the product you wish to amend are: \n\n" + product + "1. Amend Name\n2. Amend Description\n3. Cancel Amendment\n\nInvalid choice entered!!!");
                    }
                    switch (Integer.parseInt(choice)) {
                        case 1 -> amendName(product);
                        case 2 -> amendDescription(product);
                        case 3 -> {
                            JOptionPane.showMessageDialog(null, "The amend was cancelled");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Product details now amended!");

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "The ");
        }


    }

    private static void amendDescription(Product product) {
        String description = JOptionPane.showInputDialog(null, "Please enter the new description for the product ");
        while (description.isEmpty()) {
            description = JOptionPane.showInputDialog(null, "Error! Please enter the new description for the product ");
        }
        product.setDescription(description);
    }

    private static void amendName(Product product) {
        String name = JOptionPane.showInputDialog(null, "Please enter the new name for the product ");
        while (name.isEmpty()) {
            name = JOptionPane.showInputDialog(null, "Error! Please enter the new name for the product ");
        }
        product.setName(name);

    }


    public static void removeProduct(ArrayList<Product> allProducts) {
        Product productToRemove = null;

        String productsToChange = "";
        String productName = JOptionPane.showInputDialog(null, "Enter the  Name of the product you wish to amend");
        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(productName)) {
                productsToChange += product;
            }
        }

        if (!productsToChange.isEmpty()) {
            String productID = JOptionPane.showInputDialog(null, "The following products matched your search phrase\n\n" + productsToChange + "\n\nEnter the ID of the one do you want to remove");
            while (productID.isEmpty()) {
                productID = JOptionPane.showInputDialog(null, "Error! The following products matched your search phrase\n\n" + productsToChange + "\n\nEnter the ID of the one do you want to remove");
            }
            for (Product product : allProducts) {
                if (product.getId() == Integer.parseInt(productID)) {
                    int choice = JOptionPane.showConfirmDialog(null, "The details of the product ypu wish to remove are:\n" + product + "\n\nAre you sure to wish to remove this product?", "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        productToRemove = product;
                        break;
                    }

                }
            }
        }
        if (productToRemove != null) {
            allProducts.remove(productToRemove);
            JOptionPane.showMessageDialog(null, "Deleted");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void viewProducts(ArrayList<Product> allProducts) {
        String allProductsList = "";
        for (Product product : allProducts) {
            allProductsList += product;
        }
        JOptionPane.showMessageDialog(null, allProductsList, "List of All Products", JOptionPane.INFORMATION_MESSAGE);
    }


}
