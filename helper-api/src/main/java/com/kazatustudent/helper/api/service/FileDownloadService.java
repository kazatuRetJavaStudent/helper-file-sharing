package com.kazatustudent.helper.api.service;

import com.kazatustudent.helper.api.config.ApplicationConfig;
import com.kazatustudent.helper.contract.model.FileModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileDownloadService {

    private final ApplicationConfig config;

    @SneakyThrows
    public List<FileModel> getFiles() {
        File[] files = config.getFolder().listFiles();

        FileModel[] fileModels = new FileModel[files.length];

        for (int i = 0; i < fileModels.length; i++) {
            String fileName = files[i].getName();

            BasicFileAttributes fileAttributes = readFileAttributes(fileName);

            FileModel fileModel = new FileModel(
                    fileName,
                    "http://" + InetAddress.getLocalHost().getHostAddress()  + ":" + config.getServerPort() + "/api/v1/files/download/" + fileName,
                    fileAttributes.size(),
                    LocalDateTime.ofInstant(fileAttributes.creationTime().toInstant(), ZoneOffset.UTC)
            );

            fileModels[i] = fileModel;
        }

        List<FileModel> list = Arrays.asList(fileModels);

        list.sort((f1, f2) -> f2.getUploadTime().compareTo(f1.getUploadTime()));

        return list;
    }

    public ResponseEntity<Resource> getFileAsInputStreamResource(String fileName) throws FileNotFoundException {
        File file = new File(config.getFolder() + "/" + fileName);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentLength(file.length())
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileName + "\""
                )
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @SneakyThrows
    protected BasicFileAttributes readFileAttributes(String fileName) {
        return Files.readAttributes(Path.of(config.getFolder() + "/" + fileName), BasicFileAttributes.class);
    }
}
