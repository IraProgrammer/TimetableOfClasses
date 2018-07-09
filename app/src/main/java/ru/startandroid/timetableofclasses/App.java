package ru.startandroid.timetableofclasses;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static TimetableApi timetableApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://abd977d7.ngrok.io") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        timetableApi = retrofit.create(TimetableApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static TimetableApi getApi() {
        return timetableApi;
    }
}
