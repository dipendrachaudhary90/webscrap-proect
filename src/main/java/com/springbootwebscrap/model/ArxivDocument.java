package com.springbootwebscrap.model;

import java.util.Set;

public class ArxivDocument {

    private String title;

    //stored unique data
    private Set<Author> authors;

    public ArxivDocument() {

    }

    @Override
    public String toString() {
        return "ArxivDocument{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                '}';
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
