package com.example.joan.maquetacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class ListActivity extends Activity {

    private ArrayList<Persona> arrayPersonas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initList();
    }

    private void initList() {
        ListView listView = findViewById(R.id.listView);

        // Crear un adapter con datos
        arrayPersonas = getPersonas();
        ListAdapter listAdapter = new ListAdapter(arrayPersonas, this);

        // Setear ese adapter a mi lista
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Cuando se clica una posición de la lista
                Persona personaClicada = arrayPersonas.get(i);
                Intent intentActivityFormulario = new Intent(ListActivity.this, FormularioActivity.class);
                intentActivityFormulario.putExtra("persona", personaClicada);
                startActivity(intentActivityFormulario);
            }
        });
    }

    private ArrayList<Persona> getPersonas() {
        ArrayList<Persona> arrayList = new ArrayList<>();

        Persona persona1 = new Persona(
                1,
                "name1",
                "surname1",
                0,
                false,
                R.drawable.preso1,
                R.drawable.preso2);

        Persona persona2 = new Persona(
                2,
                "name2",
                "surname2",
                0,
                false,
                R.drawable.preso2,
                R.drawable.preso3);

        Persona persona3 = new Persona(
                3,
                "name3",
                "surname3",
                0,
                false,
                R.drawable.preso3,
                R.drawable.preso4);

        Persona persona4 = new Persona(
                4,
                "name4",
                "surname4",
                0,
                false,
                R.drawable.preso4,
                R.drawable.preso5);

        Persona persona5 = new Persona(
                5,
                "name5",
                "surname5",
                0,
                false,
                R.drawable.preso5,
                R.drawable.preso6);

        Persona persona6 = new Persona(
                6,
                "name6",
                "surname6",
                0,
                false,
                R.drawable.preso6,
                R.drawable.preso7);

        Persona persona7 = new Persona(
                7,
                "name7",
                "surname7",
                0,
                false,
                R.drawable.preso7,
                R.drawable.preso8);

        Persona persona8 = new Persona(
                8,
                "name8",
                "surname8",
                0,
                false,
                R.drawable.preso8,
                R.drawable.preso1);

        for (int i = 0; i<20; i++) {
            arrayList.add(persona1);
            arrayList.add(persona2);
            arrayList.add(persona3);
            arrayList.add(persona4);
            arrayList.add(persona5);
            arrayList.add(persona6);
            arrayList.add(persona7);
            arrayList.add(persona8);
        }

        return arrayList;
    }
}
