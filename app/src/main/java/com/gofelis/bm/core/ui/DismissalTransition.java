package com.gofelis.bm.core.ui;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;

public class DismissalTransition extends TranslateAnimation {

    public DismissalTransition(AnimationListener listener, ViewGroup parent) {
        super(0,parent.getMeasuredWidth(),0,0);
        setDuration(300);
        setAnimationListener(listener);
    }

    public void animateTransition(ViewGroup child){
        child.setAnimation(this);
        child.animate();
    }
}