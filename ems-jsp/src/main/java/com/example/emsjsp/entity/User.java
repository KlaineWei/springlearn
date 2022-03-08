package com.example.emsjsp.entity;

public class User {

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private Boolean gender;

    public User() {
    }

    public User(Integer id, String username, String password, String realname, Boolean gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
