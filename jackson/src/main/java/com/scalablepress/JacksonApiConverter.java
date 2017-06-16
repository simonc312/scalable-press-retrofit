package com.scalablepress;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalablepress.v2.mixins.CategoryMixin;
import com.scalablepress.v2.mixins.ColorMixin;
import com.scalablepress.v2.mixins.ImageMixin;
import com.scalablepress.v2.mixins.ProductMixin;
import com.scalablepress.v2.mixins.ProductOverviewMixin;
import com.scalablepress.v2.mixins.PropertiesMixin;
import com.scalablepress.v2.models.Category;
import com.scalablepress.v2.models.Color;
import com.scalablepress.v2.models.Image;
import com.scalablepress.v2.models.Product;
import com.scalablepress.v2.models.ProductOverview;
import com.scalablepress.v2.models.Properties;

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
        objectMapper.addMixIn(Color.class, ColorMixin.class);
        objectMapper.addMixIn(Image.class, ImageMixin.class);
        objectMapper.addMixIn(Product.class, ProductMixin.class);
        objectMapper.addMixIn(ProductOverview.class, ProductOverviewMixin.class);
        objectMapper.addMixIn(Properties.class, PropertiesMixin.class);
    }
}
