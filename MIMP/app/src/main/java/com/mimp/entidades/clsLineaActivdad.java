package com.mimp.entidades;

/**
 * Created by EdHam on 26/09/2015.
 */
public class clsLineaActivdad {
    private int pk_id;
    private String codigo;
    private String descripcion;

    public clsLineaActivdad() {
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
