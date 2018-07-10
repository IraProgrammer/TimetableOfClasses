package ru.startandroid.timetableofclasses;

import android.app.Application;

// auto import в настройках студии можно включиь


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkManager.getInstance(getBaseContext());

    }
}
