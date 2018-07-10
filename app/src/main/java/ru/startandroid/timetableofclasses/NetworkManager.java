package ru.startandroid.timetableofclasses;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
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

//TODO нужно сделать этот класс полноценным синглтном с lazy инициализацией
// это когда объект будет создаваться в момент первого вызова
// после создания вызывать метод init
public class NetworkManager {

    private TimetableApi timetableApi;
    private Retrofit retrofit;

    private List<Request> requests = new ArrayList<>();

    private String answerForAdminStr;

    private Status status;

    private List<Lesson> lessonsList;

    private String[] names;

    private String statusForSignUpStr;

    //TODO в onCreate в App не вызывается
    public void init(){
        retrofit = new Retrofit.Builder()
                //TODO строку со ссылкой лучше вынести в константу в этом же классе
                // public static final String BASE_URL = "https://abd977d7.ngrok.io"
                .baseUrl("https://abd977d7.ngrok.io") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        //TODO т.к. объект ретрофита нигде не используется, можно после build() добавить create(TimetableApi.class)
        // и создавать сразу TimetableApi
        timetableApi = retrofit.create(TimetableApi.class);
    }

    public List<Request> getUnconfirmed(String jKey){

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

    public String putAnswer(String res){

        timetableApi.putAnswer(res).enqueue(new Callback<AnswerForAdmin>() {

            @Override
            public void onResponse(Call<AnswerForAdmin> call, Response<AnswerForAdmin> response) {
                AnswerForAdmin answerForAdmin = response.body();
                answerForAdminStr = answerForAdmin.getMore();
            }

            @Override
            public void onFailure(Call<AnswerForAdmin> call, Throwable t) {
                // TODO со строковывми ресурсами так не получится сделать, R.string.error - это id ресурса
                // в данном случае у тебя преобразуется в строку id
                // строковые ресурсы достаются через Context (как и любые другие ресурсы)
                answerForAdminStr = String.valueOf(R.string.error);
            }
        });

        return answerForAdminStr;
    }

    public Status putStatus(SignIn signIn){

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

    public List<Lesson> getLessons(String jKey){

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

    public String[] getTeachers(){

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

    public String postStatusForSignUp(final SignUp signUp){

        timetableApi.postStatusForSignUp(signUp).enqueue(new Callback<StatusForSignUp>() {

            @Override
            public void onResponse(Call<StatusForSignUp> call, Response<StatusForSignUp> response) {
                StatusForSignUp statusForSignUp = response.body();
                statusForSignUpStr = statusForSignUp.getMore();
            }

            @Override
            public void onFailure(Call<StatusForSignUp> call, Throwable t) {
                //TODO писал вышел про id ресурса
                statusForSignUpStr = String.valueOf(R.string.error);
            }
        });

        return statusForSignUpStr;
    }
}
