package com.rakel.he.weatherbooth.contacts;

import com.rakel.he.weatherbooth.model.entity.TimeMachineEntity;

public interface DetailContact {
    interface View
    {
        void onTimeMachineLoaded(TimeMachineEntity entity);
    }

    interface Presenter
    {
        void loadTimeMachineData(long lat,long lon,long timestampForDay);
    }
}
