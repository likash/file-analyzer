package com.fileanalyzer.api.services;

import com.fileanalyzer.api.dtos.*;
import com.fileanalyzer.api.entities.*;
import com.fileanalyzer.api.repositories.FilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.fileanalyzer.api.utils.MessagesService;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Service
@AllArgsConstructor
public class ConverterService {
    private FilesRepository filesRepository;
    private MessagesService messagesService;

    public FileDto toDto(File entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        return FileDto.builder()
                .id(entity.getFileId())
                .fileLocation(entity.getFileLocation())
                .fileName(entity.getFileName())
                .longestWord(entity.getLongestWord())
                .shortestWord(entity.getShortestWord())
                .avarageWordLength(entity.getAvarageWordLength())
                .length(entity.getLength())
                .lines(emptyIfNull(entity.getLines()).stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public LineDto toDto(Line entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        return LineDto.builder()
                .id(entity.getLineId())
                .fileId(entity.getFile().getFileId())
                .longestWord(entity.getLongestWord())
                .shortestWord(entity.getShortestWord())
                .avarageWordLength(entity.getAvarageWordLength())
                .length(entity.getLength())
                .build();
    }

    public File toEntity(FileDto dto) {
        return File.builder()
                .fileLocation(dto.getFileLocation())
                .fileName(dto.getFileName())
                .longestWord(dto.getLongestWord())
                .shortestWord(dto.getShortestWord())
                .avarageWordLength(dto.getAvarageWordLength())
                .length(dto.getLength())
                .build();
    }

    public Line toEntity(LineDto dto) {
        File file = filesRepository.findById(dto.getFileId())
                .orElseThrow(() -> new EntityNotFoundException(messagesService.getMessage("file.not.found")));
        return Line.builder()
                .longestWord(dto.getLongestWord())
                .shortestWord(dto.getShortestWord())
                .avarageWordLength(dto.getAvarageWordLength())
                .length(dto.getLength())
                .file(file)
                .build();
    }
}
