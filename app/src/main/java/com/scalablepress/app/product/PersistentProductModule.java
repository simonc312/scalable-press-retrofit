package com.scalablepress.app.product;

import android.support.annotation.NonNull;

import com.scalablepress.ScalablePressApiBuilder;
import com.scalablepress.api.ProductApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class PersistentProductModule {

    @Provides
    @Singleton
    public ProductApi providesProductApi(ScalablePressApiBuilder scalablePressApiBuilder,
                                         Retrofit retrofit) {
        return scalablePressApiBuilder.createProductApi(retrofit);
    }

    @Provides
    @Singleton
    public ProductInteractor provideProductInteractor(@NonNull final ProductApi productApi) {
        return new ProductInteractor(productApi);
    }

}
