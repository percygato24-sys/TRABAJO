package com.miportafolio.controller;

import com.miportafolio.model.Usuario;
import com.miportafolio.service.StorageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/subir-archivo")
@MultipartConfig
public class SubirArchivoServlet extends HttpServlet {

    private StorageService storageService = new StorageService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Part filePart = request.getPart("archivo");
        if (filePart != null && filePart.getSize() > 0) {
            String nombreArchivo = filePart.getSubmittedFileName();
            long tamano = filePart.getSize();
            String url = "https://tu-supabase-storage-url/" + nombreArchivo;

            storageService.guardarArchivo(nombreArchivo, url, tamano, usuario.getId());
        }

        response.sendRedirect("dashboard.jsp");
    }
}