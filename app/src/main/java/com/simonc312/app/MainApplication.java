package com.simonc312.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.simonc312.app.product.ProductModule;

public class MainApplication extends Application {

    private static MainApplication Instance;
    private MainAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MainApplication.Instance = this;
        appComponent = buildGraph();
    }

    MainAppComponent buildGraph() {
        return DaggerMainAppComponent.create();
    }

    public void injectsMainActivity(@NonNull final MainActivity mainActivity) {
        appComponent.plus(new ProductModule(mainActivity))
                    .injectsMainActivity(mainActivity);
    }

    public static MainApplication getInstance() {
        return MainApplication.Instance;
    }
}
