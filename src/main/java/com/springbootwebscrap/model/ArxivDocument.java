package com.springbootwebscrap.model;

import java.util.List;

public class ArxivDocument {

    private String title;
    private String pdf;
    private String abstractPdf;

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

    public String getAbstractPdf() {
        return abstractPdf;
    }

    public void setAbstractPdf(String abstractPdf) {
        this.abstractPdf = abstractPdf;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "ArxivDocument{" +
                "title='" + title + '\''+"\n" +
                ", pdf='" + pdf + '\'' +
                ", abstractPdf='" + abstractPdf + '\''+"\n" +
                ", authors=" + authors +
                '}';
    }
}
