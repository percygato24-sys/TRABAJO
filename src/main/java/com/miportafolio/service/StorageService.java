package com.miportafolio.service;

import com.miportafolio.dao.ArchivoDAO;
import com.miportafolio.model.Archivo;

import java.util.List;

public class StorageService {

    private ArchivoDAO archivoDAO;

    public StorageService() {
        this.archivoDAO = new ArchivoDAO();
    }

    public boolean guardarArchivo(String nombre, String url, long tamano, int usuarioId) {
        if (nombre == null || url == null || usuarioId <= 0) {
            return false;
        }
        Archivo archivo = new Archivo();
        archivo.setNombre(nombre);
        archivo.setUrl(url);
        archivo.setTamano(tamano);
        archivo.setUsuarioId(usuarioId);

        return archivoDAO.guardar(archivo);
    }

    public List<Archivo> listarArchivosPorUsuario(int usuarioId) {
        return archivoDAO.obtenerPorUsuario(usuarioId);
    }

    public boolean eliminarArchivo(int archivoId, int usuarioId) {
        return archivoDAO.eliminar(archivoId, usuarioId);
    }
}