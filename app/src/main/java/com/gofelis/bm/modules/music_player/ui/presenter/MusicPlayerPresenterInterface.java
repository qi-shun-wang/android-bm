package com.gofelis.bm.modules.music_player.ui.presenter;

import com.gofelis.bm.core.base.BaseModulePresenter;
import com.gofelis.bm.modules.music_player.logic.interactor.MusicPlayerInteractorInput;
import com.gofelis.bm.modules.music_player.mi.MusicPlayerModuleDelegate;
import com.gofelis.bm.modules.music_player.ui.view.MusicPlayerViewInterface;
import com.gofelis.bm.modules.music_player.ui.wireframe.MusicPlayerWireframeInterface;

public interface MusicPlayerPresenterInterface extends BaseModulePresenter<MusicPlayerModuleDelegate, MusicPlayerViewInterface, MusicPlayerInteractorInput, MusicPlayerWireframeInterface> {}