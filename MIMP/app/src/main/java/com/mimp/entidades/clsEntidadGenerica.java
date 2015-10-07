package com.mimp.entidades;

/**
 * Created by EdHam on 13/09/2015.
 */
public class clsEntidadGenerica {
    private int id;
    private String dato1;
    private String dato2;
    private String dato3;

    public clsEntidadGenerica() {
    }

    public clsEntidadGenerica(String dato1, String dato2, String dato3) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    public String getDato3() {
        return dato3;
    }

    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }
}
