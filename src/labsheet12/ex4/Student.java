package labsheet12.ex4;

public class Student {
    private int id;
    private String name;
    private String department;

    public Student(int id, String name, String department){
        setId(id);
        setName(name);
        setDepartment(department);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "ID: " + getId() + "Dept: " + getDepartment();
    }
}
