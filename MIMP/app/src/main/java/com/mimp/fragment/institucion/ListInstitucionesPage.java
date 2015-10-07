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
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mimp.activity.R;
import com.mimp.entidades.clsEntidadGenerica;

import java.util.ArrayList;
import java.util.List;


public class ListInstitucionesPage extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";
    private TextView lblPagina;
    private AdaptadorInstituciones adaptadorInstituciones;
    private ListView listInstituciones;
    private List<clsEntidadGenerica> list;
    private int SizeText;
    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static ListInstitucionesPage create(int pageNumber) {
        ListInstitucionesPage fragment = new ListInstitucionesPage();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ListInstitucionesPage() {
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
        View view = (View) inflater.inflate(R.layout.page_list_instituciones, container, false);

        listInstituciones=(ListView) view.findViewById(R.id.listInstituciones);

        lblPagina=(TextView) view.findViewById(R.id.lblPagina);
        lblPagina.setText(getString(R.string.pagina_ficha)+" 1 "+getString(R.string.de_ficha)+" 3.");
        // Set the title view to show the page number.
       // ((TextView) rootView.findViewById(android.R.id.text1)).setText("datos del Anexo 2");
        getListaInstituciones();

        return view;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }

    protected void getListaInstituciones()
    {
        list=new ArrayList<clsEntidadGenerica>();
        list.add(new clsEntidadGenerica("EJEMPLO 1","Programa",""));
        list.add(new clsEntidadGenerica("EJEMPLO 2","Proyecto",""));
        list.add(new clsEntidadGenerica("EJEMPLO 3","lbergue u Hogar",""));
        list.add(new clsEntidadGenerica("EJEMPLO 4","Programa",""));
        list.add(new clsEntidadGenerica("EJEMPLO 5","Proyecto",""));
        list.add(new clsEntidadGenerica("EJEMPLO 6","lbergue u Hogar","Provisional o Transitorio"));
        list.add(new clsEntidadGenerica("EJEMPLO 7","lbergue u Hogar","Internamiento"));
        list.add(new clsEntidadGenerica("EJEMPLO 8","Programa",""));
        adaptadorInstituciones = new AdaptadorInstituciones(this.getActivity());
        listInstituciones.setAdapter(adaptadorInstituciones);
    }

    class AdaptadorInstituciones extends ArrayAdapter {

        Activity context;
        AdaptadorInstituciones(Activity context) {
            super(context, R.layout.list_instituciones, list);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos=position;
            LayoutInflater inflater = context.getLayoutInflater();

            View item = inflater.inflate(R.layout.list_instituciones, null);
            TextView lblNInstitucion= (TextView)item.findViewById(R.id.lblNInstitucion);
            lblNInstitucion.setText(""+(position+1));
            lblNInstitucion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNInstitucion.getTextSize() + SizeText);

            TextView lblNombre= (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(list.get(position).getDato1());
            lblNombre.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblNombre.getTextSize() + SizeText);

            TextView lblTipo= (TextView)item.findViewById(R.id.lblTipo);
            lblTipo.setText(list.get(position).getDato2()+" "+list.get(position).getDato3());
            lblTipo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, lblTipo.getTextSize() + SizeText);




            return(item);
        }
    }
}
