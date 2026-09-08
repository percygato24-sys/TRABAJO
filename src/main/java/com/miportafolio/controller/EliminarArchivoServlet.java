package com.miportafolio.controller;

import com.miportafolio.model.Usuario;
import com.miportafolio.service.StorageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/eliminar-archivo")
public class EliminarArchivoServlet extends HttpServlet {

    private StorageService storageService = new StorageService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int archivoId = Integer.parseInt(request.getParameter("id"));
        storageService.eliminarArchivo(archivoId, usuario.getId());

        response.sendRedirect("dashboard.jsp");
    }
}