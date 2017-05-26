package com.example.alexfengli.bancatec;

/**
 * Created by Alex on 5/24/2017.
 */

public class CreditDTO {
    public String numero_tarjeta;
    public CardDTO tarjeta;
    public int saldo,limite_max,pendiente;

    public CreditDTO(String numero_tarjeta, CardDTO tarjeta, int saldo, int limite_max, int pendiente) {
        this.numero_tarjeta = numero_tarjeta;
        this.tarjeta = tarjeta;
        this.saldo = saldo;
        this.limite_max = limite_max;
        this.pendiente = pendiente;
    }
}
