package 小实例.学生管理系统;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private String content;   //数据格式模板
    private Student students[];

    /**
     * 排序后的处理数据
     *
     * @return
     */
    @Override
    public Student[] getData1() {

        if (students == null) return null;
        Arrays.sort(students);
        return this.students;
    }

    /**
     * 向数据库取得全体数据，排序输出
     *
     * @return
     */
    @Override
    public Student[] getData2() throws SQLException {
        Connection connection = JDBCutil.getConnection();
        String sql = "select * from stu";
        PreparedStatement pstm = connection.prepareStatement(sql);
        //得到结果集
        ResultSet set = pstm.executeQuery();
        //获取数据行数
        int row = 0;
        while (set.next()) row = set.getRow();
        //开辟数组大小
        this.students = new Student[row];
        set.absolute(0);
        while (set.next()) {
            String name = set.getString(1);
            Double score = set.getDouble(2);
            this.students[set.getRow() - 1] = new Student(name, score);
        }
        set.close();
        pstm.close();
        connection.close();
        Arrays.sort(students);
        if (this.students == null) return null;
        return this.students;
    }

    /**
     * 向数据库添加学生
     *
     * @throws Exception
     */
    @Override
    public void addStudent() throws Exception {
        //输入学生模板数据
        System.out.print("输入学生信息：");
        Scanner input = new Scanner(System.in);
        this.content = input.nextLine();
        //拆分数据存到对象中
        this.splitStudent();
        Connection connection = JDBCutil.getConnection();
        //sql模板
        String sql = "insert into stu values(?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        //设置参数,使用批处理
        for (int i = 0; i < students.length; i++) {
            pstm.setString(1, students[i].getName());
            pstm.setDouble(2, students[i].getSocre());
            pstm.addBatch();
        }
        //执行批
        pstm.executeBatch();
        System.out.println("插入成功");
        pstm.close();
        connection.close();
    }

    /**
     * 拆分数据格式  姓名：成绩 | 姓名：成绩 |
     *
     * @return
     */
    @Override
    public void splitStudent() {
        String results[] = content.split("\\|");
        this.students = new Student[results.length];
        for (int i = 0; i < students.length; i++) {
            String temp[] = results[i].split(":");
            this.students[i] = new Student(temp[0], Double.parseDouble(temp[1]));
        }
    }
}
