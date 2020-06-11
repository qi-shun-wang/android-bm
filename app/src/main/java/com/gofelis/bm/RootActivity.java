package com.gofelis.bm;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

//import androidx.annotation.NonNull;

public class RootActivity extends Activity {

    ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create activity_root layout and setup a root view id called root by yourself.
        setContentView(R.layout.activity_root);
        root = findViewById(R.id.root);

    }


    @Override
    protected void onResume() {
        super.onResume();
        ((App)getApplication()).getAppDependencies().installRootView(this, root);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((App)getApplication()).getAppDependencies().uninstallRootView(root);
    }
/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Create Android Permisstion Manager by your self.
        //((App)getApplication()).getAppDependencies().getAndroidPermission().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
*/
}
