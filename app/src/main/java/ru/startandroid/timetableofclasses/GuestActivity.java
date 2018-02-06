package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import ru.startandroid.timetableofclasses.ForGSON.TeachersList;

import static ru.startandroid.timetableofclasses.SignUpActivity.url;

public class GuestActivity extends Activity {

    Intent intentL;
    String[] names = new String[100];
    static String nameL;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        JsonGet jGET = new JsonGet(url + "accounts/teachers/");
        jGET.execute();
        String result = "";
        try {

            result = jGET.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        TeachersList tl = gson.fromJson(result, TeachersList.class);
        names = tl.getTeachers();

        intentL = new Intent(this, DateActivity.class);

        // находим список
        ListView listTeachers = (ListView) findViewById(R.id.listTeachers);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        listTeachers.setAdapter(adapter);

        listTeachers.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position;
                nameL = names[pos];
                startActivity(intentL);
            }
        });
    }
}