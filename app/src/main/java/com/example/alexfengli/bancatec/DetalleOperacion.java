package com.example.alexfengli.bancatec;

import java.util.Date;

/**
 * Created by Alex on 5/25/2017.
 */

class DetalleOperacion {
    public int id,monto;
    public String descripcion, origen;
    public Date fecha;

    public DetalleOperacion(int id, int monto, String descripcion, String origen, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.origen = origen;
        this.fecha = fecha;
    }
}
