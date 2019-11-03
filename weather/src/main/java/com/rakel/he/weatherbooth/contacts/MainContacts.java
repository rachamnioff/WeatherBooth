package com.rakel.he.weatherbooth.contacts;


import com.rakel.he.weatherbooth.model.entity.DailyEntitity;
import com.rakel.he.weatherbooth.view.IView;

public interface MainContacts {
    interface View extends IView
    {
        void onForecastDataLoaded(DailyEntitity entity);
    }

    interface Presenter
    {
        void loadForecastData(double lat,double lon);
        void gotoDetailPage(long timeForDay);
    }
}
