package labsheet15.exercise1;

public class TestLecturer {
    public static void main(String[] args) {
        PermanentLecturer permanentLecturer = new PermanentLecturer();
        TemporaryLecturer temporaryLecturer = new TemporaryLecturer();

        Lecturer[] lecturerNames = {permanentLecturer, temporaryLecturer};
        Lecturer lecturerRef;
        for (Lecturer lecturer : lecturerNames) {
            lecturerRef = lecturer;
            System.out.println(lecturerRef);
        }
    }
}
