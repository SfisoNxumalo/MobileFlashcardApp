package com.example.fsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText FTitle, Description;
    TextView lblDate;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();

        String flashcardID = intent.getStringExtra("flashcardID");
        String flashcardTitle = intent.getStringExtra("flashcardTitle");
        String flashcardDate = intent.getStringExtra("flashcardDate");
        String flashcardDesc = intent.getStringExtra("flashcardDesc");

        lblDate = findViewById(R.id.lblUFlashDate);
        FTitle = findViewById(R.id.txtUTitle);
        Description = findViewById(R.id.txtUDescription);
        btnSave = findViewById(R.id.btnUpdateFlashcard);

        lblDate.setText(flashcardDate);
        FTitle.setText(flashcardTitle);
        Description.setText(flashcardDesc);

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

                    FlashcardTable flashcardTable = new FlashcardTable(UpdateActivity.this);
                    flashcardTable.openDB();
                    flashcardTable.updateRecord(flashcardID,title,dt,desc);
                    Toast.makeText(getApplicationContext(), "successfully updated flash card.", Toast.LENGTH_SHORT).show();

                    FTitle.setText("");
                    Description.setText("");

                    flashcardTable.closeDB();

                    finish();
                }




            }
        });


    }
}