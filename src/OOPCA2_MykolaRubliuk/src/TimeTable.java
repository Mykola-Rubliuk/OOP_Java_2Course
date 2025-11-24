package OOPCA2_MykolaRubliuk.src;
//TimeTable class has a composition relationship with (class) Class.
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TimeTable {
    private String groupName;
    private int groupCount;
    private Class[] classes;

    public TimeTable(String groupName, int groupCount) {
        setGroupName(groupName);
        setGroupCount(groupCount);
        classes = new Class[45];
        //example of the composition
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public Class[] getClasses() {
        return Arrays.copyOf(classes, classes.length);
        //
    }

    private String isValidStartAndEndHour(int start, int end) {
        if (start < 9 || start > 17) {
            JOptionPane.showMessageDialog(null, "Start hour for class invalid", "Error",  JOptionPane.ERROR_MESSAGE);
            return "Start hour for class invalid";
        }
        if (end < 10 || end > 18) {
            JOptionPane.showMessageDialog(null, "End hour for class invalid", "Error",  JOptionPane.ERROR_MESSAGE);
            return "End hour for class invalid";
        }
        if (start > end) {
            JOptionPane.showMessageDialog(null, "Start hour for class invalid", "Error",  JOptionPane.ERROR_MESSAGE);
            return "Start hour must be less than end hour for class";
        }
        return "valid";
    }

    public int mapClassDayTimeToArrayIndex(String day, int startHour) {
        day = day.toLowerCase();
        int dayIndex = -1;
        dayIndex = switch (day) {
            case "monday" -> 0;
            case "tuesday" -> 1;
            case "wednesday" -> 2;
            case "thursday" -> 3;
            case "friday" -> 4;
            default -> dayIndex;
        };

        return dayIndex * 9 + (startHour - 9);
    }

    public void addClass(String day, int startHour, int endHour, Class class1) {
        if (startHour >= 1 && startHour <= 6)
            startHour = startHour + 12;

        if (endHour >= 1 && endHour <= 6)
            endHour = endHour + 12;

        String result = isValidStartAndEndHour(startHour, endHour);
        if (!result.equals("valid")) {
            System.out.println(result);
            return;
        }
        System.out.println("valid");
        int slot = mapClassDayTimeToArrayIndex(day, startHour);
        if (slot == -1) {
            JOptionPane.showMessageDialog(null, "Invalid day", "Error",  JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = slot; i <= slot + (endHour - startHour) - 1; i++) {
            // slot + (endHour - startHour) - 1 - this formula calculate the during of a lesson
            classes[i] = class1;
        }
        class1.setStartHour(startHour);
        class1.setEndHour(endHour);
        JOptionPane.showMessageDialog(null, "New class added to the timetables. Details are: \n\n\nModules Details : \n\n" + class1.getModule().toString() + "\n\n" + class1);

    }

    public int getWeeklyHours() {
        int totalHours = 0;
        for (Class aClass : classes) {
            if (aClass != null) {
                totalHours += 1;
                //each slot with the class object have only a one-hour so we just increment
            }
        }
        return totalHours;
    }

    public void displayTimeTable() {

        if (classes == null) {
            JOptionPane.showMessageDialog(null, "You must create the array in order to" +
                    " see the timetable!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String timetable = "";

        String[] times = {"9-10", "10-11", "11-12", "12-1", "1-2", "2-3", "3-4", "4-5", "5-6"};
        String[] days = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        timetable += String.format("%-7s", days[0]);

        for (int i = 1; i < days.length; i++) {
            timetable += String.format("%-30s", days[i]);
        }

        timetable += "\n\n";

        for (int i = 0; i < times.length; i++) {
            timetable += String.format("%-7s", times[i]);
            for (int j = i; j < classes.length; j += 9) {
                if (classes[j] != null) {
                    timetable += String.format("%-30s", classes[j].getModule().getName());
                } else
                    timetable += String.format("%-30s", "");
            }

            timetable += "\n";
            timetable += String.format("%-7s", "");
            for (int j = i; j < classes.length; j += 9) {
                if (classes[j] != null) {
                    timetable += String.format("%-30s", classes[j].getRoom());
                } else {
                    timetable += String.format("%-30s", "");
                }
            }
            timetable += "\n";
        }

        JTextArea textArea = new JTextArea();

        Font textAreaFont = new Font("monospaced", Font.PLAIN, 12);

        textArea.setFont(textAreaFont);

        textArea.setText(timetable);

        JOptionPane.showMessageDialog(null, textArea, getGroupName() + " Timetable", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "TimeTable Details:\n" +
                "Group Name " + getGroupName() +
                "\nGroup Count " + getGroupCount() +
                "\nClasses: " + Arrays.toString(getClasses());
    }
}
