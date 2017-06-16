package com.scalablepress.app;

import com.scalablepress.app.product.PersistentProductModule;
import com.scalablepress.app.product.ProductModule;
import com.scalablepress.app.product.ProductSubComponent;

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
