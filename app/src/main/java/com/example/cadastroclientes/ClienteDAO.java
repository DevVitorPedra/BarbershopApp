package com.example.cadastroclientes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;



    public ClienteDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }
    public long inserir(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", cliente.getNome());
        contentValues.put("telefone", cliente.getTelefone());
        contentValues.put("bairro", cliente.getBairro());
        contentValues.put("lazer", cliente.getLazer());
        contentValues.put("obs", cliente.getObs());
        return banco.insert("cliente", null, contentValues);

    }
    public List<Cliente> obterTodos(){
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = banco.query("cliente", new String[]{"id", "nome","data", "telefone", "bairro", "lazer", "obs","topete", "topo", "lateral", "textura", "encaixe", "acabamento", "taper", "observacao"}, null, null, null, null, null );

while (cursor.moveToNext()){

    Cliente a = new Cliente();
    a.setId(cursor.getInt(0));
    a.setNome(cursor.getString(1));
    a.setData(cursor.getString(2));
    a.setTelefone(cursor.getString(3));
    a.setBairro(cursor.getString(4));
    a.setLazer(cursor.getString(5));
    a.setObs(cursor.getString(6));
    a.setTopete(cursor.getString(7));
    a.setTopo(cursor.getString(8));
    a.setLateral(cursor.getString(9));
    a.setTextura(cursor.getString(10));
    a.setEncaixe(cursor.getString(11));
    a.setAcabamento(cursor.getString(12));
    a.setTaper(cursor.getString(13));
    a.setObservacao(cursor.getString(14));
    clientes.add(a);

}
return clientes;

    }
    public void Excluir(Cliente a){
        banco.delete("cliente","id = ?", new String[]{a.getId().toString()});
    }
    public void atualizar(Cliente cliente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", cliente.getNome());
        contentValues.put("telefone", cliente.getTelefone());
        contentValues.put("bairro", cliente.getBairro());
        contentValues.put("lazer", cliente.getLazer());
        contentValues.put("obs", cliente.getObs());
        banco.update("cliente", contentValues, "id = ?", new String[]{cliente.getId().toString()});

    }
    public long inserirServico(Cliente cliente) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data",cliente.getData());
        contentValues.put("topete", cliente.getTopete());
        contentValues.put("topo", cliente.getTopo());
        contentValues.put("lateral", cliente.getLateral());
        contentValues.put("textura", cliente.getTextura());
        contentValues.put("encaixe", cliente.getEncaixe());
        contentValues.put("acabamento", cliente.getAcabamento());
        contentValues.put("taper", cliente.getTaper());
        contentValues.put("observacao", cliente.getObservacao());
        return banco.insert("cliente", null, contentValues);
    }
    public void atualizarServ(Cliente cliente) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data",cliente.getData());
        contentValues.put("topete", cliente.getTopete());
        contentValues.put("topo", cliente.getTopo());
        contentValues.put("lateral", cliente.getLateral());
        contentValues.put("textura", cliente.getTextura());
        contentValues.put("encaixe", cliente.getEncaixe());
        contentValues.put("acabamento", cliente.getAcabamento());
        contentValues.put("taper", cliente.getTaper());
        contentValues.put("observacao", cliente.getObservacao());
        banco.update("cliente", contentValues, "nome = ?", new String[]{cliente.getNome()});
    }
    public List<Producao> obterControle(){
        List<Producao> controle = new ArrayList<>();
        Cursor cursor = banco.query("producao",new String[]{"id","servico","hora"},null,null,null,null,null);

        while   (cursor.moveToNext()){


            Producao a = new Producao();
            a.setId(cursor.getInt(0));
            a.setServicoFeito(cursor.getString(1));
            a.setHora(cursor.getString(2));
            controle.add(a);

        }
        cursor.close();
        return controle;
    }
    public long inserirControle(Producao producao){
        ContentValues contentValues = new ContentValues();
        contentValues.put("servico",producao.getServicoFeito());
        contentValues.put("hora",producao.getHora());
        return  banco.insert("producao",null,contentValues);

    }
    public void produExcluir(Producao a){
        banco.delete("producao","id =?",new String[]{a.getId().toString()});
    }

    public boolean excluir(int id){
        return conexao.getWritableDatabase().delete("producao", "id = ?", new String[]{id + ""})>0;
    }









}
//todo
//fazer as alterações para guardar a foto tbm
