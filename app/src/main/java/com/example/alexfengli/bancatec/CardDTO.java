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
    public ClientDTO cliente_tarjeta;


    public CardDTO(String numero, String perteneciente, boolean tipo, boolean estado, int cvv, Date fechaexpira) {
        this.numero = numero;
        this.perteneciente = perteneciente;
        this.tipo = tipo;
        this.estado = estado;
        this.cvv = cvv;
        this.fechaexpira = fechaexpira;
    }

    public CardDTO(String numero, String perteneciente, boolean tipo, boolean estado, int cvv, Date fechaexpira, ClientDTO cliente_tarjeta) {
        this.numero = numero;
        this.perteneciente = perteneciente;
        this.tipo = tipo;
        this.estado = estado;
        this.cvv = cvv;
        this.fechaexpira = fechaexpira;
        this.cliente_tarjeta = cliente_tarjeta;
    }
}
