package com.gofelis.bm;

import com.gofelis.bm.modules.music_player.logic.interactor.MusicPlayerInteractor;
import com.gofelis.bm.modules.music_player.logic.manager.MusicPlayerDataManager;
import com.gofelis.bm.modules.music_player.mi.MusicPlayerModuleDelegate;
import com.gofelis.bm.modules.music_player.ui.presenter.MusicPlayerPresenter;
import com.gofelis.bm.modules.music_player.ui.wireframe.MusicPlayerWireframe;

final class AppModuleAssembler {
	private MusicPlayerPresenter musicPlayerPresenter;
	private MusicPlayerWireframe musicPlayerWireframe;

	MusicPlayerWireframe getMusicPlayerWireframe() throws NullPointerException {
		return musicPlayerWireframe;
	}


        // MARK: Setup Music Player Module
    void setupMusicPlayerModule(MusicPlayerDataManager musicPlayerDataManager) {
        
        MusicPlayerInteractor musicPlayerInteractor = new MusicPlayerInteractor(musicPlayerDataManager);
        musicPlayerPresenter = new MusicPlayerPresenter();
        musicPlayerWireframe = new MusicPlayerWireframe();

        musicPlayerPresenter.setInteractor(musicPlayerInteractor);
        musicPlayerPresenter.setRouting(musicPlayerWireframe);

        musicPlayerInteractor.setInteractorOutput(musicPlayerPresenter);
        musicPlayerWireframe.setPresenter(musicPlayerPresenter);
    }

}
