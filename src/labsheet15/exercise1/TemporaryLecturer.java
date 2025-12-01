package labsheet15.exercise1;

import java.util.GregorianCalendar;

public class TemporaryLecturer extends Lecturer {
    private int hoursWorked;

    public TemporaryLecturer(){
        super();
        setHoursWorked(0);
    }

    public TemporaryLecturer(String name, String address, GregorianCalendar dateOfBirth, String staffID, String[] coursesTaught, GregorianCalendar dateOfAppointment, int hoursWorked) {
        super(name, address, dateOfBirth, staffID, coursesTaught, dateOfAppointment);
        setHoursWorked(hoursWorked);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getStatus() {
        return "Contracted temporary lecturer on part-time hour";
    }

    @Override
    public int getPointOnScale() {
        GregorianCalendar date = new GregorianCalendar();
        GregorianCalendar appointment = getDateOfAppointment();
        int experience = date.get(GregorianCalendar.YEAR) - appointment.get(GregorianCalendar.YEAR);
        if (experience >= 3) {
            if (getHoursWorked() >= 1500) return 4;
            if (getHoursWorked() >= 1000) return (int)((getHoursWorked() *  1.33) / 700 + 1);
        }
        return experience;
    }

    @Override
    public String toString() {
        return super.toString() + " Point on scale " + getPointOnScale();
    }
}

