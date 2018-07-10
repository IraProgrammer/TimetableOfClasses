package ru.startandroid.timetableofclasses;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import ru.startandroid.timetableofclasses.ForGSON.AnswerForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.Lessons;
import ru.startandroid.timetableofclasses.ForGSON.RequestsForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.SignIn;
import ru.startandroid.timetableofclasses.ForGSON.SignUp;
import ru.startandroid.timetableofclasses.ForGSON.Status;
import ru.startandroid.timetableofclasses.ForGSON.StatusForSignUp;
import ru.startandroid.timetableofclasses.ForGSON.TeachersList;

public interface TimetableApi {


    @GET("/accounts/unconfirmed")
    Call<RequestsForAdmin> getUnconfirmed(@Query("q") String key);

    @PUT("/accounts/uniconfirmed/confirm")
    // для того, что бы отправлять "сырой" json как строку нужно
    // добавить зависимость compile 'com.squareup.retrofit2:converter-scalars:2.1.0'
    // добавить .addConverterFactory(ScalarsConverterFactory.create()) к билдеру ретрофита
    // поставить @Body перед String res
    // но лучше, конечно же, создать модель, например, как SignUp
    Call<AnswerForAdmin> putAnswer(@Body String res);

    @GET("/accounts/teachers")
    Call<TeachersList> getTeachers();

    @GET("/lessons")
    Call<Lessons> getLessons(@Query("q") String key);

    @PUT("/login")
    Call<Status> putStatus(@Body SignIn signIn);

    @POST("/accounts/unconfirmed/new")
    Call<StatusForSignUp> postStatusForSignUp(@Body SignUp signUp);
}
