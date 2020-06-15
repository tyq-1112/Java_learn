package com.Dao;

import com.entity.User;
import com.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static JDBCUtil jdbcUtil = new JDBCUtil();

    /**
     * 注册用户
     */
    public static int add(User user) throws SQLException {
        int result = 0;
        String sql = "insert into users values(null,?,?,?,?)";
        PreparedStatement pstm = jdbcUtil.createStatement(sql);
        pstm.setString(1, user.getUserName());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getSex());
        pstm.setString(4, user.getEmail());
        result = pstm.executeUpdate();
        jdbcUtil.close();
        return result;
    }

    /**
     * 查询用户
     */
    public static List find() {
        String sql = "select * from users";
        List<User> list = new ArrayList<>();
        ResultSet set = null;
        PreparedStatement pstm = jdbcUtil.createStatement(sql);
        try {
            set = pstm.executeQuery();
            while (set.next()) {
                Integer userId = set.getInt(1);
                String userName = set.getString(2);
                String password = set.getString(3);
                String sex = set.getString(4);
                String email = set.getString(5);
                User user = new User(userId, userName, password, sex, email);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(set);
        }
        return list;
    }

    /**
     * 删除用户
     */
    public static int del(String id) {
        String sql = "delete from users where userId = ?";
        int result = 0;
        PreparedStatement pstm = jdbcUtil.createStatement(sql);
        try {
            pstm.setInt(1, Integer.parseInt(id));
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return result;
    }

    /**
     * 登陆查询
     */
    public static int login(String userName, String password) {
        int result = 0;
        String sql = "select * from users where userName = ? and password = ?";
        ResultSet set = null;
        PreparedStatement pstm = jdbcUtil.createStatement(sql);
        try {
            pstm.setString(1, userName);
            pstm.setString(2, password);
            set = pstm.executeQuery();
            while (set.next()) {
                result = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(set);
        }
        return result;
    }
}
