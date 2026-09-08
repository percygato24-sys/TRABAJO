package com.miportafolio.dao;

import com.miportafolio.config.DatabaseConfig;
import com.miportafolio.model.Archivo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoDAO {

    public boolean guardar(Archivo archivo) {
        String sql = "INSERT INTO archivos (nombre, url, tamano, usuario_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, archivo.getNombre());
            stmt.setString(2, archivo.getUrl());
            stmt.setLong(3, archivo.getTamano());
            stmt.setInt(4, archivo.getUsuarioId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Archivo> obtenerPorUsuario(int usuarioId) {
        List<Archivo> lista = new ArrayList<>();
        String sql = "SELECT * FROM archivos WHERE usuario_id = ? ORDER BY fecha_subida DESC";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                lista.add(new Archivo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("url"),
                    rs.getLong("tamano"),
                    rs.getInt("usuario_id"),
                    rs.getTimestamp("fecha_subida")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean eliminar(int id, int usuarioId) {
        String sql = "DELETE FROM archivos WHERE id = ? AND usuario_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}