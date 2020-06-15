package com.entity;

public class User {
    private Integer user_Id;
    private String userName;
    private String password;
    private String sex;
    private String email;

    public User() {

    }

    public User(Integer user_Id, String userName, String password, String sex, String email) {
        this.user_Id = user_Id;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
