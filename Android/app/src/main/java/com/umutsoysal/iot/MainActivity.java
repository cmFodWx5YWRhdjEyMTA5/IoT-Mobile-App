package com.umutsoysal.iot;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class MainActivity extends Activity {

    private OkHttpClient client = new OkHttpClient();
    static InputStream is = null;
    static JSONObject jObj = null;
    String created_at,entry_id,field1;
    String update_date,gun;
    TextView update,field,day;
    Button yinele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        update=(TextView)findViewById(R.id.date);
        field=(TextView)findViewById(R.id.field);
        day=(TextView)findViewById(R.id.day);
        yinele=(Button)findViewById(R.id.guncelle);

        new GetData().execute();

        yinele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetData().execute();
            }
        });



    }


    private class GetData extends AsyncTask<Object, Object, JSONObject>
    {
        ProgressDialog dialog;//dialog nesnesini tanımladık
        @Override
        protected  void onPreExecute()//Verilerin çekilme esnasında proggres dialog çalıştırır.
        {
            super.onPreExecute();
            dialog=new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading...");
            dialog.show();

        }
        @Override
        protected JSONObject doInBackground(Object... params) {//Arka plan işlemleri gerçekleştirilir.

            GetJson("https://api.thingspeak.com/channels/375603/feeds.json?results=2");
            return null;

        }
        @Override
        protected void onPostExecute(JSONObject avoid)//Arka plan işlemleri bittikten sonra başlık yazdırılır.
        {
            dialog.dismiss();

            update.setText(update_date);
            field.setText(field1);
            day.setText(gun);

        }
    }


    public void GetJson(String get_url)
    {
        // İNDİRME İŞİNİ BURADA YAPACAĞIZ
        String jsonData = null;

        try {
            jsonData = run(get_url);
            Timber.i("JSON VERİMİZ : > " + jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JSON VERİYİ NULL DEĞİLSE JAVA NESNELERİNE DÖNÜŞTÜR
        if (null != jsonData) {
            Timber.i("jsonData null değil ..");
            // VERİYİ GSON İLE NESNELERE DÖNÜŞTÜR
            Gson gson = new Gson();
            JsonArray feeds;
            JsonElement jelement = new JsonParser().parse(jsonData);
            JsonObject jobject = jelement.getAsJsonObject();
            String []qs=jobject.toString().split("updated_at");
            update_date=qs[1].substring(2,22);
            feeds = jobject.get("feeds").getAsJsonArray();



                String a[]=feeds.get(1).toString().split("created_at");
                String b[]=a[1].toString().split(",");
                created_at=b[0].substring(2,22);
                entry_id=b[1].substring(11);
                field1=b[2].substring(10,b[2].length()-2);

                String[] dat=created_at.split("-");
                String[] dat2=dat[2].split("T");
            String month = "wrong";
            DateFormatSymbols dfs = new DateFormatSymbols();
            String[] months = dfs.getMonths();
            if (Integer.parseInt(dat[1]) >= 0 && Integer.parseInt(dat[1]) <= 11 ) {
                month = months[Integer.parseInt(dat[1])];
            }
          update_date=dat[1]+" "+month+" "+dat[0].substring(1)+" ,"+dat2[0];
            gun=dat2[1];
        }

    }



    private String run(String url) throws IOException {
        Timber.i("run ..");
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }



}
