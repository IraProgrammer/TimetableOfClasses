package ru.startandroid.timetableofclasses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import ru.startandroid.timetableofclasses.ForGSON.AnswerForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.Lessons;
import ru.startandroid.timetableofclasses.ForGSON.RequestsForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.Status;
import ru.startandroid.timetableofclasses.ForGSON.StatusForSignUp;
import ru.startandroid.timetableofclasses.ForGSON.TeachersList;

public interface TimetableApi {


    @GET("/accounts/unconfirmed")
    Call<RequestsForAdmin> getUnconfirmed(@Query("q") String key);

    @PUT("/accounts/uniconfirmed/confirm")
    Call<AnswerForAdmin> putAnswer(String res);

    @GET("/accounts/teachers")
    Call<TeachersList> getTeachers();

    @GET("/lessons")
    Call<Lessons> getLessons(@Query("q") String key);

    @PUT("/login")
    Call<Status> putStatus(String json);

    @POST("/accounts/unconfirmed/new")
    Call<StatusForSignUp> postStatusForSignUp(String json);
}
