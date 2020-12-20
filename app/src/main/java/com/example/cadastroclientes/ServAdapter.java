package com.example.cadastroclientes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ServAdapter extends RecyclerView.Adapter<ServHolder> {
    public final List<Producao> controle;

    public ServAdapter(List<Producao> controle) {
        this.controle = controle;

    }

    @NonNull
    @Override
    public ServHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ServHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ServHolder holder, int position) {
        holder.servFeito.setText(controle.get(position).getServicoFeito());
        holder.txtHoraServ.setText(controle.get(position).getHora());

        final Producao producao =controle.get(position);
        holder.btnExcluir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("confirmação").setMessage("Tem certeza que deseja excluir?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Producao producao = controle.get(position);
                        ClienteDAO dao = new ClienteDAO(view.getContext());
                        boolean sucesso = dao.excluir(producao.getId());
                        if(sucesso){
                            removerProducao(producao);
                            Snackbar.make(view,"Serviço excluido",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                        }else{
                            Snackbar.make(view,"Não excluido",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                        }

                    }
                }).setNegativeButton("cancelar", null).create().show();

            }
        });





    }


    @Override
    public int getItemCount() {
        return controle.size();



    }

    public void addProd(Producao producao){
        controle.add(producao);
        notifyItemInserted(getItemCount());
    }
    public void removerProducao(Producao producao){
        int position = controle.indexOf(producao);
        controle.remove(position);
        notifyDataSetChanged(
        );



        }

    }


