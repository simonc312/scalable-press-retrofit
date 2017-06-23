package com.simonc312.app.product;

import android.support.annotation.NonNull;

import com.simonc312.scalablepress.retrofit.ScalablePressApiBuilder;
import com.simonc312.scalablepress.retrofit.api.ProductApi;

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
