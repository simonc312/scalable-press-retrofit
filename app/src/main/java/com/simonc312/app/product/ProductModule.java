package com.simonc312.app.product;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductModule {

    private final ProductPresenter.View view;

    public ProductModule(@NonNull final ProductPresenter.View view) {
        this.view = view;
    }

    @Provides
    public ProductPresenter provideProductPresenter(@NonNull final ProductInteractor productInteractor) {
        return new ProductPresenter(productInteractor, view);
    }
}
