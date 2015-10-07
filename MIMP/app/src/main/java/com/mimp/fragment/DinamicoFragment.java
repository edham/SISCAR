package com.mimp.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.mimp.activity.R;
import com.mimp.entidades.clsFichaIndicador;
import com.mimp.entidades.clsFichaVariable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DinamicoFragment extends Fragment {
    private Calendar calendarCreacion;
    private ViewGroup mContainerView;
    private List<clsFichaIndicador> itens;
    private int ancho;
    private SimpleDateFormat dateFormatter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_dinamico, container, false);
        mContainerView = (ViewGroup) rootView.findViewById(R.id.container);
        ancho=(this.getActivity().getWindowManager().getDefaultDisplay().getWidth());
        calendarCreacion =Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        getData();
        return rootView;
    }

    public void getData()
    {
        itens = new ArrayList<clsFichaIndicador>();

        List<clsFichaVariable>list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",2,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(1,5,1,6,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,5,"titulo 1","respuesta 0","hint 1",1,1,1,0,false));

        itens.add(new clsFichaIndicador(2,0,2,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(3,0,3,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(4,0,4,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(5,0,5,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(6,0,6,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(7,0,7,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(8,0,8,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(9,0,9,3,list));


        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,1,0,0,false));

        itens.add(new clsFichaIndicador(2,0,2,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(3,0,3,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(4,0,4,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(5,0,5,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(6,0,6,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(7,0,7,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(8,0,8,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(9,0,9,3,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,1,0,0,false));

        itens.add(new clsFichaIndicador(2,0,2,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(3,0,3,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(4,0,4,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(5,0,5,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(6,0,6,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(7,0,7,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(8,0,8,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(9,0,9,3,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,1,0,0,false));

        itens.add(new clsFichaIndicador(2,0,2,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(3,0,3,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(4,0,4,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(5,0,5,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(6,0,6,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(7,0,7,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(8,0,8,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(9,0,9,3,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,1,0,0,false));

        itens.add(new clsFichaIndicador(2,0,2,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(3,0,3,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(4,0,4,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(5,0,5,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(6,0,6,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(7,0,7,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(8,0,8,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(9,0,9,3,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,1,0,0,false));

        itens.add(new clsFichaIndicador(2,0,2,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,2,0,0,false));

        itens.add(new clsFichaIndicador(3,0,3,1,list));

        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(4,0,4,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(5,0,5,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(6,0,6,2,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,4,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(7,0,7,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,0,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,1,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(8,0,8,3,list));
        list = new ArrayList<clsFichaVariable>();
        list.add(new clsFichaVariable(1,2,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,3,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));
        list.add(new clsFichaVariable(1,5,"titulo 1","respuesta 0","hint 1",1,0,0,0,false));

        itens.add(new clsFichaIndicador(9,0,9,3,list));
        for(int i=0; i<itens.size(); i++)
        {
            addItem(i);
        }

    }

    private void addItem(int position) {
        // Instantiate a new "row" view.
        final int posicion=position;
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(this.getActivity()).inflate(
                R.layout.dinamico, mContainerView, false);


        LinearLayout ll = (LinearLayout)newView.findViewById(R.id.linear);
        ll.setGravity(Gravity.CENTER_HORIZONTAL);
        int variable =itens.get(position).getListVariables().size();
        int division=ancho/itens.get(position).getPartes();

        for(int i=0;i<variable;i++) {
            final int posI=i;
            int barra=R.drawable.barra_clara;
            int colorTexto=R.color.gris_oscuro;
            int posicio=Gravity.LEFT;
            int controlSise =division*itens.get(position).getListVariables().get(i).getSise();
            if(itens.get(position).getListVariables().get(i).getPosicion()==1) {
                posicio=Gravity.CENTER;
            }
            else  if(itens.get(position).getListVariables().get(i).getPosicion()==2) {
                posicio=Gravity.RIGHT;
            }
            if(itens.get(position).getListVariables().get(i).getCombinacion()==1) {
                barra = R.drawable.barra_oscura;
                colorTexto=R.color.tono_blanco;
            }
            else if(itens.get(position).getListVariables().get(i).getCombinacion()==2) {
                barra = R.drawable.barra_garnet;
                colorTexto=R.color.tono_blanco;
            }
            switch (itens.get(position).getListVariables().get(i).getControl())
            {
               case 0:
                    final TextView TextView = new TextView(this.getActivity());
                    TextView.setText(itens.get(position).getListVariables().get(i).getTirulo());
                    TextView.setBackgroundResource(barra);
                    TextView.setWidth(controlSise);
                    TextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.text_1));
                    TextView.setTextColor(getResources().getColor(colorTexto));
                    TextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT));
                    TextView.setGravity(posicio|Gravity.CENTER);
                    ll.addView(TextView);
               break;
                case 1:
                    final EditText TexBox = new EditText(this.getActivity());
                    TexBox.setWidth(controlSise);
                    TexBox.setBackgroundResource(R.drawable.border_text_1);
                    TexBox.setHint(itens.get(position).getListVariables().get(i).getHint());
                    TexBox.setTextColor(Color.BLACK);
                    TexBox.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT));
                    TexBox.setGravity(posicio);
                    //TexBox.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                   // TexBox.setLines(itens.get(position).iValor);
                    TexBox.addTextChangedListener(new TextWatcher() {

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before,int count) {
                           // if(paginacion)
                            {
                                itens.get(posicion).getListVariables().get(posI).setRespuesta(TexBox.getText().toString());
                            }
                        }

                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                        }
                    });

                    ll.addView(TexBox);
                    TexBox.setText(itens.get(position).getListVariables().get(i).getRespuesta());
                    break;
                case 2:
                    final Spinner ComboBox = new Spinner(this.getActivity());
                    List<String> listCombo = new ArrayList<String>();

                    listCombo.add("Seleccione");
                        listCombo.add("dato1");
                        listCombo.add("dato2");
                    ArrayAdapter<String> adapterSexo = new ArrayAdapter<String>(this.getActivity(),R.layout.spinner,listCombo);
                    adapterSexo.setDropDownViewResource(R.layout.spinner_list);
                    ComboBox.setAdapter(adapterSexo);
                    ComboBox.setLayoutParams(new LinearLayout.LayoutParams(division, LinearLayout.LayoutParams.FILL_PARENT));
                    ComboBox.setBackgroundResource(barra);
                    ll.addView(ComboBox);
                    break;
                case 3:
                    final CheckBox CheckBox = new CheckBox(this.getActivity());
                    CheckBox.setWidth(division);
                    CheckBox.setGravity(posicio);
                    CheckBox.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT));
                    CheckBox.setBackgroundResource(barra);
                    CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            //  if(paginacion)
                            {
                                // itens.get(posicion).bactivo=isChecked;
                            }
                        }
                    });
                    ll.addView(CheckBox);


                    //CheckBox.setChecked(itens.get(position).bcheck);
                    break;
                case 4:
                    final RadioButton RadioBox = new RadioButton(this.getActivity());
                    RadioBox.setWidth(division);
                    RadioBox.setGravity(posicio);
                    RadioBox.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT));
                    RadioBox.setBackgroundResource(barra);
                    RadioBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            //  if(paginacion)
                            {
                                // itens.get(posicion).bactivo=isChecked;
                            }
                        }
                    });
                    ll.addView(RadioBox);
                    break;
                case 5:
                    final Calendar newCalendar = Calendar.getInstance();
                    final TextView DateView = new TextView(this.getActivity());
                    DateView.setText(dateFormatter.format(newCalendar.getTime()));
                    DateView.setBackgroundResource(barra);
                    DateView.setWidth(controlSise);
                    DateView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                    DateView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.text_1));
                    DateView.setTextColor(getResources().getColor(colorTexto));
                    DateView.setGravity(Gravity.CENTER);
                    DateView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.calendar), null, null, null);



                    final DatePickerDialog fromDatePickerDialog = new DatePickerDialog(this.getActivity(), AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {

                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            Calendar newDate = Calendar.getInstance();
                            newDate.set(year, monthOfYear, dayOfMonth);
                            DateView.setText(dateFormatter.format(newDate.getTime()));
                        }

                    },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


                    DateView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            fromDatePickerDialog.getDatePicker().setMaxDate(newCalendar.getTimeInMillis());
                            fromDatePickerDialog.show();
                        }
                    });
                    ll.addView(DateView);


                    break;
            }

        }


        mContainerView.addView(newView, position);

    }



}
