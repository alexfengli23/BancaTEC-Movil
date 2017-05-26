package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class AccountDTO {
    public String numero,descripcion,perteneciente;
    public boolean endolares,tipoahorro,estado;
    public ClientDTO cliente;
    public int saldo;

    public AccountDTO(String numero, String descripcion, String perteneciente, boolean endolares, boolean tipoahorro, boolean estado, ClientDTO cliente,int saldo) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.perteneciente = perteneciente;
        this.endolares = endolares;
        this.tipoahorro = tipoahorro;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPerteneciente() {
        return perteneciente;
    }

    public void setPerteneciente(String perteneciente) {
        this.perteneciente = perteneciente;
    }

    public boolean isEndolares() {
        return endolares;
    }

    public void setEndolares(boolean endolares) {
        this.endolares = endolares;
    }

    public boolean isTipoahorro() {
        return tipoahorro;
    }

    public void setTipoahorro(boolean tipoahorro) {
        this.tipoahorro = tipoahorro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ClientDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClientDTO cliente) {
        this.cliente = cliente;
    }
}
