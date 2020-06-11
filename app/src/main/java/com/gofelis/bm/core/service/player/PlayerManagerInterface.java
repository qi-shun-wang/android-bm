package com.gofelis.bm.core.service.player;

public interface PlayerManagerInterface {
    void play();
    void pause();
    void stop();
    void configure(PlayerManagerDelegate delegate);
}
