package com.rakel.he.weatherbooth.di.modules;

import com.rakel.he.weatherbooth.contacts.MainContacts;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final MainContacts.View mView;

    public MainModule(MainContacts.View mView) {
        this.mView = mView;
    }
    @Provides
    public MainContacts.View provideMainView(){
        return mView;
    }
}
