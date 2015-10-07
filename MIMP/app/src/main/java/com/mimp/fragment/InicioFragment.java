package com.mimp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mimp.activity.MainActivity;
import com.mimp.activity.R;
import com.mimp.entidades.clsBandeja;
import com.mimp.fragment.institucion.InscripccionSlide;
import com.mimp.utilidades.clsUtilidades;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    private List<clsBandeja> list;
    private int SizeText=0;
    private ListView listBandeja;
    private AdaptadorBandeja adaptadorBandeja;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        listBandeja=(ListView)view.findViewById(R.id.listBandeja);
        //getActivity().setTitle(getString(R.string.inscripcion_ficha)+" - "+getString(R.string.anexo_2));
        //TextView titulo = (TextView) view.findViewById(R.id.title);
        //titulo.setText("Fragment2");
        getBandeja();
        return view;
    }

    public void getBandeja()
    {
        list=new ArrayList<clsBandeja>();
        list.add(new  clsBandeja(1,"CAR 1","CAR","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 1","INSTITUCIÓN","RENOVACIÓN", "CERRADO",2));
        list.add(new  clsBandeja(1,"CAR 2","CAR","SUPERVISION", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 2","INSTITUCIÓN","RENOVACIÓN", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 3","INSTITUCIÓN","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(1,"CAR 3","CAR","RENOVACIÓN", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 4","INSTITUCIÓN","REGISTRO", "CERRADO",2));
        list.add(new  clsBandeja(1,"car 4","CAR","RENOVACIÓN", "CERRADO",2));

        list.add(new  clsBandeja(1,"CAR 1","CAR","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 1","INSTITUCIÓN","RENOVACIÓN", "CERRADO",2));
        list.add(new  clsBandeja(1,"CAR 2","CAR","SUPERVISION", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 2","INSTITUCIÓN","RENOVACIÓN", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 3","INSTITUCIÓN","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(1,"CAR 3","CAR","RENOVACIÓN", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 4","INSTITUCIÓN","REGISTRO", "CERRADO",2));
        list.add(new  clsBandeja(1,"car 4","CAR","RENOVACIÓN", "CERRADO",2));
        list.add(new  clsBandeja(1,"CAR 1","CAR","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 1","INSTITUCIÓN","RENOVACIÓN", "CERRADO",2));
        list.add(new  clsBandeja(1,"CAR 2","CAR","SUPERVISION", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 2","INSTITUCIÓN","RENOVACIÓN", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 3","INSTITUCIÓN","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(1,"CAR 3","CAR","RENOVACIÓN", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 4","INSTITUCIÓN","REGISTRO", "CERRADO",2));
        list.add(new  clsBandeja(1,"car 4","CAR","RENOVACIÓN", "CERRADO",2));
        list.add(new  clsBandeja(1,"CAR 1","CAR","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 1","INSTITUCIÓN","RENOVACIÓN", "CERRADO",2));
        list.add(new  clsBandeja(1,"CAR 2","CAR","SUPERVISION", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 2","INSTITUCIÓN","RENOVACIÓN", "ABIERTO",1));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 3","INSTITUCIÓN","REGISTRO", "ABIERTO",1));
        list.add(new  clsBandeja(1,"CAR 3","CAR","RENOVACIÓN", "ENVIADO",3));
        list.add(new  clsBandeja(2,"INSTITUCIÓN 4","INSTITUCIÓN","REGISTRO", "CERRADO",2));
        list.add(new  clsBandeja(1,"car 4","CAR","RENOVACIÓN", "CERRADO",2));
        adaptadorBandeja = new AdaptadorBandeja(this.getActivity());
        listBandeja.setAdapter(adaptadorBandeja);

    }
    class AdaptadorBandeja extends ArrayAdapter {

        Activity context;
        AdaptadorBandeja(Activity context) {
            super(context, R.layout.lista_bandeja, list);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=list.get(position).getPk_id();
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.lista_bandeja, null);

            TextView lblNumero= (TextView)item.findViewById(R.id.lblNumero);
            lblNumero.setText(""+(position+1));
            lblNumero.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNumero.getTextSize() + SizeText);

            TextView lblVer= (TextView)item.findViewById(R.id.lblVer);
            lblVer.setText("");
            lblVer.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblVer.getTextSize() + SizeText);

            TextView lblOrganismo= (TextView)item.findViewById(R.id.lblOrganismo);
            lblOrganismo.setText(list.get(position).getNombre());
            lblOrganismo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblOrganismo.getTextSize() + SizeText);

            TextView lblIntegrante= (TextView)item.findViewById(R.id.lblIntegrante);
            lblIntegrante.setText(list.get(position).getNombre());
            lblIntegrante.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblIntegrante.getTextSize() + SizeText);


            TextView lblActividad= (TextView)item.findViewById(R.id.lblActividad);
            lblActividad.setText(list.get(position).getNombre());
            lblActividad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblActividad.getTextSize() + SizeText);

            TextView lblFecha= (TextView)item.findViewById(R.id.lblFecha);
            lblFecha.setText(list.get(position).getTipo());
            lblFecha.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblFecha.getTextSize() + SizeText);

            TextView lblEstado= (TextView)item.findViewById(R.id.lblEstado);
            lblEstado.setText(list.get(position).getEstado());
            lblEstado.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblEstado.getTextSize() + SizeText);

            CheckBox chkEnviar = (CheckBox) item.findViewById(R.id.chkEnviar);
            chkEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //is chkIos checked?
                    if (((CheckBox) v).isChecked()) {

                    }

                }
            });
            return(item);
        }
    }

    public void btnIr(int id)
    {
        if(id==1)
            ((MainActivity)getActivity()).setFragment(new CarFragment());
        else
            ((MainActivity)getActivity()).setFragment(new InstitucionFragment());
    }

}
