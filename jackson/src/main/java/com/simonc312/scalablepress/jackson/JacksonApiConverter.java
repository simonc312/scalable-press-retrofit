package com.simonc312.scalablepress.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simonc312.scalablepress.jackson.mixins.CategoryMixin;
import com.simonc312.scalablepress.jackson.mixins.ProductOverviewMixin;
import com.simonc312.scalablepress.retrofit.models.Category;
import com.simonc312.scalablepress.retrofit.models.Color;
import com.simonc312.scalablepress.retrofit.models.Image;
import com.simonc312.scalablepress.retrofit.models.Product;
import com.simonc312.scalablepress.retrofit.models.ProductOverview;
import com.simonc312.scalablepress.retrofit.models.Properties;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public final class JacksonApiConverter {

    public static ObjectMapper getMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        setDefaults(objectMapper);
        return JacksonApiConverter.updateMapper(objectMapper);
    }

    public static ObjectMapper updateMapper(ObjectMapper objectMapper) {
        addMixins(objectMapper);
        return objectMapper;
    }

    private static void setDefaults(ObjectMapper objectMapper) {
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private static void addMixins(ObjectMapper objectMapper) {
        objectMapper.addMixIn(Category.class, CategoryMixin.class);
        objectMapper.addMixIn(Color.class, com.simonc312.scalablepress.jackson.mixins.ColorMixin.class);
        objectMapper.addMixIn(Image.class, com.simonc312.scalablepress.jackson.mixins.ImageMixin.class);
        objectMapper.addMixIn(Product.class, com.simonc312.scalablepress.jackson.mixins.ProductMixin.class);
        objectMapper.addMixIn(ProductOverview.class, ProductOverviewMixin.class);
        objectMapper.addMixIn(Properties.class, com.simonc312.scalablepress.jackson.mixins.PropertiesMixin.class);
    }
}
