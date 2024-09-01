//package com.etc.mywiki.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class OpenAPIConfig {
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        Server server = new Server();
//        server.setUrl("http://localhost:8088"); // Adjust to your application's base URL
//        server.setDescription("Local Server");
//
//        Contact contact = new Contact()
//                .name("Your Name")
//                .email("your_email@example.com");
//
//        Info info = new Info()
//                .title("API Documentation")
//                .version("1.0")
//                .description("API documentation for the application.")
//                .contact(contact);
//
//        return new OpenAPI().info(info).servers(List.of(server));
//    }
//}
