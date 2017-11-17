package com.example.joan.maquetacion;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Persistencia datos SharedPreference
    private final static String SHARED_PREFERENCES = "MisPreferencias";

    // Datos del formulario
    private String affair = "", message = "";
    private int spinnerSelection = 0;
    private boolean checkBoxState = false;

    // Views UI
    private EditText txtAffair, txtMessage;
    private Spinner mySpinner;
    private CheckBox cbMrPresident;
    private Button btnSave, btnLoad, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        //Html.fromHtml() Para añadir html
    }

    private void initLayout() {
        txtAffair = findViewById(R.id.txtAffair);
        txtMessage = findViewById(R.id.txtMessage);
        mySpinner = findViewById(R.id.mySpinner);
        cbMrPresident = findViewById(R.id.cbMrPresident);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void clearLayout() {
        // Empty views data
        affair = "";
        message = "";
        spinnerSelection = 0;
        checkBoxState = false;
        initLayoutData();

        txtAffair.setText(affair);
        txtMessage.setText(message);
        mySpinner.setSelection(spinnerSelection);
        cbMrPresident.setChecked(checkBoxState);
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Valor de los EditText
        String stringifyTxtAffair = txtAffair.getText().toString();
        editor.putString("txtAffair", stringifyTxtAffair);

        String stringifyTxtMessage = txtMessage.getText().toString();
        editor.putString("txtMessage", stringifyTxtMessage);

        // Posición del Spinner
        int spinnerSelection = mySpinner.getSelectedItemPosition();
        editor.putInt("mySpinner", spinnerSelection);

        // Estado del CheckBox
        checkBoxState = cbMrPresident.isChecked();
        editor.putBoolean("cbMrPresident", checkBoxState);

        editor.apply(); // apply == commit
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        affair = sharedPreferences.getString("txtAffair", "");
        message = sharedPreferences.getString("txtMessage", "");
        spinnerSelection = sharedPreferences.getInt("mySpinner", 0);
        checkBoxState = sharedPreferences.getBoolean("cbMrPresident", false);

        initLayoutData();
    }

    private void initLayoutData() {
        txtAffair.setText(affair);
        txtMessage.setText(message);
        mySpinner.setSelection(spinnerSelection);
        cbMrPresident.setChecked(checkBoxState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                saveData();
                break;
            case R.id.btnLoad:
                loadData();
                break;
            case R.id.btnDelete:
                deleteSaveData();
        }
    }

    private void deleteSaveData() {
        // Delete SharedPreferences data
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("txtAffair");
        editor.remove("txtMessage");
        editor.remove("mySpinner");
        editor.remove("cbMrPresident");
        editor.apply();

        // Empty views data
        clearLayout();
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(MainActivity.class.getSimpleName(), "onConfigurationChanged");
    }*/

}
