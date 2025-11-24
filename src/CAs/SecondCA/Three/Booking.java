package CAs.SecondCA.Three;

public class Booking {
    private static int counter = 2000;
    private int BookingID;
    private String date;
    private int hour;
    private Trip trip;
    private String agentName;
    private char status;

    public Booking(String date, int hour, Trip trip, String agentName) {
        setBookingID();
        setDate(date);
        setHour(hour);
        setTrip(trip);
        setAgentName(agentName);
        counter++;
        status = 'A';
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID() {
        BookingID = counter;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Trip getTrip() {
        return new Trip(trip);
    }

    public void setTrip(Trip trip) {
        this.trip = new Trip(trip);
    }

    public char getStatus() {
        return status;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "Booking Details\n\nBooking ID: " + getBookingID() + "\nDate: " + getDate() + "\nHour: " + getHour() + "\nTrip: " + getTrip() + "\nStatus: " + getStatus() + "\nAgent: " + getAgentName() + "\n";
    }
}
