package com.fileanalyzer.api.repositories;

import com.fileanalyzer.api.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilesRepository extends JpaRepository<File, Integer> {
    @Query("SELECT count(file) > 0 FROM File file WHERE file.fileId = :fileId")
    Boolean existsFileByFileId(@Param("fileId") Integer fileId);
}
