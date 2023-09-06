package com.kazatustudent.helper.api.controller;

import com.kazatustudent.helper.contract.rest.FileUploadResourceContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class FileUploadResource implements FileUploadResourceContract {
    @Override
    public String returnFileUploadPage() {
        return "upload"; // to make work you need thymeleaf dependency
    }

    @Override
    public String uploadFile(File file) {
        System.out.println("File " + file.getName() + " uploaded");
        return "redirect:/api/v1/files/download";
    }
}
