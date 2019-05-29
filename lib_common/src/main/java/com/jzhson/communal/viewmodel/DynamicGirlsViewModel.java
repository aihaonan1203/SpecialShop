package com.jzhson.communal.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.jzhson.communal.http.entities.GirlsData;


/**
 * Created by dxx on 2017/11/20.
 * 动态的url
 */

public class DynamicGirlsViewModel extends BaseViewModel<GirlsData> {

    public DynamicGirlsViewModel(@NonNull Application application) {
        super(application);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
