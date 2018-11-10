package com.fileanalyzer.api.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "line_info")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lineId;
    private String longestWord;
    private String shortestWord;
    private Integer length;
    private Integer avarageWordLength;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private File file;

}
