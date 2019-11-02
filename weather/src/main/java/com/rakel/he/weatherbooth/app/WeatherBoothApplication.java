package com.rakel.he.weatherbooth.app;

import android.app.Application;
import android.content.Context;

import com.rakel.he.weatherbooth.di.components.DaggerNetComponent;
import com.rakel.he.weatherbooth.di.components.NetComponent;
import com.rakel.he.weatherbooth.di.modules.NetModule;

public class WeatherBoothApplication extends Application {
    public static WeatherBoothApplication getAppContext(Context context){
        return (WeatherBoothApplication)context.getApplicationContext();
    }

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent= DaggerNetComponent.builder().netModule(new NetModule()).build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
