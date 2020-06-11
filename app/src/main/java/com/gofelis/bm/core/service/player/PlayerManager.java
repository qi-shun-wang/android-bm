package com.gofelis.bm.core.service.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class PlayerManager implements PlayerManagerInterface, ServiceConnection {

    private PlayerService playerService;
    private PlayerManagerDelegate delegate;
    private Context context;

    public PlayerManager(Context context){
        this.context = context;
        setupAndroidServices(context);
        context.bindService(new Intent(context,PlayerService.class),this, Context.BIND_AUTO_CREATE);
    }

    private void setupAndroidServices(Context application) {
        Intent intent = new Intent();
        intent.setClass(application, PlayerService.class);
        application.startService(intent);
    }

    @Override
    protected void finalize() throws Throwable {
        context.unbindService(this);
        super.finalize();
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        playerService = ((PlayerService.ServiceBinder)iBinder).getService();
        if (delegate != null) {
            delegate.didPlayerReady();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        playerService = null;
        if (delegate != null) {
            delegate.didPlayerUnready();
        }
    }

    @Override
    public void play() {
        if (playerService == null) {
            return;
        }
        playerService.resumeMusic();
    }

    @Override
    public void pause() {
        if (playerService == null) {
            return;
        }
        playerService.pauseMusic();
    }

    @Override
    public void stop() {
        if (playerService == null) {
            return;
        }
        playerService.stopMusic();
    }

    @Override
    public void configure(PlayerManagerDelegate delegate) {
        this.delegate = delegate;
    }
}
