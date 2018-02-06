package ru.startandroid.timetableofclasses;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 * Created by Irishka on 26.11.2017.
 */

public class JsonGet extends AsyncTask<Void, Void, String> {

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    static String resultJsonGET = "";
    String myUrl = null;
    public static String[] res;

    public JsonGet(String myUrl){
        this.myUrl = myUrl;
    }


    @Override
    protected String doInBackground(Void... params) {
// получаем данные с внешнего ресурса
        try {
            URL url = new URL(myUrl);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setRequestMethod("GET");
            httpCon.connect();
            InputStream inputStream = httpCon.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            resultJsonGET = buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (ProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return resultJsonGET;
    }

    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
    }
}