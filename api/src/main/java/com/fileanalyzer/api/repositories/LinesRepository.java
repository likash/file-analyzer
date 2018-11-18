package com.fileanalyzer.api.repositories;

import com.fileanalyzer.api.entities.Line;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinesRepository extends JpaRepository<Line, Integer>  {
    List<Line> findByFileFileId(Integer fileId);
}
