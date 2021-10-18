package com.example.notebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.notebook.Feed;
import com.example.notebook.R;

import java.util.List;

public class FeedAdapter extends BaseAdapter {

    private List<Feed> feeds;
    private LayoutInflater layoutInflater;

    public FeedAdapter(Context context, List<Feed> feeds) {
        this.feeds = feeds;
        layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return feeds.size();
    }

    @Override
    public Object getItem(int i) {
        return feeds.get(i);
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
        if (feeds.get(i).getTitle().length() > 40) {
            titleTextView.setText((feeds.get(i).getTitle().substring(0, 40) + "..."));
        } else {
            titleTextView.setText(feeds.get(i).getTitle());
        }
        if (feeds.get(i).getContent().length()>70) {
            subtitleTextView.setText((feeds.get(i).getContent().substring(0, 70) + "..."));
        } else {
            subtitleTextView.setText(feeds.get(i).getContent());
        }
        return view;
    }
}
