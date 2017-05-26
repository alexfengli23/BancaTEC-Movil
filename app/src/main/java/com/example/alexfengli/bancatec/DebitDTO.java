package com.example.alexfengli.bancatec;

import java.util.Date;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class DebitDTO {
    public String NumeroTarjeta,Cedula,numeroCuenta;
    public Date fechaExp;
    public int cvv;

    public DebitDTO(String numeroTarjeta, String cedula, String numeroCuenta, Date fechaExp, int cvv) {
        NumeroTarjeta = numeroTarjeta;
        Cedula = cedula;
        this.numeroCuenta = numeroCuenta;
        this.fechaExp = fechaExp;
        this.cvv = cvv;
    }
}
