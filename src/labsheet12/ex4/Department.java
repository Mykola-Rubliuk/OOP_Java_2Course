package labsheet12.ex4;

import java.util.Arrays;

public class Department {
    private String name;
    private Student[] students;

    public Department(String name, Student[] students) {
        setName(name);
        setStudents(students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return Arrays.copyOf(students, students.length);
    }

    public void setStudents(Student[] students) {
        this.students = Arrays.copyOf(students, students.length);
    }

    @Override
    public String toString() {
        return "Departments:\n" +
                "Name=" + getName() + "\n" +
                "List of students: \n\n" +
                Arrays.toString(getStudents());
    }
}
