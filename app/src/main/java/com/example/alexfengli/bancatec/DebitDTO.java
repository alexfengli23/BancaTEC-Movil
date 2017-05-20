package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class DebitDTO {
    public String numerodetarjeta,numerodecuenta;
    public CardDTO tarjeta;
    public AccountDTO cuenta;

    public DebitDTO(String numerodetarjeta, String numerodecuenta, CardDTO tarjeta, AccountDTO cuenta) {
        this.numerodetarjeta = numerodetarjeta;
        this.numerodecuenta = numerodecuenta;
        this.tarjeta = tarjeta;
        this.cuenta = cuenta;
    }
}
