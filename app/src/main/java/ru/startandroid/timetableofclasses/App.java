package ru.startandroid.timetableofclasses;

import android.app.Application;

//TODO auto import в настройках студии можно включиь
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//TODO нужно доабвить в manifest строку android:name=".App" в тэг application
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
