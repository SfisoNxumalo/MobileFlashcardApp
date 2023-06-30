package com.example.fsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ReadActivity extends AppCompatActivity {
    ListView lst;
    Cursor cursor;
    int intListViewItemPosition;

    TextView lblOutput;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        lst = findViewById(R.id.lstReadView);
        lblOutput = findViewById(R.id.empty);

        updateListView();
        registerForContextMenu(lst);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Hold Item for options", Toast.LENGTH_LONG).show();
            }
        });

        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                intListViewItemPosition=i;

                return false;
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Menu");

        menu.add("Edit");
        menu.add("Delete");

        Toast.makeText(ReadActivity.this, "" + menu.size(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.toString())
        {
            case "Edit":
                cursor.moveToPosition(intListViewItemPosition);

                String flashcardID = cursor.getString(0);
                String flashcardTitle = cursor.getString(1);
                String flashcardDate = cursor.getString(2);
                String flashcardDesc = cursor.getString(3);

                Intent update = new Intent(ReadActivity.this, UpdateActivity.class);
                update.putExtra("flashcardID", flashcardID);
                update.putExtra("flashcardTitle", flashcardTitle);
                update.putExtra("flashcardDate", flashcardDate);
                update.putExtra("flashcardDesc", flashcardDesc);
                startActivity(update);

            break;

                case "Delete":
                    cursor.moveToPosition(intListViewItemPosition);

                    String ID = cursor.getString(0);
                    FlashcardTable flashcardTable = new FlashcardTable(ReadActivity.this);
                    flashcardTable.openDB();
                    flashcardTable.deleteRecord(ID);
                    Toast.makeText(getApplicationContext(), "Deletion successful", Toast.LENGTH_LONG).show();
                    flashcardTable.closeDB();
                    break;

            default:
                Toast.makeText(ReadActivity.this, "Incorrect Selection.", Toast.LENGTH_SHORT).show();
                break;
        }
        updateListView();
        return true;
    }

    void updateListView()
    {
        FlashcardTable flashcardTable = new FlashcardTable(ReadActivity.this);
        flashcardTable.openDB();
        cursor = flashcardTable.getAllRecords();
        CustomAdapter customAdapter = new CustomAdapter(ReadActivity.this, cursor);
        lst.setAdapter(customAdapter);
        flashcardTable.closeDB();

        if(cursor.getCount() > 0)
        {
            lblOutput.setVisibility(View.GONE);
        }
    }
}