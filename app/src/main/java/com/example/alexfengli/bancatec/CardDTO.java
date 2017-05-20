package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class CardDTO {
    public String numero,perteneciente;
    public boolean tipo,estado;
    public int cvv;
    public Date fechaexpira;

    public CardDTO(String numero, String perteneciente, boolean tipo, boolean estado, int cvv, Date fechaexpira) {
        this.numero = numero;
        this.perteneciente = perteneciente;
        this.tipo = tipo;
        this.estado = estado;
        this.cvv = cvv;
        this.fechaexpira = fechaexpira;
    }
}
