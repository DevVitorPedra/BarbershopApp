package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteBarba extends AppCompatActivity implements Serializable {
    private Spinner spinnComprimento, spinnBrbLat, spinnBigode, spinnLinhaBochecha, spinnLinhaGogo;
    private EditText edtDetalhes;
    private Button btnSalvarBarba;
    private TextView data;

    private Cliente cliente = null;
    private ClienteDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_barba);
        spinnBigode = findViewById(R.id.spinnBigode);
        spinnBrbLat = findViewById(R.id.spinnBrbLat);
        spinnComprimento = findViewById(R.id.spinnComprimento);
        spinnLinhaBochecha = findViewById(R.id.spinnBochecha);
        spinnLinhaGogo = findViewById(R.id.spinnGogo);
        edtDetalhes = findViewById(R.id.edtDetalhes);
        btnSalvarBarba = findViewById(R.id.btnSalvarBarba);
        dao = new ClienteDAO(this);

        data = findViewById(R.id.txtDataBarba);
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date datahoraatual = new Date();
        String dataFormatada = formataData.format(datahoraatual);
        data.setText(dataFormatada);


        Intent At = getIntent();
        if (At.hasExtra("cliente")) {
            cliente = (Cliente) At.getSerializableExtra("cliente");
        }


        String[] bigode = {"Contorno Boca", "Natural", "Natural Baixo", "Fininho", "Mustache", "Outro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, bigode);
        spinnBigode.setAdapter(adapter);

        String[] laterais = {"0", "1", "2", "3", "Tesoura", "Liso", ""};
        ArrayAdapter<String> topoAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, laterais);
        spinnBrbLat.setAdapter(topoAdapter);

        String[] comprimento = {"Igual Laterais", " 1 dedo", "2 dedos", "3 dedos", "longa", "Spartana", "Quadrada", "Redonda"};
        ArrayAdapter<String> lateralAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, comprimento);
        spinnComprimento.setAdapter(lateralAdapter);
        String[] bochecha = {"Reta", "Curva Leve", "Curva Forte", "Natural", "Bem Marcada", "Xande de Pilares"};
        ArrayAdapter<String> texturaAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, bochecha);
        spinnLinhaBochecha.setAdapter(texturaAdapter);

        String[] gogo = {"Reto no gogo", "Inclinado no gogo", "Contorno maxilar", "Natural"};
        ArrayAdapter<String> encaixeAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, gogo);
        spinnLinhaGogo.setAdapter(encaixeAdapter);

    }

    public void salvarBarba(View view) {
        if (cliente == null) {


            cliente = new Cliente();
            cliente.setData(data.getText().toString());
            cliente.setBrbBigode(spinnBigode.getSelectedItem().toString());
            cliente.setBrbComp(spinnComprimento.getSelectedItem().toString());
            cliente.setBrbLat(spinnBrbLat.getSelectedItem().toString());
            cliente.setBrbLBochecha(spinnLinhaBochecha.getSelectedItem().toString());
            cliente.setBrbLGogo(spinnLinhaGogo.getSelectedItem().toString());
            cliente.setBrbDetalhes(edtDetalhes.getText().toString());

            dao.inserirBarba(cliente);
            Toast.makeText(this, "Serviço salvo", Toast.LENGTH_SHORT).show();
            finish();
        } else {

            cliente = new Cliente();
            cliente.setData(data.getText().toString());
            cliente.setBrbBigode(spinnBigode.getSelectedItem().toString());
            cliente.setBrbComp(spinnComprimento.getSelectedItem().toString());
            cliente.setBrbLat(spinnBrbLat.getSelectedItem().toString());
            cliente.setBrbLBochecha(spinnLinhaBochecha.getSelectedItem().toString());
            cliente.setBrbLGogo(spinnLinhaGogo.getSelectedItem().toString());
            cliente.setBrbDetalhes(edtDetalhes.getText().toString());

            dao.atualizarBarba(cliente);
            Toast.makeText(this, "Serviço atualizado", Toast.LENGTH_SHORT).show();
            finish();


        }
    }
}