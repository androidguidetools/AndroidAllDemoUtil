package com.retrofitdemo.retrofitlearnigtopics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.retrofitdemo.retrofitlearnigtopics.adapter.MyAppListAdapter;
import com.retrofitdemo.retrofitlearnigtopics.model.AppList;
import com.retrofitdemo.retrofitlearnigtopics.rest.ApiClient;
import com.retrofitdemo.retrofitlearnigtopics.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<AppList> appList;
    private MyAppListAdapter myAppListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<AppList>> call = apiInterface.getAppList();
        call.enqueue(new Callback<List<AppList>>() {
            @Override
            public void onResponse(Call<List<AppList>> call, Response<List<AppList>> response) {
                appList = response.body();
                myAppListAdapter = new MyAppListAdapter(MainActivity.this,appList);
                recyclerView.setAdapter(myAppListAdapter);
            }

            @Override
            public void onFailure(Call<List<AppList>> call, Throwable t) {

            }
        });
    }
}
