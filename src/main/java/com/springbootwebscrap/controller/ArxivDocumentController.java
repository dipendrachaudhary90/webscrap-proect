package com.springbootwebscrap.controller;

import com.springbootwebscrap.model.ArxivDocument;
import com.springbootwebscrap.service.DocumentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArxivDocumentController {

    @Autowired
    private DocumentSearchService documentSearchService;

    /*
    * This method return List of ArxivDocument which takes String query */
    @GetMapping("/listAll")
    public List<ArxivDocument> getAllLists(@RequestParam("query") String query, Model model) throws IOException {

        return documentSearchService.getAllSearchList(query);
    }
}
