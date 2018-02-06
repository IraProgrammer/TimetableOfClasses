package ru.startandroid.timetableofclasses;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by Irishka on 26.11.2017.
 */

public class JsonPutOrPost extends AsyncTask<Void, Void, String> {

    HttpsURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    String myUrl = null;
    String method = "";
    String json = "";

    public JsonPutOrPost(String myUrl, String method, String json){

        this.myUrl = myUrl;
        this.method = method;
        this.json = json;
    }


    @Override
    protected String doInBackground(Void... params) {
// получаем данные с внешнего ресурса
        try {
            URL url = new URL(myUrl);
            HttpsURLConnection httpCon = (HttpsURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod(method);
            httpCon.setRequestProperty("Content-Type","application/json");
            httpCon.connect();

            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());

            out.write(json);
            out.close();
            InputStream inputStream = httpCon.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (ProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return resultJson;
    }

    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
    }
}