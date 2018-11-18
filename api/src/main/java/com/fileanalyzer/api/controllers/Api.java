package com.fileanalyzer.api.controllers;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Api {
    public final String ROOT = "/api";

    @UtilityClass
    public class Files {
        public final String FILES = "/files";
        public final String FILE_BY_ID = "/files/{file_id}";
        public final String FILE_LINE = "/files/{file_id}/lines";
        public final String FILE_LINE_BY_ID = "/files/{file_id}/lines/{line_id}";
    }

    @UtilityClass
    public class AnalyzeText {
        public final String ANALYZE_TEXT = "/analyze-text";
    }
}
