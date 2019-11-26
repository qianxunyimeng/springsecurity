package com.qianxun.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qianxun.dto.User;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-10-20 17:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.userSampleView.class)
    public List<User> query(@RequestParam(name="username",required = false,defaultValue = "tom") String username,
    @PageableDefault(page = 2,size = 10,sort = "username,desc") Pageable pageable
    ){
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return  list;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.userDetailView.class)
    public User getInfo( @PathVariable String id) {
//		throw new RuntimeException("user not exist");
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if(errors.hasErrors()){

            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                String errorMessage = error.getDefaultMessage();
                System.out.println(field + ": " + errorMessage);
            });

        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody  User user, BindingResult errors) {
        if(errors.hasErrors()){

            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                String errorMessage = error.getDefaultMessage();
                System.out.println(field + ": " + errorMessage);
            });

        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
