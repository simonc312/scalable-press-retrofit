package com.simonc312.scalablepress.retrofit;

import com.simonc312.scalablepress.retrofit.api.ProductApi;

import retrofit2.Retrofit;

public class ScalablePressApiBuilder {

    private static String BASE_URL = "https://api.scalablepress.com/";

    public static ScalablePressApiBuilder createInstance() {
        return new ScalablePressApiBuilder();
    }

    private ScalablePressApiBuilder() {

    }

    public Retrofit build(Retrofit.Builder builder) {
        builder.baseUrl(BASE_URL);
        return builder.build();
    }

    public ProductApi createProductApi(Retrofit retrofit) {
        return retrofit.create(ProductApi.class);
    }
}
