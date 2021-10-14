package com.example.notebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    private EditText titleTextView;
    private EditText contentTextView;
    private int position;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        extras = getIntent().getExtras();
        titleTextView = findViewById(R.id.itemTitleTextView);
        contentTextView = findViewById(R.id.itemContentTextView);
        contentTextView.setHorizontallyScrolling(false);
        contentTextView.setLines(100);
        if (extras!=null){
            titleTextView.setText(extras.getString("title"));
            contentTextView.setText(extras.getString("content"));
            position = extras.getInt("position");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void savePressed(View view){
        MainActivity.notes.set(position, new Note(titleTextView.getText().toString(), contentTextView.getText().toString()));
        finish();
    }

    public void deletePressed(View view){
        MainActivity.notes.remove(position);
        finish();
    }
}