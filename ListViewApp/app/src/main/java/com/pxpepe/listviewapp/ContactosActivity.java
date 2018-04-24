package com.pxpepe.listviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ContactosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        Toast.makeText(this, b.getString("nome"),
                Toast.LENGTH_LONG).show();

    }
}
