package com.scalablepress.app.product;

import android.support.annotation.NonNull;

import com.scalablepress.v2.ProductApi;
import com.scalablepress.v2.models.Category;
import com.scalablepress.v2.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Simon on 6/16/2017.
 */

class ProductInteractor implements Callback<List<Category>> {

    private final ProductApi productApi;
    private Output output;

    private final Callback<Category> categoryCallback = new Callback<Category>() {
        @Override
        public void onResponse(Call<Category> call, Response<Category> response) {
            if (response.isSuccessful()) {
                ProductInteractor.this.output.handleCategoryResponse(response.body());
            }
        }

        @Override
        public void onFailure(Call<Category> call, Throwable t) {
            ProductInteractor.this.output.handleError(t);
        }
    };

    private final Callback<Product> productCallback = new Callback<Product>() {
        @Override
        public void onResponse(Call<Product> call, Response<Product> response) {
            if (response.isSuccessful()) {
                ProductInteractor.this.output.handleProductResponse(response.body());
            }
        }

        @Override
        public void onFailure(Call<Product> call, Throwable t) {
            ProductInteractor.this.output.handleError(t);
        }
    };

    ProductInteractor(@NonNull final ProductApi productApi) {
        this.productApi = productApi;
    }

    void setOutput(Output output) {
        this.output = output;
    }

    void getCategories() {
        this.productApi.getCategories().enqueue(this);
    }

    void getCategory(String categoryId) {
        this.productApi.getCategory(categoryId).enqueue(categoryCallback);
    }

    void getProduct(String productId) {
        this.productApi.getProduct(productId).enqueue(productCallback);
    }

    @Override
    public void onResponse(Call<List<Category>> call,
                           Response<List<Category>> response) {

        if (response.isSuccessful()) {
            if (output != null) {
                output.handleCategoriesResponse(response.body());
            }
        }
    }

    @Override
    public void onFailure(Call<List<Category>> call, Throwable t) {
        if (output != null) {
            output.handleError(t);
        }
    }

    interface Output {
        void handleCategoriesResponse(List<Category> categories);
        void handleError(Throwable t);
        void handleCategoryResponse(Category category);
        void handleProductResponse(Product product);
    }
}
