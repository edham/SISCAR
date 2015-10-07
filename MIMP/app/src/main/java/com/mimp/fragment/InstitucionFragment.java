package com.mimp.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import static android.content.Context.LOCATION_SERVICE;

import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mimp.activity.MainActivity;
import com.mimp.activity.R;
import com.mimp.entidades.clsDepartamento;
import com.mimp.entidades.clsDistrito;
import com.mimp.entidades.clsEntidadGenerica;
import com.mimp.entidades.clsProgramas;
import com.mimp.entidades.clsProvincia;
import com.mimp.fragment.institucion.InscripccionSlide;
import com.mimp.utilidades.clsUbigeo;
import com.mimp.utilidades.clsUtilidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InstitucionFragment extends Fragment {

    private List<clsProgramas> listaProgramas;
    private AdaptadorProgramas adaptadorProgramas;
    private ListView listProgramas;
    private double latitude=0d;
    private double longitude=0d;
    private Spinner ComboCategoria;
    private Spinner ComboCargo;
    private Spinner ComboDepartamento;
    private Spinner ComboProvincia;
    private Spinner ComboDistrito;
    private Spinner ComboTipoLocal;
    private Calendar calendarCreacion;
    private Calendar calendarMaxCreacion;
    private int mYearCreacion;
    private int mMonthCreacion;
    private int mDayCreacion;
    private Calendar calendarSolicitud;
    private Calendar calendarMaxSolicitud;
    private int mYearSolicitud;
    private int mMonthSolicitud;
    private int mDaySolicitud;
    public int SizeText=1;
    private TextView lblTitulo;
    private TextView lblDatos;
    private View viewDatos;
    private TextView lblNIndetificacion;
    private EditText txtNIndetificacion;
    private TextView lblFecSolicitud;
    private TextView lblFecCreacion;
    private TextView lblTFechaSolicitud;
    private TextView lblNInstitucion;
    private EditText txtNInstitucion;
    private EditText txtObejtivo;
    private TextView lblNIdentificacion;
    private EditText txtNIdentificacion;
    private TextView lblTFechaCreacion;
    private TextView lblCatInstitucion;
    private TextView lblNruc;
    private EditText txtNruc;
    private TextView lblDResponsable;
    private View viewDResponsable;
    private TextView lblAPaterno;
    private EditText txtAPaterno;
    private TextView lblAMaterno;
    private EditText txtAMaterno;
    private TextView lblNombres;
    private EditText txtNombres;
    private TextView lblCargo;
    private TextView lblTRTelefono;
    private EditText txtRTelefono;
    private TextView lblInfTecnica;
    private View viewInfTecnica;
    private TextView  lblDirSede;
    private EditText txtDirSede;
    private TextView  lblUbigeo;
    private TextView lblTITTelefono;
    private EditText txtTITTelefono;
    private TextView lblFax;
    private EditText txtFax;
    private TextView lblWeb;
    private EditText txtWeb;
    private TextView lblEmail;
    private EditText txtEmail;
    private TextView lblHAtencion;
    private EditText txtHAtencion;
    private TextView lblLocal;
    private TextView lblUbiFisica;
    private View viewUbiFisica;
    private TextView lblObejtivo;
    private TextView lblPEjecutados;
    private TextView lblTDuracion;
    private TextView lblIResponsable;
    private Button btnAgregar;
    private TextView lblFinacioamento;
    private View viewFinacioamento;
    private TextView lblRubros;
    private TextView lblValor;
    private TextView lblFuente;
    private TextView lblOperativo;
    private TextView lblProgramas;
    private TextView lblInversion;
    private EditText txtValor1;
    private EditText txtValor2;
    private EditText txtValor3;
    private EditText txtFuente1;
    private EditText txtFuente2;
    private EditText txtFuente3;
    private TextView lblTotal;
    private TextView lblTotalValor;
    private TextView lblPNumeracion;

    private TextView lblObservaciones;
    private View viewObservaciones;
    private EditText txtObservaciones;
    private Button btnAceptar;
    private Button btnUbicar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_institucion, container, false);

        lblTitulo = (TextView)view.findViewById(R.id.lblTitulo);
        viewDatos = (View)view.findViewById(R.id.viewDatos);
        lblDatos = (TextView)view.findViewById(R.id.lblDatos);
        lblDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDatos();
            }
        });

        lblNIndetificacion = (TextView)view.findViewById(R.id.lblNIndetificacion);
        txtNIndetificacion = (EditText)view.findViewById(R.id.txtNIndetificacion);
        lblTFechaSolicitud = (TextView)view.findViewById(R.id.lblTFechaSolicitud);

         lblNInstitucion = (TextView)view.findViewById(R.id.lblNInstitucion);
         txtNInstitucion = (EditText)view.findViewById(R.id.txtNInstitucion);
         lblNIdentificacion = (TextView)view.findViewById(R.id.lblNIdentificacion);
         txtNIdentificacion = (EditText)view.findViewById(R.id.txtNIdentificacion);
         lblTFechaCreacion = (TextView)view.findViewById(R.id.lblTFechaCreacion);
         lblCatInstitucion = (TextView)view.findViewById(R.id.lblCatInstitucion);
         lblNruc = (TextView)view.findViewById(R.id.lblNruc);
         txtNruc = (EditText)view.findViewById(R.id.txtNruc);
         viewDResponsable = (View)view.findViewById(R.id.viewDResponsable);
         lblDResponsable = (TextView)view.findViewById(R.id.lblDResponsable);
         lblDResponsable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblDResponsable();
            }
         });

         lblAPaterno = (TextView)view.findViewById(R.id.lblAPaterno);
         txtAPaterno = (EditText)view.findViewById(R.id.txtAPaterno);
         lblAMaterno = (TextView)view.findViewById(R.id.lblAMaterno);
         txtAMaterno = (EditText)view.findViewById(R.id.txtAMaterno);
         lblNombres = (TextView)view.findViewById(R.id.lblNombres);
         txtNombres = (EditText)view.findViewById(R.id.txtNombres);
         lblCargo = (TextView)view.findViewById(R.id.lblCargo);
         lblTRTelefono = (TextView)view.findViewById(R.id.lblTRTelefono);
         txtRTelefono = (EditText)view.findViewById(R.id.txtRTelefono);

        viewInfTecnica = (View)view.findViewById(R.id.viewInfTecnica);
         lblInfTecnica = (TextView)view.findViewById(R.id.lblInfTecnica);
        lblInfTecnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblInfTecnica();
            }
        });

        lblDirSede = (TextView)view.findViewById(R.id.lblDirSede);
         txtDirSede = (EditText)view.findViewById(R.id.txtDirSede);
          lblUbigeo = (TextView)view.findViewById(R.id.lblUbigeo);
         lblTITTelefono = (TextView)view.findViewById(R.id.lblTITTelefono);
         txtTITTelefono = (EditText)view.findViewById(R.id.txtTITTelefono);
         lblFax = (TextView)view.findViewById(R.id.lblFax);
        txtFax = (EditText)view.findViewById(R.id.txtFax);
         lblWeb = (TextView)view.findViewById(R.id.lblWeb);
         txtWeb = (EditText)view.findViewById(R.id.txtWeb);
         lblEmail = (TextView)view.findViewById(R.id.lblEmail);
         txtEmail = (EditText)view.findViewById(R.id.txtEmail);
         lblHAtencion = (TextView)view.findViewById(R.id.lblHAtencion);
         txtHAtencion = (EditText)view.findViewById(R.id.txtHAtencion);
         lblLocal = (TextView)view.findViewById(R.id.lblLocal);
        lblPNumeracion = (TextView)view.findViewById(R.id.lblPNumeracion);
         viewUbiFisica= (View)view.findViewById(R.id.viewUbiFisica);
         lblUbiFisica = (TextView)view.findViewById(R.id.lblUbiFisica);
         lblUbiFisica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lblUbiFisica();
                }
            });

         lblObejtivo = (TextView)view.findViewById(R.id.lblObejtivo);
         lblPEjecutados = (TextView)view.findViewById(R.id.lblPEjecutados);
         lblTDuracion = (TextView)view.findViewById(R.id.lblTDuracion);
         lblIResponsable = (TextView)view.findViewById(R.id.lblIResponsable);
         btnAgregar = (Button)view.findViewById(R.id.btnAgregar);
         btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAgregar();
            }
        });

        viewFinacioamento = (View)view.findViewById(R.id.viewFinacioamento);
         lblFinacioamento = (TextView)view.findViewById(R.id.lblFinacioamento);
         lblFinacioamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFinacioamento();
            }
        });

         lblRubros = (TextView)view.findViewById(R.id.lblRubros);
         lblValor = (TextView)view.findViewById(R.id.lblValor);
         lblFuente = (TextView)view.findViewById(R.id.lblFuente);
         lblOperativo = (TextView)view.findViewById(R.id.lblOperativo);
         lblProgramas = (TextView)view.findViewById(R.id.lblProgramas);
         lblInversion = (TextView)view.findViewById(R.id.lblInversion);
         txtValor1 = (EditText)view.findViewById(R.id.txtValor1);
         txtValor2 = (EditText)view.findViewById(R.id.txtValor2);
         txtValor3 = (EditText)view.findViewById(R.id.txtValor3);
         txtFuente1 = (EditText)view.findViewById(R.id.txtFuente1);
         txtFuente2 = (EditText)view.findViewById(R.id.txtFuente2);
         txtFuente3 = (EditText)view.findViewById(R.id.txtFuente3);
         lblTotal = (TextView)view.findViewById(R.id.lblTotal);
         lblTotalValor = (TextView)view.findViewById(R.id.lblTotalValor);

         viewObservaciones = (View)view.findViewById(R.id.viewObservaciones);
         lblObservaciones = (TextView)view.findViewById(R.id.lblObservaciones);
        lblObservaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblObservaciones();
            }
        });

        txtObservaciones = (EditText)view.findViewById(R.id.txtObservaciones);
         btnAceptar = (Button)view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAceptar();
            }
        });
        txtObejtivo = (EditText)view.findViewById(R.id.txtObejtivo);


        btnUbicar = (Button) view.findViewById(R.id.btnUbicar);
        btnUbicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnUbicar();
            }
        });

        listProgramas = (ListView)view.findViewById(R.id.listProgramas);


        ComboCategoria = (Spinner)view.findViewById(R.id.ComboCategoria);
        ComboCategoria();
        ComboCargo = (Spinner)view.findViewById(R.id.ComboCargo);
        ComboCargo();
        ComboDepartamento = (Spinner)view.findViewById(R.id.ComboDepartamento);
        ComboDepartamento();
        ComboProvincia = (Spinner)view.findViewById(R.id.ComboProvincia);
        ComboDistrito = (Spinner)view.findViewById(R.id.ComboDistrito);
        ComboTipoLocal = (Spinner)view.findViewById(R.id.ComboTipoLocal);
        ComboTipoLocal();



        lblFecSolicitud = (TextView)view.findViewById(R.id.lblFecSolicitud);
        lblFecSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFecSolicitud();
            }
        });
        lblFecCreacion = (TextView)view.findViewById(R.id.lblFecCreacion);
        lblFecCreacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblFecCreacion();
            }
        });

        calendarSolicitud =Calendar.getInstance();
        calendarSolicitud.add(Calendar.DATE, -1);

        calendarMaxSolicitud =Calendar.getInstance();
        calendarMaxSolicitud.add(Calendar.MONTH, -1);

        mYearSolicitud = calendarSolicitud.get(Calendar.YEAR);
        mMonthSolicitud = calendarSolicitud.get(Calendar.MONTH);
        mDaySolicitud = calendarSolicitud.get(Calendar.DATE);


        calendarCreacion =Calendar.getInstance();
        calendarCreacion.add(Calendar.DATE, -1);

        calendarMaxCreacion =Calendar.getInstance();
        calendarMaxCreacion.add(Calendar.MONTH, -1);

        mYearCreacion = calendarCreacion.get(Calendar.YEAR);
        mMonthCreacion = calendarCreacion.get(Calendar.MONTH);
        mDayCreacion = calendarCreacion.get(Calendar.DATE);


            listaProgramas= new ArrayList<clsProgramas>();
            getListaProgramas();
            getActivity().setTitle(getString(R.string.inscripcion_ficha) + " - " + getString(R.string.anexo_1));

        updateDisplaySolicitud();
        updateDisplayCreacion();
        setHasOptionsMenu(true);
        return view;
    }
    public void lblObservaciones()
    {
        if(viewObservaciones.getVisibility()==View.GONE)
        {
            viewObservaciones.setVisibility(View.VISIBLE);
            lblObservaciones.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewObservaciones.setVisibility(View.GONE);
            lblObservaciones.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
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
    public void lblDatos()
    {
        if(viewDatos.getVisibility()==View.GONE)
        {
            viewDatos.setVisibility(View.VISIBLE);
            lblDatos.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.open), null);
        }
        else
        {
            viewDatos.setVisibility(View.GONE);
            lblDatos.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.closed), null);
        }
    }
    public void btnAgregar()
    {
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_programas);


        TextView lblProgramas= (TextView)dialog.findViewById(R.id.lblProgramas);
        lblProgramas.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblProgramas.getTextSize() + SizeText);

        TextView lblDuracion= (TextView)dialog.findViewById(R.id.lblDuracion);
        lblDuracion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDuracion.getTextSize() + SizeText);

        TextView lblIResponsable= (TextView)dialog.findViewById(R.id.lblIResponsable);
        lblIResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblIResponsable.getTextSize()+SizeText);


        final EditText txtProgramas = (EditText)dialog.findViewById(R.id.txtProgramas);
        txtProgramas.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtProgramas.getTextSize()+SizeText);
        txtProgramas.setText("");

        final EditText txtDuracion = (EditText)dialog.findViewById(R.id.txtDuracion);
        txtDuracion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtDuracion.getTextSize()+SizeText);
        txtDuracion.setText("");

        final EditText txtIResponsable = (EditText)dialog.findViewById(R.id.txtIResponsable);
        txtIResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtIResponsable.getTextSize()+SizeText);
        txtIResponsable.setText("");

        Button btnAgregar = (Button) dialog.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clsProgramas objLineaActivdad = new clsProgramas();
                objLineaActivdad.setResponsable(txtIResponsable.getText().toString());
                objLineaActivdad.setDuracion(txtDuracion.getText().toString());
                objLineaActivdad.setNombre(txtProgramas.getText().toString());
                listaProgramas.add(objLineaActivdad);
                getListaProgramas();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public class SelectDateSolicitudFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int yy = calendarSolicitud.get(Calendar.YEAR);
            int mm = calendarSolicitud.get(Calendar.MONTH);
            int dd = calendarSolicitud.get(Calendar.DATE);
            DatePickerDialog DatePickerInicio =new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, yy, mm, dd);
           // DatePickerInicio.getDatePicker().setMinDate(calendarMinInicio.getTimeInMillis());
            DatePickerInicio.getDatePicker().setMaxDate(calendarMaxSolicitud.getTimeInMillis());
            return DatePickerInicio;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYearSolicitud = yy;
            mMonthSolicitud = mm;
            mDaySolicitud = dd;
            updateDisplaySolicitud();
        }
    }

    public class SelectDateCreacionFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int yy = calendarCreacion.get(Calendar.YEAR);
            int mm = calendarCreacion.get(Calendar.MONTH);
            int dd = calendarCreacion.get(Calendar.DATE);
            DatePickerDialog DatePickerInicio =new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, yy, mm, dd);
            // DatePickerInicio.getDatePicker().setMinDate(calendarMinInicio.getTimeInMillis());
            DatePickerInicio.getDatePicker().setMaxDate(calendarMaxCreacion.getTimeInMillis());
            return DatePickerInicio;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            mYearCreacion = yy;
            mMonthCreacion = mm;
            mDayCreacion = dd;
            updateDisplayCreacion();
        }
    }



    private void updateDisplaySolicitud() {

        calendarSolicitud.set(mYearSolicitud, mMonthSolicitud, mDaySolicitud);
        lblFecSolicitud.setText(new StringBuilder().append(clsUtilidades.pad(mDaySolicitud)).append("/").append(clsUtilidades.pad(mMonthSolicitud + 1)).append("/").append(mYearSolicitud));

    }
    public void lblFecSolicitud ()
    {
        DialogFragment newFragment = new SelectDateSolicitudFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }


    private void updateDisplayCreacion() {

        calendarCreacion.set(mYearCreacion, mMonthCreacion, mDayCreacion);
        lblFecCreacion.setText(new StringBuilder().append(clsUtilidades.pad(mDayCreacion)).append("/").append(clsUtilidades.pad(mMonthCreacion + 1)).append("/").append(mYearCreacion));

    }
    public void lblFecCreacion ()
    {
        DialogFragment newFragment = new SelectDateCreacionFragment();
        newFragment.show(getFragmentManager(), "DatePicker");
    }



    public void ComboCategoria(){
        /*itensHabitacion= clsTipoHabitacionSQL.Listar(this.getActivity(),entidad.getIdSucursal());
        itensHabitacion.add(0,new clsTipoHabitacion(0,"Todos"));
        List<String> listString = new ArrayList<String>();
        for(clsTipoHabitacion objTipoHabitacion:itensHabitacion)
            listString.add(objTipoHabitacion.getNombreComercial());
*/
        String[] listString=getResources().getStringArray(R.array.array);

        ArrayAdapter<String> adapterConbo = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,listString);

        adapterConbo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboCategoria.setAdapter(adapterConbo);
        ComboCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getLista(itensHabitacion.get(position).getIdTipoHabitacion());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboCategoria.setSelection(0);
    }

    public void ComboCargo(){
        /*itensHabitacion= clsTipoHabitacionSQL.Listar(this.getActivity(),entidad.getIdSucursal());
        itensHabitacion.add(0,new clsTipoHabitacion(0,"Todos"));
        List<String> listString = new ArrayList<String>();
        for(clsTipoHabitacion objTipoHabitacion:itensHabitacion)
            listString.add(objTipoHabitacion.getNombreComercial());
*/
        String[] listString=getResources().getStringArray(R.array.array);

        ArrayAdapter<String> adapterConbo = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,listString);

        adapterConbo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboCargo.setAdapter(adapterConbo);
        ComboCargo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getLista(itensHabitacion.get(position).getIdTipoHabitacion());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboCargo.setSelection(0);
    }
    public void ComboDepartamento(){
        List<clsDepartamento> lista= clsUbigeo.getListDepartamento();
        lista.add(0,new clsDepartamento(0,"Selecciones un Departamento"));

        ArrayAdapter<clsDepartamento> adapter = new ArrayAdapter<clsDepartamento>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
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

        lista.add(0,new clsProvincia(0,"Selecciones un Provincia"));

        ArrayAdapter<clsProvincia> adapter = new ArrayAdapter<clsProvincia>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        ComboProvincia.setAdapter(adapter);
        ComboProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ComboDistrito(((clsProvincia)ComboProvincia.getSelectedItem()).getPk_id());;
            }
            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboProvincia.setSelection(0);
    }

    public void ComboDistrito(int idProvincia){
        List<clsDistrito> lista=clsUbigeo.getListDistritoXProvincia(idProvincia);

        lista.add(0,new clsDistrito(0,"Selecciones un Distrito"));

        ArrayAdapter<clsDistrito> adapter = new ArrayAdapter<clsDistrito>(this.getActivity(),
                R.layout.spinner,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
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

    public void ComboTipoLocal(){
        /*itensHabitacion= clsTipoHabitacionSQL.Listar(this.getActivity(),entidad.getIdSucursal());
        itensHabitacion.add(0,new clsTipoHabitacion(0,"Todos"));
        List<String> listString = new ArrayList<String>();
        for(clsTipoHabitacion objTipoHabitacion:itensHabitacion)
            listString.add(objTipoHabitacion.getNombreComercial());
*/
        String[] listString=getResources().getStringArray(R.array.array);

        ArrayAdapter<String> adapterConbo = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,listString);

        adapterConbo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ComboTipoLocal.setAdapter(adapterConbo);
        ComboTipoLocal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getLista(itensHabitacion.get(position).getIdTipoHabitacion());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //User selected same item. Nothing to do.
            }
        });
        ComboTipoLocal.setSelection(0);
    }

    public void btnUbicar()
    {

        DialogFragment dialogMapa = new DialogMapa();
        dialogMapa.setCancelable(false);
        dialogMapa.show(getFragmentManager(), "DialogMapa");
    }





    public class DialogMapa extends DialogFragment implements LocationListener,GoogleMap.OnMapClickListener {


        // flag for GPS status
        boolean isGPSEnabled = false;

        // flag for network status
        boolean isNetworkEnabled = false;

        // flag for GPS status
        boolean canGetLocation = false;
        private boolean zoon=true;
        Location location; // location

        private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 10 meters

        // The minimum time between updates in milliseconds
        private static final long MIN_TIME_BW_UPDATES = 1000 * 20; // 1 minute

        // Declaring a Location Manager
        protected LocationManager locationManager;
        private GoogleMap googleMap;
        MapView mapView=null;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.dialog_maps, container, false);

            getDialog().setTitle(getString(R.string.sel_ubicacion_inscripcion_anexo_1));
            getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

            int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getActivity());
            Button btnAceptarDialogMap = (Button)view.findViewById(R.id.btnAceptarDialogMap);
            btnAceptarDialogMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnAceptarDialogMap();
                }
            });


            Button btnCancelarDialogMap = (Button)view.findViewById(R.id.btnCancelarDialogMap);
            btnCancelarDialogMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    latitude=0d;
                    longitude=0d;
                    getDialog().dismiss();
                }
            });


            // Showing status
            if(status!= ConnectionResult.SUCCESS){ // Google Play Services are not available

                int requestCode = 10;
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this.getActivity(), requestCode);
                dialog.show();

            }else { // Google Play Services are available
                mapView = (MapView)view.findViewById(R.id.mapview);
                mapView.onCreate(savedInstanceState);

                // Getting GoogleMap object from the fragment
                googleMap = mapView.getMap();
                googleMap.setMyLocationEnabled(true);
                googleMap.setOnMapClickListener(this);
                getLocation();

            }
            return view;
        }


        @Override
        public void onResume() {
            if(mapView!=null)
                mapView.onResume();
            locationManager.removeUpdates(this);
            super.onResume();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            if(mapView!=null)
                mapView.onDestroy();
            locationManager.removeUpdates(this);
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            if(mapView!=null)
                mapView.onLowMemory();
            locationManager.removeUpdates(this);
        }

        @Override
        public void onLocationChanged(Location location) {

            if(zoon)
            {
                LatLng  latLng = new LatLng(location.getLatitude(), location.getLongitude());
                if(latitude!=0D  && longitude!=0D)
                {
                    latLng = new LatLng(latitude, longitude);
                    googleMap.addMarker(new MarkerOptions().position(latLng).
                            icon(BitmapDescriptorFactory.fromResource(R.drawable.maker)));
                }

                googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));


                zoon=false;

            }
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }

        @Override
        public void onMapClick(LatLng puntoPulsado) {
            googleMap.clear();
            googleMap.addMarker(new MarkerOptions().position(puntoPulsado).icon(BitmapDescriptorFactory.fromResource(R.drawable.maker)));

            latitude = puntoPulsado.latitude;
            longitude = puntoPulsado.longitude;
        }

        public void getLocation() {
            try {
                locationManager = (LocationManager) DialogMapa.this.getActivity().getSystemService(LOCATION_SERVICE);

                // getting GPS status
                isGPSEnabled = locationManager
                        .isProviderEnabled(LocationManager.GPS_PROVIDER);

                // getting network status
                isNetworkEnabled = locationManager
                        .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if (!isGPSEnabled && !isNetworkEnabled) {
                    // no network provider is enabled
                    Intent viewIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(viewIntent);
                } else {
                    this.canGetLocation = true;
                    // First get location from Network Provider
                    if (isNetworkEnabled) {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("Network", "Network");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if (location != null) {
                                onLocationChanged(location);
                            }
                        }
                    }
                    // if GPS Enabled get lat/long using GPS Services
                    if (isGPSEnabled) {
                        if (location == null) {
                            locationManager.requestLocationUpdates(
                                    LocationManager.GPS_PROVIDER,
                                    MIN_TIME_BW_UPDATES,
                                    MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                            Log.d("GPS Enabled", "GPS Enabled");
                            if (locationManager != null) {
                                location = locationManager
                                        .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                if (location != null) {
                                    onLocationChanged(location);
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void btnAceptarDialogMap()
        {
            getDialog().dismiss();
        }
    }


    class AdaptadorProgramas extends ArrayAdapter {

        Activity context;
        AdaptadorProgramas(Activity context) {
            super(context, R.layout.list_programas, listaProgramas);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final int pos=position;
            View item = inflater.inflate(R.layout.list_programas, null);

            TextView lblPNumeracion= (TextView)item.findViewById(R.id.lblPNumeracion);
            lblPNumeracion.setText(""+(position+1));
            lblPNumeracion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblPNumeracion.getTextSize()+SizeText);

            TextView lblProgramas= (TextView)item.findViewById(R.id.lblProgramas);
            lblProgramas.setText(listaProgramas.get(position).getNombre());
            lblProgramas.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblProgramas.getTextSize()+SizeText);

            TextView lblTiempo= (TextView)item.findViewById(R.id.lblTiempo);
            lblTiempo.setText(listaProgramas.get(position).getDuracion());
            lblTiempo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTiempo.getTextSize() + SizeText);

            TextView lblResponsable= (TextView)item.findViewById(R.id.lblResponsable);
            lblResponsable.setText(listaProgramas.get(position).getResponsable());
            lblResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblResponsable.getTextSize()+SizeText);

            Button btnEliminar = (Button)item.findViewById(R.id.btnEliminar);
            btnEliminar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnEliminar.getTextSize()+SizeText);
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnEliminarProgramas(pos);
                }
            });

            return(item);
        }
    }
    public void btnEliminarProgramas(int pos)
    {
        final int position=pos;
        android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.eliminar_dialog));
        alert.setPositiveButton(getString(R.string.btn_aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                listaProgramas.remove(position);
                getListaProgramas();

            }
        });
        alert.setNegativeButton(getString(R.string.btn_cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }
    public void getListaProgramas()
    {

        adaptadorProgramas = new AdaptadorProgramas(this.getActivity());

        listProgramas.setAdapter(adaptadorProgramas);
        clsUtilidades.setListViewHeightBasedOnChildren(listProgramas);
        /*listProgramas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(clsPersonaSQL.getSeleccionado(FragmentTab3.this.getActivity())==null) {
                    FragmentLogin fragment = new FragmentLogin();
                    Bundle bundle = new Bundle();
                    bundle.putInt("fragment",3); // use as per your need
                    fragment.setArguments(bundle);
                    ((MainActivity) getActivity()).setFragment(fragment);
                }
                else
                    getDisponibilidad(itens.get(position).getIdCostoTipoHabitacion());

            }
        });*/
    }






    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.action_mas:
                // do s.th.
                SizeText++;
                setSize(1);

                return true;
            case R.id.action_menos:
                // do s.th.--;
                SizeText--;
                setSize(-1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setSize(int sise)
    {
        lblTitulo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTitulo.getTextSize()+sise);
        lblDatos.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDatos.getTextSize()+sise);
        lblNIndetificacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNIndetificacion.getTextSize()+sise);
        lblFecSolicitud.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblFecSolicitud.getTextSize()+sise);
        txtNIndetificacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtNIndetificacion.getTextSize()+sise);
        lblNInstitucion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNInstitucion.getTextSize()+sise);
        txtNInstitucion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtNInstitucion.getTextSize()+sise);
        lblNIdentificacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNIdentificacion.getTextSize()+sise);
        txtNIdentificacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtNIdentificacion.getTextSize()+sise);
        lblTFechaCreacion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTFechaCreacion.getTextSize()+sise);
        lblCatInstitucion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblCatInstitucion.getTextSize()+sise);
        lblNruc.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNruc.getTextSize()+sise);
        txtNruc.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtNruc.getTextSize()+sise);
        lblDResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDResponsable.getTextSize()+sise);
        lblAPaterno.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblAPaterno.getTextSize()+sise);
        txtAPaterno.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtAPaterno.getTextSize()+sise);
        lblAMaterno.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblAMaterno.getTextSize()+sise);
        txtAMaterno.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtAMaterno.getTextSize()+sise);
        lblNombres.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNombres.getTextSize()+sise);
        txtNombres.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtNombres.getTextSize() + sise);
        lblCargo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblCargo.getTextSize()+sise);
        lblTRTelefono.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTRTelefono.getTextSize()+sise);
        txtRTelefono.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtRTelefono.getTextSize()+sise);
        lblInfTecnica.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblInfTecnica.getTextSize()+sise);
        lblDirSede.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDirSede.getTextSize()+sise);
        txtDirSede.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtDirSede.getTextSize()+sise);
        lblUbigeo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblUbigeo.getTextSize()+sise);
        lblTITTelefono.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTITTelefono.getTextSize()+sise);
        txtTITTelefono.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtTITTelefono.getTextSize()+sise);
        lblFax.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblFax.getTextSize()+sise);
        txtFax.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtFax.getTextSize()+sise);
        lblWeb.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblWeb.getTextSize()+sise);
        txtWeb.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtWeb.getTextSize()+sise);
        lblEmail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblEmail.getTextSize()+sise);
        txtEmail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtEmail.getTextSize()+sise);
        lblHAtencion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblHAtencion.getTextSize()+sise);
        txtHAtencion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtHAtencion.getTextSize()+sise);
        lblLocal.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblLocal.getTextSize()+sise);
        lblUbiFisica.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblUbiFisica.getTextSize()+sise);
        lblObejtivo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblObejtivo.getTextSize()+sise);
        lblPEjecutados.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblPEjecutados.getTextSize()+sise);
        lblTDuracion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTDuracion.getTextSize()+sise);
        lblIResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblIResponsable.getTextSize()+sise);
        btnAgregar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnAgregar.getTextSize()+sise);
        lblFinacioamento.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblFinacioamento.getTextSize()+sise);
        lblRubros.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblRubros.getTextSize()+sise);
        lblValor.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblValor.getTextSize()+sise);
        lblFuente.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblFuente.getTextSize()+sise);
        lblOperativo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblOperativo.getTextSize()+sise);
        lblProgramas.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblProgramas.getTextSize()+sise);
        lblInversion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblInversion.getTextSize()+sise);
        txtValor1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtValor1.getTextSize()+sise);
        txtValor2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtValor2.getTextSize()+sise);
        txtValor3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtValor3.getTextSize()+sise);
        txtFuente1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtFuente1.getTextSize()+sise);
        txtFuente2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtFuente2.getTextSize()+sise);
        txtFuente3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtFuente3.getTextSize()+sise);
        lblTotal.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTotal.getTextSize()+sise);
        lblTotalValor.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTotalValor.getTextSize()+sise);
        lblObservaciones.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblObservaciones.getTextSize()+sise);
        txtObservaciones.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtObservaciones.getTextSize()+sise);
        btnAceptar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnAceptar.getTextSize()+sise);
        btnUbicar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnUbicar.getTextSize()+sise);
        txtObejtivo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtObejtivo.getTextSize()+sise);
        lblPNumeracion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblPNumeracion.getTextSize()+sise);
            getListaProgramas();
    }

    public void btnAceptar(){
        ((MainActivity)getActivity()).setFragment(new InscripccionSlide());
    }
}