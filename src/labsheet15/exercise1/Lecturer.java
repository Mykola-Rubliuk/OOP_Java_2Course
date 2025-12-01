package labsheet15.exercise1;

import java.util.Arrays;
import java.util.GregorianCalendar;

public abstract class Lecturer {
    private String name;
    private String address;
    private GregorianCalendar dateOfBirth;
    private String staffID;
    private String[] coursesTaught;
    private GregorianCalendar dateOfAppointment;

    public Lecturer(String name, String address, GregorianCalendar dateOfBirth, String staffID, String[] coursesTaught, GregorianCalendar dateOfAppointment) {
        setName(name);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
        setStaffID(staffID);
        setCoursesTaught(coursesTaught);
        setDateOfAppointment(dateOfAppointment);
    }

    public Lecturer(){
        setName("NoName");
        setAddress("NoAddress");
        setDateOfBirth(new GregorianCalendar());
        setStaffID("NoStaffID");
        setCoursesTaught(new String[]{});
        setDateOfAppointment(new GregorianCalendar());
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

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String[] getCoursesTaught() {
        return Arrays.copyOf(coursesTaught, coursesTaught.length);
    }

    public void setCoursesTaught(String[] coursesTaught) {
        this.coursesTaught = Arrays.copyOf(coursesTaught, coursesTaught.length);
    }

    public GregorianCalendar getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(GregorianCalendar dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public abstract String getStatus();

    public abstract int getPointOnScale();

    public String toString(){
        return "Lecturer name " + getName() + "Status: " + getStatus();
    }
}
