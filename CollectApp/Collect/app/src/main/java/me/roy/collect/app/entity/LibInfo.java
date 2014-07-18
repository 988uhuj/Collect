package me.roy.collect.app.entity;

import com.orm.SugarRecord;

/**
 * Created by chenupt@gmail.com on 2014/7/11.
 * Description : TODO
 */
public class LibInfo extends SugarRecord<LibInfo> {

    private String name;
    private String author;
    private String description;
    private String url;
    private int type;
    private boolean isCollect;

    private String sample;

    public LibInfo() {
    }

    public LibInfo(String name, String author, String description, String url, int type, boolean isCollect, String sample) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.url = url;
        this.type = type;
        this.isCollect = isCollect;
        this.sample = sample;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean isCollect) {
        this.isCollect = isCollect;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
}
