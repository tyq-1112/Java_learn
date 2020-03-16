package 数据库.JDBC入门;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Batch {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;
        con = JDBCutils.getconnection();            //获得连接
        String sql = "insert into tb_stu values(?,?,?,?)";          //SQL模板
        pstm = con.prepareStatement(sql);
        for (int i = 1; i < 10000; i++) {
            pstm.setInt(1, i + 1);
            pstm.setString(2, "stu" + i);
            pstm.setInt(3, new Random().nextInt(80));
            if (i % 3 == 0) pstm.setString(4, "男");
            else pstm.setString(4, "女");
            pstm.addBatch();                                         //将一批数据到集合中
        }
        long start = System.currentTimeMillis();
        pstm.executeBatch();                                        //执行批
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
