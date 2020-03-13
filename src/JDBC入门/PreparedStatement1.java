package JDBC入门;

import java.sql.*;

public class PreparedStatement1 {
    public static void main(String[] args) throws  SQLException {
        String ename = "SMITH";
        String empno = "7369" ;
        System.out.println(login(ename,empno));
    }
    /**
     * 登陆
     * 使用 ename 和 empno 去查询数据
     * 若查出结果集，返回 true
     */
    public static boolean login(String ename ,String empno) throws SQLException {
        Connection con = null ;
        PreparedStatement pstm = null ;
        ResultSet set = null ;
        try{
            //获取连接
            con = JDBCutils.getconnection();
            //SQL模板
            String sql = "select * from emp where ename=? and empno=?" ;

            //得到PreparedStatement 对象
            pstm = con.prepareStatement(sql) ;

            //设置参数
            pstm.setString(1,ename);
            pstm.setString(2,empno);

            //得到结果集
            set = pstm.executeQuery();

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            boolean flag = set.next();
            if(set!=null )set.close();
            if(pstm!=null )pstm.close();
            if(con!=null )con.close();
            return flag;
        }
    }
}
