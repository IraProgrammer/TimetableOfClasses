package ru.startandroid.timetableofclasses;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.startandroid.timetableofclasses.ForGSON.Answer;
import ru.startandroid.timetableofclasses.ForGSON.AnswerForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.Lesson;
import ru.startandroid.timetableofclasses.ForGSON.Lessons;
import ru.startandroid.timetableofclasses.ForGSON.Request;
import ru.startandroid.timetableofclasses.ForGSON.RequestsForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.SignIn;
import ru.startandroid.timetableofclasses.ForGSON.SignUp;
import ru.startandroid.timetableofclasses.ForGSON.Status;
import ru.startandroid.timetableofclasses.ForGSON.StatusForSignUp;
import ru.startandroid.timetableofclasses.ForGSON.TeachersList;

// нужно сделать этот класс полноценным синглтном с lazy инициализацией
// это когда объект будет создаваться в момент первого вызова
// после создания вызывать метод init
public class NetworkManager {

    private static NetworkManager networkManager;

    private static TimetableApi timetableApi;
    private Retrofit retrofit;

    private static final String BASE_URL = "https://abd977d7.ngrok.io";

    private List<Request> requests = new ArrayList<>();

    private String answerForAdminStr;

    private Status status;

    private List<Lesson> lessonsList;

    private String[] names;

    private String statusForSignUpStr;

    private Context context;

    private NetworkManager(Context context) {
        this.context = context;
    }

    public static NetworkManager getInstance(Context context) {

        if (networkManager == null) {
            networkManager = new NetworkManager(context);
            init();
        }

        return networkManager;
    }

    private static void init() {
        timetableApi = new Retrofit.Builder()
                .baseUrl(BASE_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(TimetableApi.class);
        // и создавать сразу TimetableApi
    }

    public List<Request> getUnconfirmed(String jKey) {

        timetableApi.getUnconfirmed(jKey).enqueue(new Callback<RequestsForAdmin>() {

            @Override
            public void onResponse(Call<RequestsForAdmin> call, Response<RequestsForAdmin> response) {
                RequestsForAdmin requestsForAdmin = response.body();
                requests = requestsForAdmin.getRequests();
            }

            @Override
            public void onFailure(Call<RequestsForAdmin> call, Throwable t) {
            }
        });

        return requests;
    }

    public String putAnswer(String res) {

        timetableApi.putAnswer(res).enqueue(new Callback<AnswerForAdmin>() {

            @Override
            public void onResponse(Call<AnswerForAdmin> call, Response<AnswerForAdmin> response) {
                AnswerForAdmin answerForAdmin = response.body();
                answerForAdminStr = answerForAdmin.getMore();
            }

            @Override
            public void onFailure(Call<AnswerForAdmin> call, Throwable t) {
                //  со строковывми ресурсами так не получится сделать, R.string.error - это id ресурса
                // в данном случае у тебя преобразуется в строку id
                // строковые ресурсы достаются через Context (как и любые другие ресурсы)
                answerForAdminStr = context.getString(R.string.error);
            }
        });

        return answerForAdminStr;
    }

    public Status putStatus(SignIn signIn) {

        timetableApi.putStatus(signIn).enqueue(new Callback<Status>() {

            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                status = response.body();
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
            }
        });

        return status;
    }

    public List<Lesson> getLessons(String jKey) {

        timetableApi.getLessons(jKey).enqueue(new Callback<Lessons>() {

            @Override
            public void onResponse(Call<Lessons> call, Response<Lessons> response) {
                Lessons lessons = response.body();
                lessonsList = lessons.getLessons();
            }

            @Override
            public void onFailure(Call<Lessons> call, Throwable t) {
            }
        });

        return lessonsList;
    }

    public String[] getTeachers() {

        timetableApi.getTeachers().enqueue(new Callback<TeachersList>() {

            @Override
            public void onResponse(Call<TeachersList> call, Response<TeachersList> response) {
                TeachersList tl = response.body();
                names = tl.getTeachers();
            }

            @Override
            public void onFailure(Call<TeachersList> call, Throwable t) {
            }
        });

        return names;
    }

    public String postStatusForSignUp(final SignUp signUp) {

        timetableApi.postStatusForSignUp(signUp).enqueue(new Callback<StatusForSignUp>() {

            @Override
            public void onResponse(Call<StatusForSignUp> call, Response<StatusForSignUp> response) {
                StatusForSignUp statusForSignUp = response.body();
                statusForSignUpStr = statusForSignUp.getMore();
            }

            @Override
            public void onFailure(Call<StatusForSignUp> call, Throwable t) {
                //писал вышел про id ресурса
                statusForSignUpStr = context.getString(R.string.error);
            }
        });

        return statusForSignUpStr;
    }
}
