package ru.startandroid.timetableofclasses;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ru.startandroid.timetableofclasses.ForGSON.AnswerForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.Request;
import ru.startandroid.timetableofclasses.ForGSON.RequestsForAdmin;
import ru.startandroid.timetableofclasses.ForGSON.Token;

import static ru.startandroid.timetableofclasses.RegistrationActivity.token;
import static ru.startandroid.timetableofclasses.SignUpActivity.url;

public class AdminActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<AdminListItem> products = new ArrayList<AdminListItem>();
    Adapter boxAdapter;
    List<Request> requests;
    SwipeRefreshLayout mSwipeRefresh;
    String jKey;


    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.srl_container);

        //Настраиваем выполнение OnRefreshListener для данной activity:
        mSwipeRefresh.setOnRefreshListener(this);
        //Настраиваем цветовую тему значка обновления, используя наши цвета:
        mSwipeRefresh.setColorSchemeResources
                (R.color.blue, R.color.blue,R.color.blue);

        String key = token;
        Gson g = new Gson();
        Token token = new Token(key);
        jKey = g.toJson(token);

        JsonGet jGET = new JsonGet(url + "accounts/unconfirmed/?q=" + jKey);
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
        RequestsForAdmin requestsForAdmin = gson.fromJson(result, RequestsForAdmin.class);
        requests = requestsForAdmin.getRequests();

        // создаем адаптер
        fillData();

        boxAdapter = new Adapter(this, products);

        Button admin = (Button) findViewById(R.id.buttonAdmin);
        if(products.size() == 0){
            admin.setEnabled(false);
        }

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.listAdmin);
        lvMain.setAdapter(boxAdapter);

    }

    @Override
    public void onRefresh() {

        products.clear();

        JsonGet jGET = new JsonGet(url + "accounts/unconfirmed/?q=" + jKey);
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
        RequestsForAdmin requestsForAdmin = gson.fromJson(result, RequestsForAdmin.class);
        requests = requestsForAdmin.getRequests();

        // создаем адаптер
        fillData();

        boxAdapter = new Adapter(this, products);

        Button admin = (Button) findViewById(R.id.buttonAdmin);
        if(products.size() == 0){
            admin.setEnabled(false);
        }

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.listAdmin);
        lvMain.setAdapter(boxAdapter);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                //Останавливаем обновление:
                mSwipeRefresh.setRefreshing(false)
                ;}}, 1000);
    }

    // генерируем данные для адаптера
    void fillData() {
        Request request;
        for (int i = 0; i < requests.size(); i++) {
            request = requests.get(i);
            products.add(new AdminListItem(Integer.toString(request.getId()), request.getName(), request.getRequest(), false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {

        String res = "{\"Токен\":\"" + token + "\",\"Вердикт\":{";
        for (AdminListItem p : boxAdapter.getBox()) {
            if (p.box) {
                res += "\"" + p.id + "\"" + ":\"Принять\",";
            }
        else {
            res += "\""+p.id +"\"" + ":\"Отклонить\",";
        }
        }

        String res2 = res.substring(0, res.length()-1);
        res2 += "}}";

        JsonPutOrPost jPUT = new JsonPutOrPost(url + "accounts/uniconfirmed/confirm/", "PUT", res2);
        jPUT.execute();
        String result = "";
        try {

            result = jPUT.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    Gson gson = new Gson();
    AnswerForAdmin answerForAdmin = gson.fromJson(result, AnswerForAdmin.class);
    String s = answerForAdmin.getMore();
    Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}