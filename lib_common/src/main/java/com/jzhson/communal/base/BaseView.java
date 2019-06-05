package com.jzhson.communal.base;

/**
 * Created by Hjb on 2019/5/30.
 */

public interface BaseView {

    void showToast(String s,int type);

    void showDialog(String s);

    void onError(Integer type);


}
