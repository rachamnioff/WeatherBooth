package com.rakel.he.weatherbooth.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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

    @Override
    public Context getContext() {
        return this;
    }
}
