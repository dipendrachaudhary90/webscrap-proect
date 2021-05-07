package com.springbootwebscrap.controller;

import com.springbootwebscrap.service.DocumentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
public class AppController {


    @Autowired
    private DocumentSearchService documentSearchService;
/* return index.html page for searching
* */
    @GetMapping("/")
    public String viewIndexPage() throws IOException {
        return "index";
    }

    /*
    * In this method,Get Method and return home page and takes String query*/
    @GetMapping("/getAll")
    public String getAllLists(@RequestParam("query") String query, Model model) throws IOException {
        model.addAttribute("listAllData",documentSearchService.getAllSearchList(query));
        return "home";
    }
}
