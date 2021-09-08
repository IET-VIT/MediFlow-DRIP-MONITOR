package com.undamped.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView drip_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        drip_text = findViewById(R.id.drip_text);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thingspeak.com/channels/1352492/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceholder = retrofit.create(JSONPlaceHolder.class);
        Call<Feeds> call = jsonPlaceholder.getFeeds();
        call.enqueue(new Callback<Feeds>() {
            @Override
            public void onResponse(Call<Feeds> call, Response<Feeds> response) {
                if (!response.isSuccessful()) {
                    Log.e("Info", String.valueOf(response.code()));
                    return;
                }

                List<Feeds> feeds = response.body().getFeeds();
                Log.e("Info", feeds.get(0).getCreated_at());
                Collections.reverse(feeds);
                checkDripActivity(feeds);
                FieldAdapter fieldAdapter = new FieldAdapter(feeds);
                recyclerView.setAdapter(fieldAdapter);
            }

            @Override
            public void onFailure(Call<Feeds> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void checkDripActivity(List<Feeds> feeds) {
        boolean stopped = false;

        int firstMin = Integer.parseInt(feeds.get(0).getCreated_at().substring(14,16));
        int secondMin = Integer.parseInt(feeds.get(1).getCreated_at().substring(14,16));
        int firstHour = Integer.parseInt(feeds.get(0).getCreated_at().substring(11,13));
        int secondHour = Integer.parseInt(feeds.get(1).getCreated_at().substring(11,13));

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY, firstHour);
        c1.set(Calendar.MINUTE, firstMin);
        c2.set(Calendar.HOUR_OF_DAY, secondHour);
        c2.set(Calendar.MINUTE, secondMin);

        if((feeds.get(0).getField2() == feeds.get(1).getField2()) && (c1.getTimeInMillis() - c2.getTimeInMillis()) > 300000)
            stopped = true;

        if (stopped)
            drip_text.setText("Drip has Stopped");
        else
            drip_text.setText("Drip is Flowing");
    }
}