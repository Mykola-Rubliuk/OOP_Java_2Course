package labsheet13.exercise1;

public class TestVehicle {
    public static  void main(String[] args) {
        System.out.println("Testing the cae no-arg constructor");
        Car car = new Car();
        System.out.println(car);

        System.out.println("\n\nTesting the Car multi-arg constructor:\n");
        Car car2 = new Car(1000000, 4.5, 1.25, 2000, "Ferrari", "F2", 2, "05GFL");
        System.out.println(car2);

        System.out.println("Testing the cae no-arg constructor");
        Bicycle bicycle = new Bicycle();
        System.out.println(bicycle);

        System.out.println("\n\nTesting the Car multi-arg constructor:\n");
        Bicycle bicycle1 = new Bicycle(500, 1.5, 0, 50, "Raleigh", "MountainBike", 5, true);
        System.out.println(bicycle1);
    }
}
