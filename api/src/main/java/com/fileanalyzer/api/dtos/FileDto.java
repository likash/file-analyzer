package com.fileanalyzer.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private Integer id;
    @NotBlank
    private String fileLocation;
    @NotBlank
    private String fileName;
    private String longestWord;
    private String shortestWord;
    private Integer length;
    private Integer averageWordLength;
    private List<LineDto> lines;
}
