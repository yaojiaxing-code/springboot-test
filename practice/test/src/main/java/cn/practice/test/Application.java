package cn.practice.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cn.practice.test")
@ServletComponentScan
//@ComponentScan(basePackages = {"cn.practice.test.dao"})
//@ComponentScan(basePackages = {"cn.practice.test.service"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
