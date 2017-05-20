package com.example.alexfengli.bancatec;

import android.telecom.Call;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

public interface InstituteService {
    @POST("/Login/{id}")
    public void login(@Path("id") int operator,@Body LoginDTO loginData, Callback<ClientDTO> callback);
    @GET("/Client/{id}")
    public void getClient(@Path("id") String id, Callback<ClientDTO> callback);
    @GET("/Account")
    public void getAccountsClient(@Query("cedula") String id, Callback<List<AccountDTO>> callback);
    @GET("/Debit_C_?IdCuenta={IdCuenta}")
    public void getTarjetasDeCuenta(@Path("Idcuenta")String id, Callback<List<DebitDTO>> callback);
}
