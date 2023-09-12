package com.kazatustudent.helper.api.service;

import com.kazatustudent.helper.contract.model.FileModel;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileDownloadService {

    private final File folder = new File("content");

    public List<FileModel> getFiles() {
        File[] files = folder.listFiles();

        FileModel[] fileModels = new FileModel[files.length];

        for (int i = 0; i < fileModels.length; i++) {
            String fileName = files[i].getName();

            FileModel fileModel = new FileModel(
                    fileName,
                    "http://10.0.13.131:8081/api/v1/files/download/" + fileName
            );
            fileModels[i] = fileModel;
        }

        return new ArrayList<>(Arrays.asList(fileModels));
    }

    public ResponseEntity<Resource> getFileAsInputStreamResource(String fileName) throws FileNotFoundException {
        File file = new File(folder + "/" + fileName);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
