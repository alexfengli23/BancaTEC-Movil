package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by Alex Feng Li on 5/6/2017.
 */

public class MovementHistoryDto {
    public int operacion,tipo;
    public Date date;
    public DetalleOperacion detalleOperacion;
    public AccountDTO cuenta;
    public String numeroCuenta;


}
