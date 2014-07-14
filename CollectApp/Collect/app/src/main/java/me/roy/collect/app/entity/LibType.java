package me.roy.collect.app.entity;

import com.orm.SugarRecord;

/**
 * Created by chenupt@gmail.com on 2014/7/13.
 * Description : TODO
 */
public class LibType extends SugarRecord<LibType>{

    private int type;
    private String title;
    private String description;

    public LibType() {
    }

    public LibType(int type, String title, String description) {
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
