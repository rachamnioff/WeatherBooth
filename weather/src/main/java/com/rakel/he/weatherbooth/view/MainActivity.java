package com.rakel.he.weatherbooth.view;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.rakel.he.weatherbooth.R;
import com.rakel.he.weatherbooth.contacts.MainContacts;
import com.rakel.he.weatherbooth.model.entity.DailyEntitity;
import com.rakel.he.weatherbooth.presenter.MainPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import android.widget.TextView;

public class MainActivity extends BasicActivity implements MainContacts.View {

    private TextView mDateView,mTemperatureRangeView,mIconView;
    private final int LOCATION_PERMISSION_REQUEST_CODE=1;
    private long timeForDay=-1;


    MainPresenter mPresenter;


    public void onForecastDataLoaded(DailyEntitity entity) {
        if(entity!=null)
        {
            mIconView.setText(entity.icon);
            mTemperatureRangeView.setText(String.format(getString(R.string.temperature_range),
                    entity.temperatureHigh,entity.temperatureLow));
            timeForDay=entity.time;
            mIconView.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initDateInfo();
        requestStoragePermission();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mDateView=findViewById(R.id.main_date);
        mTemperatureRangeView=findViewById(R.id.main_temperature_range);
        mIconView=findViewById(R.id.main_icon);
        mIconView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(timeForDay<0)
                    return;
                mPresenter.gotoDetailPage(timeForDay);
            }
        });
    }

    private void initDateInfo()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/dd");
        mDateView.setText(sdf.format(new Date()));
    }



    private void loadForecast()
    {
        Location lastestLocation=getCurrentLocation();
        mPresenter.loadForecastData(lastestLocation.getLatitude(),lastestLocation.getLongitude());
    }


    private void requestStoragePermission()
    {
        LocationManager lm = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
        if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if (Build.VERSION.SDK_INT > 22) {
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}
                            , LOCATION_PERMISSION_REQUEST_CODE);
                } else {
                    loadForecast();
                }
            } else {
                loadForecast();
            }
        }else
        {
            showToast(getString(R.string.open_location_service));
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

    private void onPermissionDenied()
    {
        mTemperatureRangeView.setText(R.string.error_location_permission_denied);
        mIconView.setText(R.string.error_location_permission_denied);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==LOCATION_PERMISSION_REQUEST_CODE&&grantResults[0]==PERMISSION_GRANTED)
        {
            loadForecast();
        }else
        {
            onPermissionDenied();
        }
    }

}
