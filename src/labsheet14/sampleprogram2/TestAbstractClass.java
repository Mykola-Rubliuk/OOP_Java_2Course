package labsheet14.sampleprogram2;

//TestAbstractClass.java
/*A driver class to test out the Shape, Circle and Rectangle classes*/

public class TestAbstractClass {
      public static void main(String[] args) {

          //Creating some Circle objects and displaying their state
          Circle circle2 = new Circle(5.5);

          //Creating some Rectangle objects and displaying their state
          Rectangle rectangle2 = new Rectangle(4.3, 1.8);
          Ellipse ellipse =  new Ellipse(3.0, 8.0);
          Triangle triangle = new Triangle(5.0, 5.0, 5.0);
          //Creating an array of Shape to store references to all the Circle and Rectangle objects
          //This is legal since a Circle is-a Shape and a Rectangle is-a Shape.
          //A Shape reference can reference an object that subclasses Shape

          Shape[] allShapes = {circle2, rectangle2, ellipse, triangle};

          //Looping through the array of Shape references to display the state of the
          //various shapes it contains, using polymorphism and dynamic method binding

          System.out.println("\n\nDetails of all Shape objects contained in the Shape array: \n");
          for (Shape allShape : allShapes) {
              System.out.println(allShape + "\n\n");
          }
      }
}