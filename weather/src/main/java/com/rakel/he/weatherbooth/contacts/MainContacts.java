package com.rakel.he.weatherbooth.contacts;

import com.rakel.he.weatherbooth.model.entity.ForecastEntity;

public interface MainContacts {
    interface View
    {
        void onForecastDataLoaded(ForecastEntity entity);
    }

    interface Presenter
    {
        void loadForecastData(long lat,long lon);
        void gotoDetailPage(long timeForDay);
    }
}
