package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class AccountDTO {
    public String numeroCuenta,descripcion,cedula;
    public int saldo;
    public boolean endolares,tipoCuenta;

    public AccountDTO(String numeroCuenta, String descripcion, String cedula, int saldo, boolean endolares, boolean tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.descripcion = descripcion;
        this.cedula = cedula;
        this.saldo = saldo;
        this.endolares = endolares;
        this.tipoCuenta = tipoCuenta;
    }
}
