package com.diegocasas.festival;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.diegocasas.festival.Adapter.CustomAdapter;
import com.diegocasas.festival.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class Programa extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    List<Item> items;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initItem();
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void initItem() {
        items = new ArrayList<>();

        items.add(new Item(0,"New","FESTIVAL CULTURAL 1","https://www.zonaturistica.com/files/ferias/727/F5_727.jpg"));
        items.add(new Item(1,"Hot","FESTIVAL CULTURAL 2","https://www.zonaturistica.com/files/ferias/727/F5_727.jpg"));
        items.add(new Item(1,"Hot","FESTIVAL CULTURAL 3","https://www.zonaturistica.com/files/ferias/727/F5_727.jpg"));
        items.add(new Item(0,"New","FESTIVAL CULTURAL 4","https://www.zonaturistica.com/files/ferias/727/F5_727.jpg"));
        items.add(new Item(2,"","FESTIVAL CULTURAL 5","https://www.zonaturistica.com/files/ferias/727/F5_727.jpg"));

        adapter = new CustomAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    public void evento(View view){
        Intent intent = new Intent(Programa.this, Evento.class);
        startActivity(intent);
    }
}
