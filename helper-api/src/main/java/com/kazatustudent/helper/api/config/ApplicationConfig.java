package com.kazatustudent.helper.api.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class ApplicationConfig {

    @Value("${server.port}")
    private String serverPort;
}
