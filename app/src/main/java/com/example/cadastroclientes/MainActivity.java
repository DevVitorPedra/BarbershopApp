package com.example.cadastroclientes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnAtualizar, btnPesquisar, btnControle, btnAgenda, btnImportar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Cadastrar(View view) {
        Intent et = new Intent(MainActivity.this, CadastroClientes.class);
        startActivity(et);
    }
    public void Pesquisar(View view){
        Intent it = new Intent(MainActivity.this, ListarClientes.class);
        startActivity(it);
    }
    public void Controle(View view){
        Intent CS = new Intent(MainActivity.this, Controle.class);
        startActivity(CS);
    }
    public void Agenda(View view){
        Intent Ag = new Intent(MainActivity.this, Agenda.class);
        startActivity(Ag);

    }

}

