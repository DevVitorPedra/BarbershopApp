package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Controle extends AppCompatActivity {


    private EditText edtCaraio;

    private ClienteDAO dao;
    private ListView lista;
    private List<Producao> controle = new ArrayList<>(20);
    private Button servCorTes, servCorMaq,servBarba,servInf,servAcab,servSobrancelha, servSelagem,servProgressiva,servCamu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);

        lista = findViewById(R.id.lista);
        edtCaraio =findViewById(R.id.txtCaraio);

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


        ArrayAdapter<Producao> adaptadores = new ArrayAdapter<Producao>(this, android.R.layout.simple_list_item_1, controle);
        lista.setAdapter(adaptadores);



        registerForContextMenu(lista);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = new MenuInflater(this);
        i.inflate(R.menu.menu_controle, menu);
    }

    @Override
    public void onResume(){
        super.onResume();
        controle= dao.obterControle();
        controle.clear();
        lista.invalidateViews();
    }
    public void apagar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Producao apagar = controle.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("ATENÇÃO")
                .setMessage("Deseja excluir este serviço?")
                .setNegativeButton("NÂO",null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controle.remove(apagar);
                        dao.produExcluir(apagar);
                        lista.invalidateViews();



                    }

                }).create();


        dialog.show();


    }




    public void onClickBarba(){
        Producao producao = new Producao();
        producao.setServicoFeito(servBarba.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }
    public void onClickCorInf(){
        Producao producao = new Producao();
        producao.setServicoFeito(servInf.getText().toString());
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

    public void onClickCorTes(View view) {
        edtCaraio.setText(servCorTes.getText());
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();

    }

    public void onClickCorMaq(View view) {
        Producao producao = new Producao();
        producao.setServicoFeito("Corte maquina ");
        dao.inserirControle(producao);
        Toast.makeText(this,"Serviço inserido",Toast.LENGTH_SHORT ).show();
        finish();
    }

}
//todo
//corrigir linha 88, esta dando erro porem tem a mesma linha na act listar