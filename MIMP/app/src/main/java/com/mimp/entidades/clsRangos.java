package com.mimp.entidades;

/**
 * Created by EdHam on 26/09/2015.
 */
public class clsRangos {
    private int pk_id;
    private int rangoM;
    private int rangoF;
    private String rango;
    private boolean libre;

    private int total;

    public clsRangos() {
    }

    public clsRangos(int pk_id, String rango) {
        this.pk_id = pk_id;
        this.rango = rango;
        this.libre=false;
    }

    public clsRangos(int pk_id, boolean libre) {
        this.pk_id = pk_id;
        this.libre = libre;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getRangoM() {
        return rangoM;
    }

    public void setRangoM(int rangoM) {
        this.rangoM = rangoM;
    }

    public int getRangoF() {
        return rangoF;
    }

    public void setRangoF(int rangoF) {
        this.rangoF = rangoF;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
}
