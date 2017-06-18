package com.scalablepress.v2.mixins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "label"
})
public class ImageMixin {

    @JsonProperty("url")
    public String url;
    @JsonProperty("label")
    public String label;

}
