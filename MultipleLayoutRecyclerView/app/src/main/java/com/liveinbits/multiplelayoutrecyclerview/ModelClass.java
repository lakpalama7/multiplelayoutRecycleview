package com.liveinbits.multiplelayoutrecyclerview;

public class ModelClass {

    public static final int USER_DETAIL_LAY=0;
    public static final int IMAGE_LAY=1;
    public static final int ADD_LAY=2;


    private int viewType;
    private String name;
    private String address;
    private int image;

    public ModelClass(int viewType, String name, String address, int image) {
        this.viewType = viewType;
        this.name = name;
        this.address = address;
        this.image = image;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String title;

    public ModelClass(int viewType, String title) {
        this.viewType = viewType;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int resource;

    public ModelClass(int viewType, int resource) {
        this.viewType = viewType;
        this.resource = resource;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
