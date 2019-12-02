package com.qianxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 千寻
 * @version 1.0
 * @create 2019-10-19 17:12
 */

@SpringBootApplication
@RestController
@EnableSwagger2
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
