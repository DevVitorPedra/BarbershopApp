package com.example.cadastroclientes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicoAtual extends AppCompatActivity implements Serializable {
    private Cliente cliente;
    private ClienteDAO dao;
    private SQLiteDatabase banco;
    private TextView edtNome, edtTopete, edtTopo, edtLateral, edtTextura, edtEncaixe, edtAcabamento, edtTaper, edtObs, edtData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_atual);
        dao = new ClienteDAO(this);

        edtNome = findViewById(R.id.edtNome);
        edtData = findViewById(R.id.edtData);
        edtTopete = findViewById(R.id.edtTopete);
        edtTopo = findViewById(R.id.edtTopo);
        edtLateral = findViewById(R.id.edtLateral);
        edtTextura = findViewById(R.id.edtTextura);
        edtEncaixe = findViewById(R.id.edtEncaixe);
        edtAcabamento = findViewById(R.id.edtAcabamento);
        edtTaper = findViewById(R.id.edtTaper);
        edtObs = findViewById(R.id.edtObs);


        Intent At = getIntent();
        if (At.hasExtra("cliente")) {
            cliente = (Cliente) At.getSerializableExtra("cliente");
            edtNome.setText(cliente.getNome());
            edtData.setText(cliente.getData());
            edtTopete.setText(cliente.getTopete());
            edtTopo.setText(cliente.getTopo());
            edtLateral.setText(cliente.getLateral());
            edtTextura.setText(cliente.getTextura());
            edtEncaixe.setText(cliente.getEncaixe());
            edtAcabamento.setText(cliente.getAcabamento());
            edtTaper.setText(cliente.getTaper());
            edtObs.setText(cliente.getObservacao());




        }
    }
}
//todo
//fazer a inserção da foto aki tbm