package com.scalablepress.api;

import com.scalablepress.v2.models.Category;
import com.scalablepress.v2.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApi {

    @GET("/v2/categories")
    Call<List<Category>> getCategories();

    @GET("/v2/categories/{id}")
    Call<Category> getCategory(@Path("id") String id);

    @GET("/v2/products/{id}")
    Call<Product> getProduct(@Path("id") String id);

}
