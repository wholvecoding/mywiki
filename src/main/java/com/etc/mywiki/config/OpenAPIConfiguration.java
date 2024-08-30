package com.etc.mywiki.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;


@Configuration
@Import({CommonConfig.class})
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8088");
        server.setDescription("mywiki Service");

        Contact myContact = new Contact();
        myContact.setName("Yyh");
        myContact.setEmail("wssb@163.com");

        Info information = new Info()
                .title("eBiding API")
                .version("1.0")
                .description("This API exposes endpoints to manage Users.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of());
    }
}

