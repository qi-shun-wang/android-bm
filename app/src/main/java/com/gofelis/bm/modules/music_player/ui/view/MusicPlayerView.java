package com.gofelis.bm.modules.music_player.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gofelis.bm.core.ui.ViewTransitionDelegate;
import com.gofelis.bm.modules.music_player.mi.MusicPlayerModuleInterface;

public class MusicPlayerView extends LinearLayout implements MusicPlayerViewInterface {

    private MusicPlayerModuleInterface eventHandler;
    private ViewTransitionDelegate viewTransitionDelegate;
    
    public MusicPlayerView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        setOrientation(LinearLayout.VERTICAL);

        TextView hello_world = new TextView(context);
        hello_world.setBackgroundColor(Color.BLACK);
        hello_world.setTextColor(Color.parseColor("#ff0000"));
        hello_world.setText("Hello World");
        addView(hello_world);
    }

    public void setEventHandler(MusicPlayerModuleInterface eventHandler) {
        this.eventHandler = eventHandler;
    }

    public MusicPlayerModuleInterface getEventHandler() throws NullPointerException {
        return eventHandler;
    }


    public ViewTransitionDelegate getViewTransitionDelegate() {
        return viewTransitionDelegate;
    }

    public void setViewTransitionDelegate(ViewTransitionDelegate viewTransitionDelegate) {
        this.viewTransitionDelegate = viewTransitionDelegate;
    }

    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d("finalize-->",getClass().toString());
    }


    @Override
    public void present() {
        getViewTransitionDelegate().shouldAttachToSuperview();
    }

    @Override
    public void dismiss() {
        getViewTransitionDelegate().shouldRemoveFromSuperview();
    }


    @Override
    public void run(Runnable runnable) {
        Handler mainHandler = new Handler(getContext().getMainLooper());
        mainHandler.post(runnable);
    }

}
