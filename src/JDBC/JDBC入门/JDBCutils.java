package JDBC.JDBC入门;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 此类保存那些每次连接数据库都要写的语句
 * 得到Connection对象直接调用此类获取
 */
public class JDBCutils {
    public static ResourceBundle rb = null;

    static {  //静态代码块 只执行一次
        rb = ResourceBundle.getBundle("JDBC.JDBC入门.data");
        try {
            Class.forName(rb.getString("jdbc.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws ClassNotFoundException, SQLException {

        return DriverManager.getConnection(rb.getString("jdbc.url"),
                rb.getString("jdbc.username"),
                rb.getString("jdbc.password"));
    }
}
