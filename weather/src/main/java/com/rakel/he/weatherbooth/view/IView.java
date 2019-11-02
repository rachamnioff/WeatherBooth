package com.rakel.he.weatherbooth.view;

import android.content.Context;

public interface IView {
    void showProgress(String msg);
    void dismissProgress();
    void showToast(String msg);
    void goBack();
    Context getContext();
}
