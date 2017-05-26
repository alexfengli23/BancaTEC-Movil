package com.example.alexfengli.bancatec;

import java.sql.Date;

/**
 * Created by Alex on 5/22/2017.
 */

class OperacionMovimientoDTO {
    private int id,monto;
    private String descripcion,origen;
    private Date fecha;

    public OperacionMovimientoDTO(int id, int monto, String descripcion, String origen, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.origen = origen;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
