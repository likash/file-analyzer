package com.fileanalyzer.api.repositories;

import com.fileanalyzer.api.entities.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinesRepository extends JpaRepository<Line, Integer>  {
}
