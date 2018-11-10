package com.fileanalyzer.api.controllers;
import com.fileanalyzer.api.dtos.FileDto;
import com.fileanalyzer.api.dtos.LineDto;
import com.fileanalyzer.api.services.LineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(Api.ROOT)
@AllArgsConstructor
public class LineController {
    private final LineService lineService;

    @GetMapping(Api.Files.FILE_LINE)
    public List<LineDto> getLines() {
        return lineService.getLines();
    }

    @GetMapping(Api.Files.FILE_LINE_BY_ID)
    public LineDto getFileById(@PathVariable(name = "line_id") Integer lineId) {
        return lineService.getLineById(lineId);
    }
}
