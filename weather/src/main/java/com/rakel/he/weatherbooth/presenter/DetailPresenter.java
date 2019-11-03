package com.rakel.he.weatherbooth.presenter;

import com.rakel.he.weatherbooth.contacts.DetailContact;
import com.rakel.he.weatherbooth.model.ApiService;
import com.rakel.he.weatherbooth.model.entity.TimeMachineEntity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.schedulers.Schedulers;


public class DetailPresenter extends  BasePresenter implements DetailContact.Presenter {
    private DetailContact.View mView;
    private ApiService mModel;

    @Inject
    public void DetailPresenter(DetailContact.View view, ApiService apiService)
    {
        this.mModel=apiService;
        this.mView=view;
    }


    public void loadTimeMachineData(double lat, double lon, long timestampForDay) {
        mView.showProgress("loading");
        mModel.getTimeMachine(KEY,lat,lon,timestampForDay)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<TimeMachineEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TimeMachineEntity timeMachineEntity) {
                        mView.dismissProgress();
                        mView.onTimeMachineLoaded(timeMachineEntity);
                    }
                });
    }
}
