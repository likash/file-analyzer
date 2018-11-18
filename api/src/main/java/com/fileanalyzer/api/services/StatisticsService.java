package com.fileanalyzer.api.services;

import com.fileanalyzer.api.dtos.StatisticsDto;
import com.fileanalyzer.api.dtos.StatisticsLineDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Service
public class StatisticsService {

    public StatisticsDto getAllStatistics (String content) {
        List<StatisticsLineDto> lines = new ArrayList<StatisticsLineDto>();
        List<String> linesContent = new ArrayList<>(splitText(content));

        for(String lineContent : linesContent) {
            lines.add(StatisticsLineDto.builder()
                    .content(lineContent)
                    .longestWord(getMaxLengthWord(lineContent))
                    .shortestWord(getMinLengthWord(lineContent))
                    .averageWordLength(getaverageWordLegth(lineContent))
                    .length(lineContent.length())
                    .build());
        }

        return StatisticsDto.builder()
                .longestWord(getMaxLengthWord(content))
                .shortestWord(getMinLengthWord(content))
                .averageWordLength(getaverageWordLegth(content))
                .length(content.length())
                .lines(lines)
                .build();
    }

    private static List<String> splitLine(String line) {

        return new ArrayList<>((Arrays.asList(line.split(" |\n", -1))));
    }

    private List<String> splitText (String content) {
        return new ArrayList<>(Arrays.asList(content.split("\n[\n]+")));
    }

    private String getMinLengthWord(String line) {
        List<String> words = splitLine(line);
        String minStr = "";
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (min > word.length()) {
                minStr = word;
                min = word.length();
            }
        }
        return minStr;
    }

    private String getMaxLengthWord(String line) {
        List<String> words = splitLine(line);
        String maxStr = "";

        for (String word : words) {
            if (maxStr.length() < word.length()) {
                maxStr = word;
            }
        }
        return maxStr;
    }

    private int getaverageWordLegth(String line) {
        List<String> words = splitLine(line);
        int sum = 0, average;

        for (String word : words) {
            sum += word.length();
        }
        average = sum / words.size();
        return average;
    }
}

