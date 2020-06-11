package com.gofelis.bm.modules.music_player.ui.wireframe;

import com.gofelis.bm.core.base.BaseRouting;

public interface MusicPlayerWireframeInterface extends BaseRouting {
    void presentMusicPlayerViewFromParent();
    void dismissMusicPlayerViewFromParent();
}