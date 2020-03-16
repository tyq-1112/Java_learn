# JDBC入门

### jdbc四大配置参数

> 导jar包：驱动
>
> 加载驱动类：class.forName("类名")
>
> 给出url 、username 、password 
>
> 使用DriverManager类来得到connection对象

```properties
jdbc.Driver = com.mysql.jdbc.Driver
jdbc.url = jdbc:mysql://localhost:3306/aliyun_test?serverTimezone=UTC
jdbc.username = root
jdbc.password = 121314
```

```java
ResourceBundle RD = ResourceBundle.getBundle("JDBC入门.data");

Class.forName(RD.getString("jdbc.Driver"));
//com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//DriverManager.registerDriver(driver);

//所有的java.sql.Driver实现类，都提供static块，块内的代码就是把自己注册到DriverManager中！
Connection con = DriverManager.getConnection(RD.getString("jdbc.url"),
        RD.getString("jdbc.username"),
        RD.getString("jdbc.password"));
System.out.println(con);
```



### JDBC完成增、删、改、查

1.通过**Connection**对象创建**Statement**

> Statement语句的发送器，功能就是想数据库发送sql语句

2.调用它的int executeUpdate(String sql) ,它可以发送DML、DDL

```java
Statement state = con.createStatement();
String sql = "INSERT INTO tb_stu values (null , '杜甫',20,'男','1998-2-4')" ;
int change = state.executeUpdate(sql);
```

**查询：**

3.调用Statement的**ResultSet** rs = excuteQuery(String querysql)

```java
ResultSet set = state.executeQuery("select * from emp") ;
//解析ResultSet
while(set.next()){   //判断下一行是否存在
    String name = set.getString("ename");    //通过名称来获取该列的值
    String job = set.getString(4);            //通过编号来获取该列的值
    double sal = set.getDouble(5);
    System.out.println(name + "、" + job + "、" + sal);
```

**最后关闭资源：**

```java
set.close();
state.close();
con.close();
```



### JDBC代码规范化

```java
package JDBC入门;

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
            String sql = "insert into tb_stu values(null,'柳宗元',25,'男','1997-5-9')";
            state.executeUpdate(sql);
            String csql = "select * from emp";
            set = state.executeQuery(csql);

            //三、循环遍历set，打印数据
            int column = set.getMetaData().getColumnCount();    //得到列数
            //获取指定列的列名：String getColumnName(int index)
            while (set.next()) {
                for(int i = 1 ; i<=column ;i++){
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
```



### 结果集的特性

> 是否滚动：ResultSet的方法分为两类，一类用来判断游标位置的，另一类是用来移动游标的。如果结果集是不可滚动的，那么只能使用next()方法来移动游标，而beforeFirst()、afterLast()、first()、last()、previous()、relative()方法都不能使用
>
> 是否敏感(敏感：数据库改变，使结果集也会改变)
>
> 是否可更新(可更新：修改结果集，使数据库也改变)

```java
1.con.createStatement()  ——>  生成的结果集：不滚动、不敏感、不可更新

2.con.createStatement(int ,int )

第一个参数：

//ResultSet.TYPE_Forward_ONLY ：不滚动结果集

//ResultSet.TYPE_SCROLL_INSENSITIVE ：滚动结果集，但是结果集数据不会跟随数据库变化而变化

//ResultSet.TYPE_SCROLL_SENSITIVE：滚动结果集，但是结果集数据不会跟随数据库变化而变化(基本不用)

第二个参数：

 //CONCUR_REND_ONLY：结果集只读，不嫩通过修改结果集而影响数据库

 //CONCUR_UPDATABLE：结果集可更新，对结果集更新影响数据库
```



### PreparedStatement的用法

> 它是Statement接口的子接口
>
> 防SQL攻击
>
> 提高代码的可读性、可维护性
>
> **得到PreparedStatement对象**
>
> >给出SQL模板
> >
> >调用Connection的preparedStatement preparedStatement(String SQL模板)
> >
> >调用preparedStatement的setXXX() 方法对SQL模板的？赋值
> >
> >调用preparedStatement的executeUpdate() 或execteQuery() ,  无参数

```java
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
        //获取资源文件的值
        ResourceBundle rb = ResourceBundle.getBundle("JDBC入门.data");
        //加载类
        Class.forName(rb.getString("jdbc.Driver"));
        //获取连接
        con = DriverManager.getConnection(rb.getString("jdbc.url"),
                rb.getString("jdbc.username"),
                rb.getString("jdbc.password"));

        //SQL模板
        String sql = "select * from emp where ename=? and empno=?" ;
        
        //得到PreparedStatement 对象
        pstm = con.prepareStatement(sql) ;

        //设置参数
        pstm.setString(1,ename);
        pstm.setString(2,empno);
        
        //向数据库发送查询语句，得到结果集
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
    
    String sql = "select * from emp where ename='" + ename +"'and empno='" + empno +"'" ;
    
    防止ename = "a' or 'a' = 'a"; empno = "a' or 'a' = 'a";登陆进去
    ——> sql = "select * from emp where ename ='a'or 'a' = 'a' and empno =‘a'or'a' = 'a'";
        
        PreparedStatement：用setXXX()方法设置参数后
    ——> sql = "select * from emp where ename=? and empno=? ";
```



### 预处理的原理

**服务器的工作：**

> 校验sql语句的语法
>
> 编译：一个与函数相似的东西
>
> 执行：调用函数

**preparedStatement：**

> 每一个preparedStatement都与一个sql模板绑定在一起，

> 先把sql模板给数据库，数据库进行校验，再进行编译，执行时把参数传递过去
>
> 若第二次执行时，不用校验和编译，直接执行



### jdbcUtils1.0小工具

```java
/**
 * 此类保存那些每次连接数据库都要写的语句
 * 得到Connection对象直接调用此类获取
 */
public class JDBCutils {
    public static ResourceBundle rb = null ;
    static {  //静态代码块 只执行一次
         rb = ResourceBundle.getBundle("JDBC入门.data");
        try {
            Class.forName(rb.getString("jdbc.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static  Connection getconnection() throws ClassNotFoundException, SQLException {

        return DriverManager.getConnection(rb.getString("jdbc.url"),
                rb.getString("jdbc.username"),
                rb.getString("jdbc.password"));
    }
}
```



### util包下的Date与sql包下的时间类型之间的转换

**数据库类型与Java中类型的对应关系：**

> DATE ——> java.sql.Date
>
> TIME——> java.sql.Time
>
> TIMESTAMP——> java.sql.Timestamp

**ResultSet #getDate()  返回的是 java.sql.Date()**

**PreparedStatement # setDate(int , Date), 其中第二个参数是 sql.Date****



时间类型的转换：

java.util.Date   —— >  java.sql.Date、Time、Timestamp

> 把util的Dtae转换橙毫秒值
>
> 使用毫秒值创建sql 的Dtae、Time、Timestamp

java.sql.Date  —— > java.util.Date

> sql.Date 是 util.Date的子类，不需要处理



### Blob文件存取

```java
import org.apache.commons.io.IOUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Blob1 {
    public static void main(String[] args) {
        Connection con = null ;
        PreparedStatement pstm = null ;
        //存歌曲数据
        try{
            con = JDBCutils.getconnection();
            String sql = "INSERT INTO songs_bin values (?,?,?)";
            pstm = con.prepareStatement(sql);

            //把文件换成byte[]
            byte[] bytes = IOUtils.toByteArray(new FileInputStream("D:\\Desktop\\my all.mp3"));
            //byte[]创建blob
            Blob blob = new SerialBlob(bytes) ;

            pstm.setString(1,null);
            pstm.setString(2,"my all.mp3");
            pstm.setBlob(3,blob);

            pstm.executeUpdate();

        }catch (Exception e){
            throw new RuntimeException(e) ;
        }

        //取歌曲
        ResultSet set = null ;
        try{
            con = JDBCutils.getconnection() ;
            String sql = "select * from songs_bin where id = ?" ;
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,1);
            set = pstm.executeQuery() ;

            if(set.next()){
                System.out.print("歌名："+set.getString("filename"));

                Blob blob = set.getBlob("data") ;
                //通过Blob得到输入流
                InputStream in = blob.getBinaryStream();
                //自己创建输出流
                OutputStream out = new FileOutputStream("C:\\Desktop\\my all.mp3") ;
                //把输入流的数据写到输出流中
                IOUtils.copy(in,out);


            }
        }catch (Exception e){
            throw new RuntimeException(e) ;
        }
    }
}
```



### 批处理

```java
public class Batch {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null ;
        PreparedStatement pstm = null ;
        con = JDBCutils.getconnection() ;            //获得连接
        String sql = "insert into tb_stu values(?,?,?,?)";          //SQL模板
        pstm = con.prepareStatement(sql) ;
        for(int i=1;i<10000;i++){
            pstm.setInt(1,i+1);
            pstm.setString(2,"stu"+i);
            pstm.setInt(3, new Random().nextInt(80));
            if(i%3==0) pstm.setString(4,"男");
            else pstm.setString(4,"女");
            pstm.addBatch();                                         //将一批数据到集合中
        }
        long start = System.currentTimeMillis();
        pstm.executeBatch() ;                                        //执行批
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
```

```properties
jdbc.Driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/aliyun_test?serverTimezone=UTC&rewriteBatchedStatements=true
jdbc.username=root
jdbc.password=121314
```

