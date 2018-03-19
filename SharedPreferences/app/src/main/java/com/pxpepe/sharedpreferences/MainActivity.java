package com.pxpepe.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String AS_MINHAS_PREFERENCIAS = "AS_MINHAS_PREFERENCIAS";
    private static final String O_MEU_CAMPO_DE_TEXTO = "O_MEU_CAMPO_DE_TEXTO";
    private static final String O_MEU_CAMPO_NUMERICO = "O_MEU_CAMPO_NUMERICO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colocarValorTxtView();
    }

    private void colocarValorTxtView() {
        SharedPreferences prefs = getSharedPreferences(AS_MINHAS_PREFERENCIAS, MODE_PRIVATE);
        String nome = prefs.getString(O_MEU_CAMPO_DE_TEXTO, "Ainda não foi definido nenhum nome!");
        int idade = prefs.getInt(O_MEU_CAMPO_NUMERICO, 0);

        TextView txtNome = findViewById(R.id.txtViewNome);
        TextView txtIdade = findViewById(R.id.txtViewIdade);

        txtNome.setText(nome);
        txtIdade.setText(String.valueOf(idade));

    }

    public void btnGuardarShared(View vistaBtn) {

        SharedPreferences.Editor editor = getSharedPreferences(AS_MINHAS_PREFERENCIAS, MODE_PRIVATE).edit();

        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtIdade = findViewById(R.id.txtIdade);

        editor.putString(O_MEU_CAMPO_DE_TEXTO, txtNome.getText().toString());
        editor.putInt(O_MEU_CAMPO_NUMERICO, Integer.parseInt(txtIdade.getText().toString()));
        editor.apply();

        colocarValorTxtView();

    }

}
