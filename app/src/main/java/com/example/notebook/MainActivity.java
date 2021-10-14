package com.example.notebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.notebook.adapter.NoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    public static List<Note> notes = new ArrayList<>();
    private NoteAdapter noteAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        noteAdapter = new NoteAdapter(this, notes);
        listView.setAdapter(noteAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, ItemActivity.class);
            intent.putExtra("title", notes.get(i).getTitle());
            intent.putExtra("content", notes.get(i).getContent());
            intent.putExtra("position", i);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addPressed (View view){
        notes.add(new Note("Title", "Content"));
        noteAdapter.notifyDataSetChanged();
    }
}