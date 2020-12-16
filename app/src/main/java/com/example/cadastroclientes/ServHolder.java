package com.example.cadastroclientes;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.text.BreakIterator;

public class ServHolder extends ViewHolder {
    public TextView servFeito;
    public ImageButton btnExcluir;
    public TextView txtHoraServ;


    public ServHolder(@NonNull View itemView) {
        super(itemView);

        servFeito =(TextView) itemView.findViewById(R.id.txtServ);
        btnExcluir = (ImageButton) itemView.findViewById(R.id.btnDelete);
        txtHoraServ = (TextView) itemView.findViewById(R.id.txtHoraServ);
    }
}
