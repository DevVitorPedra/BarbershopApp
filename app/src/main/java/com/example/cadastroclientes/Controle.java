package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Controle extends AppCompatActivity {
    private TextView txtCorteTesoura, txtCorteMaquina,txtBarba, txtAcabCabelo,txtAcabBarba, txtSobrancelha, txtSelagem, txtProgressiva, txtCamuCabelo, txtCamuBarba;
    private EditText edtCorteCabelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);

        txtCorteTesoura = findViewById(R.id.txtCorteTesoura);
        txtCorteMaquina = findViewById(R.id.txtCorteMaquina);
        txtBarba = findViewById(R.id.txtBarba);
        txtAcabBarba = findViewById(R.id.txtAcabBarba);
        txtAcabCabelo = findViewById(R.id.txtAcabCabelo);
        txtCamuBarba = findViewById(R.id.txtCamuBarba);
        txtCamuCabelo = findViewById(R.id.txtCamuCabelo);
        txtSobrancelha = findViewById(R.id.txtSobrancelha);
        txtSelagem = findViewById(R.id.txtSelagem);
        txtProgressiva = findViewById(R.id.txtProgressiva);
    }
}