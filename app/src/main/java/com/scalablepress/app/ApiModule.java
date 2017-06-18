package com.scalablepress.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalablepress.JacksonApiConverter;
import com.scalablepress.ScalablePressApiBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public ScalablePressApiBuilder provideScalablePressApi() {
        return ScalablePressApiBuilder.createInstance();
    }

    @Provides
    @Singleton
    public ObjectMapper provideJacksonObjectMapper() {
        return JacksonApiConverter.getMapper();
    }

    @Provides
    @Singleton
    public JacksonConverterFactory provideJsonConverterFactory(ObjectMapper objectMapper) {
        return JacksonConverterFactory.create(objectMapper);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder(OkHttpClient client,
                                                    JacksonConverterFactory factory) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(client);
        builder.addConverterFactory(factory);
        return builder;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(ScalablePressApiBuilder scalablePressApiBuilder,
                                     Retrofit.Builder builder) {
        return scalablePressApiBuilder.build(builder);
    }
}
