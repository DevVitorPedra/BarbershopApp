package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class BarbaAtual extends AppCompatActivity  implements Serializable {
   private TextView edtCompBarba2,edtBarbLat2,edtBigode2,edtBarbBochecha2,edtLinhaGogo2,edtBarbDetalhes2;

    private Cliente cliente;
    private ClienteDAO dao;
    private SQLiteDatabase banco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barba_atual);


        dao = new ClienteDAO(this);


        edtCompBarba2 =findViewById(R.id.edtCompBarba2);
        edtBarbLat2 =findViewById(R.id.edtBarbLat2);
        edtBigode2 = findViewById(R.id.edtBigode2);
        edtBarbBochecha2 =findViewById(R.id.edtBarbBochecha2);
        edtLinhaGogo2 = findViewById(R.id.edtLinhaGogo2);
        edtBarbDetalhes2 =findViewById(R.id.edtBarbDetalhes2);


        Intent At = getIntent();
        if (At.hasExtra("cliente")){
            cliente = (Cliente) At.getSerializableExtra("cliente");
            edtCompBarba2.setText(cliente.getBrbComp());
            edtBarbLat2.setText(cliente.getBrbLat());
            edtBigode2.setText(cliente.getBrbBigode());
            edtBarbBochecha2.setText(cliente.getBrbLBochecha());
            edtLinhaGogo2.setText(cliente.getBrbLGogo());
            edtBarbDetalhes2.setText(cliente.getBrbDetalhes());
        }

    }
}