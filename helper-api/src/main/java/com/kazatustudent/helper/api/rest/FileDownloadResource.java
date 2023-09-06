package com.kazatustudent.helper.api.rest;

import com.kazatustudent.helper.api.service.FileDownloadService;
import com.kazatustudent.helper.contract.model.FileModel;
import com.kazatustudent.helper.contract.rest.FileDownloadResourceContract;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileDownloadResource implements FileDownloadResourceContract {

    private final FileDownloadService fileDownloadService;

    @Override
    public List<FileModel> getFiles() {
        return fileDownloadService.getFiles();
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String fileName) throws FileNotFoundException {
        return fileDownloadService.getFileAsInputStreamResource(fileName);
    }
}
