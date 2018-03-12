package com.pxpepe.toastesnack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void outraImagem(View vistaImg) {

        ImageView imgCentro = findViewById(R.id.imgCentro);
        imgCentro.setImageResource(R.drawable.img2);

    }

}
