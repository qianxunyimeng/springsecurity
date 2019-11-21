package com.qianxun.dto;

import com.fasterxml.jackson.annotation.JsonView;

import java.sql.PreparedStatement;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-10-20 17:16
 */
public class User {

    public interface  userSampleView{};

    public interface userDetailView extends userSampleView{};

    private String username;

    private String password;

    @JsonView(userSampleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonView(userDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
