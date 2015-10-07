/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mimp.entidades;


public class clsProvincia {
  private int pk_id;
  private String nombre;
  private clsDepartamento objDepartamento;

    public clsProvincia() {
    }

    public clsProvincia(int pk_id) {
        this.pk_id = pk_id;
    }

    
    public clsProvincia(int pk_id, clsDepartamento objDepartamento, String nombre) {
        this.pk_id = pk_id;
        this.nombre = nombre;
        this.objDepartamento = objDepartamento;
    }

    public clsProvincia(int pk_id, String nombre) {
        this.pk_id = pk_id;
        this.nombre = nombre;
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

    public clsDepartamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(clsDepartamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    @Override
    public String toString() {
        return nombre;
    }
  
  
  
  
}
