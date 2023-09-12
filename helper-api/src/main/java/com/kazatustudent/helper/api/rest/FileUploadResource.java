package com.kazatustudent.helper.api.rest;

import com.kazatustudent.helper.contract.rest.FileUploadResourceContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
public class FileUploadResource implements FileUploadResourceContract {
    @Override
    public String returnFileUploadPage() {
        return "upload"; // to make work you need thymeleaf dependency
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        Path root = Path.of("content");

        InputStream inputStream = file.getInputStream();
        Files.copy(inputStream, root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();

        return "redirect:/api/v1/files/download";
    }
}
