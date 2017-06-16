package com.scalablepress.app.product;

import com.scalablepress.app.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
    ProductModule.class
}
)
public interface ProductSubComponent {

    MainActivity injectsMainActivity(MainActivity mainActivity);
}
