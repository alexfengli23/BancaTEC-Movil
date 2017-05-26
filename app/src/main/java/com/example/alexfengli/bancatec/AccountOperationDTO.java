package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by Alex on 5/25/2017.
 */

public class AccountOperationDTO {
    public String numeroCuenta,origen,desc;
    public Date fecha;
    public int monto;

    public AccountOperationDTO(String numeroCuenta, String origen, String desc, Date fecha, int monto) {
        this.numeroCuenta = numeroCuenta;
        this.origen = origen;
        this.desc = desc;
        this.fecha = fecha;
        this.monto = monto;
    }

    public AccountOperationDTO(String numeroCuenta, String origen, String desc, int monto) {
        this.numeroCuenta = numeroCuenta;
        this.origen = origen;
        this.desc = desc;
        this.monto = monto;
        this.fecha = null;
    }
}
