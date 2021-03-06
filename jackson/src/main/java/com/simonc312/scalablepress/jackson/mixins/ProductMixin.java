package com.simonc312.scalablepress.jackson.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.simonc312.scalablepress.retrofit.models.Color;
import com.simonc312.scalablepress.retrofit.models.Image;
import com.simonc312.scalablepress.retrofit.models.Properties;

import java.util.List;

@JsonPropertyOrder({
        "comments",
        "description",
        "name",
        "type",
        "properties",
        "colors",
        "additionalImages",
        "image",
        "available",
        "url",
        "availabilityUrl",
        "productId"
})
public class ProductMixin {

    @JsonProperty("comments")
    public String comments;
    @JsonProperty("description")
    public String description;
    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;
    @JsonProperty("properties")
    public Properties properties;
    @JsonProperty("colors")
    public List<Color> colors = null;
    @JsonProperty("additionalImages")
    public List<Image> additionalImages = null;
    @JsonProperty("image")
    public Image image;
    @JsonProperty("available")
    public Boolean available;
    @JsonProperty("url")
    public String url;
    @JsonProperty("availabilityUrl")
    public String availabilityUrl;
    @JsonProperty("productId")
    public String productId;

}
