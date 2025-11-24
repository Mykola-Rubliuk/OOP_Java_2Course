package OOPCA2_MykolaRubliuk.src;
//Module class is a "standard" class. This class contains information about this Module that we can use in other class
import java.util.Arrays;

public class Module {
    private String name;
    private int moduleCode;
    private int credits;
    private int lectureHours;
    private int labHours;
    private String[] groups;
    private String[] lectures;

    public Module(String name, int credits, int lectureHours, int labHours, String[] groups, String[] lectures) {
        setName(name);
        setModuleCode();
        setCredits(credits);
        setLectureHours(lectureHours);
        setLabHours(labHours);
        setGroups(groups);
        setLectures(lectures);
    }
    public Module(Module other) {
        setName(other.getName());
        setModuleCode();
        setCredits(other.getCredits());
        setLectureHours(other.getLectureHours());
        setLabHours(other.getLabHours());
        setGroups(other.getGroups());
        setLectures(other.getLectures());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode() {
        this.moduleCode = (int) (Math.random() * 90000) + 10000;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if ((credits > 0 && credits <= 15) && (credits % 5 == 0)) {
            this.credits = credits;
        } else {
            this.credits = 5;
        }
    }

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public String[] getGroups() {
        return Arrays.copyOf(groups, groups.length);
    }

    public void setGroups(String[] groups) {
        this.groups = Arrays.copyOf(groups, groups.length);
    }

    public String[] getLectures() {
        return Arrays.copyOf(lectures, lectures.length);
    }

    public void setLectures(String[] lectures) {
        this.lectures = Arrays.copyOf(lectures, lectures.length);
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nCode: " + getModuleCode() + "\nCredits: " + getCredits() + "\nLecture Hours: " + getLectureHours() + "\nLab Hours: " + getLabHours() + "\nGroups: " + Arrays.toString(getGroups()) + "\nLectures: " + Arrays.toString(getLectures());
    }
}
