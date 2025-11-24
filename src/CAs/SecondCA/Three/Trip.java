package CAs.SecondCA.Three;

public class Trip {
    private static int count = 20000;
    private int tripID;
    private String destination;
    private String startDate;
    private String endDate;
    private double price;
    private Customer customer;

    public Trip(String destination, String startDate, String endDate, double price, Customer customer) {
        setTripID();
        setDestination(destination);
        setStartDate(startDate);
        setEndDate(endDate);
        setPrice(price);
        setCustomer(customer);
    }

    public Trip(Trip other) {
        setTripID();
        setDestination(other.getDestination());
        setStartDate(other.getStartDate());
        setEndDate(other.getEndDate());
        setPrice(other.getPrice());
        setCustomer(other.getCustomer());
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID() {
        this.tripID = count++;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    @Override
    public String toString() {
        return "Trip Details\n\n TripID " + getTripID() + " Destination " + getDestination() + " Customer " + getCustomer();
    }
}
