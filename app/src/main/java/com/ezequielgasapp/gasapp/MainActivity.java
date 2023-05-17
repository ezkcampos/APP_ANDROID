package com.ezequiel.gasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textViewResultado = findViewById(R.id.textViewResultado);
    }

    public void calcularPreco(View view){

        //recuperar os valores digitados nos campos
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        if(validarCampos(precoAlcool, precoGasolina)){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            if ((valorAlcool/valorGasolina) >= 0.7) {
                textViewResultado.setText("Melhor utilizar Gasolina");
            } else {
                textViewResultado.setText("Melhor utilizar Alcool");
            }
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        if(pAlcool == null || pAlcool.equals(""))
            return false;
        else if(pGasolina==null || pGasolina.equals(""))
            return false;
        else
            return true;
    }
}