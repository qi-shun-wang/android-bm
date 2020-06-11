package com.gofelis.bm;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.gofelis.bm.core.service.player.PlayerManager;
import com.gofelis.bm.core.service.player.PlayerManagerDelegate;
import com.gofelis.bm.core.service.player.PlayerManagerInterface;
import com.gofelis.bm.modules.music_player.logic.manager.MusicPlayerDataManager;

final class AppDependencies {

    private AppModuleAssembler assembler = new AppModuleAssembler();

    AppDependencies(Context application){
        configure(application);
    }

    private void configure(Context application){

        MusicPlayerDataManager musicPlayerDataManager = new MusicPlayerDataManager();

        final PlayerManagerInterface manager = new PlayerManager(application);

        manager.configure(new PlayerManagerDelegate() {
            @Override
            public void didPlayerReady() {
                Log.d("TAG", "didPlayerReady: ");
                manager.play();
            }

            @Override
            public void didPlayerUnready() {

            }
        });



		assembler.setupMusicPlayerModule(musicPlayerDataManager);


    }


    //PermissionManager getAndroidPermission(){
    //    return permissionManager;
    //}

    //private void configureAndroidPermission(Context activity){
    //    ((AndroidPermission)permissionManager).configureActivityContext(activity);
    //}

    void installRootView(Context activity, ViewGroup root) {
		assembler.getMusicPlayerWireframe().configureParentView(root);

		assembler.getMusicPlayerWireframe().presentMusicPlayerViewFromParent();

    }

    void uninstallRootView(ViewGroup root) {
		//assembler.getMusicPlayerWireframe().dismissMusicPlayerViewFromParent();

    }

}
