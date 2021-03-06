package com.simonc312.scalablepress.jackson.mixins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.simonc312.scalablepress.retrofit.models.Image;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "style",
        "image",
        "id",
        "url"
})
public class ProductOverviewMixin {

    @JsonProperty("name")
    public String name;
    @JsonProperty("style")
    public String style;
    @JsonProperty("image")
    public Image image;
    @JsonProperty("id")
    public String id;
    @JsonProperty("url")
    public String url;

}
