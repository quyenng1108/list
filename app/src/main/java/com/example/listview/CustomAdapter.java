package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Articles> articlesData;
    private LayoutInflater layoutInflater;
    Articles articles;
    int resource;
    public CustomAdapter(Context context, ArrayList<Articles> articlesData) {
        this.context = context;
        this.articlesData = articlesData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return articlesData.size();
    }

    @Override
    public Object getItem(int position) {
        return articlesData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View rowView = view;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.row_view, null, true);
        }
        //link views
        ImageView imageView = rowView.findViewById(R.id.image);
        TextView title = rowView.findViewById(R.id.title);
        TextView author = rowView.findViewById(R.id.author);
        TextView date = rowView.findViewById(R.id.date);

        articles = articlesData.get(position);

        imageView.setImageResource(articles.getImg());
        title.setText(articles.getTitle());
        author.setText(articles.getAuthor());
        date.setText(articles.getDate());

        return rowView;

    }

}
