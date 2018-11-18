package com.fileanalyzer.api.controllers;

import com.fileanalyzer.api.dtos.ContentDto;
import com.fileanalyzer.api.dtos.StatisticsDto;
import com.fileanalyzer.api.services.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Api.ROOT)
@AllArgsConstructor
public class AnalyzeTextController {
    private final StatisticsService statisticsService;

    @PostMapping(Api.AnalyzeText.ANALYZE_TEXT)
    public StatisticsDto getStatistics(@RequestBody ContentDto content) {
        return statisticsService.getAllStatistics(content.getContent());
    }
}
