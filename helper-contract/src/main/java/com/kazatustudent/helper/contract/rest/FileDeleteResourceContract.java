package com.kazatustudent.helper.contract.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/api/v1/files/delete")
public interface FileDeleteResourceContract {

    @PostMapping("/{fileName}")
    ResponseEntity<String> deleteFile(@PathVariable String fileName) throws IOException;
}
