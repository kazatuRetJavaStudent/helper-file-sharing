package com.kazatustudent.helper.contract.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FileModel {
    private String fileName;
    private String url;
    private LocalDateTime uploadTime;
}
