package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Controle extends AppCompatActivity {



    ServAdapter adapter;
    private TextView txtTotal;
    private TextClock txtClock;

    private ClienteDAO dao;
    private RecyclerView lista;
    private List<Producao> controle = new ArrayList<>(20);
    private Button servCorTes, servCorMaq,servBarba,servInf,servAcab,servSobrancelha, servSelagem,servProgressiva,servCamu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);

        lista = findViewById(R.id.lista);
        txtTotal =findViewById(R.id.txtTotal);
        txtClock = findViewById(R.id.txtClock);

        //buttons
        servCorTes = findViewById(R.id.btnCorTes);
        servCorMaq = findViewById(R.id.btnCorMaq);
        servBarba  = findViewById(R.id.btnBarba);
        servInf    = findViewById(R.id.btnCorInf);
        servAcab   = findViewById(R.id.btnAcabCabelo);
        servSobrancelha = findViewById(R.id.btnSob);
        servProgressiva = findViewById(R.id.btnProgressiva);
        servCamu = findViewById(R.id.btnCamuCabelo);


        dao = new ClienteDAO(this);
        controle = dao.obterControle();

        configurarRecycler();


        registerForContextMenu(lista);


size();






    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = new MenuInflater(this);
        i.inflate(R.menu.menu_controle, menu);
    }
    public void configurarRecycler(){
        lista = (RecyclerView) findViewById(R.id.lista);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);

        adapter = new ServAdapter(dao.obterControle());
        lista.setAdapter(adapter);
        lista.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


    }



    @Override
    public void onResume(){
        super.onResume();


    }





    public void onClickBarba(View view){
        Producao producao = new Producao();
        producao.setServicoFeito("Barba");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }
    public void onClickCorInf(View view){
        Producao producao = new Producao();
        producao.setServicoFeito("Corte Infantil");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void onClickCorTes(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("corte Tesoura");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();


    }

    public void onClickCorMaq(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Corte maquina");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void myClick(View view) {
        int itemPosition = lista.getChildLayoutPosition(view);
        String item = controle.get(itemPosition).getServicoFeito();
        Toast.makeText(this,"item " + itemPosition,Toast.LENGTH_SHORT).show();
    }

    public void onClickAcabamento(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Acabamento");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void onClickSobrancelha(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Sobrancelha");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void onClickCamuflagem(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Camuflagem");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void onClickSelagem(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Selagem");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void onClickProgressiva(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Progressiva");
        producao.setHora(txtClock.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();

        finish();
    }
    public void size(){
     int i = adapter.getItemCount();
     txtTotal.setText("Total de serviços = "+ i);
    }

}