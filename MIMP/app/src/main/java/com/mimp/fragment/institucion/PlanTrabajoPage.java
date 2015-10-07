/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mimp.fragment.institucion;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.mimp.activity.R;
import com.mimp.entidades.clsPlanTrabajo;
import com.mimp.utilidades.clsUtilidades;

import java.util.ArrayList;
import java.util.List;


public class PlanTrabajoPage extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";
    private TextView lblPagina;

    private List<clsPlanTrabajo> list;
    private int SizeText=0;
    private AdaptadorPlanTrabajo adaptadorPlanTrabajo;
    private ListView listPlanTrabajo;
    private Button btnAgregar;

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static PlanTrabajoPage create(int pageNumber) {
        PlanTrabajoPage fragment = new PlanTrabajoPage();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlanTrabajoPage() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        View view = (View) inflater
                .inflate(R.layout.page_plan_trabajo, container, false);

        list= new ArrayList<clsPlanTrabajo>();

        lblPagina=(TextView) view.findViewById(R.id.lblPagina);
        lblPagina.setText(getString(R.string.pagina_ficha)+" 2 "+getString(R.string.de_ficha)+" 3.");

        listPlanTrabajo=(ListView) view.findViewById(R.id.listPlanTrabajo);

        btnAgregar = (Button) view.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAgregar();
            }
        });
        list = new ArrayList<clsPlanTrabajo>();
        getListaPlanTrabajo();
        return view;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }

    public void btnAgregar()
    {
        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_plan_trabajo);


        TextView lblResponsable= (TextView)dialog.findViewById(R.id.lblResponsable);
        lblResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblResponsable.getTextSize() + SizeText);

        TextView lblDResponsable= (TextView)dialog.findViewById(R.id.lblDResponsable);
        lblDResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblDResponsable.getTextSize() + SizeText);

        TextView lblObejtivo= (TextView)dialog.findViewById(R.id.lblObejtivo);
        lblObejtivo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblObejtivo.getTextSize() + SizeText);

        TextView lblMeta= (TextView)dialog.findViewById(R.id.lblMeta);
        lblMeta.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblMeta.getTextSize()+SizeText);

        TextView lblActividad= (TextView)dialog.findViewById(R.id.lblActividad);
        lblActividad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblActividad.getTextSize()+SizeText);

        TextView lblCronograma= (TextView)dialog.findViewById(R.id.lblCronograma);
        lblCronograma.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblCronograma.getTextSize()+SizeText);

        final EditText txtObejtivo = (EditText)dialog.findViewById(R.id.txtObejtivo);
        txtObejtivo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtObejtivo.getTextSize()+SizeText);
        txtObejtivo.setText("");

        final EditText txtActividad = (EditText)dialog.findViewById(R.id.txtActividad);
        txtActividad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtActividad.getTextSize()+SizeText);
        txtActividad.setText("");

        final EditText txtCronograma = (EditText)dialog.findViewById(R.id.txtCronograma);
        txtCronograma.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtCronograma.getTextSize()+SizeText);
        txtCronograma.setText("");

        final EditText txtMeta = (EditText)dialog.findViewById(R.id.txtMeta);
        txtMeta.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtMeta.getTextSize()+SizeText);
        txtMeta.setText("");

        final EditText txtResponsable = (EditText)dialog.findViewById(R.id.txtResponsable);
        txtResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, txtResponsable.getTextSize()+SizeText);
        txtResponsable.setText("");

        Button btnAgregar = (Button) dialog.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clsPlanTrabajo entidad = new clsPlanTrabajo();
                entidad.setActividad(txtActividad.getText().toString());
                entidad.setCronograma(txtCronograma.getText().toString());
                entidad.setMeta(txtMeta.getText().toString());
                entidad.setObejtivo(txtObejtivo.getText().toString());
                entidad.setResponsable(txtResponsable.getText().toString());
                list.add(entidad);
                getListaPlanTrabajo();
                dialog.dismiss();
            }
        });
        dialog.show();


    }

    class AdaptadorPlanTrabajo extends ArrayAdapter {

        Activity context;
        AdaptadorPlanTrabajo(Activity context) {
            super(context, R.layout.list_plan_trabajo, list);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_plan_trabajo, null);

            TextView lblNObejtivo= (TextView)item.findViewById(R.id.lblNObejtivo);
            lblNObejtivo.setText(""+(position+1));
            lblNObejtivo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNObejtivo.getTextSize() + SizeText);


            TextView lblObejtivo= (TextView)item.findViewById(R.id.lblObejtivo);
            lblObejtivo.setText(list.get(position).getActividad());
            lblObejtivo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblObejtivo.getTextSize() + SizeText);

            TextView lblActividad= (TextView)item.findViewById(R.id.lblActividad);
            lblActividad.setText(list.get(position).getObejtivo());
            lblActividad.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblActividad.getTextSize() + SizeText);

            TextView lblMeta= (TextView)item.findViewById(R.id.lblMeta);
            lblMeta.setText(list.get(position).getMeta());
            lblMeta.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblMeta.getTextSize() + SizeText);

            TextView lblCronograma= (TextView)item.findViewById(R.id.lblCronograma);
            lblCronograma.setText(list.get(position).getCronograma());
            lblCronograma.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblCronograma.getTextSize() + SizeText);

            TextView lblResponsable= (TextView)item.findViewById(R.id.lblResponsable);
            lblResponsable.setText(list.get(position).getResponsable());
            lblResponsable.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblResponsable.getTextSize() + SizeText);

            Button btnEliminar = (Button) item.findViewById(R.id.btnEliminar);
            btnEliminar.setTextSize(TypedValue.COMPLEX_UNIT_DIP, btnEliminar.getTextSize() + SizeText);
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnEliminar(pos);
                    }
                });
            return(item);
        }
    }

    public void btnEliminar(int pos)
    {
        final int position=pos;
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());
        alert.setTitle(getString(R.string.eliminar_dialog));
        alert.setPositiveButton(getString(R.string.btn_aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                list.remove(position);

                getListaPlanTrabajo();

            }
        });
        alert.setNegativeButton(getString(R.string.btn_cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }

    protected void getListaPlanTrabajo()
    {
        adaptadorPlanTrabajo = new AdaptadorPlanTrabajo(this.getActivity());
        listPlanTrabajo.setAdapter(adaptadorPlanTrabajo);
    }

}
