package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CadastroClientes extends AppCompatActivity {
    private EditText nome, telefone, bairro, lazer, obs;
    private ClienteDAO dao;
    private Cliente cliente = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_clientes);
        nome = findViewById(R.id.edtNome);
        telefone = findViewById(R.id.edtTelefone);
        bairro = findViewById(R.id.edtBairro);
        lazer  = findViewById(R.id.edtLazer);
        obs     = findViewById(R.id.edtObs);
        dao = new ClienteDAO(this);

        Intent At = getIntent();
        if(At.hasExtra("cliente")){
            cliente = (Cliente) At.getSerializableExtra("cliente");
            nome.setText(cliente.getNome());
            telefone.setText(cliente.getTelefone());
            bairro.setText(cliente.getBairro());
            lazer.setText(cliente.getLazer());
            obs.setText(cliente.getObs());
        }


    }
    public void salvar(View view){
        if (cliente == null) {

        cliente = new Cliente();
        cliente.setNome(nome.getText().toString());
        cliente.setTelefone(telefone.getText().toString());
        cliente.setBairro(bairro.getText().toString());
        cliente.setLazer(lazer.getText().toString());
        cliente.setObs(obs.getText().toString());
            if (isNomeEmpty(nome.getText().toString())) {
                nome.requestFocus();
                Toast.makeText(this, "Digite um nome", Toast.LENGTH_SHORT).show();

            }else{
                dao.inserir(cliente);
                Toast.makeText(this, getString(R.string.Cadastro_Realizado) , Toast.LENGTH_SHORT).show();
                finish();
            }

        }else{
            if (isNomeEmpty(nome.getText().toString())) {
                nome.requestFocus();
                Toast.makeText(this, "Digite um nome", Toast.LENGTH_SHORT).show();
            }else {
                cliente.setNome(nome.getText().toString());
                cliente.setTelefone(telefone.getText().toString());
                cliente.setBairro(bairro.getText().toString());
                cliente.setLazer(lazer.getText().toString());
                cliente.setObs(obs.getText().toString());
                dao.atualizar(cliente);
                Toast.makeText(this, getString(R.string.Cadastro_Atualizado), Toast.LENGTH_SHORT).show();
                finish();
            }
        }

    }
    public boolean isNomeEmpty(String valor){
        boolean resultado = (TextUtils.isEmpty(valor)|| valor.trim().isEmpty());
        return resultado;

    }



}