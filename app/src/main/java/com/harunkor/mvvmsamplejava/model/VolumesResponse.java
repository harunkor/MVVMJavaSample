package com.harunkor.mvvmsamplejava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumesResponse {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("items")
    @Expose
    private List<Volume> items = null;

    @SerializedName("totalItems")
    @Expose
    private int totalItems;

    public String getKind() {
        return kind;
    }

    public List<Volume> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }
}
