 package com.gofelis.bm.core.ui;

 import android.view.ViewGroup;
 import android.view.animation.TranslateAnimation;

 public class PresentationTransition extends TranslateAnimation {

     public PresentationTransition(AnimationListener listener, ViewGroup parent) {
         super(parent.getMeasuredWidth(),0,0,0);
         setDuration(400);
         setAnimationListener(listener);
     }

     public void animateTransition(ViewGroup child){
         child.setAnimation(this);
         child.animate();
     }
 }
