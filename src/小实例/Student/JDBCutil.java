package 小实例.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCutil {
    private static ResourceBundle rb = null;

    /**
     * 静态代码块，只执行一次，
     */
    static {
        rb = ResourceBundle.getBundle("小实例.Student.mysqlsource");
        try {
            Class.forName(rb.getString("jdbc.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到mysql连接
     *
     * @return Connect对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(rb.getString("jdbc.url"),
                rb.getString("jdbc.username"),
                rb.getString("jdbc.password"));
    }
}
