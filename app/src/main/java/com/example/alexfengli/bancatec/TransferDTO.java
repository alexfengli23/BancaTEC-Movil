package com.example.alexfengli.bancatec;

/**
 * Created by Alex on 5/22/2017.
 */

public class TransferDTO {
    String origen,destino,descripcion,lugar;
    int monto;

    public TransferDTO(String origen, String destino, String descripcion, String lugar, int monto) {
        this.origen = origen;
        this.destino = destino;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
