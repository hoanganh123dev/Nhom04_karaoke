package com.example.nhom04_karaoke;

import java.util.ArrayList;
import java.util.List;

public class Song {
    public String Code="";
    public String Title="";
    public String Description="";
    public String Author="";

    public Song(String code, String title, String description, String author) {
        Code = code;
        Title = title;
        Description = description;
        Author = author;
    }
    public Song(){}

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

}
