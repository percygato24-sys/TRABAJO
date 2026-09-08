package com.miportafolio.controller;

import com.miportafolio.service.AuthService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    private AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean exito = authService.registrarUsuario(nombre, email, password);

        if (exito) {
            response.sendRedirect("login.jsp?registroExitoso=true");
        } else {
            request.setAttribute("error", "No se pudo registrar el usuario");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}