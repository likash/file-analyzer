package com.fileanalyzer.api.services;

import com.fileanalyzer.api.dtos.LineDto;
import com.fileanalyzer.api.entities.Line;
import com.fileanalyzer.api.repositories.LinesRepository;
import com.fileanalyzer.api.utils.MessagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LineService {
    private final ConverterService converter;
    private final MessagesService messagesService;
    private final LinesRepository linesRepository;

    public List<LineDto> getLines() {
        List<Line> lines = linesRepository.findAll();
        return lines.stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    public LineDto getLineById(Integer lineId) {
        Line lineEntity = findValidLine(lineId);
        return converter.toDto(lineEntity);
    }

    private Line findValidLine(Integer lineId) {
        return linesRepository.findById(lineId)
                .orElseThrow(() -> new EntityNotFoundException(messagesService.getMessage("line.not.found")));
    }
}
