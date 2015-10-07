package com.mimp.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mimp.activity.MainActivity;
import com.mimp.activity.R;
import com.mimp.entidades.clsDepartamento;
import com.mimp.entidades.clsDistrito;
import com.mimp.entidades.clsLineaActivdad;
import com.mimp.entidades.clsProblacionObetivo;
import com.mimp.entidades.clsProfesion;
import com.mimp.entidades.clsProvincia;
import com.mimp.entidades.clsRangos;
import com.mimp.entidades.clsServicio;
import com.mimp.utilidades.clsDatosTem;
import com.mimp.utilidades.clsUbigeo;
import com.mimp.utilidades.clsUtilidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragmento para el contenido principal
 */
public class CarFragment extends Fragment {
    /**
     * Este argumento del fragmento representa el título de cada
     * sección
     */
    private List<clsProfesion> listRecrusosHumanos;
    private List<clsServicio> listServicios;
    private boolean[] booleanSelectArrayServicios;
    private clsDistrito objDistritoZona=null;
    private List<clsDistrito> listZona;
    private Spinner ComboDepartamento;
    private Spinner ComboProvincia;
    private Spinner ComboDistrito;
    private Spinner ComboRecursosHumanos;

    private Spinner ComboDepartamentoZona;
    private Spinner ComboProvinciaZona;
    private Spinner ComboDistritoZona;

    private TextView lblDatos;
    private View viewDatosGenerales;
    private TextView lblDResponsable;
    private View viewDResponsable;
    private View viewUbiFisica;
    private TextView lblUbiFisica;

    private View viewPoblacionObjetivo;
    private TextView lblPoblacionObjetivo;

    private View viewZonaInfluencia;
    private TextView lblZonaInfluencia;


    private View viewModalidadIngreso;
    private TextView lblModalidadIngreso;

    private View viewFinacioamento;
    private TextView lblFinacioamento;

    private View viewInfTecnica;
    private TextView lblInfTecnica;

    private View viewServicios;
    private TextView lblServicios;

    private View viewInfraestructura;
    private TextView lblInfraestructura;

    private View viewRecursosHumanos;
    private TextView lblRecursosHumanos;

    private TextView lblPoblacion1;
    private TextView lblPoblacionDescripcion1;
    private TextView lblPoblacionCategoria1;
    private TextView lblPoblacionCategoriaDes1;

    private TextView lblPoblacion2;
    private TextView lblPoblacionDescripcion2;
    private TextView lblPoblacionCategoria2;
    private TextView lblPoblacionCategoriaDes2;

    private TextView lblPoblacion3;
    private TextView lblPoblacionDescripcion3;
    private TextView lblPoblacionCategoria3;
    private TextView lblPoblacionCategoriaDes3;

    private TextView lblModalidad1;
    private TextView lblModalidad2;
    private TextView lblModalidad3;

    private TextView lblRangoM1T;
    private TextView lblRangoF1T;
    private TextView lblRangoT1T;
    private TextView lblRangoM2T;
    private TextView lblRangoF2T;
    private TextView lblRangoT2T;
    private TextView lblRangoM3T;
    private TextView lblRangoF3T;
    private TextView lblRangoT3T;

    private TextView lblRangoModalidadM1T;
    private TextView lblRangoModalidadF1T;
    private TextView lblRangoModalidadT1T;
    private TextView lblRangoModalidadM2T;
    private TextView lblRangoModalidadF2T;
    private TextView lblRangoModalidadT2T;
    private TextView lblRangoModalidadM3T;
    private TextView lblRangoModalidadF3T;
    private TextView lblRangoModalidadT3T;

    private EditText txtCRecursosHumanos;

    private TextView lblServiciosSeleccion;

    private Button btnPoblacion1;
    private Button btnPoblacion2;
    private Button btnPoblacion3;

    private Button btnModalidad1;
    private Button btnModalidad2;
    private Button btnModalidad3;
    private Button btnAgregarServicios;

    private Button btnAgregarZonaInfluencia;
    private Button btnAgregarRecursosHumanos;

    private Button btnAceptar;
    private AdaptadorRangos adaptadorRangos;
    private AdaptadorModalidadIngreso adaptadorModalidadIngreso;
    private AdaptadorRecursosHumanos adaptadorRecursosHumanos;
    private List<clsLineaActivdad> listLineaActividad;



    private AdaptadorLineaActividad adaptadorLineaActividad;
    private AdaptadorPoblacionObejtivo adaptadorPoblacionObejtivo;

    private AdaptadorZonaInfluencia adaptadorZonaInfluencia;
    private ListView listZonaInfluencia;
    private ListView listActividad;
    private ListView listPoblacionObjetiva;
    private ListView listModalidadIngreso;
    private List<clsRangos> listRangos;

    private ListView listRecursosHumanos;

    private Button btnLineaActividad;
    private int SizeText=0;
    private clsProblacionObetivo  objPoblacion1;
    private clsProblacionObetivo  objPoblacion2;
    private clsProblacionObetivo  objPoblacion3;

    private clsProblacionObetivo  objModalidad1;
    private clsProblacionObetivo  objModalidad2;
    private clsProblacionObetivo  objModalidad3;

    private clsProblacionObetivo  objTemp;

    private String nuevoRango="";
    private int contM1=0;
    private int contF1=0;
    private int contT1=0;

    private int contM2=0;
    private int contF2=0;
    private int contT2=0;

    private int contM3=0;
    private int contF3=0;
    private int contT3=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);

        listRecrusosHumanos= new ArrayList<clsProfesion>();
        listZona=new ArrayList<clsDistrito>();
        listServicios= clsDatosTem.getServicios();
        booleanSelectArrayServicios = new boolean[listServicios.size()];
        ComboRecursosHumanos = (Spinner)view.findViewById(R.id.ComboRecursosHumanos);
        ComboRecursosHumanos();
        ComboDepartamento = (Spinner)view.findViewById(R.id.ComboDepartamento);
        ComboDepartamento();
        ComboProvincia = (Spinner)view.findViewById(R.id.ComboProvincia);
        ComboDistrito = (Spinner)view.findViewById(R.id.ComboDistrito);

        ComboDepartamentoZona = (Spinner)view.findViewById(R.id.ComboDepartamentoZona);
        ComboDepartamentoZona();
        ComboProvinciaZona = (Spinner)view.findViewById(R.id.ComboProvinciaZona);
        ComboDistritoZona = (Spinner)view.findViewById(R.id.ComboDistritoZona);

        viewDatosGenerales=(View)view.findViewById(R.id.viewDatosGenerales);
        lblDatos=(TextView)view.findViewById(R.id.lblDatos);
        lblDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDatos();
            }
        });
        viewPoblacionObjetivo=(View)view.findViewById(R.id.viewPoblacionObjetivo);
        lblPoblacionObjetivo=(TextView)view.findViewById(R.id.lblPoblacionObjetivo);
        lblPoblacionObjetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblPoblacionObjetivo();
            }
        });
        viewDResponsable=(View)view.findViewById(R.id.viewDResponsable);
        lblDResponsable=(TextView)view.findViewById(R.id.lblDResponsable);
        lblDResponsable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDResponsable();
            }
        });
        viewUbiFisica=(View)view.findViewById(R.id.viewUbiFisica);
        lblUbiFisica=(TextView)view.findViewById(R.id.lblUbiFisica);
        lblUbiFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblUbiFisica();
            }
        });

        viewZonaInfluencia=(View)view.findViewById(R.id.viewZonaInfluencia);
        lblZonaInfluencia=(TextView)view.findViewById(R.id.lblZonaInfluencia);
        lblZonaInfluencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblZonaInfluencia();
            }
        });

        viewServicios=(View)view.findViewById(R.id.viewServicios);
        lblServicios=(TextView)view.findViewById(R.id.lblServicios);
        lblServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblServicios();
            }
        });

        viewInfraestructura=(View)view.findViewById(R.id.viewInfraestructura);
        lblInfraestructura=(TextView)view.findViewById(R.id.lblInfraestructura);
        lblInfraestructura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblInfraestructura();
            }
        });



        viewModalidadIngreso=(View)view.findViewById(R.id.viewModalidadIngreso);
        lblModalidadIngreso=(TextView)view.findViewById(R.id.lblModalidadIngreso);
        lblModalidadIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblModalidadIngreso();
            }
        });

        viewRecursosHumanos=(View)view.findViewById(R.id.viewRecursosHumanos);
        lblRecursosHumanos=(TextView)view.findViewById(R.id.lblRecursosHumanos);
        lblRecursosHumanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblRecursosHumanos();
            }
        });

        viewFinacioamento=(View)view.findViewById(R.id.viewFinacioamento);
        lblFinacioamento=(TextView)view.findViewById(R.id.lblFinacioamento);
        lblFinacioamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFinacioamento();
            }
        });

        viewInfTecnica=(View)view.findViewById(R.id.viewInfTecnica);
        lblInfTecnica=(TextView)view.findViewById(R.id.lblInfTecnica);
        lblInfTecnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblInfTecnica();
            }
        });
        lblPoblacion1=(TextView)view.findViewById(R.id.lblPoblacion1);
        lblPoblacion1.setText(lblPoblacion1.getText() + " " + 1);
        lblPoblacionDescripcion1=(TextView)view.findViewById(R.id.lblPoblacionDescripcion1);
        lblPoblacionCategoria1=(TextView)view.findViewById(R.id.lblPoblacionCategoria1);
        lblPoblacionCategoriaDes1=(TextView)view.findViewById(R.id.lblPoblacionCategoriaDes1);

        lblPoblacion2=(TextView)view.findViewById(R.id.lblPoblacion2);
        lblPoblacion2.setText(lblPoblacion2.getText()+" "+2);
        lblPoblacionDescripcion2=(TextView)view.findViewById(R.id.lblPoblacionDescripcion2);
        lblPoblacionCategoria2=(TextView)view.findViewById(R.id.lblPoblacionCategoria2);
        lblPoblacionCategoriaDes2=(TextView)view.findViewById(R.id.lblPoblacionCategoriaDes2);

        lblPoblacion3=(TextView)view.findViewById(R.id.lblPoblacion3);
        lblPoblacion3.setText(lblPoblacion3.getText()+" "+3);
        lblPoblacionDescripcion3=(TextView)view.findViewById(R.id.lblPoblacionDescripcion3);
        lblPoblacionCategoria3=(TextView)view.findViewById(R.id.lblPoblacionCategoria3);
        lblPoblacionCategoriaDes3=(TextView)view.findViewById(R.id.lblPoblacionCategoriaDes3);

        lblModalidad1=(TextView)view.findViewById(R.id.lblModalidad1);
        lblModalidad1.setText(lblModalidad1.getText()+" "+1);

        lblModalidad2=(TextView)view.findViewById(R.id.lblModalidad2);
        lblModalidad2.setText(lblModalidad2.getText()+" "+2);

        lblModalidad3=(TextView)view.findViewById(R.id.lblModalidad3);
        lblModalidad3.setText(lblModalidad3.getText()+" "+3);

        lblRangoM1T=(TextView)view.findViewById(R.id.lblRangoM1T);
        lblRangoF1T=(TextView)view.findViewById(R.id.lblRangoF1T);
        lblRangoT1T=(TextView)view.findViewById(R.id.lblRangoT1T);

        lblRangoM2T=(TextView)view.findViewById(R.id.lblRangoM2T);
        lblRangoF2T=(TextView)view.findViewById(R.id.lblRangoF2T);
        lblRangoT2T=(TextView)view.findViewById(R.id.lblRangoT2T);

        lblRangoM3T=(TextView)view.findViewById(R.id.lblRangoM3T);
        lblRangoF3T=(TextView)view.findViewById(R.id.lblRangoF3T);
        lblRangoT3T=(TextView)view.findViewById(R.id.lblRangoT3T);
        txtCRecursosHumanos=(EditText)view.findViewById(R.id.txtCRecursosHumanos);

        lblRangoModalidadM1T=(TextView)view.findViewById(R.id.lblRangoModalidadM1T);
        lblRangoModalidadF1T=(TextView)view.findViewById(R.id.lblRangoModalidadF1T);
        lblRangoModalidadT1T=(TextView)view.findViewById(R.id.lblRangoModalidadT1T);

        lblRangoModalidadM2T=(TextView)view.findViewById(R.id.lblRangoModalidadM2T);
        lblRangoModalidadF2T=(TextView)view.findViewById(R.id.lblRangoModalidadF2T);
        lblRangoModalidadT2T=(TextView)view.findViewById(R.id.lblRangoModalidadT2T);

        lblRangoModalidadM3T=(TextView)view.findViewById(R.id.lblRangoModalidadM3T);
        lblRangoModalidadF3T=(TextView)view.findViewById(R.id.lblRangoModalidadF3T);
        lblRangoModalidadT3T=(TextView)view.findViewById(R.id.lblRangoModalidadT3T);

        lblServiciosSeleccion=(TextView)view.findViewById(R.id.lblServiciosSeleccion);
        listLineaActividad = new ArrayList<clsLineaActivdad>();

        listRangos=clsDatosTem.getRangos();
        objPoblacion1 =new clsProblacionObetivo(1,false,clsDatosTem.getRangos());
        objPoblacion2 =new clsProblacionObetivo(2,false,clsDatosTem.getRangos());
        objPoblacion3 =new clsProblacionObetivo(3,false,clsDatosTem.getRangos());

        objModalidad1 =new clsProblacionObetivo(1,true,clsDatosTem.getRangos());
        objModalidad2 =new clsProblacionObetivo(2,true,clsDatosTem.getRangos());
        objModalidad3 =new clsProblacionObetivo(3,true,clsDatosTem.getRangos());
        listActividad=(ListView)view.findViewById(R.id.listActividad);
        listModalidadIngreso=(ListView)view.findViewById(R.id.listModalidadIngreso);
        listPoblacionObjetiva=(ListView)view.findViewById(R.id.listPoblacionObjetiva);
        listZonaInfluencia=(ListView)view.findViewById(R.id.listZonaInfluencia);
        btnLineaActividad=(Button)view.findViewById(R.id.btnLineaActividad);
        btnLineaActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLineaActividad();
            }
        });

        listRecursosHumanos=(ListView)view.findViewById(R.id.listRecursosHumanos);

        btnPoblacion1=(Button)view.findViewById(R.id.btnPoblacion1);
        btnPoblacion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoblacion(1);
            }
        });

        btnPoblacion2=(Button)view.findViewById(R.id.btnPoblacion2);
        btnPoblacion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoblacion(2);
            }
        });

        btnPoblacion3=(Button)view.findViewById(R.id.btnPoblacion3);
        btnPoblacion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoblacion(3);
            }
        });

        btnAceptar=(Button)view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptar();
            }
        });

        btnModalidad1=(Button)view.findViewById(R.id.btnModalidad1);
        btnModalidad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoblacion(4);
            }
        });

        btnModalidad2=(Button)view.findViewById(R.id.btnModalidad2);
        btnModalidad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoblacion(5);
            }
        });

        btnModalidad3=(Button)view.findViewById(R.id.btnModalidad3);
        btnModalidad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoblacion(6);
            }
        });

        btnAgregarServicios=(Button)view.findViewById(R.id.btnAgregarServicios);
        btnAgregarServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAgregarServicios();
            }
        });

        btnAgregarZonaInfluencia=(Button)view.findViewById(R.id.btnAgregarZonaInfluencia);
        btnAgregarZonaInfluencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAgregarZonaInfluencia();
            }
        });

        btnAgregarRecursosHumanos=(Button)view.findViewById(R.id.btnAgregarRecursosHumanos);
        btnAgregarRecursosHumanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAgregarRecursosHumanos();
            }
        });

        getListaLineaActividad();
        getListaPoblacionObejtivo();
        getListaModalidadIngreso();
        getZonaInfluencia();
        getRecursosHumanos();
        return view;
    }

    public void lblInfTecnica()
    {
        if(viewInfTecnica.getVisibility()==View.GONE)
        {
            viewInfTecnica.setVisibility(View.VISIBLE);
            lblInfTecnica.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewInfTecnica.setVisibility(View.GONE);
            lblInfTecnica.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblDResponsable()
    {
        if(viewDResponsable.getVisibility()==View.GONE)
        {
            viewDResponsable.setVisibility(View.VISIBLE);
            lblDResponsable.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewDResponsable.setVisibility(View.GONE);
            lblDResponsable.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblUbiFisica()
    {
        if(viewUbiFisica.getVisibility()==View.GONE)
        {
            viewUbiFisica.setVisibility(View.VISIBLE);
            lblUbiFisica.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewUbiFisica.setVisibility(View.GONE);
            lblUbiFisica.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblZonaInfluencia()
    {
        if(viewZonaInfluencia.getVisibility()==View.GONE)
        {
            viewZonaInfluencia.setVisibility(View.VISIBLE);
            lblZonaInfluencia.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewZonaInfluencia.setVisibility(View.GONE);
            lblZonaInfluencia.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }

    public void lblPoblacionObjetivo() {
        if (viewPoblacionObjetivo.getVisibility() == View.GONE) {
            viewPoblacionObjetivo.setVisibility(View.VISIBLE);
            lblPoblacionObjetivo.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        } else {
            viewPoblacionObjetivo.setVisibility(View.GONE);
            lblPoblacionObjetivo.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblDatos()
    {
        if(viewDatosGenerales.getVisibility()==View.GONE)
        {
            viewDatosGenerales.setVisibility(View.VISIBLE);
            lblDatos.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewDatosGenerales.setVisibility(View.GONE);
            lblDatos.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblModalidadIngreso()
    {
        if(viewModalidadIngreso.getVisibility()==View.GONE)
        {
            viewModalidadIngreso.setVisibility(View.VISIBLE);
            lblModalidadIngreso.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewModalidadIngreso.setVisibility(View.GONE);
            lblModalidadIngreso.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblRecursosHumanos()
    {
        if(viewRecursosHumanos.getVisibility()==View.GONE)
        {
            viewRecursosHumanos.setVisibility(View.VISIBLE);
            lblRecursosHumanos.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewRecursosHumanos.setVisibility(View.GONE);
            lblRecursosHumanos.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }

    public void lblFinacioamento()
    {
        if(viewFinacioamento.getVisibility()==View.GONE)
        {
            viewFinacioamento.setVisibility(View.VISIBLE);
            lblFinacioamento.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewFinacioamento.setVisibility(View.GONE);
            lblFinacioamento.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblServicios()
    {
        if(viewServicios.getVisibility()==View.GONE)
        {
            viewServicios.setVisibility(View.VISIBLE);
            lblServicios.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewServicios.setVisibility(View.GONE);
            lblServicios.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void lblInfraestructura()
    {
        if(viewInfraestructura.getVisibility()==View.GONE)
        {
            viewInfraestructura.setVisibility(View.VISIBLE);
            lblInfraestructura.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewInfraestructura.setVisibility(View.GONE);
            lblInfraestructura.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }

    public void btnPoblacion(int  objeto)
    {
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_poblacion);

        TextView lblPoblacion= (TextView)dialog.findViewById(R.id.lblPoblacion);
        lblPoblacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblPoblacion.getTextSize() + SizeText);


        TextView lblModalidad= (TextView)dialog.findViewById(R.id.lblModalidad);
        lblModalidad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblModalidad.getTextSize() + SizeText);

        View viewPoblacion= (View)dialog.findViewById(R.id.viewPoblacion);
        View viewModalidad= (View)dialog.findViewById(R.id.viewModalidad);

        objTemp=new clsProblacionObetivo();
        final int objFinal=objeto;
        if(objeto==1) {
            objTemp = objPoblacion1;
            lblPoblacion.setText(lblPoblacion1.getText());
        }
        else if(objeto==2) {
            objTemp = objPoblacion2;
            lblPoblacion.setText(lblPoblacion2.getText());
        }
        else if(objeto==3){
            objTemp = objPoblacion3;
            lblPoblacion.setText(lblPoblacion3.getText());
        }
        else if(objeto==4) {
            lblModalidad.setText(lblModalidad1.getText());
            viewPoblacion.setVisibility(View.GONE);
            viewModalidad.setVisibility(View.VISIBLE);
            objTemp = objModalidad1;
        }
        else if(objeto==5) {
            lblModalidad.setText(lblModalidad2.getText());
            viewPoblacion.setVisibility(View.GONE);
            viewModalidad.setVisibility(View.VISIBLE);
            objTemp = objModalidad2;
        }
        else if(objeto==6) {
            lblModalidad.setText(lblModalidad3.getText());
            viewPoblacion.setVisibility(View.GONE);
            viewModalidad.setVisibility(View.VISIBLE);
            objTemp = objModalidad3;
        }




        TextView lblTModalidad= (TextView)dialog.findViewById(R.id.lblTModalidad);
        lblTModalidad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTModalidad.getTextSize() + SizeText);



        TextView lblDescripcion= (TextView)dialog.findViewById(R.id.lblDescripcion);
        lblDescripcion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDescripcion.getTextSize() + SizeText);

        TextView lblRangoEdad= (TextView)dialog.findViewById(R.id.lblRangoEdad);
        lblRangoEdad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoEdad.getTextSize() + SizeText);

        TextView lblRangoM= (TextView)dialog.findViewById(R.id.lblRangoM);
        lblRangoM.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM.getTextSize() + SizeText);

        TextView lblRangoF= (TextView)dialog.findViewById(R.id.lblRangoF);
        lblRangoF.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF.getTextSize() + SizeText);

        ListView listPoblacion= (ListView)dialog.findViewById(R.id.listPoblacion);
        adaptadorRangos = new AdaptadorRangos(this.getActivity());
        listPoblacion.setAdapter(adaptadorRangos);
        clsUtilidades.setListViewHeightBasedOnChildren(listPoblacion);


        final EditText txtPoblacion= (EditText)dialog.findViewById(R.id.txtPoblacion);
        txtPoblacion.setText(objTemp.getDescripcion());
        txtPoblacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtPoblacion.getTextSize() + SizeText);

        final EditText txtPoblacionCategoria= (EditText)dialog.findViewById(R.id.txtPoblacionCategoria);
        txtPoblacionCategoria.setText(objTemp.getCodigo_descricion());
        txtPoblacionCategoria.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtPoblacionCategoria.getTextSize() + SizeText);

        final EditText txtPoblacionCategoriaDes= (EditText)dialog.findViewById(R.id.txtPoblacionCategoriaDes);
        txtPoblacionCategoriaDes.setText(objTemp.getCodigo());
        txtPoblacionCategoriaDes.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtPoblacionCategoriaDes.getTextSize() + SizeText);

        Button btn_aceptar = (Button) dialog.findViewById(R.id.btnAceptar);
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objTemp.setDescripcion(txtPoblacion.getText().toString());
                objTemp.setCodigo_descricion(txtPoblacionCategoria.getText().toString());
                objTemp.setCodigo(txtPoblacionCategoriaDes.getText().toString());
                if(objFinal==1) {
                    lblPoblacionDescripcion1.setText(objTemp.getDescripcion());
                    lblPoblacionCategoria1.setText(objTemp.getCodigo_descricion());
                    lblPoblacionCategoriaDes1.setText(objTemp.getCodigo());
                    objPoblacion1 = objTemp;
                    getListaPoblacionObejtivo();
                }
                else if(objFinal==2) {
                    objPoblacion2 = objTemp;
                    lblPoblacionDescripcion2.setText(objTemp.getDescripcion());
                    lblPoblacionCategoria2.setText(objTemp.getCodigo_descricion());
                    lblPoblacionCategoriaDes2.setText(objTemp.getCodigo());
                    getListaPoblacionObejtivo();
                }
                else if(objFinal==3) {
                    objPoblacion3 = objTemp;
                    lblPoblacionDescripcion3.setText(objTemp.getDescripcion());
                    lblPoblacionCategoria3.setText(objTemp.getCodigo_descricion());
                    lblPoblacionCategoriaDes3.setText(objTemp.getCodigo());
                    getListaPoblacionObejtivo();
                }
                else if(objFinal==4) {
                    objModalidad1 = objTemp;
                    getListaModalidadIngreso();
                }
                else if(objFinal==5) {
                    objModalidad2 = objTemp;
                    getListaModalidadIngreso();
                }
                else if(objFinal==6) {
                    objModalidad3 = objTemp;
                    getListaModalidadIngreso();
                }


                dialog.dismiss();
            }
        });
        dialog.show();



       // adaptadorRangos
    }
    public void btnLineaActividad(){
            final Dialog dialog = new Dialog(this.getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            //dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog_actividad);


            TextView lblInfTecnica= (TextView)dialog.findViewById(R.id.lblInfTecnica);
            lblInfTecnica.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblInfTecnica.getTextSize() + SizeText);

            TextView lblDescripcion= (TextView)dialog.findViewById(R.id.lblDescripcion);
            lblDescripcion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDescripcion.getTextSize() + SizeText);

            TextView lblCodigo= (TextView)dialog.findViewById(R.id.lblCodigo);
            lblCodigo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblCodigo.getTextSize()+SizeText);


            final EditText txtDescripcion = (EditText)dialog.findViewById(R.id.txtDescripcion);
            txtDescripcion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtDescripcion.getTextSize()+SizeText);
            txtDescripcion.setText("");

            final EditText txtCodigo = (EditText)dialog.findViewById(R.id.txtCodigo);
            txtCodigo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtCodigo.getTextSize()+SizeText);
            txtCodigo.setText("");

            Button btnAgregar = (Button) dialog.findViewById(R.id.btnAgregar);
            btnAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clsLineaActivdad objLineaActivdad = new clsLineaActivdad();
                    objLineaActivdad.setDescripcion(txtDescripcion.getText().toString());
                    objLineaActivdad.setCodigo(txtCodigo.getText().toString());
                    listLineaActividad.add(objLineaActivdad);
                    getListaLineaActividad();
                    dialog.dismiss();
                }
            });
            dialog.show();
    }



    class AdaptadorLineaActividad extends ArrayAdapter {

        Activity context;
        AdaptadorLineaActividad(Activity context) {
            super(context, R.layout.list_linea_actividad, listLineaActividad);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_linea_actividad, null);

            TextView lblLActividadContador= (TextView)item.findViewById(R.id.lblLActividadContador);
            lblLActividadContador.setText(""+(position+1));
            lblLActividadContador.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblLActividadContador.getTextSize()+SizeText);

            TextView lblActividadDescripcion= (TextView)item.findViewById(R.id.lblActividadDescripcion);
            lblActividadDescripcion.setText(listLineaActividad.get(position).getDescripcion());
            lblActividadDescripcion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblActividadDescripcion.getTextSize()+SizeText);

            TextView lblActividadCodigo= (TextView)item.findViewById(R.id.lblActividadCodigo);
            lblActividadCodigo.setText(listLineaActividad.get(position).getCodigo());
            lblActividadCodigo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblActividadCodigo.getTextSize()+SizeText);

            Button btnActividadEliminar = (Button)item.findViewById(R.id.btnActividadEliminar);
            btnActividadEliminar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnActividadEliminar.getTextSize()+SizeText);
            btnActividadEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnActividadEliminar(pos);
                }
            });
            return(item);
        }
    }


    protected void getListaLineaActividad()
    {
        adaptadorLineaActividad = new AdaptadorLineaActividad(this.getActivity());
        listActividad.setAdapter(adaptadorLineaActividad);
        clsUtilidades.setListViewHeightBasedOnChildren(listActividad);
    }


    public void btnActividadEliminar(int pos)
    {
        final int position=pos;
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.eliminar_dialog));
        alert.setPositiveButton(getString(R.string.btn_aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                listLineaActividad.remove(position);getListaLineaActividad();

            }
        });
        alert.setNegativeButton(getString(R.string.btn_cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }


    class AdaptadorPoblacionObejtivo extends ArrayAdapter {

        Activity context;
        AdaptadorPoblacionObejtivo(Activity context) {
            super(context, R.layout.list_poblacion_objetivo, listRangos);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_poblacion_objetivo, null);



            TextView lblRangoEdad= (TextView)item.findViewById(R.id.lblRangoEdad);
            if((listRangos.size()-1)==position)
                lblRangoEdad.setText(nuevoRango);
            else
                lblRangoEdad.setText(listRangos.get(position).getRango());
            lblRangoEdad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoEdad.getTextSize() + SizeText);

            TextView lblRangoM1= (TextView)item.findViewById(R.id.lblRangoM1);
            lblRangoM1.setText(""+objPoblacion1.getList().get(position).getRangoM());
            lblRangoM1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM1.getTextSize() + SizeText);

            TextView lblRangoF1= (TextView)item.findViewById(R.id.lblRangoF1);
            lblRangoF1.setText("" + objPoblacion1.getList().get(position).getRangoF());
            lblRangoF1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF1.getTextSize() + SizeText);

            int total=objPoblacion1.getList().get(position).getRangoM()+objPoblacion1.getList().get(position).getRangoF();
            contT1+=total;
            contM1+=objPoblacion1.getList().get(position).getRangoM();
            contF1+=objPoblacion1.getList().get(position).getRangoF();
            TextView lblRangoT1= (TextView)item.findViewById(R.id.lblRangoT1);
            lblRangoT1.setText(""+total);
            lblRangoT1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoT1.getTextSize() + SizeText);


            TextView lblRangoM2= (TextView)item.findViewById(R.id.lblRangoM2);
            lblRangoM2.setText("" + objPoblacion2.getList().get(position).getRangoM());
            lblRangoM2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM2.getTextSize() + SizeText);

            TextView lblRangoF2= (TextView)item.findViewById(R.id.lblRangoF2);
            lblRangoF2.setText(""+objPoblacion2.getList().get(position).getRangoF());
            lblRangoF2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF2.getTextSize() + SizeText);

            total=objPoblacion2.getList().get(position).getRangoM()+objPoblacion2.getList().get(position).getRangoF();
            contT2+=total;
            contM2+=objPoblacion2.getList().get(position).getRangoM();
            contF2+=objPoblacion2.getList().get(position).getRangoF();
            TextView lblRangoT2= (TextView)item.findViewById(R.id.lblRangoT2);
            lblRangoT2.setText(""+total);
            lblRangoT2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoT2.getTextSize() + SizeText);


            TextView lblRangoM3= (TextView)item.findViewById(R.id.lblRangoM3);
            lblRangoM3.setText(""+objPoblacion3.getList().get(position).getRangoM());
            lblRangoM3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM3.getTextSize() + SizeText);

            TextView lblRangoF3= (TextView)item.findViewById(R.id.lblRangoF3);
            lblRangoF3.setText("" + objPoblacion3.getList().get(position).getRangoF());
            lblRangoF3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF3.getTextSize() + SizeText);

            total=objPoblacion3.getList().get(position).getRangoM()+objPoblacion3.getList().get(position).getRangoF();
            contT3+=total;
            contM3+=objPoblacion3.getList().get(position).getRangoM();
            contF3+=objPoblacion3.getList().get(position).getRangoF();



            TextView lblRangoT3= (TextView)item.findViewById(R.id.lblRangoT3);
            lblRangoT3.setText(""+total);
            lblRangoT3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoT3.getTextSize() + SizeText);

            return(item);
        }

        
    }

    class AdaptadorModalidadIngreso extends ArrayAdapter {

        Activity context;
        AdaptadorModalidadIngreso(Activity context) {
            super(context, R.layout.list_poblacion_objetivo, listRangos);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_poblacion_objetivo, null);



            TextView lblRangoEdad= (TextView)item.findViewById(R.id.lblRangoEdad);
            if((listRangos.size()-1)==position)
                lblRangoEdad.setText(nuevoRango);
            else
                lblRangoEdad.setText(listRangos.get(position).getRango());
            lblRangoEdad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoEdad.getTextSize() + SizeText);

            TextView lblRangoM1= (TextView)item.findViewById(R.id.lblRangoM1);
            lblRangoM1.setText(""+objModalidad1.getList().get(position).getRangoM());
            lblRangoM1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM1.getTextSize() + SizeText);

            TextView lblRangoF1= (TextView)item.findViewById(R.id.lblRangoF1);
            lblRangoF1.setText("" + objModalidad1.getList().get(position).getRangoF());
            lblRangoF1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF1.getTextSize() + SizeText);

            int total=objModalidad1.getList().get(position).getRangoM()+objModalidad1.getList().get(position).getRangoF();
            contT1+=total;
            contM1+=objModalidad1.getList().get(position).getRangoM();
            contF1+=objModalidad1.getList().get(position).getRangoF();
            TextView lblRangoT1= (TextView)item.findViewById(R.id.lblRangoT1);
            lblRangoT1.setText(""+total);
            lblRangoT1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoT1.getTextSize() + SizeText);


            TextView lblRangoM2= (TextView)item.findViewById(R.id.lblRangoM2);
            lblRangoM2.setText("" + objModalidad2.getList().get(position).getRangoM());
            lblRangoM2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM2.getTextSize() + SizeText);

            TextView lblRangoF2= (TextView)item.findViewById(R.id.lblRangoF2);
            lblRangoF2.setText("" + objModalidad2.getList().get(position).getRangoF());
            lblRangoF2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF2.getTextSize() + SizeText);

            total=objModalidad2.getList().get(position).getRangoM()+objModalidad2.getList().get(position).getRangoF();
            contT2+=total;
            contM2+=objModalidad2.getList().get(position).getRangoM();
            contF2+=objModalidad2.getList().get(position).getRangoF();
            TextView lblRangoT2= (TextView)item.findViewById(R.id.lblRangoT2);
            lblRangoT2.setText(""+total);
            lblRangoT2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoT2.getTextSize() + SizeText);


            TextView lblRangoM3= (TextView)item.findViewById(R.id.lblRangoM3);
            lblRangoM3.setText(""+objModalidad3.getList().get(position).getRangoM());
            lblRangoM3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoM3.getTextSize() + SizeText);

            TextView lblRangoF3= (TextView)item.findViewById(R.id.lblRangoF3);
            lblRangoF3.setText("" + objModalidad3.getList().get(position).getRangoF());
            lblRangoF3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoF3.getTextSize() + SizeText);

            total=objModalidad3.getList().get(position).getRangoM()+objModalidad3.getList().get(position).getRangoF();
            contT3+=total;
            contM3+=objPoblacion3.getList().get(position).getRangoM();
            contF3+=objPoblacion3.getList().get(position).getRangoF();



            TextView lblRangoT3= (TextView)item.findViewById(R.id.lblRangoT3);
            lblRangoT3.setText(""+total);
            lblRangoT3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoT3.getTextSize() + SizeText);

            return(item);
        }


    }


    public void getListaModalidadIngreso()
    {

        contT1=0;
        contM1=0;
        contF1=0;
        contT2=0;
        contM2=0;
        contF2=0;
        contT3=0;
        contM3=0;
        contF3=0;

        adaptadorModalidadIngreso = new AdaptadorModalidadIngreso(this.getActivity());
        listModalidadIngreso.setAdapter(adaptadorModalidadIngreso);
        clsUtilidades.setListViewHeightBasedOnChildren(listModalidadIngreso);

        lblRangoModalidadM1T.setText("" + contM1);
        lblRangoModalidadF1T.setText("" + contF1);
        lblRangoModalidadT1T.setText("" + contT1);

        lblRangoModalidadM2T.setText("" + contM2);
        lblRangoModalidadF2T.setText("" + contF2);
        lblRangoModalidadT2T.setText("" + contT2);

        lblRangoModalidadM3T.setText("" + contM3);
        lblRangoModalidadF3T.setText("" + contF3);
        lblRangoModalidadT3T.setText("" + contT3);

    }


    public void getListaPoblacionObejtivo()
    {
        contT1=0;
        contM1=0;
        contF1=0;
        contT2=0;
        contM2=0;
        contF2=0;
        contT3=0;
        contM3=0;
        contF3=0;

        adaptadorPoblacionObejtivo = new AdaptadorPoblacionObejtivo(this.getActivity());
        listPoblacionObjetiva.setAdapter(adaptadorPoblacionObejtivo);
        clsUtilidades.setListViewHeightBasedOnChildren(listPoblacionObjetiva);

        lblRangoM1T.setText("" + contM1);
        lblRangoF1T.setText("" + contF1);
        lblRangoT1T.setText("" + contT1);

        lblRangoM2T.setText("" + contM2);
        lblRangoF2T.setText("" + contF2);
        lblRangoT2T.setText("" + contT2);

        lblRangoM3T.setText("" + contM3);
        lblRangoF3T.setText("" + contF3);
        lblRangoT3T.setText("" + contT3);
    }



    class AdaptadorRangos extends ArrayAdapter {

        Activity context;
        AdaptadorRangos(Activity context) {
            super(context, R.layout.list_poblacion, listRangos);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_poblacion, null);

            final EditText txtRangoEdad = (EditText) item.findViewById(R.id.txtRangoEdad);
            TextView lblRangoEdad = (TextView) item.findViewById(R.id.lblRangoEdad);

            if((listRangos.size()-1)==position) {
                lblRangoEdad.setVisibility(View.GONE);

                txtRangoEdad.setVisibility(View.VISIBLE);
                txtRangoEdad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtRangoEdad.getTextSize() + SizeText);
                txtRangoEdad.setText(nuevoRango);
                txtRangoEdad.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        nuevoRango=txtRangoEdad.getText().toString();
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
            }
            else {
                lblRangoEdad.setText(listRangos.get(position).getRango());
                lblRangoEdad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRangoEdad.getTextSize() + SizeText);
            }

            final EditText txtRangoM = (EditText) item.findViewById(R.id.txtRangoM);
            if(objTemp.getList().get(position).getRangoM()>0)
                txtRangoM.setText(""+objTemp.getList().get(position).getRangoM());
            else
                txtRangoM.setText("");
            txtRangoM.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtRangoM.getTextSize() + SizeText);
            txtRangoM.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!txtRangoM.getText().toString().equals(""))
                    objTemp.getList().get(pos).setRangoM(Integer.parseInt(txtRangoM.getText().toString()));
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            final EditText txtRangoF = (EditText) item.findViewById(R.id.txtRangoF);
            if(objTemp.getList().get(position).getRangoF()>0)
                txtRangoF.setText(""+objTemp.getList().get(position).getRangoF());
            else
                txtRangoF.setText("");
            txtRangoF.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtRangoF.getTextSize() + SizeText);
            txtRangoF.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!txtRangoF.getText().toString().equals(""))
                        objTemp.getList().get(pos).setRangoF(Integer.parseInt(txtRangoF.getText().toString()));
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            return(item);
        }


    }

    public void ComboRecursosHumanos(){
        List<clsProfesion> lista= clsDatosTem.getProfesion();
        lista.add(0, new clsProfesion("00", getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsProfesion> adapter = new ArrayAdapter<clsProfesion>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboRecursosHumanos.setAdapter(adapter);

        ComboRecursosHumanos.setSelection(0);
    }

    public void ComboDepartamento(){
        List<clsDepartamento> lista= clsUbigeo.getListDepartamento();
        lista.add(0,new clsDepartamento(0,getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsDepartamento> adapter = new ArrayAdapter<clsDepartamento>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboDepartamento.setAdapter(adapter);
        ComboDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ComboProvincia(((clsDepartamento)ComboDepartamento.getSelectedItem()).getPk_id());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDepartamento.setSelection(0);
    }

    public void ComboProvincia(int idDepartamento){
        List<clsProvincia> lista=clsUbigeo.getListProvinciaXDepartamento(idDepartamento);

        lista.add(0,new clsProvincia(0,getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsProvincia> adapter = new ArrayAdapter<clsProvincia>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboProvincia.setAdapter(adapter);
        ComboProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ComboDistrito(((clsProvincia) ComboProvincia.getSelectedItem()).getPk_id());;
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboProvincia.setSelection(0);
    }

    public void ComboDistrito(int idProvincia){
        List<clsDistrito> lista=clsUbigeo.getListDistritoXProvincia(idProvincia);

        lista.add(0,new clsDistrito(0,getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsDistrito> adapter = new ArrayAdapter<clsDistrito>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboDistrito.setAdapter(adapter);
        ComboDistrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(RegistroActivity.this,((clsDistrito)ComboDistrito.getSelectedItem()).getStr_nombre(), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDistrito.setSelection(0);
    }


    public void ComboDepartamentoZona(){
        List<clsDepartamento> lista= clsUbigeo.getListDepartamento();
        lista.add(0,new clsDepartamento(0,getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsDepartamento> adapter = new ArrayAdapter<clsDepartamento>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboDepartamentoZona.setAdapter(adapter);
        ComboDepartamentoZona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ComboProvinciaZona(((clsDepartamento) ComboDepartamentoZona.getSelectedItem()).getPk_id());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDepartamentoZona.setSelection(0);
    }

    public void ComboProvinciaZona(int idDepartamento){
        List<clsProvincia> lista=clsUbigeo.getListProvinciaXDepartamento(idDepartamento);

        lista.add(0,new clsProvincia(0,getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsProvincia> adapter = new ArrayAdapter<clsProvincia>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboProvinciaZona.setAdapter(adapter);
        ComboProvinciaZona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ComboDistritoZona(((clsProvincia) ComboProvinciaZona.getSelectedItem()).getPk_id());;
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboProvinciaZona.setSelection(0);
    }

    public void ComboDistritoZona(int idProvincia){
        List<clsDistrito> lista=clsUbigeo.getListDistritoXProvincia(idProvincia);

        lista.add(0,new clsDistrito(0,getString(R.string.spinner_seleccione)));

        ArrayAdapter<clsDistrito> adapter = new ArrayAdapter<clsDistrito>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(R.layout.spinner_list);
        ComboDistritoZona.setAdapter(adapter);
        ComboDistritoZona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                clsDistrito entidad=((clsDistrito)ComboDistritoZona.getSelectedItem());
                if(entidad.getPk_id()>0) {
                    objDistritoZona=clsUbigeo.getDistrito(entidad.getPk_id());
                    ComboDistritoZona.setSelection(0);
                }
                // Toast.makeText(RegistroActivity.this,.getStr_nombre(), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboDistritoZona.setSelection(0);
    }


    class AdaptadorZonaInfluencia extends ArrayAdapter {

        Activity context;
        AdaptadorZonaInfluencia(Activity context) {
            super(context, R.layout.list_zona_influencia, listZona);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_zona_influencia, null);

            TextView lblContador= (TextView)item.findViewById(R.id.lblContador);
            lblContador.setText(""+(position+1));
            lblContador.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblContador.getTextSize()+SizeText);

            TextView lblDeparamento= (TextView)item.findViewById(R.id.lblDeparamento);
            lblDeparamento.setText(listZona.get(position).getObjProvincia().getObjDepartamento().getNombre());
            lblDeparamento.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDeparamento.getTextSize()+SizeText);

            TextView lblDistrito= (TextView)item.findViewById(R.id.lblDistrito);
            lblDistrito.setText(listZona.get(position).getObjProvincia().getNombre());
            lblDistrito.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDistrito.getTextSize()+SizeText);

            TextView lblProvincia= (TextView)item.findViewById(R.id.lblProvincia);
            lblProvincia.setText(listZona.get(position).getNombre());
            lblProvincia.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblProvincia.getTextSize()+SizeText);


            Button btnEliminar = (Button)item.findViewById(R.id.btnEliminar);
            btnEliminar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnEliminar.getTextSize()+SizeText);
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnZonaEliminar(pos);
                }
            });
            return(item);
        }
    }

    public void btnZonaEliminar(int pos)
    {
        final int position=pos;
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.eliminar_dialog));
        alert.setPositiveButton(getString(R.string.btn_aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                listZona.remove(position);
                getZonaInfluencia();

            }
        });
        alert.setNegativeButton(getString(R.string.btn_cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }


    public void getZonaInfluencia()
    {
        adaptadorZonaInfluencia = new AdaptadorZonaInfluencia(this.getActivity());
        listZonaInfluencia.setAdapter(adaptadorZonaInfluencia);
        clsUtilidades.setListViewHeightBasedOnChildren(listZonaInfluencia);

    }
    public void btnAgregarZonaInfluencia(){
        if(objDistritoZona!=null)
        {
            listZona.add(objDistritoZona);
            objDistritoZona=null;
            getZonaInfluencia();
        }
    }

    public void btnAgregarServicios()
    {
        final CharSequence[] items = new String[listServicios.size()];;
        for(int i=0;i<listServicios.size();i++)
        {
            items[i]=listServicios.get(i).getNombre();
        }


        AlertDialog.Builder builder=new AlertDialog.Builder(this.getActivity());
        builder.setTitle(getString(R.string.servicios_ficha));
        builder.setPositiveButton(R.string.btn_aceptar, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                lblServiciosSeleccion.setText("");
                List<String> lista= new ArrayList<String>();
                for(int i=0;i< booleanSelectArrayServicios.length;i++)
                {
                    if(booleanSelectArrayServicios[i])
                        lista.add(listServicios.get(i).getNombre());
                }
                for(int i=0; i<lista.size();i++)
                {
                    if(i==(lista.size()-1))
                        lblServiciosSeleccion.setText(lblServiciosSeleccion.getText()+lista.get(i));
                    else
                        lblServiciosSeleccion.setText(lblServiciosSeleccion.getText()+lista.get(i)+" - ");
                }

            }
        });

//setMultiChoiceItems will allow use to select multiple items from list by clicking on checkbox
        builder.setMultiChoiceItems(items, booleanSelectArrayServicios, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.show();


    }
    class AdaptadorRecursosHumanos extends ArrayAdapter {

        Activity context;
        AdaptadorRecursosHumanos(Activity context) {
            super(context, R.layout.list_recursos_humanos, listRecrusosHumanos);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_recursos_humanos, null);

            TextView lblNRHContador= (TextView)item.findViewById(R.id.lblNRHContador);
            lblNRHContador.setText(""+(position+1));
            lblNRHContador.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNRHContador.getTextSize()+SizeText);

            TextView lblNombre= (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(listRecrusosHumanos.get(position).getDescripcion());
            lblNombre.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNombre.getTextSize()+SizeText);

            TextView lblCantidad= (TextView)item.findViewById(R.id.lblCantidad);
            lblCantidad.setText(""+listRecrusosHumanos.get(position).getTotal());
            lblCantidad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblCantidad.getTextSize()+SizeText);


            Button btnEliminar = (Button)item.findViewById(R.id.btnEliminar);
            btnEliminar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnEliminar.getTextSize()+SizeText);
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnRecursosHumanosEliminar(pos);
                }
            });
            return(item);
        }
    }
    public void btnAgregarRecursosHumanos() {
        if(ComboRecursosHumanos.getSelectedItemPosition()>0) {

            clsProfesion entidad = (clsProfesion) ComboRecursosHumanos.getSelectedItem();
            if(!txtCRecursosHumanos.getText().toString().equals("")) {
                entidad.setTotal(Integer.parseInt(txtCRecursosHumanos.getText().toString()));
                listRecrusosHumanos.add(entidad);
                getRecursosHumanos();
                txtCRecursosHumanos.setText("");
                ComboRecursosHumanos.setSelection(0);
            }
        }
    }

    public void getRecursosHumanos()
    {
        adaptadorRecursosHumanos = new AdaptadorRecursosHumanos(this.getActivity());
        listRecursosHumanos.setAdapter(adaptadorRecursosHumanos);
        clsUtilidades.setListViewHeightBasedOnChildren(listRecursosHumanos);

    }

    public void btnRecursosHumanosEliminar(int pos)
    {
        final int position=pos;
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.eliminar_dialog));
        alert.setPositiveButton(getString(R.string.btn_aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                listRecrusosHumanos.remove(position);
                getRecursosHumanos();

            }
        });
        alert.setNegativeButton(getString(R.string.btn_cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }

    public void btnAceptar(){
        ((MainActivity)getActivity()).setFragment(new InicioFragment());
    }
}
