package com.example.cadastroclientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    ClienteDAO dao;

    private static final String name = "banco.db";
    private static final int DATABASE_VERSION = 1;


    public Conexao(@Nullable Context context) {
        super(context, name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cliente (Id Integer primary key autoincrement, "+
                "nome varchar(50),data varchar(15), telefone varchar (15),bairro varchar (15), lazer varchar (20), obs varchar(200), topete varchar(15), topo varchar(15), lateral varchar(15), Textura varchar(15)," +
                "encaixe varchar(15), acabamento varchar(15), taper varchar (15), observacao varchar (250),barbacomp varchar(20),barbalat varchar(20),bigode varchar(20),linhabochecha varchar(20)," +
                "linhagogo varchar(20),detalhes varchar(20))");
        db.execSQL("CREATE TABLE producao(id Integer primary key autoincrement,servico varchar(30), hora varchar(20)) ");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



        }



}
/*
ja foram adicionadas
            db.execSQL("ALTER TABLE cliente ADD COLUMN barbacomp varchar(20)");
            db.execSQL("ALTER TABLE cliente ADD COLUMN barbalat varchar(20)");
            db.execSQL("ALTER TABLE cliente ADD COLUMN bigode varchar(20)");
            db.execSQL("ALTER TABLE cliente ADD COLUMN linhabochecha varchar(20)");
            db.execSQL("ALTER TABLE cliente ADD COLUMN linhagogo varchar(20)");
            db.execSQL("ALTER TABLE cliente ADD COLUMN detalhes varchar(20)");


 */

