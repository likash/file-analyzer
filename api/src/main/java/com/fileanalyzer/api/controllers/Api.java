package com.fileanalyzer.api.controllers;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Api {
    public final String ROOT = "/api";

    @UtilityClass
    public class Files {
        public final String FILES = "/files";
        public final String FILE_BY_ID = "/file/{file_id}";
        public final String FILE_LINE = "/file/{file_id}/lines";
        public final String FILE_LINE_BY_ID = "/file/{file_id}/lines/{line_id}";
    }
}
