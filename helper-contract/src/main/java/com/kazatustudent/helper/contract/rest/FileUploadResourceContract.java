package com.kazatustudent.helper.contract.rest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@RequestMapping("/upload")
public interface FileUploadResourceContract {

    @GetMapping
    String returnFileUploadPage();

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}) // 415
    String uploadFile(@RequestBody File file);
}
