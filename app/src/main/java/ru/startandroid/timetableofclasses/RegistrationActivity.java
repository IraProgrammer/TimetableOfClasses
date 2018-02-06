package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.lang.InterruptedException;
import android.widget.Toast;
import java.util.*;

import com.google.gson.Gson;

import ru.startandroid.timetableofclasses.ForGSON.Error;
import ru.startandroid.timetableofclasses.ForGSON.SignIn;
import ru.startandroid.timetableofclasses.ForGSON.Status;

import static ru.startandroid.timetableofclasses.GuestActivity.nameL;
import static ru.startandroid.timetableofclasses.DateActivity.day;
import static ru.startandroid.timetableofclasses.SignUpActivity.url;

public class RegistrationActivity extends Activity implements TextWatcher {

    EditText login;
    EditText password;
    EditText sp;
    Button signin;
    public static String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        login = (EditText) findViewById(R.id.editLog);
        password = (EditText) findViewById(R.id.editPass);
        signin = (Button) findViewById(R.id.buttonSignIn);

        login.addTextChangedListener(this);
        password.addTextChangedListener(this);

        signin.setEnabled(false);

        String fontPath = "fonts/MyFont.ttf";

        TextView text = (TextView) findViewById(R.id.textView);

        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);

        text.setTypeface(typeface);

        TextView tv = (TextView) findViewById(R.id.textView3);
        String s = tv.getText().toString();
        SpannableString ss = new SpannableString(s);
        ss.setSpan(new UnderlineSpan(), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss);

        TextView tv4 = (TextView) findViewById(R.id.textView4);
        String s4 = tv4.getText().toString();
        SpannableString ss4 = new SpannableString(s4);
        ss4.setSpan(new UnderlineSpan(), 0, s4.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv4.setText(ss4);


    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    } */

    public void onTextChanged(CharSequence a, int b, int c, int d) {
        if (!login.getText().toString().isEmpty() &&
                !password.getText().toString().isEmpty()) {
            signin.setEnabled(true);
        } else signin.setEnabled(false);
    }

    public void afterTextChanged(Editable s) {

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    public void onClickSignUp(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void onClickAsGuest(View v) {

        Intent intent = new Intent(this, GuestActivity.class);
        startActivity(intent);
    }

    public void onClickSignIn(View v) {

        SignIn signin = new SignIn(login.getText().toString(), password.getText().toString());
        String json = new Gson().toJson(signin);

        JsonPutOrPost jPUT = new JsonPutOrPost(url + "login/", "PUT", json);
        jPUT.execute();
        String result = "";
        try {

            result = jPUT.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {

        Gson gson = new Gson();
        Status status = gson.fromJson(result, Status.class);
        token = status.getToken();
        String s = status.getStatus();

            if (s.length() != 13) {
                Intent intent1 = new Intent(this, AdminActivity.class);
                startActivity(intent1);
            } else if (s.length() == 13) {
                nameL = status.getName();
                Calendar c = Calendar.getInstance();
                int year = c.get(c.YEAR);
                int month = c.get(c.MONTH);
                int days = c.get(c.DAY_OF_MONTH);
                day = new MyCalendar().getDay(year, month, days);
                Intent intent = new Intent(this, LessonsActivity.class);
                startActivity(intent);
            }
        }
        catch (Exception e) {
            Gson gson = new Gson();
            Error error = gson.fromJson(result, Error.class);
            Toast.makeText(this, error.getMore().toString(), Toast.LENGTH_LONG).show();
       }

    }
}
