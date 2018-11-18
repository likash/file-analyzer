package com.fileanalyzer.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsLineDto {
    private String content;
    private String longestWord;
    private String shortestWord;
    private Integer length;
    private Integer averageWordLength;
}
