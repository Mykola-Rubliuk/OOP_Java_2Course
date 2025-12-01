package labsheet16.exercise1;

//TestComputer.java
/*A driver class for the Computer class that uses a for-each loop*/

public class TestComputer {
    public static void main(String[] args) {

        double totalPrice = 0;
        Computer highestSpeedComputer;
        String priceOver500 = "";
        String typeTablet = "";

        Computer c1 = new Computer();
        Computer c2 = new Computer("Dell", "Laptop", 3.25, 16, 550.99);
        Computer c3 = new Computer("Apple", "Tablet", 3.65, 8, 500.25);
        Computer c4 = new Computer("Sun", "Server", 4.25, 32, 1768.45);
        Computer c5 = new Computer("Lenovo", "Desktop", 2.86, 14, 457.34);

        Computer[] allComputers = {c1, c2, c3, c4, c5};

        highestSpeedComputer = allComputers[0];

        System.out.println("Some additional information\n\n");
        for (Computer computer : allComputers) {
            totalPrice += computer.getPrice();
            if (computer.getPrice() >= 500) {
                priceOver500 += computer + "\n";
            }
            if (highestSpeedComputer.getSpeed() <= computer.getSpeed()) {
                highestSpeedComputer = computer;
            }
            if (computer.getType().equals("Tablet")) {
                typeTablet += computer + "\n";
            }
        }
        System.out.printf("Average computer price is: $%.2f\n", totalPrice / allComputers.length);
        System.out.println("Details of highest speed computer: " + highestSpeedComputer);
        System.out.println("List of computers whose price exceeds $500:\n\n" + priceOver500);
        System.out.println("\nList of computers that are tablets:\n" + typeTablet);
        System.out.println("\nUpdated details of all Computers in the array\n\n");

        for (Computer computer : allComputers) {
            if (computer.getManufacturer().equals("Lenovo")) {
                computer.setManufacturer("Dell");
            }
            System.out.println(computer);
        }


    }
}
