package com.pxpepe.toastesnack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String obterTexto() {
        EditText caixaTexto = findViewById(R.id.txtValor);
        String texto = caixaTexto.getText().toString();
        if (texto.trim().equals("")) {
            texto = "Não há qualquer texto introduzido!";
        }
        return texto;
    }

    public void toastClick(View vistaBtn) {
        Toast.makeText(MainActivity.this, obterTexto(), Toast.LENGTH_LONG).show();
    }

    public void snackClick(View vistaBtn) {
        Snackbar.make(vistaBtn,obterTexto(), Snackbar.LENGTH_LONG).show();
    }

}
