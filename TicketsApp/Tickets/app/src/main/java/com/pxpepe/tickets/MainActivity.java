package com.pxpepe.tickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private void colocarInfoSpiner() {

        Spinner spinner = (Spinner) findViewById(R.id.spinerName);

        // Criamos o adaptador utilizando o array de strings e o spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_alunos, android.R.layout.simple_spinner_item);

        // Especifificamos o layout a utilizar quando a lista aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicamos ao spinner
        spinner.setAdapter(adapter);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colocarInfoSpiner();

    }

    public void btnClicado(View vistaBtn) {


        Spinner mySpinner= findViewById(R.id.spinerName);
        String nome = mySpinner.getSelectedItem().toString();

        EditText txtDesc = findViewById(R.id.txtDesc);
        String desc = txtDesc.getText().toString();

        String parametros = "";
        try {
            parametros =  URLEncoder.encode(nome,"UTF8")
                    +"&desc="+URLEncoder.encode(desc,"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://server.weicap.com/pdm/abrir_pedido.php?nome="+parametros;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);

    }

    public void btnAtendido(View vistaBtn) {


        Spinner mySpinner= findViewById(R.id.spinerName);
        String nome = mySpinner.getSelectedItem().toString();

        String parametros = "";
        try {
            parametros =  URLEncoder.encode(nome,"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://server.weicap.com/pdm/fechar_pedido.php?nome="+parametros;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);

    }

}
