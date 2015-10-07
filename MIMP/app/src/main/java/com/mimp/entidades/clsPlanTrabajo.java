package com.mimp.entidades;

/**
 * Created by EdHam on 01/10/2015.
 */
public class clsPlanTrabajo {
    private int pk_id;
    private String obejtivo;
    private String actividad;
    private String meta;
    private String cronograma;
    private String responsable;

    public clsPlanTrabajo() {
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getObejtivo() {
        return obejtivo;
    }

    public void setObejtivo(String obejtivo) {
        this.obejtivo = obejtivo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
