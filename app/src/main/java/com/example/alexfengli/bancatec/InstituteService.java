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
    @POST("/Login/2")
    public void login(@Body LoginDTO loginData, Callback<ClientDTO> callback);
    @GET("/Client/{id}")
    public void getClient(@Path("id") String id, Callback<ClientDTO> callback);
    @GET("/Account")
    public void getAccountsClient(@Query("cedula") String id, Callback<List<AccountDTO>> callback);
    @GET("/Debit_C_")
    public void getTarjetasDeCuenta(@Query("Idcuenta") String id, Callback<List<DebitDTO>> callback);
    @POST("/Account?op=1")
    public void transfer(@Body TransferDTO data,Callback<TransferDTO> callback);
    @GET("/Account")
    public void getAccountMovement(@Query("numeroCuenta") String id,Callback<List<MovimientoCuentaDTO>> callback);
    @GET("/Loan")
    public void getPrestamoActivo (@Query("CedulaCliente") String id,Callback<List<String>> callback);
    @GET("/Loan")
    public void pagoPrestamo(@Query("idPrestamo") int idPrestamo,@Query("monto") int monto,Callback<List<String>> callback);
    @POST("/Credit_C_")
    public void pagoTarjetaCredito(@Query("numeroTarjeta") String id, Callback<String> callback);
    @GET("/Credit_C_")
    public void getListaTarjetaCredito(@Query("cedulaCliente") String id,Callback<List<CreditDTO>> callback);
    @GET("/Account/{id}")
    public void getCuenta(@Path("id") String id,Callback<AccountDTO> callback);
    @GET("/Credit_C_/{id}")
    public void getTarjetaCredito(@Path("id") String id,Callback<CreditDTO> callback);
    @GET("/Credit_C_")
    public void getTarjetasPendientes(@Query("cedula") String id, Callback<List<CreditDTO>> callback);
    @POST("/Credit_C_")
    public void pagarTarjetaPendiente(@Query("numeroTarjeta") String id,Callback<String> callback);
    @POST("/Account")
    public void operacionCuenta(@Body AccountOperationDTO data,@Query("accion") boolean operation,Callback<String> callback);


}
