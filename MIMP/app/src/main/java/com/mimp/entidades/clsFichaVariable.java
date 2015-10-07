package com.mimp.entidades;

/**
 * Created by EdHam on 04/10/2015.
 */
public class clsFichaVariable
{
    private int pk_id;
    private int control;
    private String tirulo;
    private String respuesta;
    private String hint;
    private int sise;
    private int combinacion;
    private int posicion;
    private int combo;
    private boolean punto;


    public clsFichaVariable(int pk_id, int control, String tirulo, String respuesta, String hint, int sise, int combinacion, int posicion, int combo, boolean punto) {
        this.pk_id = pk_id;
        this.control = control;
        this.tirulo = tirulo;
        this.respuesta = respuesta;
        this.hint = hint;
        this.sise = sise;
        this.combinacion = combinacion;
        this.posicion = posicion;
        this.combo = combo;
        this.punto = punto;
    }

    public clsFichaVariable() {
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getSise() {
        return sise;
    }

    public void setSise(int sise) {
        this.sise = sise;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public boolean isPunto() {
        return punto;
    }

    public void setPunto(boolean punto) {
        this.punto = punto;
    }

    public String getTirulo() {
        return tirulo;
    }

    public void setTirulo(String tirulo) {
        this.tirulo = tirulo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(int combinacion) {
        this.combinacion = combinacion;
    }
}
