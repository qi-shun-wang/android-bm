package com.gofelis.bm.modules.music_player.ui.wireframe;

import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.gofelis.bm.core.ui.PresentationTransition;
import com.gofelis.bm.core.ui.DismissalTransition;
import com.gofelis.bm.core.ui.ViewTransitionDelegate;
//import com.gofelis.bm.modules.music_player.ui.transition.MusicPlayerDismissalTransition;
//import com.gofelis.bm.modules.music_player.ui.transition.MusicPlayerPresentationTransition;
import com.gofelis.bm.modules.music_player.ui.presenter.MusicPlayerPresenter;
import com.gofelis.bm.modules.music_player.ui.view.MusicPlayerView;
import com.gofelis.bm.modules.music_player.ui.wireframe.MusicPlayerWireframeInterface;

public class MusicPlayerWireframe implements MusicPlayerWireframeInterface, ViewTransitionDelegate {

    private MusicPlayerPresenter presenter;
    private MusicPlayerView musicPlayerView;
    private ViewGroup parent;

    public void configureParentView(ViewGroup parent) {
        this.parent = parent;
    }

    public void setPresenter(MusicPlayerPresenter presenter) {
        this.presenter = presenter;
    }

    private void presentMusicPlayerInterfaceFromViewGroup() {
        if (musicPlayerView != null) {return;}

        musicPlayerView = new MusicPlayerView(parent.getContext());
        musicPlayerView.setEventHandler(presenter);
        musicPlayerView.setViewTransitionDelegate(this);

        parent.addView(musicPlayerView);
        presenter.attachView(musicPlayerView);
    }

    private void dismissMusicPlayerInterfaceFromViewGroup(){
        if (musicPlayerView == null) return;
        presenter.detachView();
        ((ViewGroup)musicPlayerView.getParent()).removeView(musicPlayerView);
        musicPlayerView = null;
    }


    @Override
    public void shouldAttachToSuperview() {

        new PresentationTransition(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }, parent).animateTransition(musicPlayerView);

    }

    @Override
    public void shouldRemoveFromSuperview() {

        musicPlayerView.clearAnimation();

        new DismissalTransition(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("onAnimationStart","<======");

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dismissMusicPlayerInterfaceFromViewGroup();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        },parent).animateTransition(musicPlayerView);



    }

    @Override
    public void presentMusicPlayerViewFromParent() {
        presentMusicPlayerInterfaceFromViewGroup();
    }

    @Override
    public void dismissMusicPlayerViewFromParent() {
        dismissMusicPlayerInterfaceFromViewGroup();
    }
}
