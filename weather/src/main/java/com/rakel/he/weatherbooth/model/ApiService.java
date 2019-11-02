package com.rakel.he.weatherbooth.model;

import com.rakel.he.weatherbooth.model.entity.ForecastEntity;
import com.rakel.he.weatherbooth.model.entity.TimeMachineEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiService {
    //  /forecast
    @GET("/forecast/{key}/{lat},{long}?exclude=currently,minutely,alerts,flags,hourly")
    Observable<ForecastEntity> getForecast(@Path("key")String key,
                                           @Path("lat")float lat,
                                           @Path("long")float lon);


    @GET("/forecast/{key}/{lat},{long},{time}?exclude=currently,minutely,alerts,flags,daily")
    Observable<TimeMachineEntity> getTimeMachine(@Path("key")String key,
                                                 @Path("lat")float lat,
                                                 @Path("long")float lon,
                                                 @Path("time")long timeForDay);
}
