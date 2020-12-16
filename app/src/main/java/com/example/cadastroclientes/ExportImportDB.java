package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ExportImportDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_import_d_b);
    }

    public void importDB(View view) {
        File dir = Environment.getExternalStorageDirectory();
        File sd = new File(String.valueOf(dir));
        File data =Environment.getDataDirectory();
        FileChannel src = null;
        FileChannel dst = null;

        String backupDBPath= "/data/user/0/com.example.cadastroclientes/databases/banco.db";
        String currentDBPath = "BackupFolder/banco.db";

        File currentDB = new File (data, currentDBPath);
        File backupDB = new File(sd,backupDBPath);
        try {
            src =new FileInputStream(currentDB).getChannel();
            dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src,0,src.size());
            src.close();
            dst.close();
            Toast.makeText(this,"Banco de dados importado", Toast.LENGTH_SHORT).show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void exportDB(View view) {
        File sd = Environment.getExternalStorageDirectory();
        File data =Environment.getDataDirectory();
        FileChannel src = null;
        FileChannel dst = null;

        String currentDBPath = "/data/user/0/com.example.cadastroclientes/databases/banco.db";
        String backupDBPath = "BackupFolder/banco.db";

        File currentDB = new File (data, currentDBPath);
        File backupDB = new File(sd,backupDBPath);
        try {
            src = new FileInputStream(currentDB).getChannel();
            dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src,0,src.size());
            src.close();
            dst.close();
            Toast.makeText(this,"Banco de dados Exportado", Toast.LENGTH_SHORT).show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}