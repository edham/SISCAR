/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mimp.entidades;


public class clsDepartamento {
    private int pk_id;
    private String nombre;

    public clsDepartamento() {
    }

    public clsDepartamento(int pk_id, String nombre) {
        this.pk_id = pk_id;
        this.nombre = nombre;
    }

    public clsDepartamento(int pk_id) {
        this.pk_id = pk_id;
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
    
     @Override
    public String toString()
    {
        return nombre;
    }
}
