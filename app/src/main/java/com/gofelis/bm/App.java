package com.gofelis.bm;

import android.app.Application;
/*
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    
    ...

    <application
     
        ...
        
        android:name=".App"
        >
        <activity android:name=".RootActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
*/
public class App extends Application {

    private AppDependencies appDependencies;

    @Override
    public void onCreate() {
        super.onCreate();
        appDependencies = new AppDependencies(this);
    }

    public AppDependencies getAppDependencies() {
        return appDependencies;
    }
}