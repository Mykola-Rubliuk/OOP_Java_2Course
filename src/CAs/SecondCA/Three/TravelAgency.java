package CAs.SecondCA.Three;

import java.lang.annotation.Retention;
import java.lang.module.FindException;
import java.util.Arrays;
import java.util.Random;

public class TravelAgency {
    private String name;
    private String address;
    private String phone;
    private final String[] agents;
    private final Trip[] trips;
    private final Booking[] bookings;


    public TravelAgency(String name, String address, String phone) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        agents = new String[20];
        trips = new Trip[20];
        bookings = new Booking[20];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addAgent(String agentName) {
        for (int i = 0; i < agents.length; i++) {
            if (agents[i] == null) {
                agents[i] = agentName;
                return;
            }
        }
    }

    public void addTrip(Trip trip) {
        int tripID = trip.getTripID();
        int lastDigitInID = tripID % 10;
        trips[lastDigitInID] = trip;
    }

    public String[] getBookedAgents(String date, int hour) {
        String[] bookedAgents = new String[agents.length];
        int index = 0;
        for (Booking booking : bookings) {
            if (booking != null) {
                if (date.equals(booking.getDate()) && hour == booking.getHour()) {
                    bookedAgents[index] = booking.getAgentName();
                    index++;
                }
            }
        }
        return bookedAgents;
    }

    private boolean linearSearch(String[] arr, String target) {
        for (String s : arr) {
            if (s != null && s.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public String[] getAvailableAgents(String[] bookedAgents) {
        String[] availableAgents = new String[bookedAgents.length];
        for (int i = 0; i < agents.length; i++) {
            if (!(linearSearch(bookedAgents, agents[i]))) {
                availableAgents[i] = agents[i];
            }
        }
        return availableAgents;
    }

    public void makeBooking(String date, int hour, Trip trip) {
        int count = 0;
        String[] bookedAgents = getBookedAgents(date, hour);
        String[] availableAgents = getAvailableAgents(bookedAgents);
        for (String availableAgent : availableAgents) {
            if (availableAgent != null) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Sorry, no agents are available at this time");
            return;
        }
        int randomIndex = (int) (Math.random() * count);

        String agent = "";
        int index = 0;
        for (String availableAgent : availableAgents) {
            if (availableAgent != null) {
                if (index == randomIndex) {
                    agent = availableAgent;
                } else {
                    index++;
                }
            }
        }
        Booking booking = new Booking(date, hour, trip, agent);
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                bookings[i] = booking;
                System.out.println("Booking is made successfully");
                break;
            }
        }

    }

    public String[] getAgents() {
        return agents;
    }

    public Trip[] getTrips() {
        return trips;
    }

    public Booking[] getBookings() {
        return Arrays.copyOf(bookings, bookings.length);
    }

    @Override
    public String toString() {
        return "TravelAgency Details\n\n Name " + getName() + " Bookings: " + Arrays.toString(getBookings());
    }
}
