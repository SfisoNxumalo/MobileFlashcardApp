package com.example.fsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout add, Update, Delete, View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.LLdd);
        View = findViewById(R.id.LLView);
        Delete = findViewById(R.id.LLDelete);
        Update = findViewById(R.id.LLUpdate);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(add);
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent other = new Intent(MainActivity.this, ReadActivity.class);
                startActivity(other);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent other = new Intent(MainActivity.this, ReadActivity.class);
                Toast.makeText(MainActivity.this, "Select to delete", Toast.LENGTH_LONG).show();
                startActivity(other);
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent other = new Intent(MainActivity.this, ReadActivity.class);
                Toast.makeText(MainActivity.this, "Select to edit", Toast.LENGTH_LONG).show();
                startActivity(other);
            }
        });




    }
}