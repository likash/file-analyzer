package com.fileanalyzer.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDto {
    private String longestWord;
    private String shortestWord;
    private Integer length;
    private Integer averageWordLength;
    private List<StatisticsLineDto> lines;
}
