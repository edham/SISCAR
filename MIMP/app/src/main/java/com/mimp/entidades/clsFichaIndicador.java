package com.mimp.entidades;

import java.util.List;

/**
 * Created by EdHam on 04/10/2015.
 */
public class clsFichaIndicador {
    private int pk_id;
    private int puntos;
    private int posicion;
    private int partes;
    private List<clsFichaVariable> listVariables;

    public clsFichaIndicador(int pk_id, int puntos, int posicion, int partes, List<clsFichaVariable> listVariables) {
        this.pk_id = pk_id;
        this.puntos = puntos;
        this.posicion = posicion;
        this.partes = partes;
        this.listVariables = listVariables;
    }

    public clsFichaIndicador() {
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<clsFichaVariable> getListVariables() {
        return listVariables;
    }

    public void setListVariables(List<clsFichaVariable> listVariables) {
        this.listVariables = listVariables;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPartes() {
        return partes;
    }

    public void setPartes(int partes) {
        this.partes = partes;
    }
}
