package com.rakel.he.weatherbooth.di.modules;

import com.rakel.he.weatherbooth.contacts.DetailContact;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
    private final DetailContact.View mView;

    public DetailModule(DetailContact.View mView) {
        this.mView = mView;
    }
    @Provides
    public DetailContact.View provideDetailView(){
        return mView;
    }
}
