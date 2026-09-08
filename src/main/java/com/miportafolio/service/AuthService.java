package com.miportafolio.service;

import com.miportafolio.dao.UsuarioDAO;
import com.miportafolio.model.Usuario;

public class AuthService {

    private UsuarioDAO usuarioDAO;

    public AuthService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean registrarUsuario(String nombre, String email, String password) {
        if (nombre == null || email == null || password == null || email.trim().isEmpty()) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(nombre, email, password);
        return usuarioDAO.registrar(nuevoUsuario);
    }

    public Usuario iniciarSesion(String email, String password) {
        if (email == null || password == null) {
            return null;
        }
        return usuarioDAO.autenticar(email, password);
    }
}