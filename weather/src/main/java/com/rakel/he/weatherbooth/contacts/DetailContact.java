package com.rakel.he.weatherbooth.contacts;

import com.rakel.he.weatherbooth.model.entity.TimeMachineEntity;
import com.rakel.he.weatherbooth.view.IView;

public interface DetailContact {
    interface View extends IView
    {
        void onTimeMachineLoaded(TimeMachineEntity entity);
    }

    interface Presenter
    {
        void loadTimeMachineData(double lat,double lon,long timestampForDay);
    }
}
