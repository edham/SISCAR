package com.mimp.utilidades;

import com.mimp.entidades.clsProfesion;
import com.mimp.entidades.clsRangos;
import com.mimp.entidades.clsServicio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EdHam on 26/09/2015.
 */
public class clsDatosTem {
    public static List<clsProfesion> getProfesion()
    {
        List<clsProfesion> lista = new ArrayList<clsProfesion>();
        lista.add(new clsProfesion("01","MÉDICOS PEDIATRAS"));
        lista.add(new clsProfesion("02","OTROS TIPOS DE MÉDICOS"));
        lista.add(new clsProfesion("03","PERSONAL PARAMÉDICO"));
        lista.add(new clsProfesion("04","PSICÓLOGOS"));
        lista.add(new clsProfesion("05","SOCIÓLOGOS"));
        lista.add(new clsProfesion("06","ABOGADOS"));
        lista.add(new clsProfesion("07","NUTRICIONISTAS"));
        lista.add(new clsProfesion("08","ASISTENTES SOCIALES"));

        lista.add(new clsProfesion("09","COMUNICADORES"));
        lista.add(new clsProfesion("10","EDUCADORES"));
        lista.add(new clsProfesion("11","ADMINISTRATIVOS"));
        lista.add(new clsProfesion("12","PERSONAL DE SERVICIO"));
        lista.add(new clsProfesion("13","PERSONAL DE COCINA"));
        lista.add(new clsProfesion("23","PROMOTORES DEFENSORES"));
        lista.add(new clsProfesion("31","VOLUNTARIOS"));
        lista.add(new clsProfesion("33","MADRES DE FAMILIA"));

        return lista;
    }

    public static List<clsRangos> getRangos()
    {
        List<clsRangos> lista = new ArrayList<clsRangos>();
        lista.add(new clsRangos(1,"0 - 2"));
        lista.add(new clsRangos(2,"3 - 5"));
        lista.add(new clsRangos(3,"6 - 9"));
        lista.add(new clsRangos(4,"10 - 12"));
        lista.add(new clsRangos(5,"13 - 15"));
        lista.add(new clsRangos(6,"16 < 18"));
        lista.add(new clsRangos(8,true));

        return lista;
    }

    public static List<clsServicio> getServicios()
    {
        List<clsServicio> lista = new ArrayList<clsServicio>();
        lista.add(new clsServicio(1,"INSTALACIÓN DE AGUA"));
        lista.add(new clsServicio(2,"INSTALACIÓN DE DESAGÜE"));
        lista.add(new clsServicio(3,"INSTALACIÓNES ELÉCTRICAS"));
        lista.add(new clsServicio(4,"SERVICIOS HIGIÉNICOS"));
        lista.add(new clsServicio(5,"COCINA"));
        lista.add(new clsServicio(6,"INSTALCIÓN DE GAS"));

        return lista;
    }
}
