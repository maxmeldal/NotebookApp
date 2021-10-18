package com.example.notebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.notebook.adapter.NoteAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    public static List<Feed> feeds = new ArrayList<>();
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        noteAdapter = new NoteAdapter(this, feeds);
        fillList();
        listView.setAdapter(noteAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, ItemActivity.class);
            intent.putExtra("title", feeds.get(i).getTitle());
            intent.putExtra("content", feeds.get(i).getContent());
            intent.putExtra("url", feeds.get(i).getUrl());
            intent.putExtra("position", i);
            startActivity(intent);
        });
    }

    public void fillList(){
        Thread thread = new Thread(){
            public void run(){
                try {
                    feeds.addAll(RSSParser.getFeeds());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        noteAdapter.notifyDataSetChanged();
        thread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

    public void addPressed (View view){
        feeds.add(new Feed("Title", "Content", "Url"));
        noteAdapter.notifyDataSetChanged();
    }
}