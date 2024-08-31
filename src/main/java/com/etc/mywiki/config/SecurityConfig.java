package com.etc.mywiki.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
//@EnableWebSecurity//开启Spring Security的功能
//prePostEnabled属性决定Spring Security在接口前注解是否可用@PreAuthorize,@PostAuthorize等注解,设置为true,会拦截加了这些注解的接口
@EnableGlobalMethodSecurity(prePostEnabled=true)
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SecurityConfig  {
//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /**
//         * 基于内存的方式，创建两个用户admin/123456，user/123456
//         * */
//        auth.inMemoryAuthentication()
//                .withUser("admin")//用户名
//                .password(passwordEncoder().encode("123456"))//密码
//                .roles("ADMIN");//角色
//        auth.inMemoryAuthentication()
//                .withUser("user")//用户名
//                .password(passwordEncoder().encode("123456"))//密码
//                .roles("USER");//角色
//    }

    /**
     * 指定加密方式
     */
   // @Bean
//    public PasswordEncoder passwordEncoder(){
//        // 使用BCrypt加密密码
//        return new BCryptPasswordEncoder();
//    }
}



