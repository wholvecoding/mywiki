package com.etc.mywiki.vo;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

/**
 * AllArgsConstructor注解将在当前类加一个有参构造，需要对所有字段进行赋值
 * Component注解，由SpringBoot管理当前类的对象
 * Value注解，在当前加属性的setter方法
 */
//@AllArgsConstructor
@Value
public class User {
    private String name;
    private int age;


}
