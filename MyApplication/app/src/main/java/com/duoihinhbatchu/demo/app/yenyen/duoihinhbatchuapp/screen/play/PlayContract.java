package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.play;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BasePresenter;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BaseView;

/**
 * Created by yenyen on 10/5/2017.
 */

public interface PlayContract {
    interface View extends BaseView<PlayContract.Presenter>{
        void setAnimtoProgressBar();
        void setAnimtoImageDisc();
    }
    interface Presenter extends BasePresenter{

    }
}
