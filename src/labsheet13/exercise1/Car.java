package labsheet13.exercise1;

public class Car extends Vehicle {
    private int maxPassengers;
    private String registrationNumber;

    public Car() {
        setMaxPassengers(0);
        setRegistrationNumber("No registration number specified");
    }

    public Car(double seat, double length, double height, double weight, String manufacturer, String model, int maxPassengers, String registrationNumber) {
        super(seat, length, height, weight, manufacturer, model);
        setMaxPassengers(maxPassengers);
        setRegistrationNumber(registrationNumber);
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    @Override
    public String toString() {
        return super.toString() + "\n\nCar Details: " + "\nMaxPassengers " + getMaxPassengers() + "\nRegistrationNumber " + getRegistrationNumber();
    }
}
