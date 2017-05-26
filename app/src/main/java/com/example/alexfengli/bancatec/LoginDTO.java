package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class LoginDTO {
    String cedula, contrasena;

    public LoginDTO(String usuario, String contraseña) {
        this.cedula = usuario;
        this.contrasena = contraseña;
    }

    public String getUsuario() {
        return cedula;
    }

    public void setUsuario(String usuario) {
        this.cedula = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
