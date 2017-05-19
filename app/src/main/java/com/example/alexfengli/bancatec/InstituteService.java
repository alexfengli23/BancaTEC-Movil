package com.example.alexfengli.bancatec;

import android.telecom.Call;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

public interface InstituteService {
    @POST("api/Client?usuario={usuario}&contrasena={contrasena}")
    public void login(@Path("usuario") String userName,@Path("contrasena") String pwd, Callback<ClientDTO> callback);
}
