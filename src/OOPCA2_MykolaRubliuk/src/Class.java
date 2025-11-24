package OOPCA2_MykolaRubliuk.src;
//Class is a "standard" class. That contains information about this Class that we can use in other class
public class Class {
    private Module module;
    private String room;
    private String lecturer;
    private int startHour;
    private int endHour;
    private String type;

    public Class(Module module, String room, String lecturer, String type) {
        setModule(module);
        setRoom(room);
        setLecturer(lecturer);
        setType(type);
        setStartHour(0);
        setEndHour(0);
    }

    public Module getModule() {
        return new Module(module);
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room: " + getRoom() + "\nStart hour: " + getStartHour() + "\nEnd hour: " + getEndHour() + "\nLecturer: " + getLecturer() + "\nType: " + getType();
    }
}
