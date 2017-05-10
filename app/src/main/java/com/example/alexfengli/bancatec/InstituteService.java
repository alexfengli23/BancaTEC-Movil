package com.example.alexfengli.bancatec;

import android.telecom.Call;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

public interface InstituteService {
    @POST("/Login")
    public void login(@Body LoginDto loginData, Callback<LoginDto> callback);
}
