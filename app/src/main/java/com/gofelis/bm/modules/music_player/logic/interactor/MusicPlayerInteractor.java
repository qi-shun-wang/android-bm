package com.gofelis.bm.modules.music_player.logic.interactor;

//import com.gofelis.bm.models.entities.music_player.MusicPlayer;
import com.gofelis.bm.modules.music_player.logic.manager.MusicPlayerDataManager;


public class MusicPlayerInteractor implements MusicPlayerInteractorInterface , MusicPlayerInteractorInput {

    private MusicPlayerInteractorOutput musicPlayerInteractorOutput;

    private MusicPlayerDataManager musicPlayerDataManager;

    public MusicPlayerInteractor(MusicPlayerDataManager musicPlayerDataManager){
        this.musicPlayerDataManager = musicPlayerDataManager;
    }

    @Override
    public void setInteractorOutput(MusicPlayerInteractorOutput output) {
        this.musicPlayerInteractorOutput = output;
    }

    @Override
    public MusicPlayerInteractorOutput getInteractorOutput() throws NullPointerException {
        if (musicPlayerInteractorOutput != null) return musicPlayerInteractorOutput;
        throw new NullPointerException("You must setup MusicPlayerInteractorOutput before you use it.");
    }
}