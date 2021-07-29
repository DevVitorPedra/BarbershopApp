package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Servico extends AppCompatActivity implements Serializable {
    private Spinner spinnTopete, spinnTopo, spinnLateral,spinnTextura, spinnEncaixe, spinnDetalhe,spinnTaper;
    private EditText observacao;
    private TextView Data;
    private ImageView imgFoto;
    private Bitmap bitmap;


    private static final int CAMERA_REQUEST = 123;



    private Cliente cliente = null;
    private ClienteDAO dao;
    private EditText nome;
    private Button btnExibirFotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);
        btnExibirFotos = findViewById(R.id.btnExibirFotos);
        btnExibirFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);

            }
        });


        Intent At = getIntent();
        if(At.hasExtra("cliente")){
            cliente = (Cliente) At.getSerializableExtra("cliente");
        }





        Data = findViewById(R.id.txtData);
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date datahoraatual = new Date();
        String dataFormatada = formataData.format(datahoraatual);
        Data.setText(dataFormatada);


        imgFoto = findViewById(R.id.imgFoto);
        nome = findViewById(R.id.edtNome);
        spinnTopete = findViewById(R.id.spinnTopete);
        spinnTopo = findViewById(R.id.spinnTopo);
        spinnLateral = findViewById(R.id.spinnLateral);
        spinnTextura = findViewById(R.id.spinnTextura);
        spinnEncaixe = findViewById(R.id.spinnEncaixe);
        spinnDetalhe = findViewById(R.id.spinnDetalhe);
        spinnTaper = findViewById(R.id.spinnTaper);
        observacao = findViewById(R.id.edtObsServ);
        dao = new ClienteDAO(this);


        String[] topete = {"1 dedo","dedo e meio","2 dedos","3 dedos", "4 dedos", "longo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,topete);
        spinnTopete.setAdapter(adapter);

        String[] topo = {"1 dedo","dedo e meio","2 dedos","3 dedos", "4 dedos", "longo"};
        ArrayAdapter<String> topoAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,topo);
        spinnTopo.setAdapter(topoAdapter);

        String[] lateral = {"Degra 0","Degra 1","maquina 1", "maquina 2", "maquina 3","1 dedo","dedo e meio","2 dedos","3 dedos", "4 dedos"};
        ArrayAdapter<String> lateralAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,lateral);
        spinnLateral.setAdapter(lateralAdapter);
        String[] textura = {"Sem texturas", "dentada nas pontas","redução de volume","45º", "deep cut"};
        ArrayAdapter<String> texturaAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, textura);
        spinnTextura.setAdapter(texturaAdapter);

        String[] encaixe = { "reto", "arredondado","45º pra fora"};
        ArrayAdapter<String> encaixeAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, encaixe);
        spinnEncaixe.setAdapter(encaixeAdapter);

        String[] acabamento = {"suave", "bem desenhado","sem acabamento"};
        ArrayAdapter<String> acabamentoAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, acabamento);
        spinnDetalhe.setAdapter(acabamentoAdapter);

        String[] taper = {"Não", "0", "1","1,5","2", "3", "Clipper"};
        ArrayAdapter<String> taperAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, taper);
        spinnTaper.setAdapter(taperAdapter);

    }



    public void salvar(View view) {
        if (cliente == null) {


            cliente = new Cliente();
            cliente.setData(Data.getText().toString());
            cliente.setTopete(spinnTopete.getSelectedItem().toString());
            cliente.setTopo(spinnTopo.getSelectedItem().toString());
            cliente.setLateral(spinnLateral.getSelectedItem().toString());
            cliente.setTextura(spinnTextura.getSelectedItem().toString());
            cliente.setEncaixe(spinnEncaixe.getSelectedItem().toString());
            cliente.setAcabamento(spinnDetalhe.getSelectedItem().toString());
            cliente.setTaper(spinnTaper.getSelectedItem().toString());
            cliente.setObservacao(observacao.getText().toString());

            dao.inserirServico(cliente);
            Toast.makeText(this, "Serviço salvo", Toast.LENGTH_SHORT).show();
            finish();
        }else{

            cliente.setData(Data.getText().toString());
            cliente.setTopete(spinnTopete.getSelectedItem().toString());
            cliente.setTopo(spinnTopo.getSelectedItem().toString());
            cliente.setLateral(spinnLateral.getSelectedItem().toString());
            cliente.setTextura(spinnTextura.getSelectedItem().toString());
            cliente.setEncaixe(spinnEncaixe.getSelectedItem().toString());
            cliente.setAcabamento(spinnDetalhe.getSelectedItem().toString());
            cliente.setTaper(spinnTaper.getSelectedItem().toString());
            cliente.setObservacao(observacao.getText().toString());
            dao.atualizarServ(cliente);
            Toast.makeText(this, "Serviço atualizado", Toast.LENGTH_SHORT).show();
            finish();

        }
    }
    public void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgFoto.setImageBitmap(bitmap);










        }

    }

//todo
    //montar layout para receber a foto
    //setar o campo de inserção no new cliente

}
