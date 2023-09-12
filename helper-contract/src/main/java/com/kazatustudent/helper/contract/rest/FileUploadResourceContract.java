package com.kazatustudent.helper.contract.rest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping("/upload")
public interface FileUploadResourceContract {

    @GetMapping
    String returnFileUploadPage();
    @PostMapping
    String uploadFile(@RequestParam("file") MultipartFile file) throws IOException;
}
