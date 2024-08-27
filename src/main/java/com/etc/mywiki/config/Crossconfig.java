package com.etc.mywiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Crossconfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedMethods("GET","PUT","POST","DELETE")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
