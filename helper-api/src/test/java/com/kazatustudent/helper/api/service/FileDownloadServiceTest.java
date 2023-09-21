package com.kazatustudent.helper.api.service;

import com.kazatustudent.helper.api.config.ApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileDownloadServiceTest {

    private FileDownloadService underTest;

    @Mock
    private ApplicationConfig config;

    @BeforeEach
    void setUp() {
        underTest = new FileDownloadService(config);
    }

    @Test
    void getFileAsInputStreamResource() {
    }
}