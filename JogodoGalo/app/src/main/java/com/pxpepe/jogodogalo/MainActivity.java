package com.pxpepe.jogodogalo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 = azul, 1 = vermelho

    int jogadorAtivo = 0;

    boolean jogoAtivo = true;

    // 2 significa que ainda não se jogou
    int[] estadoJogo = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // condições de vitória
    int[][] condsVitoria = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View vistaClicada) {

        Button btnClicado = (Button) vistaClicada;

        int indiceClicado = Integer.parseInt(btnClicado.getTag().toString());

        if (estadoJogo[indiceClicado] == 2 && jogoAtivo) {

            estadoJogo[indiceClicado] = jogadorAtivo;

            if (jogadorAtivo == 0) {

                vistaClicada.setBackgroundColor(Color.BLUE);

                jogadorAtivo = 1;

            } else {

                vistaClicada.setBackgroundColor(Color.RED);

                jogadorAtivo = 0;

            }

            for (int[] condVitoria : condsVitoria) {

                if (estadoJogo[condVitoria[0]] == estadoJogo[condVitoria[1]] &&
                        estadoJogo[condVitoria[1]] == estadoJogo[condVitoria[2]] &&
                        estadoJogo[condVitoria[0]] != 2) {

                    // Someone has won!

                    jogoAtivo = false;

                    String vencedor = "Vermelho";

                    if (estadoJogo[condVitoria[0]] == 0) {

                        vencedor = "Azul";

                    }

                    TextView mensagemVitoria = (TextView) findViewById(R.id.mensagemVitoria);

                    mensagemVitoria.setText("O Jogador " + vencedor + " venceu!");

                    LinearLayout layout = (LinearLayout)findViewById(R.id.jogarNovamenteLayout);

                    layout.setVisibility(View.VISIBLE);

                } else {

                    boolean gameIsOver = true;

                    for (int jogaEstado : estadoJogo) {

                        if (jogaEstado == 2) gameIsOver = false;

                    }

                    if (gameIsOver) {

                        TextView mensagemVitoria = (TextView) findViewById(R.id.mensagemVitoria);

                        mensagemVitoria.setText("Empate!");

                        LinearLayout layout = (LinearLayout)findViewById(R.id.jogarNovamenteLayout);

                        layout.setVisibility(View.VISIBLE);

                    }

                }

            }
        }


    }

    public void jogarNovamente(View vistaBtn) {

        jogoAtivo = true;

        LinearLayout layout = (LinearLayout)findViewById(R.id.jogarNovamenteLayout);

        layout.setVisibility(View.INVISIBLE);

        jogadorAtivo = 0;

        for (int i = 0; i < estadoJogo.length; i++) {

            estadoJogo[i] = 2;

        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.novoJogoGridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {

            ((Button) gridLayout.getChildAt(i)).setBackgroundColor(Color.WHITE);

        }

    }

}
