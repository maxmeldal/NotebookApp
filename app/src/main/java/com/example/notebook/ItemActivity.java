package com.example.notebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ItemActivity extends AppCompatActivity {
    private EditText titleTextView;
    private EditText contentTextView;
    private String url;
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
            url = extras.getString("url");
            position = extras.getInt("position");
        }
    }

    public void savePressed(View view){
        MainActivity.feeds.set(position, new Feed(titleTextView.getText().toString(), contentTextView.getText().toString(), url));
        finish();
    }

    public void deletePressed(View view){
        MainActivity.feeds.remove(position);
        finish();
    }

    public void openLinkPressed(View view){
        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);    }
}