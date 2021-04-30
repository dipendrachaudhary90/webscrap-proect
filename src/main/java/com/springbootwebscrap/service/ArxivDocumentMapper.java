package com.springbootwebscrap.service;

import com.springbootwebscrap.model.ArxivDocument;

import java.util.ArrayList;
import java.util.List;

public class ArxivDocumentMapper {
    public static final String CONTENTS = "contents";
    public static final String FILE_NAME = "filename";
    public static final String FILE_PATH = "filepath";
    public static final int MAX_SEARCH = 10;

    public List<ArxivDocument> getAll(){
        List<ArxivDocument> listOfDocument = new ArrayList<>();
        return listOfDocument;
    }
}
