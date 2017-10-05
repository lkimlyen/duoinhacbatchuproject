package com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.screen.play;

import android.animation.ObjectAnimator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.R;
import com.duoihinhbatchu.demo.app.yenyen.duoihinhbatchuapp.app.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by yenyen on 10/5/2017.
 */

public class PlayFragment extends BaseActivity implements PlayContract.View {
    @BindView(R.id.circular_progress_bar)
    ProgressBar mprogressBar;
    @BindView(R.id.imageView1)
    ImageView imageView;
    @Override
    public void setPresenter(PlayContract.Presenter presenter) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void setAnimtoProgressBar() {
        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }

    @Override
    public void setAnimtoImageDisc() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1500);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(rotateAnimation);
    }
}
