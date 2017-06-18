package com.scalablepress.app.product;

import android.support.annotation.NonNull;

import com.scalablepress.v2.models.Category;
import com.scalablepress.v2.models.Product;

import java.util.List;

public class ProductPresenter {

    private final ProductInteractor productInteractor;

    private final View view;

    private final ProductInteractor.Output interactorOutput = new ProductInteractor.Output() {
        @Override
        public void handleCategoriesResponse(List<Category> categories) {
            ProductPresenter.this.view.updateProductCategories(categories);
        }

        @Override
        public void handleError(Throwable t) {
            ProductPresenter.this.view.updateError(t.getMessage());
        }

        @Override
        public void handleCategoryResponse(Category category) {
            //todo handle
            ProductPresenter.this.view.updateError(category.toString());
        }

        @Override
        public void handleProductResponse(Product product) {
            //todo handle
            ProductPresenter.this.view.updateError(product.toString());
        }
    };

    public ProductPresenter(@NonNull final ProductInteractor productInteractor,
                            @NonNull final View view) {
        this.view = view;
        this.productInteractor = productInteractor;
        this.productInteractor.setOutput(interactorOutput);
    }

    public void getCategories() {
        this.productInteractor.getCategories();
    }

    public void getCategory(String categoryId) {
        this.productInteractor.getCategory(categoryId);
    }

    public void getProduct(String productId) {
        this.productInteractor.getProduct(productId);
    }

    public interface View {

        void updateProductCategories(List<Category> categories);

        void updateError(String errorMessage);
    }
}
