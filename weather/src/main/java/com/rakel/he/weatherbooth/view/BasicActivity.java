package com.rakel.he.weatherbooth.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.widget.Toast;


public abstract class BasicActivity extends Activity implements  IView{
    protected ProgressDialog mDialog;

    public void goBack()
    {
        finish();
    }

    public void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG);
    }

    public void dismissProgress()
    {
        if(mDialog!=null)
        {
            mDialog.dismiss();
        }
    }

    public void showProgress(String message)
    {
        if(mDialog==null) {
            mDialog = new ProgressDialog(this);
            mDialog.setCancelable(false);
        }
        mDialog.setMessage(message);
        mDialog.show();
    }

    protected Location getCurrentLocation()
    {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // 高精度
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW); // 低功耗
        String provider = locationManager.getBestProvider(criteria, true);

        //获取Location
        try {
            return locationManager.getLastKnownLocation(provider);
        }catch (SecurityException e)
        {
            return null;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
