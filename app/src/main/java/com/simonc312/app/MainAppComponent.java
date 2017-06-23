package com.simonc312.app;

import com.simonc312.app.product.PersistentProductModule;
import com.simonc312.app.product.ProductModule;
import com.simonc312.app.product.ProductSubComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        PersistentProductModule.class,
})
public interface MainAppComponent {

    ProductSubComponent plus(ProductModule productModule);
}
