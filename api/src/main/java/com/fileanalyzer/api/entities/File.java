package com.fileanalyzer.api.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Builder
@Table(name = "file_info")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;
    private String fileLocation;
    private String fileName;
    private String longestWord;
    private String shortestWord;
    private Integer length;
    private Integer avarageWordLength;

    @OneToMany(mappedBy = "file")
    private List<Line> lines;
}
