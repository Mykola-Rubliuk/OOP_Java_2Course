package CAs.SecondCA.One;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Flight {
    private static int MAX_BOOKING = 180;
    private static int bookingsCount;
    private String flightID;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String departureTime;
    private boolean[] seats;
    private Booking[] bookings;

    public Flight(String flightID, String airline, String departureAirport, String arrivalAirport, String arrivalDate, String arrivalTime, String departureDate, String departureTime) {
        setFlightID(flightID);
        setAirline(airline);
        setDepartureAirport(departureAirport);
        setArrivalAirport(arrivalAirport);
        setArrivalDate(arrivalDate);
        setArrivalTime(arrivalTime);
        setDepartureDate(departureDate);
        setDepartureTime(departureTime);
        seats = new boolean[MAX_BOOKING];
        bookings = new Booking[MAX_BOOKING];
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void displaySeats() {
        JTextArea textArea = new JTextArea();
        Font textAreaFont = new Font("Courier New", Font.BOLD, 12);
        textArea.setFont(textAreaFont);
        textArea.append(String.format("%-5s%-4s%-4s%-4s%-4s%-4s%-4s\n\n", "", "A", "B", "C", "D", "E", "F"));
        for (int i = 1; i <= 30; i++) {
            textArea.append(String.format("%-5d", i));
            for (int j = 0; j < 6; j++) {
                String seatChar = "☐";
                if (seats[(i - 1) * 6 + j]) seatChar = "X";

                textArea.append(String.format("%-4s", seatChar));
            }
            textArea.append("\n\n");
        }
        JOptionPane.showMessageDialog(null, textArea, "Flight Seats", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addBooking(Customer customer) {
        // 1) ищем первую свободную ячейку в bookings
        int freeIdx = -1;
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                freeIdx = i;
                break;
            }
        }
        if (freeIdx == -1) {
            JOptionPane.showMessageDialog(null, "Sorry, flight is already fully booked");
            return;
        }

        // 2) имя
        String name = JOptionPane.showInputDialog(null, "Please enter the passenger's name");
        if (name == null) {
            JOptionPane.showMessageDialog(null, "Booking cancelled by the customer");
            return;
        }
        name = name.trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.");
            return;
        }

        // 3) паспорт
        String passportID = JOptionPane.showInputDialog(null, "Please enter the passenger's passport ID");
        if (passportID == null) {
            JOptionPane.showMessageDialog(null, "Booking cancelled by the customer");
            return;
        }
        passportID = passportID.trim();
        if (passportID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Passport ID cannot be empty.");
            return;
        }

        // показать схему мест
        displaySeats();

        // 4) выбор места
        String seat;
        int rowNumber;
        char letterChar;
        int seatIndex;

        while (true) {
            seat = JOptionPane.showInputDialog(null, "Please choose the seat (e.g. 19C)");
            if (seat == null) {
                JOptionPane.showMessageDialog(null, "Booking cancelled by the customer");
                return;
            }
            seat = seat.trim().toUpperCase();

            if (seat.length() < 2) {
                JOptionPane.showMessageDialog(null, "Invalid format! Use e.g. 19C");
                continue;
            }

            // отделяем: число = всё кроме последнего символа; буква = последний символ
            String numberPart = seat.substring(0, seat.length() - 1);
            letterChar = seat.charAt(seat.length() - 1);

            try {
                rowNumber = Integer.parseInt(numberPart);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number! Use e.g. 19C");
                continue;
            }

            String result = isValidSeat(String.valueOf(rowNumber), String.valueOf(letterChar));
            if ("X".equals(result)) {
                JOptionPane.showMessageDialog(null, "Booking cancelled by the customer");
                return;
            }
            if (!"Valid".equals(result)) {
                JOptionPane.showMessageDialog(null, "Invalid seat. Try again!");
                continue;
            }

            seatIndex = mapSeatToNumber(rowNumber, letterChar);
            if (seatIndex < 0 || seatIndex >= seats.length) {
                JOptionPane.showMessageDialog(null, "Seat mapping error. Try again.");
                continue;
            }
            if (seats[seatIndex]) {
                JOptionPane.showMessageDialog(null, "Seat already taken. Choose another one.");
                continue;
            }

            // резервируем место (занято)
            seats[seatIndex] = true;
            break;
        }

        // 5) приоритет (Y/N)
        String strPriority = JOptionPane.showInputDialog(null, "Do you wish to avail of priority boarding (Y or N)?");
        if (strPriority == null) {
            JOptionPane.showMessageDialog(null, "Booking cancelled by the customer");
            return;
        }
        boolean priority = strPriority.trim().equalsIgnoreCase("Y");

        // 6) доп. сумки (безопасный парс)
        int extraBags;
        while (true) {
            String bagsStr = JOptionPane.showInputDialog(null, "How many extra bags are you carrying? (0 if none)");
            if (bagsStr == null) {
                JOptionPane.showMessageDialog(null, "Booking cancelled by the customer");
                return;
            }
            bagsStr = bagsStr.trim();
            try {
                extraBags = Integer.parseInt(bagsStr);
                if (extraBags < 0) {
                    JOptionPane.showMessageDialog(null, "Bags cannot be negative.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer number.");
            }
        }

        // 7) создаём и сохраняем Booking
        String seatStr = rowNumber + String.valueOf(letterChar);
        Booking booking = new Booking(customer, this, name, passportID, seatStr, priority, extraBags);

        bookings[freeIdx] = booking;   // кладём в массив бронирований
        customer.addBooking(booking);  // линкуем к клиенту

        JOptionPane.showMessageDialog(null, "Booking completed successfully!");
    }


    private String isValidSeat(String row, String col) {
        if (row.charAt(0) == 'X')
            return "X";
        int number = Integer.parseInt(row);
        if (!(1 <= number && number <= 30)) {
            return "Invalid row. Value must be between 1 and 30 (inclusive)";
        }
        char seatChar = col.charAt(0);
        if (!('A' <= seatChar && seatChar <= 'F')) {
            return "Invalid column. Value must be between A and F (inclusive)";
        }
        return "Valid";
    }

    private int mapSeatToNumber(int row, char col) {
        int intCol = Character.getNumericValue(col) - 10;
        return intCol * row;

    }

    public String bookingsDetails() {
        return "";
    }
}
