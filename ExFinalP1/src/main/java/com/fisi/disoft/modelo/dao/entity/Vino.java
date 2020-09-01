package com.fisi.disoft.modelo.dao.entity;

public class Vino {
    private Integer idVino;
    private String nombre;
    private Integer grado;
    private Integer _year;

    public Integer getIdVino() {
        return idVino;
    }

    public void setIdVino(Integer idVino) {
        this.idVino = idVino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Integer get_year() {
        return _year;
    }

    public void set_year(Integer _year) {
        this._year = _year;
    }
}
