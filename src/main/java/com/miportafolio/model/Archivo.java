package com.miportafolio.model;

import java.sql.Timestamp;

public class Archivo {
    private int id;
    private String nombre;
    private String url;
    private long tamano;
    private int usuarioId;
    private Timestamp fechaSubida;

    public Archivo() {}

    public Archivo(int id, String nombre, String url, long tamano, int usuarioId, Timestamp fechaSubida) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.tamano = tamano;
        this.usuarioId = usuarioId;
        this.fechaSubida = fechaSubida;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public long getTamano() { return tamano; }
    public void setTamano(long tamano) { this.tamano = tamano; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public Timestamp getFechaSubida() { return fechaSubida; }
    public void setFechaSubida(Timestamp fechaSubida) { this.fechaSubida = fechaSubida; }
}