package CAs.SecondCA.Three;

public class TestTravelAgency {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John Murphy", "john.m@gmail.com", "085-3345221");
        Customer customer2 = new Customer("Lisa Power", "lisa.power@yahoo.com", "083-9918272");

        Trip trip1 = new Trip("Paris", "12-03-2023", "20-03-2023", 799.99, customer1);
        Trip trip2 = new Trip("Rome", "01-04-2023", "10-04-2023", 699.49, customer2);
        Trip trip3 = new Trip("Tokyo", "05-06-2023", "18-06-2023", 1499.00, customer2);

        TravelAgency travelAgency = new TravelAgency("SkyHigh Travel", "Main St., Tralee", "087-5341111");
        travelAgency.addTrip(trip1);
        travelAgency.addTrip(trip2);
        travelAgency.addTrip(trip3);

        travelAgency.addAgent("Patrick O'Neil");
        travelAgency.addAgent("Samantha Blake");

        travelAgency.makeBooking("24-02-2023",15,trip1);
        travelAgency.makeBooking("24-02-2023",15,trip2);
        travelAgency.makeBooking("24-02-2023",15,trip2);

        System.out.println(travelAgency);

    }
}
