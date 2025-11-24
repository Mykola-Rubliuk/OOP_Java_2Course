package CAs.SecondCA.One;

import java.util.Arrays;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String dateOfBirth;
    private String email;
    private String mobile;
    private Booking[] bookings;

    public Customer(String name, String address, String dateOfBirth, String email, String mobile) {
        setCustomerID();
        setName(name);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
        setEmail(email);
        setMobile(mobile);
        bookings = new Booking[20];
    }

    public String getCustomerID() {
        return customerID;
    }

    private void setCustomerID() {
        this.customerID = String.valueOf((Math.random() * 300_000_000) + 100_000_000);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void addBooking(Booking booking) {
        Booking[] subBooking = new Booking[this.bookings.length];
        for (int i = 1; i < this.bookings.length; i++) {
            subBooking[i] = bookings[i];
        }
        subBooking[0] = booking;
        this.bookings = subBooking;
    }

    public String bookingDetails() {
        String bookingDetails = "";
        for (int i = 0; i < this.bookings.length; i++) {
            if (bookings[i] != null) {
                bookingDetails += bookings[i].toString();
            }
        }
        return bookingDetails;
    }

    @Override
    public String toString() {
        return "Customer Details:\n\n" +
                "ID: " + getCustomerID() + " Name: " + getName() + " Address: " + getAddress() + " Date of Birth " + getDateOfBirth() + " Email: " + getEmail() + " Mobile: " + getMobile();
    }

}
