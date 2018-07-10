package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.startandroid.timetableofclasses.ForGSON.RequestsForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.TeachersList;

public class GuestActivity extends Activity {

    Intent intentL;
    String[] names = new String[100];
    static String nameL;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        names = NetworkManager.getInstance(this).getTeachers();

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