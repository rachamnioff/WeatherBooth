package com.rakel.he.weatherbooth.view;

import com.rakel.he.weatherbooth.contacts.MainContacts;
import com.rakel.he.weatherbooth.model.entity.ForecastEntity;
import com.rakel.he.weatherbooth.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BasicActivity implements MainContacts.View {

    @Inject
    MainPresenter mPresenter;

    @Override
    public void onForecastDataLoaded(ForecastEntity entity) {

    }

}
