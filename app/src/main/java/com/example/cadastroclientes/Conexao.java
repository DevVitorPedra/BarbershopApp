package com.example.cadastroclientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cliente (Id Integer primary key autoincrement, "+
                "nome varchar(50),data varchar(15), telefone varchar (15),bairro varchar (15), lazer varchar (20), obs varchar(200), topete varchar(15), topo varchar(15), lateral varchar(15), Textura varchar(15)," +
                "encaixe varchar(15), acabamento varchar(15), taper varchar (15), observacao varchar (250))");

      //  db.execSQL("CREATE TABLE servico(nome  varchar(50) primary key unique,data varchar(15), topete varchar(15), topo varchar(15), lateral varchar(15), Textura varchar(15), " +
      //  "encaixe varchar (15), acabamento varchar(15), taper varchar (15), observacao varchar (250))" );



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
