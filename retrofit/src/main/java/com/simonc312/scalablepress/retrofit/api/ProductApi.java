package com.simonc312.scalablepress.retrofit.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApi {

    @GET("/v2/categories")
    Call<List<com.simonc312.scalablepress.retrofit.models.Category>> getCategories();

    @GET("/v2/categories/{id}")
    Call<com.simonc312.scalablepress.retrofit.models.Category> getCategory(@Path("id") String id);

    @GET("/v2/products/{id}")
    Call<com.simonc312.scalablepress.retrofit.models.Product> getProduct(@Path("id") String id);

}
