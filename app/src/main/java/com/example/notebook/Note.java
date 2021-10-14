package com.example.notebook;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Note {
    private String title;
    private String content;
    private LocalDateTime created;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.created = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
