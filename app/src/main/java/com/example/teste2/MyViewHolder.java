package com.example.teste2;


import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste2.db.MyDataSource;

public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener, PopupMenu.OnMenuItemClickListener {


    TextView nameview, nota1view, nota2view, mediaview, statusview;
    LinearLayout linear;

    MyDataSource dataSource = new MyDataSource(itemView.getContext());
    dataSource.open();


    public MyViewHolder(@NonNull View itemview) {
        super(itemview);
        nota1view = itemview.findViewById(R.id.tvNota1);
        nameview = itemview.findViewById(R.id.tvName);
        nota2view = itemview.findViewById(R.id.tvNota2);
        mediaview = itemview.findViewById(R.id.tvMedia);
        statusview = itemview.findViewById(R.id.tvStatus);
        linear = itemview.findViewById(R.id.linear);

        linear.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        showPopupMenu(view);
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), linear);
        popupMenu.inflate(R.menu.popmenu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.update){
            update();
            return true;
        }else if (id == R.id.remover){
            remove();
            return true;
        }else {
            return false;
        }
    }

    private void update() {

    }

    private void remove(){

    }

    public long getItemId(int position) {
        if (students != null && position >= 0 && position < students.size()) {
            return students.get(position).getId();
        }
        return -1; // Retorna -1 se a posição for inválida ou a lista de students for nula
    }


}


