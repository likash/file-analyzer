package com.fileanalyzer.api.services;

import com.fileanalyzer.api.dtos.FileDto;
import com.fileanalyzer.api.entities.File;
import com.fileanalyzer.api.repositories.FilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.fileanalyzer.api.utils.MessagesService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FileService {
    private final ConverterService converter;
    private final MessagesService messagesService;
    private final FilesRepository filesRepository;

    public List<FileDto> getFiles() {
        List<File> files = filesRepository.findAll();
        return files.stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    public FileDto getFileById(Integer fileId) {
        File fileEntity = findValidFile(fileId);
        return converter.toDto(fileEntity);
    }

    private File findValidFile(Integer fileId) {
        return filesRepository.findById(fileId)
                .orElseThrow(() -> new EntityNotFoundException(messagesService.getMessage("file.not.found")));
    }
}
