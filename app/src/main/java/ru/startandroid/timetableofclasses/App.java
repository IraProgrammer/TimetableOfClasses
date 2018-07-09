package ru.startandroid.timetableofclasses;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static NetworkManager networkManager;

    @Override
    public void onCreate() {
        super.onCreate();

        networkManager = new NetworkManager();
    }

    public static NetworkManager getNetworkManager() {
        return networkManager;
    }
}
