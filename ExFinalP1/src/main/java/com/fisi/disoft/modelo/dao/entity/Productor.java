package com.fisi.disoft.modelo.dao.entity;

public class Productor {
    private Integer idProductor;
    private String nombre;
    private String apellido;
    private String region;

    public Productor() {
    }

    public Productor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(Integer idProductor) {
        this.idProductor = idProductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Productor{" +
                "idProductor=" + idProductor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
