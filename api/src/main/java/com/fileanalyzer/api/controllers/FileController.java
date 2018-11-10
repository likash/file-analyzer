package com.fileanalyzer.api.controllers;

import com.fileanalyzer.api.dtos.FileDto;
import com.fileanalyzer.api.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Api.ROOT)
@AllArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping(Api.Files.FILES)
    public List<FileDto> getFiles() {
        return fileService.getFiles();
    }

    @GetMapping(Api.Files.FILE_BY_ID)
    public FileDto getFileById(@PathVariable(name = "file_id") Integer fileId) {
        return fileService.getFileById(fileId);
    }
}
