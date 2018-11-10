package com.fileanalyzer.api.repositories;

import com.fileanalyzer.api.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<File, Integer> {

}
