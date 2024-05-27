package com.example.artur3;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;



public class ContactActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> namesList;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        listView = findViewById(R.id.list_view);

        namesList = getIntent().getStringArrayListExtra("nameList");

        if (namesList == null) {
            namesList = new ArrayList<>();
        }

        adapter = new ContactAdapter(this, R.layout.name_item, namesList);
        listView.setAdapter(adapter);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
