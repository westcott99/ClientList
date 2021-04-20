package com.example.clientlist.util;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.InvalidationTracker;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.clientlist.R;
import com.example.clientlist.data.AppDatabase;
import com.example.clientlist.data.RecyclingCenter;
import com.example.clientlist.data.RecyclingCenterDAO;

import java.util.List;

public class RecyclingAdapter extends RecyclerView.Adapter<RecyclingAdapter.ViewHolder> {

    List<RecyclingCenter>client;
    Context context;

    public RecyclingAdapter(List<RecyclingCenter>client,Context context){
        this.context = context;
        this.client = client;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View clientView = inflater.inflate(R.layout.item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(clientView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        RecyclingCenter recyclingCenter = client.get(i);
        viewHolder.name.setText("Nombre: "+recyclingCenter.getName());
        viewHolder.address.setText("Direccion: "+recyclingCenter.getAddress());
        viewHolder.email.setText("Email: "+recyclingCenter.getEmail());
        viewHolder.phone.setText("Telefono: "+recyclingCenter.getPhone());
        viewHolder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        viewHolder.btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return client.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address;
        TextView email;
        TextView phone;
        Button btndelete;
        Button btnagregar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            btndelete = itemView.findViewById(R.id.btndelete);
            btnagregar = itemView.findViewById(R.id.btnagregar);
        }
    }
}
