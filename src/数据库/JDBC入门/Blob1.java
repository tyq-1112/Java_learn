package 数据库.JDBC入门;

import org.apache.commons.io.IOUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Blob1 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstm = null;
        //存大数据
        try {
            con = JDBCutils.getconnection();
            String sql = "INSERT INTO songs_bin values (?,?,?)";
            pstm = con.prepareStatement(sql);

            //把文件换成byte[]
            byte[] bytes = IOUtils.toByteArray(new FileInputStream("D:\\Desktop\\my all.mp3"));

            //byte[]创建blob
            Blob blob = new SerialBlob(bytes);

            pstm.setString(1, null);
            pstm.setString(2, "my all.mp3");
            pstm.setBlob(3, blob);

            pstm.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //取数据
        ResultSet set = null;
        try {
            con = JDBCutils.getconnection();
            String sql = "select * from songs_bin where id = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, 1);
            set = pstm.executeQuery();

            if (set.next()) {
                System.out.print("歌名：" + set.getString("filename"));

                Blob blob = set.getBlob("data");
                //通过Blob得到输入流
                InputStream in = blob.getBinaryStream();
                //自己创建输出流
                OutputStream out = new FileOutputStream("C:\\Desktop\\my all.mp3");
                //把输入流的数据写到输出流中
                IOUtils.copy(in, out);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
