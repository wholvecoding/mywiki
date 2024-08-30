package com.etc.mywiki.controller;

import com.etc.mywiki.vo.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制器类，类名以Controller结尾
 * 注解：springBoot3以后使用RestController声明一个控制器类，
 * 返回内容以json格式数据为主，只要前后端数据传输接口固定，前后端可同时开发，
 * 符合Restfule框架，http://localhost/xxx?name=tom容易产生sql注入
 * http://localhost/xxx/tom
 */
@RestController
public class HelloController {
    /**
     * Value注解，读取项目配置文件，根据配置文件中的key获取对应的value
     * 将配置文件的value赋值给字段
     */
    @Value("${school.name}")
    private String schoolname;

    /**
     * 控制器方法注解取决于使用哪种http请求方法
     * GET
     * POST
     * DELET
     * PUT
     * OPTION
     * GETMapping表示接收get请求
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/school")
    public String hellschool(){
        return "hello "+schoolname;
    }

    /**
     * RequestParam注解表示声明请求参数
     * 注解中的name是前端发送请求时的参数名
     * 控制器方法中的参数name是接收请求值的本地变量
     * 使用对象形式的请求参数，首先创建参数对象
     * 根据请求参数的key通过反射机制去对象中查找对应的set方法，key=>name,找setName方法
     * 如果有这个方法则调用set方法为对象属性赋值
     * @return
     */
    @PostMapping("/hellopost")
    //public String hellopost(@RequestParam("name") String name,
    // @RequestParam("age") int age)
    public String hellopost(User user){
        return "hello "+user.getName()+" "+user.getAge();
    }

}
