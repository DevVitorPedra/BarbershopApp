package com.example.cadastroclientes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListarClientes extends AppCompatActivity implements Serializable {

    private ListView listView;
    private ClienteDAO dao;
    private List<Cliente> clientes;
    private List<Cliente> clientesFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);
        listView = findViewById(R.id.listaClientes);
        dao = new ClienteDAO(this);
        clientes = dao.obterTodos();
        clientesFiltrados.addAll(clientes);
        ArrayAdapter<Cliente> adaptador = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientesFiltrados);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ProcurarClientes(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ProcurarClientes(s);
                return false;
            }
        });
        return true;


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = new MenuInflater(this);
        i.inflate(R.menu.menu_contexto, menu);
    }

    public void ProcurarClientes(String nome) {
        clientesFiltrados.clear();
        for (Cliente a : clientes) {
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                clientesFiltrados.add(a);
            }
        }
        listView.invalidateViews();
    }

    public void Cadastrar(MenuItem menu) {
        Intent it = new Intent(this, CadastroClientes.class);
        startActivity(it);


    }

    @Override
    public void onResume() {
        super.onResume();
        clientes = dao.obterTodos();
        clientesFiltrados.clear();
        clientesFiltrados.addAll(clientes);
        listView.invalidateViews();
    }

    public void Excluir(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Cliente clienteExcluir = clientesFiltrados.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("ATENÇÃO")
                .setMessage("Deseja excluir este cliente?")
                .setNegativeButton("NÂO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clientesFiltrados.remove(clienteExcluir);
                        clientes.remove(clienteExcluir);
                        dao.Excluir(clienteExcluir);
                        listView.invalidateViews();


                    }

                }).create();


        dialog.show();

    }

    public void atualizar(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Cliente clienteAtualizar = clientesFiltrados.get(menuInfo.position);

        Intent At = new Intent(this, CadastroClientes.class);
        At.putExtra("cliente", clienteAtualizar);
        startActivity(At);

    }

    public void salvarServico(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Cliente clienteAtualizar = clientesFiltrados.get(menuInfo.position);

        Intent At = new Intent(this, Servico.class);
        At.putExtra("cliente", clienteAtualizar);
        startActivity(At);

    }

    public void ServicoCadastrado(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Cliente clienteAtualizar = clientesFiltrados.get(menuInfo.position);

        Intent At = new Intent(this, ServicoAtual.class);
        At.putExtra("cliente", clienteAtualizar);
        startActivity(At);
    }
}

