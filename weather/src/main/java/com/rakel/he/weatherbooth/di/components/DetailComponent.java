package com.rakel.he.weatherbooth.di.components;


import com.rakel.he.weatherbooth.di.modules.DetailModule;
import com.rakel.he.weatherbooth.view.DetailActivity;
import dagger.Component;


@Component(modules = DetailModule.class,dependencies = NetComponent.class)
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
