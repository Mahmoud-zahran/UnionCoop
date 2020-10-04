package com.example.UnionCoop.model;


/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
public class RepoData {

  //  @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String author;

    private String description;
    private String avatar;
    private String language;
    private String languageColor;


    private String starsNo;
    private String forksNo;


    private String url;

    public RepoData(String name, String author, String description,
                    String avatar, String language, String languageColor,
                    String starsNo, String forksNo, String url) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.avatar = avatar;
        this.language = language;
        this.languageColor = languageColor;
        this.starsNo = starsNo;
        this.forksNo = forksNo;
        this.url = url;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public String getStarsNo() {
        return starsNo;
    }

    public void setStarsNo(String starsNo) {
        this.starsNo = starsNo;
    }

    public String getForksNo() {
        return forksNo;
    }

    public void setForksNo(String forksNo) {
        this.forksNo = forksNo;
    }
}
