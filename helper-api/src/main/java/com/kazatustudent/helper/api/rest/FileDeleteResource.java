package com.kazatustudent.helper.api.rest;

import com.kazatustudent.helper.contract.rest.FileDeleteResourceContract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class FileDeleteResource implements FileDeleteResourceContract {

    @Override
    public ResponseEntity<String> deleteFile(String fileName) throws IOException {
        return Files.deleteIfExists(Path.of("/content/" + fileName))
                ? ResponseEntity.ok("File Successfully deleted")
                : ResponseEntity.badRequest().body("File not found");
    }
}
