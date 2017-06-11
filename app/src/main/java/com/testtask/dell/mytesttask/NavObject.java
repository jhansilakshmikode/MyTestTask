package com.testtask.dell.mytesttask;

/**
 * Created by DELL on 6/10/2017.
 */

public class NavObject {

    private String name;
    private int imageId;

    public NavObject(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


