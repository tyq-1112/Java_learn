package 数据库.JDBC入门;

import java.sql.*;

public class Standard {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement state = null;
        ResultSet set = null;
        try {
            // 一、得到连接
            String Driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/aliyun_test?serverTimezone=UTC";
            String username = "root";
            String password = "121314";

            Class.forName(Driver);
            con = DriverManager.getConnection(url, username, password);

            //二、创建Statement
            state = con.createStatement();
            //String sql = "insert into tb_stu values(null,'柳宗元',25,'男','1997-5-9')";
            //state.executeUpdate(sql);
            String csql = "select * from emp";
            set = state.executeQuery(csql);

            //三、循环遍历set，打印数据
            int column = set.getMetaData().getColumnCount();    //得到列数
            //获取指定列的列名：String getColumnName(int index)
            while (set.next()) {
                for (int i = 1; i <= column; i++) {
                    System.out.print(set.getString(i));
                    System.out.print("  ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭
            if (set != null) set.close();
            if (state != null) state.close();
            if (con != null) con.close();
        }
    }
}
