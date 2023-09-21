package com.kazatustudent.helper.api.service;

import com.kazatustudent.helper.api.config.ApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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