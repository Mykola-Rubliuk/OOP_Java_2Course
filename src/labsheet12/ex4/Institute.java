package labsheet12.ex4;

import java.util.Arrays;

public class Institute {
    private String name;
    private Department[] departments;

    public Institute(String name, Department[] departments) {
        setName(name);
        setDepartments(departments);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return Arrays.copyOf(departments, departments.length);
    }

    public void setDepartments(Department[] departments) {
        this.departments = Arrays.copyOf(departments, departments.length);
    }

    public int getTotalStudents() {
        int total = 0;
        if (this.departments == null) return 0;

        for (Department dept : this.departments) {
            if (dept == null) continue;

            Student[] students = dept.getStudents();
            if (students == null) continue;

            for (Student s : students) {
                if (s != null) total++;
            }

        }
        return total;
    }

    public void moveStudent(int studentId, String fromDeptName, String toDeptName) {
        int toIndex = -1;
        int fromIndex = -1;

        if (departments == null) return;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) continue;
            if (departments[i].getName().equals(fromDeptName)) fromIndex = i;
            if (departments[i].getName().equals(toDeptName)) toIndex = i;
        }
        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("One or both departments not found.");
            return;
        }

        Student[] fromStudents = departments[fromIndex].getStudents();
        Student[] toStudents = departments[toIndex].getStudents();

        if (fromStudents == null || toStudents == null) {
            System.out.println("One of the student arrays is null.");
            return;
        }

        Student Jake = null;
        int jakePos = -1;

        for (int i = 0; i < fromStudents.length; i++) {
            if (fromStudents[i].getId() == studentId) {
                jakePos = i;
                Jake = fromStudents[i];
                break;
            }
        }
        if (Jake == null) {
            System.out.println(studentId + " not found in " + fromDeptName);
            return;
        }

        fromStudents[jakePos] = null;

        for (int i = 0; i < toStudents.length; i++) {
            if (toStudents[i] == null) {
                toStudents[i] = Jake;
                System.out.println(studentId + " moved to " + toDeptName);
                return;
            }
        }

        System.out.println("No free space in " + toDeptName + " to add " + studentId);
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n\nDepartments\n" + Arrays.toString(getDepartments()) + "\n";
    }
}
