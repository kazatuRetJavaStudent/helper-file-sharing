package com.kazatustudent.helper.api.controller;

import com.kazatustudent.helper.contract.rest.FileUploadResourceContract;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class FileUploadResource implements FileUploadResourceContract {
    @Override
    public String returnFileUploadPage() {
        return "upload"; // to make work you need thymeleaf dependency
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        System.out.println("File " + file.getName() + " uploaded");
        Path path = Path.of("content");
        file.transferTo(path); // access denied
        return "redirect:/api/v1/files/download";
    }
}
