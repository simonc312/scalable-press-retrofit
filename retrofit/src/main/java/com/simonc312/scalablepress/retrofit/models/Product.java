package com.simonc312.scalablepress.retrofit.models;

import java.util.List;

public class Product {

    public String comments;
    public String description;
    public String name;
    public String type;
    public Properties properties;
    public List<com.simonc312.scalablepress.retrofit.models.Color> colors = null;
    public List<com.simonc312.scalablepress.retrofit.models.Image> additionalImages = null;
    public com.simonc312.scalablepress.retrofit.models.Image image;
    public Boolean available;
    public String url;
    public String availabilityUrl;
    public String productId;

}
