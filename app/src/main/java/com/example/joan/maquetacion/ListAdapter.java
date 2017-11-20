package com.example.joan.maquetacion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<Persona> arrayList;
    private Context context;

    public ListAdapter(ArrayList<Persona> arrayList, Context context) { // El contexto és la Activity
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d(ListAdapter.class.getSimpleName(), "getCount = " + arrayList.size());
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    // i == position
    @Override
    public long getItemId(int i) {
        return arrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d(ListAdapter.class.getSimpleName(), "getView position = " + i);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = layoutInflater.inflate(R.layout.item_persona, null); // Inflater se encarga de rellenar el layout con los datos

        Log.d(ListAdapter.class.getSimpleName(), "getView, Se está instanciando ImageView/TextView: " + i);
        ImageView imageView = view.findViewById(R.id.imgPersona);
        TextView nombreView = view.findViewById(R.id.nombrePersona);

        Persona persona = arrayList.get(i);
        nombreView.setText(persona.getName());
        imageView.setImageResource(persona.getImgFront());

        return view;
    }
}