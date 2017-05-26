package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by alex on 26/05/17.
 */

class CalendarioDTO {
    public Date fecha;
    public int montoPago,montoExtra;
    public boolean estado;

    public CalendarioDTO(Date fecha, int montoPago, int montoExtra, boolean estado) {
        this.fecha = fecha;
        this.montoPago = montoPago;
        this.montoExtra = montoExtra;
        this.estado = estado;
    }
}
