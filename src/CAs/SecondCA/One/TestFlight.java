package CAs.SecondCA.One;

import java.util.Arrays;

public class TestFlight {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Joe Bloggs","23 Spa Rd, Tralee, Co. Kerry", "12-04-1978","joebloggs999@gmail.com","085-1234567");
        Flight flight = new Flight("FR322","Ryanair","Shannon", "Alicante","22-07-2024","15:15","22-07-2024", "17:30");
        flight.addBooking(customer1);
        flight.addBooking(customer1);


    }
}