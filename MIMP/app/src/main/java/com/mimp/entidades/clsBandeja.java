package com.mimp.entidades;

/**
 * Created by EdHam on 28/09/2015.
 */
public class clsBandeja {
    private int pk_id;
    private String nombre;
    private String tipo;
    private String actividad;
    private String estado;
    private int parametro;

    public clsBandeja() {
    }

    public clsBandeja(int pk_id, String nombre, String tipo, String actividad, String estado, int parametro) {
        this.pk_id = pk_id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.actividad = actividad;
        this.estado = estado;
        this.parametro = parametro;
    }


    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }
}
