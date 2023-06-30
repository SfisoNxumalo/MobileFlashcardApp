package com.example.fsa;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    private Context context;

    private Cursor cursor;

    public CustomAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_layout, null);

        TextView flashcardID = view.findViewById(R.id.FlashcardID);
        TextView flashcardTitle = view.findViewById(R.id.FlashcardTitle);
        TextView flashcardDate = view.findViewById(R.id.FlashcardDate);
        TextView flashcardDesc = view.findViewById(R.id.flashcardDesc);

        cursor.moveToPosition(i);

        flashcardID.setText(cursor.getString(0));
        flashcardTitle.setText(cursor.getString(1));
        flashcardDate.setText(cursor.getString(2));
        flashcardDesc.setText(cursor.getString(3));


        return view;
    }
}
