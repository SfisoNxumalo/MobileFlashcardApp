package com.example.fsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateActivity extends AppCompatActivity {

    EditText FTitle, Description;
    TextView lblDate;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        lblDate = findViewById(R.id.lblFlashDate);
        FTitle = findViewById(R.id.txtTitle);
        Description = findViewById(R.id.txtDescription);
        btnSave = findViewById(R.id.btnAddFlashcard);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String EntryDate = sdf.format(date);
        lblDate.setText(EntryDate);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(FTitle.getText().toString().isEmpty() || Description.getText().toString().isEmpty() || lblDate.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "not empty fields allowed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String title = FTitle.getText().toString();
                    String desc = Description.getText().toString();
                    String dt = lblDate.getText().toString();

                    FlashcardTable flashcardTable = new FlashcardTable(CreateActivity.this);
                    flashcardTable.openDB();
                    flashcardTable.insertRecord(title,dt,desc);
                    Toast.makeText(getApplicationContext(), "successfully submitted.", Toast.LENGTH_SHORT).show();

                    FTitle.setText("");
                    Description.setText("");

                    flashcardTable.closeDB();
                }
            }
        });


    }
}