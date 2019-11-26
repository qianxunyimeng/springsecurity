package com.qianxun.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.qianxun.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-10-20 17:16
 */
@Component
public class User {

    //使用接口声明视图
    public interface  userSampleView{};

    public interface userDetailView extends userSampleView{};

    private String id;
    @MyConstraint(message = "这是一个测试")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    @JsonView(userSampleView.class)
    public String getUsername() {
        return username;
    }//用户简单信息，不会包含密码信息

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
    @JsonView(userSampleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonView(userSampleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
