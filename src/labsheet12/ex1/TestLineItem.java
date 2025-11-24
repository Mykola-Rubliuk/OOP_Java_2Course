package labsheet12.ex1;

//TestLineItem.java
/*A driver (test) class that contains the main() method for
testing the functionality of the LineItem and Product classes*/

public class TestLineItem {
    public static void main(String[] args) {

        //Create an array of LineItem objects
        LineItem[] allLineItems = new LineItem[10];

        // Create Products
        Product p1 = new Product("Pen", "This is a red pen");
        Product p2 = new Product("Pencil", "This is a pencil");
        Product p3 = new Product("Ruler", "This is a ruler");
        Product p4 = new Product("Marker", "This is a black permanent marker");

        // Create LineItem objects

        LineItem item1 = new LineItem(1, 3, p1);
        LineItem item2 = new LineItem(2, 4, p2);
        LineItem item3 = new LineItem(3, 2, p3);

        allLineItems[0] = item1;
        allLineItems[1] = item2;
        allLineItems[2] = item3;

        System.out.println("Displaying the state of all line-items ...\n\n");
        for (int i = 0; i < allLineItems.length; i++)
            if (allLineItems[i] != null) System.out.println(allLineItems[i]);

        System.out.println("Now changing product associated with first line-item to a marker...\n\n");
        item1.setProduct(p4);

        System.out.println("Displaying the state of all line-items again...\n\n");
        for (int i = 0; i < allLineItems.length; i++)
            if (allLineItems[i] != null) System.out.println(allLineItems[i]);

        System.out.println("Now destroying the second line item (the 4 pencils)...\n");

        item2 = null; //destroy the 2nd LineItem object in the array
        allLineItems[1] = null;

        System.out.println("Displaying the state of the second product ...\n");
        System.out.println(p2); //and yet the Product associated with it still exists

        System.out.println("\nDisplaying the state of all line-items one last time...\n\n");
        for (int i = 0; i < allLineItems.length; i++)
            if (allLineItems[i] != null) System.out.println(allLineItems[i]);
    }
}
