package 数据库.JDBC入门;

import java.sql.*;
import java.util.ResourceBundle;

public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ResourceBundle RD = ResourceBundle.getBundle("数据库.JDBC入门.data");
        Class.forName(RD.getString("jdbc.Driver"));
        //com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        //DriverManager.registerDriver(driver);

        Connection con = DriverManager.getConnection(RD.getString("jdbc.url"),
                RD.getString("jdbc.username"),
                RD.getString("jdbc.password"));
        Statement state = con.createStatement();
        String sql = "INSERT INTO tb_stu values (null , '杜甫',20,'男','1998-2-4')";
        int change = state.executeUpdate(sql);

        ResultSet set = state.executeQuery("select * from emp");
        //解析ResultSet
        while (set.next()) {   //判断下一行是否存在
            String name = set.getString("ename");    //通过名称来获取该列的值
            String job = set.getString(4);            //通过编号来获取该列的值
            double sal = set.getDouble(5);
            System.out.println(name + "、" + job + "、" + sal);
        }
        //最后关闭资源 ， 倒关
        set.close();
        state.close();
        con.close();
    }

}
