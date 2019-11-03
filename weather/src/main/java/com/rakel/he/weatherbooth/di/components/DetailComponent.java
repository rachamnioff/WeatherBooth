package com.rakel.he.weatherbooth.di.components;


import com.rakel.he.weatherbooth.di.modules.DetailModule;
import com.rakel.he.weatherbooth.di.scope.UserScope;
import com.rakel.he.weatherbooth.view.DetailActivity;
import dagger.Component;

@UserScope
@Component(modules = DetailModule.class,dependencies = NetComponent.class)
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
