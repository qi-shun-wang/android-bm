package com.gofelis.bm.modules.music_player.ui.presenter;

import com.gofelis.bm.modules.music_player.logic.interactor.MusicPlayerInteractorInput;
import com.gofelis.bm.modules.music_player.logic.interactor.MusicPlayerInteractorOutput;
import com.gofelis.bm.modules.music_player.mi.MusicPlayerModuleDelegate;
import com.gofelis.bm.modules.music_player.mi.MusicPlayerModuleInterface;
import com.gofelis.bm.modules.music_player.ui.view.MusicPlayerViewInterface;
import com.gofelis.bm.modules.music_player.ui.wireframe.MusicPlayerWireframeInterface;

public class MusicPlayerPresenter implements MusicPlayerPresenterInterface, MusicPlayerInteractorOutput, MusicPlayerModuleInterface {

    private MusicPlayerViewInterface musicPlayerViewInterface;
    private MusicPlayerInteractorInput musicPlayerInteractorInput;
    private MusicPlayerWireframeInterface musicPlayerWireframe;
    private MusicPlayerModuleDelegate musicPlayerModuleDelegate;

    @Override
    public MusicPlayerInteractorInput getInteractor() {
        return musicPlayerInteractorInput;
    }

    @Override
    public MusicPlayerWireframeInterface getRouting() {
        return musicPlayerWireframe;
    }

    @Override
    public MusicPlayerViewInterface getView() {
        return musicPlayerViewInterface;
    }

    @Override
    public void setRouting(MusicPlayerWireframeInterface routing) {
        musicPlayerWireframe = routing;
    }

    @Override
    public void setInteractor(MusicPlayerInteractorInput interactor) {
        this.musicPlayerInteractorInput = interactor;
    }

    @Override
    public void attachView(MusicPlayerViewInterface view) {
        this.musicPlayerViewInterface = view;
        getView().present();
    }

    @Override
    public void detachView() {
        this.musicPlayerViewInterface = null;
    }

    //BaseModulePresenter methods.
    @Override
    public MusicPlayerModuleDelegate getModuleDelegate() {
        return musicPlayerModuleDelegate;
    }

    @Override
    public void setModuleDelegate(MusicPlayerModuleDelegate moduleDelegate) {
        musicPlayerModuleDelegate = moduleDelegate;
    }
}
