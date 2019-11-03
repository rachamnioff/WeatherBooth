package com.rakel.he.weatherbooth.di.components;

import com.rakel.he.weatherbooth.di.modules.MainModule;
import com.rakel.he.weatherbooth.di.scope.UserScope;
import com.rakel.he.weatherbooth.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = MainModule.class,dependencies = NetComponent.class)
@UserScope
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
