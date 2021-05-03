package com.springbootwebscrap.model;

import java.util.List;

public class ArxivDocument {

    private String title;
    private String pdf;
    private String abstractContent;
    private String content;

    //to stored orderly
    private List<Author> authors;

    public ArxivDocument() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArxivDocument{" +
                "title='" + title + '\'' +
                ", pdf='" + pdf + '\'' +
                ", abstractContent='" + abstractContent + '\'' +
                ", content='" + content + '\'' +
                ", authors=" + authors +
                '}';
    }
}
