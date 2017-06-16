package com.scalablepress.v2.mixins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.scalablepress.v2.models.Image;
import com.scalablepress.v2.models.ProductOverview;

import java.util.List;

/**
 * Created by Simon on 6/14/2017.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "name",
        "family",
        "url",
        "categoryId"
})
public class CategoryMixin {

    @JsonProperty("type")
    public String type;
    @JsonProperty("name")
    public String name;
    @JsonProperty("family")
    public String family;
    @JsonProperty("image")
    public Image image;
    @JsonProperty("url")
    public String url;
    @JsonProperty("categoryId")
    public String categoryId;
    @JsonProperty("products")
    public List<ProductOverview> productOverviews;

}
