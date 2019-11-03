package com.rakel.he.weatherbooth.presenter;

import android.app.Activity;
import android.content.Intent;

import com.rakel.he.weatherbooth.contacts.MainContacts;
import com.rakel.he.weatherbooth.model.ApiService;
import com.rakel.he.weatherbooth.model.entity.DailyEntitity;
import com.rakel.he.weatherbooth.model.entity.ForecastEntity;
import com.rakel.he.weatherbooth.view.DetailActivity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainPresenter extends  BasePresenter implements MainContacts.Presenter {

    private MainContacts.View mView;
    private ApiService mModel;

    @Inject
    public void MainPresenter(MainContacts.View view,ApiService apiService)
    {
        this.mModel=apiService;
        this.mView=view;
    }

    @Override

    public void loadForecastData(double lat,double lon) {
        mView.showProgress("loading");
        mModel.getForecast(KEY,lat,lon)
                .map(new Func1<ForecastEntity, DailyEntitity>() {
            @Override
            public DailyEntitity call(ForecastEntity entity) {
                long time=Long.MAX_VALUE;
                int index=0,selectedItemIndex=-1;
                for(;index<entity.daily.size();index++)
                {
                    if(entity.daily.get(index).time<time)
                    {
                        selectedItemIndex=index;
                        time=entity.daily.get(index).time;
                    }
                }
                if(selectedItemIndex>=0)
                {
                    return entity.daily.get(selectedItemIndex);
                }
                return null;
            }
        }).subscribeOn(Schedulers.newThread())
          .observeOn(Schedulers.io())
                .subscribe(new Subscriber<DailyEntitity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DailyEntitity dailyEntitity) {
                        mView.dismissProgress();
                        mView.onForecastDataLoaded(dailyEntitity);
                    }
                });
    }

    @Override
    public void gotoDetailPage(long timeForDay) {
        Intent intent=new Intent((Activity)mView, DetailActivity.class);
        intent.putExtra("timestampForDay",timeForDay);
        mView.getContext().startActivity(intent);
    }
}
