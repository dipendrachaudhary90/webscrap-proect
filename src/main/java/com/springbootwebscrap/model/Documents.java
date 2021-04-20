package com.springbootwebscrap.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Documents {

    private String title;
    //stored unique data
    private Set<Author> authors;

    public Documents(String title) {
        this.title = title;
        this.authors = authors;
    }

    public Documents() {

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}