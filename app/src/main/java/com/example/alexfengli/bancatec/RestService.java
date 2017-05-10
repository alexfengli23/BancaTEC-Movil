package com.example.alexfengli.bancatec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit.Ok3Client;

import okhttp3.OkHttpClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

public class RestService {
    private static String URL = "";
    private retrofit.RestAdapter restAdapter;
    private InstituteService apiService;

    public RestService()
    {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        restAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(URL)
                .setClient(new Ok3Client(new OkHttpClient()))
                .setConverter(new GsonConverter(gson))
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();

        apiService = restAdapter.create(InstituteService.class);
    }
    public InstituteService getService(){return apiService;}
}
