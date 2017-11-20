package com.example.joan.maquetacion;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class ListActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initList();
    }

    private void initList() {
        ListView listView = findViewById(R.id.listView);

        // Crear un adapter con datos
        ListAdapter listAdapter = new ListAdapter(getPersonas(), this);

        // Setear ese adapter a mi lista
        listView.setAdapter(listAdapter);
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
                R.drawable.preso1);

        Persona persona2 = new Persona(
                2,
                "name2",
                "surname2",
                1,
                false,
                R.drawable.preso2,
                R.drawable.preso2);

        Persona persona3 = new Persona(
                3,
                "name3",
                "surname3",
                2,
                false,
                R.drawable.preso3,
                R.drawable.preso3);

        Persona persona4 = new Persona(
                4,
                "name4",
                "surname4",
                3,
                false,
                R.drawable.preso4,
                R.drawable.preso4);

        for (int i = 0; i<100; i++) {
            arrayList.add(persona1);
            arrayList.add(persona2);
            arrayList.add(persona3);
            arrayList.add(persona4);
        }

        return arrayList;
    }
}
