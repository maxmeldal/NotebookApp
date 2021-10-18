package com.example.notebook;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class RSSParser{

    public static ArrayList<Feed> getFeeds () throws IOException {
        ArrayList<Feed> feeds = new ArrayList<>();

        Document doc = Jsoup.connect("https://www.livemint.com/rss/AI").get();

        Elements elements = doc.select("item");
        for (Element e : elements) {
            feeds.add(new Feed(e.select("title").text(), e.select("description").text(), e.select("link").text()));
        }

        return feeds;
    }
}
