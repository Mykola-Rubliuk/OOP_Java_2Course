package CAs.SecondCA.One;

import java.util.Arrays;

public class Booking {
    private String bookingID;
    private Customer customer;
    private Flight flight;
    private String passenger;
    private String passportID;
    private String seat;
    private boolean priorityBoarding;
    private int additionalBaggage;

    public Booking(Customer customer, Flight flight, String passenger, String passportID, String seat, boolean priorityBoarding, int additionalBaggage) {
        setBookingID();
        setCustomer(customer);
        setFlight(flight);
        setPassenger(passenger);
        setPassportID(passportID);
        setSeat(seat);
        setPriorityBoarding(priorityBoarding);
        setAdditionalBaggage(additionalBaggage);
    }

    public String getBookingID() {
        return bookingID;
    }


    public void setBookingID() {
        String strBookingID = "";
        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * 26) + 65;
            System.out.println(randomIndex);
            if (i == 3) {
                strBookingID += randomIndex;
            } else {
                strBookingID += String.valueOf(Character.toChars(randomIndex));
            }
        }
        this.bookingID = strBookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean isPriorityBoarding() {
        return priorityBoarding;
    }

    public void setPriorityBoarding(boolean priorityBoarding) {
        this.priorityBoarding = priorityBoarding;
    }

    public int getAdditionalBaggage() {
        return additionalBaggage;
    }

    public void setAdditionalBaggage(int additionalBaggage) {
        this.additionalBaggage = additionalBaggage;
    }

    public String toStringForCustomer() {
        return "";
    }

    @Override
    public String toString() {
        return "Booking ID: " + getBookingID() + "  Customer Details: \n" + getCustomer() +
                "\n Flight Details: \n" + getFlight() + "\n Passenger: " + getCustomer() +
                " Seat" + getSeat() + " PriorityBoarding: " + isPriorityBoarding() +
                " AdditionalBaggage: " + getAdditionalBaggage();
    }


}
