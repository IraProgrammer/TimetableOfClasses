package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.startandroid.timetableofclasses.ForGSON.SignUp;
import ru.startandroid.timetableofclasses.ForGSON.Status;
import ru.startandroid.timetableofclasses.ForGSON.StatusForSignUp;

import static android.R.attr.name;

public class SignUpActivity extends Activity implements TextWatcher{

    EditText name;
    EditText login;
    EditText password;
    EditText passagain;
    EditText request;
    Button send;
    RadioButton teacher;
    RadioButton admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.editName);
        login = (EditText) findViewById(R.id.editLogin);
        password = (EditText) findViewById(R.id.editPassword);
        passagain = (EditText) findViewById(R.id.editPassAgain);
        request = (EditText) findViewById(R.id.editMulti);
        send = (Button) findViewById(R.id.buttonSend);
        teacher = (RadioButton) findViewById(R.id.radioTeacher);
        admin = (RadioButton) findViewById(R.id.radioAdmin);

        name.addTextChangedListener(this);
        login.addTextChangedListener(this);
        password.addTextChangedListener(this);
        passagain.addTextChangedListener(this);
        request.addTextChangedListener(this);
        send.setEnabled(false);
    }

    public void onTextChanged(CharSequence a, int b, int c, int d) {
        if     (!name.getText().toString().isEmpty() &&
                !login.getText().toString().isEmpty() &&
                !password.getText().toString().isEmpty() &&
                !passagain.getText().toString().isEmpty() &&
                !request.getText().toString().isEmpty()) {
            send.setEnabled(true);
        }
        else send.setEnabled(false);
    }

        public void afterTextChanged(Editable s) {

        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

   public void onClickSend(View v){
       String status = "";
       if (teacher.isChecked()) {
           status = "Преподаватель";
       }
       else
    {
        status = "Админ";
    }

        if (!password.getText().toString().equals(passagain.getText().toString())) {
            Toast.makeText(this, R.string.difPass, Toast.LENGTH_LONG).show();
        }

        else if (password.getText().length() < 8) {
           Toast.makeText(this, R.string.minPass, Toast.LENGTH_LONG).show();
       }

       else {

            SignUp signup = new SignUp(request.getText().toString(), status,
                    name.getText().toString(), login.getText().toString(), password.getText().toString());
            String json = new Gson().toJson(signup);


            App.getApi().postStatusForSignUp(json).enqueue(new Callback<StatusForSignUp>() {

                @Override
                public void onResponse(Call<StatusForSignUp> call, Response<StatusForSignUp> response) {
                    StatusForSignUp statusForSignUp = response.body();
                    Toast.makeText(SignUpActivity.this, statusForSignUp.getMore(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<StatusForSignUp> call, Throwable t) {
                    Toast.makeText(SignUpActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
