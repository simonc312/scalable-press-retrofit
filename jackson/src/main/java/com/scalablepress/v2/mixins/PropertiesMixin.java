package com.scalablepress.v2.mixins;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "brand",
        "material",
        "style"
})
public class PropertiesMixin {

    @JsonProperty("brand")
    public String brand;
    @JsonProperty("material")
    public String material;
    @JsonProperty("style")
    public String style;

}
