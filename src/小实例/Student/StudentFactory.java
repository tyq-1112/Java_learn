package 小实例.Student;

public class StudentFactory {
    private StudentFactory() {
    }

    public static IStudentService getInstance() {
        return new StudentService();
    }
}
