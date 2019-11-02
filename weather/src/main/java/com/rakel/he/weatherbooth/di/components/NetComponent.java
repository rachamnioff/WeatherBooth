package com.rakel.he.weatherbooth.di.components;


import com.rakel.he.weatherbooth.di.modules.NetModule;
import com.rakel.he.weatherbooth.model.ApiService;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetModule.class)
@Singleton
public interface NetComponent {
    ApiService getApiService();
//    OkHttpClient getOkHttp();
//    Retrofit getRetrofit();
}
