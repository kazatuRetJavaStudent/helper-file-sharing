package com.kazatustudent.helper.api.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Setter
public class SecurityConfig implements WebMvcConfigurer {

    @Value("${app.host.protocol}")
    private String hostProtocol;
    @Value("${app.host.name}")
    private String hostName;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(hostName + " " + hostProtocol);
        registry.addMapping("/**")
                .allowedOrigins(hostProtocol + "://" + hostName)
                .allowedMethods("*");
    }
}
