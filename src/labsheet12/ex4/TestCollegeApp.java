package labsheet12.ex4;

public class TestCollegeApp {
    public static void main(String[] args) {
        Student student1 = new Student(154345, "Jake", "Computing");
        Student student2 = new Student(234567, "Mary", "Creative Media");
        Student student3 = new Student(345678, "Tommy", "Computing");
        Student student4 = new Student(456789, "Peter", "Creative Media");

        Student[] computingStudents = new Student[10];
        computingStudents[0] = student1;
        computingStudents[1] = student3;

        Student[] mediaStudents = new Student[10];
        mediaStudents[0] = student2;
        mediaStudents[1] = student4;

        Department computingDept = new Department("Computing", computingStudents);
        Department mediaDept = new Department("Creative Media", mediaStudents);

        Department[] departments = new Department[5];
        departments[0] = computingDept;
        departments[1] = mediaDept;

        Institute institute = new Institute("Institute of Technology, Tralee", departments);

        System.out.println(institute);
        System.out.println(institute.getTotalStudents());
        institute.moveStudent(154345, "Computing", "Creative Media");
    }
}
