package labsheet15.exercise1;

import java.util.GregorianCalendar;

public class PermanentLecturer extends Lecturer {
    private String pensionEntitlements;
    private String status;

    public PermanentLecturer(String name, String address, GregorianCalendar dateOfBirth, String staffID, String[] coursesTaught, GregorianCalendar dateOfAppointment, String pensionEntitlements, String status) {
        super(name, address, dateOfBirth, staffID, coursesTaught, dateOfAppointment);
        setPensionEntitlements(pensionEntitlements);
        setStatus(status);
    }

    public PermanentLecturer() {
        super();
        setStatus("NoStatus");
        setPensionEntitlements("NoPensionEntitlements");
    }

    public String getPensionEntitlements() {
        return pensionEntitlements;
    }

    public void setPensionEntitlements(String pensionEntitlements) {
        this.pensionEntitlements = pensionEntitlements;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPointOnScale() {
        GregorianCalendar date = new GregorianCalendar();
        GregorianCalendar appointment = getDateOfAppointment();
        int experience = date.get(GregorianCalendar.YEAR) - appointment.get(GregorianCalendar.YEAR);
        return Math.min(experience, 20);

    }

    @Override
    public String toString() {
        return super.toString() + " Point on scale " + getPointOnScale();

    }
}
