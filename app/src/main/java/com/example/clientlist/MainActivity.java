package com.example.clientlist;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.clientlist.data.AppDatabase;
import com.example.clientlist.data.RecyclingCenterDAO;
import com.example.clientlist.util.RecyclingAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onResume(){
        super.onResume();
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class,"mydb").allowMainThreadQueries().build();
        RecyclingCenterDAO recyclingCenterDAO = database.getRecyclingCenterDAO();
        RecyclingAdapter adapter = new RecyclingAdapter(recyclingCenterDAO.getRecyclingCenterList(),this);
        recyclerView.setAdapter(adapter);
    }
    public void add(View view){
        Intent intent = new Intent(this, AddRecycler.class);
        startActivity(intent);
    }
}
