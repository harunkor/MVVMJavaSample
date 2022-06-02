package com.harunkor.mvvmsamplejava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeInfo {

    @SerializedName("title")
    @Expose
    private String title;


    @SerializedName("authors")
    @Expose
    private List<String> authors = null;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("publishDate")
    @Expose
    private String publishDate;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("pageCount")
    @Expose
    private int pageCount;

    @SerializedName("printType")
    @Expose
    private String printType;

    @SerializedName("imageLinks")
    @Expose
    private VolumeImageLinks imageLinks;

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public VolumeImageLinks getImageLinks() {
        return imageLinks;
    }
}
