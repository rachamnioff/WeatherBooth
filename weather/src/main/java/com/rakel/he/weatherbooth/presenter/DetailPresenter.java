package com.rakel.he.weatherbooth.presenter;

import com.rakel.he.weatherbooth.contacts.DetailContact;
import com.rakel.he.weatherbooth.contacts.MainContacts;
import com.rakel.he.weatherbooth.model.ApiService;

import javax.inject.Inject;

public class DetailPresenter extends  BasePresenter implements DetailContact.Presenter {
    private MainContacts.View mView;
    private ApiService mModel;

    @Inject
    public void MainPresenter(MainContacts.View view,ApiService apiService)
    {
        this.mModel=apiService;
        this.mView=view;
    }

    @Override
    public void loadTimeMachineData(long lat, long lon, long timestampForDay) {

    }
}
