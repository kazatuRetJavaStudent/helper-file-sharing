package com.kazatustudent.helper.api.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Setter
@Getter
@Configuration
public class ApplicationConfig {
    private String serverPort;
    private final File folder;

    public ApplicationConfig(
            @Value("${server.port}") String serverPort,
            @Value("${app.folder}") String contentFolderName) {

        this.serverPort = serverPort;
        folder = new File(contentFolderName);
    }

}
