package labsheet11.ex2;

//TestAnimal.java
/*A driver (test) class that contains the main() method for
testing the functionality of the Animal class*/

public class TestAnimal {
    public static void main(String[] args) {

        System.out.println("testing the no-argument constructor....");
        Animal animal1 = new Animal(); //tests no-arg constructor
        System.out.println(animal1); //tests toString() and the accessor methods
        String[] lionContinents = {"Africa", "Asia"}; //initialise an array of strings

        //tests 4-arg constructor and the 4 mutator methods
        System.out.println("\n\n\ntesting the 4-argument constructor....");
        animal1 = new Animal("Lion", lionContinents, 200, 40);
        System.out.println(animal1);
        lionContinents[0] = "Europe";
        System.out.println("\n" + animal1);
        System.out.println(animal1.getType());
    }
}