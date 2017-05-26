package com.example.alexfengli.bancatec;

import java.util.Date;

/**
 * Created by Alex on 5/22/2017.
 */

public class MovimientoCuentaDTO {
    public Date fecha;
    public String descripcion,origen,operacion;
    public int monto;

    public MovimientoCuentaDTO(Date fecha, String descripcion, String origen, String operacion, int monto) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.origen = origen;
        this.operacion = operacion;
        this.monto = monto;
    }
}
