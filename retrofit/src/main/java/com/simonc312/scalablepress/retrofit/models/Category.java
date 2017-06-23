package com.simonc312.scalablepress.retrofit.models;

import java.util.List;

public class Category {

    public String type;
    public String name;
    public String family;
    public Image image; //was not included in api docs
    public String url;
    public String categoryId;
    public List<ProductOverview> productOverviews;

}
