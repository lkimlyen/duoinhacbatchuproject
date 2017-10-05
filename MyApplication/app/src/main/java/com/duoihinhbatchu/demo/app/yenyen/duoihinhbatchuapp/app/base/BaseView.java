package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base;

/**
 * Created by yenyen on 10/5/2017.
 */

public interface BaseView <T extends BasePresenter>{
    void setPresenter(T presenter);
    void showProgressBar();
    void hideProgressBar();
}
