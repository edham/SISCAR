/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mimp.entidades;


public class clsDistrito {
  private int pk_id;
  private String nombre;
  private clsProvincia objProvincia;

    public clsDistrito() {
    }

    public clsDistrito(int pk_id) {
        this.pk_id = pk_id;
    }

    public clsDistrito(int pk_id, String nombre) {
        this.pk_id = pk_id;
        this.nombre = nombre;
    }

    public clsDistrito(int pk_id, clsProvincia objProvincia, String nombre) {
        this.pk_id = pk_id;
        this.nombre = nombre;
        this.objProvincia = objProvincia;
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

    public clsProvincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(clsProvincia objProvincia) {
        this.objProvincia = objProvincia;
    }
   
    @Override
    public String toString()
    {
        return nombre;
    }
  
}
