package com.kazatustudent.helper.contract.rest;

import com.kazatustudent.helper.contract.model.FileModel;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.List;

@RequestMapping("/api/v1/files/download")
public interface FileDownloadResourceContract {

    @GetMapping
    List<FileModel> getFiles();

    @GetMapping("/{fileName}")
    ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws FileNotFoundException;

}
