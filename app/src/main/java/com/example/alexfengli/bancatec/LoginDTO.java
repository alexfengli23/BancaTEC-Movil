package com.example.alexfengli.bancatec;

/**
 * Created by Alex Feng Li on 5/19/2017.
 */

public class LoginDTO {
    String usuario, contrasena;

    public LoginDTO(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contrasena = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
