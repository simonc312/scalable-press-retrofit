package com.scalablepress.v2.mixins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.scalablepress.v2.models.Image;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "hex",
        "images",
        "sizes"
})
public class ColorMixin {

    @JsonProperty("name")
    public String name;
    @JsonProperty("hex")
    public String hex;
    @JsonProperty("images")
    public List<Image> images = null;
    @JsonProperty("sizes")
    public List<String> sizes = null;

}
