package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class DebitDTO {
    public String numero_tarjeta,numero_cuenta;
    public CardDTO tarjeta;
    public AccountDTO cuenta;

    public DebitDTO(String numerodetarjeta, String numerodecuenta, CardDTO tarjeta, AccountDTO cuenta) {
        this.numero_tarjeta = numerodetarjeta;
        this.numero_cuenta = numerodecuenta;
        this.tarjeta = tarjeta;
        this.cuenta = cuenta;
    }
}
