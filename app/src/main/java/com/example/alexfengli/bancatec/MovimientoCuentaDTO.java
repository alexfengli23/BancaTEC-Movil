package com.example.alexfengli.bancatec;

/**
 * Created by Alex on 5/22/2017.
 */

public class MovimientoCuentaDTO {
    private int operacion,tipo;
    private OperacionMovimientoDTO DetalleOperacion;
    private String numerodecuenta;
    private AccountDTO cuenta;

    public MovimientoCuentaDTO(int operacion, OperacionMovimientoDTO detalleMovimiento, String numeroCuenta, AccountDTO cuenta,int tipo) {
        this.operacion = operacion;
        DetalleOperacion = detalleMovimiento;
        this.numerodecuenta = numeroCuenta;
        this.cuenta = cuenta;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public OperacionMovimientoDTO getDetalleMovimiento() {
        return DetalleOperacion;
    }

    public void setDetalleMovimiento(OperacionMovimientoDTO detalleMovimiento) {
        DetalleOperacion = detalleMovimiento;
    }

    public String getNumeroCuenta() {
        return numerodecuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numerodecuenta = numeroCuenta;
    }

    public AccountDTO getCuenta() {
        return cuenta;
    }

    public void setCuenta(AccountDTO cuenta) {
        this.cuenta = cuenta;
    }
}
