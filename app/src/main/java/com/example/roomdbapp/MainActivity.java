package com.example.roomdbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roomdbapp.DataBase.AppDatabase;
import com.example.roomdbapp.dao.ItemDAO;
import com.example.roomdbapp.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;
    private ItemDAO itemDAO;

    private Button bt_check_data;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = ((RoomDbApp)getApplicationContext()).getDatabase();

        bt_check_data = (Button)findViewById(R.id.bt_check_data);
        textView = (TextView)findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        itemDAO = database.getItemDAO();
        Item item = new Item();
        item.setName("Item001");
        item.setDescription("Item 001");
        item.setQuantity(Long.valueOf(1000));
        itemDAO.insert(item);

        bt_check_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });


    }

    private void fetchData() {

        List<Item> items = itemDAO.getItems();
        System.out.println("Bapi"+items.get(0).getName());

        textView.setText(items.get(0).getName());
    }
}
