package 小实例.学生管理系统;

public class StudentFactory {
    private StudentFactory() {
    }

    public static IStudentService getInstance() {
        return new StudentService();
    }
}
