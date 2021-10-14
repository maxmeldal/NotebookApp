package com.example.notebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.notebook.Note;
import com.example.notebook.R;

import java.util.List;

public class NoteAdapter extends BaseAdapter {

    private List<Note> notes;
    private LayoutInflater layoutInflater;

    public NoteAdapter(Context context, List<Note> notes) {
        this.notes = notes;
        layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.notesrow, null);
        }
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView subtitleTextView = view.findViewById(R.id.subtitleTextView);
        if (notes.get(i).getTitle().length() > 10) {
            titleTextView.setText((notes.get(i).getTitle().substring(0, 10) + "..."));
        }
        if (notes.get(i).getContent().length()>30) {
            subtitleTextView.setText((notes.get(i).getContent().substring(0, 30) + "..."));
        }
        return view;
    }
}
