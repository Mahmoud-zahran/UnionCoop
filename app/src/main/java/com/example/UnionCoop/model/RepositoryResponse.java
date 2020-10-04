package com.example.UnionCoop.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
@Entity(tableName = "favorite_table")
public class RepositoryResponse {


    @PrimaryKey(autoGenerate = true)
    private int id;

        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("avatar")
        @Expose
        private String avatar;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("languageColor")
        @Expose
        private String languageColor;
        @SerializedName("stars")
        @Expose
        private Integer stars;
        @SerializedName("forks")
        @Expose
        private Integer forks;
        @SerializedName("currentPeriodStars")
        @Expose
        private Integer currentPeriodStars;
        @Ignore
        @SerializedName("builtBy")
        @Expose
        private List<BuiltBy> builtBy = null;

        private boolean expanded=false;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public Integer getStars() {
            return stars;
        }

        public void setStars(Integer stars) {
            this.stars = stars;
        }

        public Integer getForks() {
            return forks;
        }

        public void setForks(Integer forks) {
            this.forks = forks;
        }

        public Integer getCurrentPeriodStars() {
            return currentPeriodStars;
        }

        public void setCurrentPeriodStars(Integer currentPeriodStars) {
            this.currentPeriodStars = currentPeriodStars;
        }

        public List<BuiltBy> getBuiltBy() {
            return builtBy;
        }

        public void setBuiltBy(List<BuiltBy> builtBy) {
            this.builtBy = builtBy;
        }



    //   -----------------------------------com.example.BuiltBy.java-----------------------------------
    public class BuiltBy {

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("avatar")
        @Expose
        private String avatar;
        private List<String> builtBys;

        public BuiltBy(List<String> builtBys) {
            this.builtBys = builtBys;
        }

        public List<String> getBuiltBys() {
            return builtBys;
        }

        public void setBuiltBys(List<String> builtBys) {
            this.builtBys = builtBys;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

    }
    public class BuiltByConverter {
        @TypeConverter
        public BuiltBy storedStringToBuiltBys(String value) {
            List<String> langs = Arrays.asList(value.split("\\s*,\\s*"));
            return new BuiltBy(langs);
        }

        @TypeConverter
        public String builtBysToStoredString(BuiltBy cl) {
            String value = "";

            for (String lang :cl.getBuiltBys())
                value += lang + ",";

            return value;
        }
    }
}
