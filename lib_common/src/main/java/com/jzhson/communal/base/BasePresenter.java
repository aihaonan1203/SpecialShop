package com.jzhson.communal.base;

/**
 * Created by Hjb on 2019/5/30.
 */

public class BasePresenter<T extends BaseView> {

    public T view;

    public BasePresenter(T view) {
        this.view = view;
    }
}
