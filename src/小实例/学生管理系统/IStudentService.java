package 小实例.学生管理系统;

import java.sql.SQLException;

/**
 * 定义Student接口标准
 */
public interface IStudentService {
    //每一次插入数据排序后的数据
    public Student[] getData1();

    //添加数据
    public void addStudent() throws Exception;

    //拆分格式
    public void splitStudent();

    //取得数据库中所有学生数据
    public Student[] getData2() throws SQLException;
}
