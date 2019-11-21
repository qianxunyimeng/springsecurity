package com.qianxun.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qianxun.dto.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-10-20 17:13
 */

@RestController
public class UserCobtroller {

    @RequestMapping(value="/user",method = RequestMethod.GET)
    @JsonView(User.userSampleView.class)
    public List<User> query(@RequestParam(name="username",required = false,defaultValue = "tom") String username){
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return  list;
    }
}
