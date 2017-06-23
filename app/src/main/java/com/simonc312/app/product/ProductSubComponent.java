package com.simonc312.app.product;

import com.simonc312.app.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {
    ProductModule.class
}
)
public interface ProductSubComponent {

    MainActivity injectsMainActivity(MainActivity mainActivity);
}
