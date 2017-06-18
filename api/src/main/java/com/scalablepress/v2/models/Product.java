package com.scalablepress.v2.models;

import java.util.List;

public class Product {

    public String comments;
    public String description;
    public String name;
    public String type;
    public Properties properties;
    public List<Color> colors = null;
    public List<Image> additionalImages = null;
    public Image image;
    public Boolean available;
    public String url;
    public String availabilityUrl;
    public String productId;

}
