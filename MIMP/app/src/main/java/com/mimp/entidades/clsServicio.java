package com.mimp.entidades;

/**
 * Created by EdHam on 27/09/2015.
 */
public class clsServicio {
    private int pk_id;
    private String nombre;

    public clsServicio() {
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

    public clsServicio(int pk_id, String nombre) {
        this.pk_id = pk_id;
        this.nombre = nombre;
    }
}
