package com.mimp.entidades;

import java.util.List;

/**
 * Created by EdHam on 26/09/2015.
 */
public class clsProblacionObetivo {

    private int pk_id;
    private String descripcion;
    private String codigo;
    private String codigo_descricion;
    private boolean modalidadIngreso;
    private List<clsRangos> list;
    private int numero;
    private int totalH;
    private int totalM;
    private int total;

    public clsProblacionObetivo(int numero, boolean modalidadIngreso, List<clsRangos> list) {
        this.numero = numero;
        this.modalidadIngreso = modalidadIngreso;
        this.list = list;
        this.descripcion="";
        this.codigo="";
        this.codigo_descricion="";
    }

    public clsProblacionObetivo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(boolean modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
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

    public List<clsRangos> getList() {
        return list;
    }

    public void setList(List<clsRangos> list) {
        this.list = list;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotalH() {
        return totalH;
    }

    public void setTotalH(int totalH) {
        this.totalH = totalH;
    }

    public int getTotalM() {
        return totalM;
    }

    public void setTotalM(int totalM) {
        this.totalM = totalM;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCodigo_descricion() {
        return codigo_descricion;
    }

    public void setCodigo_descricion(String codigo_descricion) {
        this.codigo_descricion = codigo_descricion;
    }
}
