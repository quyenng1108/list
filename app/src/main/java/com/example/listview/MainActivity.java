package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    static ArrayList<Articles> articleData;
    CustomAdapter customAdapter;
    Button plus;
    Button minus;
    Articles articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        articleData = new ArrayList<Articles>();
        articleData.add(new Articles(
                "Learning to reset",
                "John Doe",
                "Apr 16 | 5 minutes read",
                R.drawable.image1
        ));
        articleData.add(new Articles(
                "Learning to Co-operate",
                "John Doe",
                "Apr 16 | 5 minutes read",
                R.drawable.image2
        ));

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        customAdapter = new CustomAdapter(context,articleData);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                if(position % 2 == 0) {
                    myWebLink.setData(Uri.parse("http://www.youtube.com"));
                } else {
                    myWebLink.setData(Uri.parse("http://www.facebook.com"));
                }
                startActivity(myWebLink);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = customAdapter.getCount();
                articleData.remove(customAdapter.getItem(i-1));
                customAdapter.notifyDataSetChanged();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                articleData.add(new Articles(
                        "Learning to Co-operate",
                        "John Doe",
                        "Apr 16 | 5 minutes read",
                        R.drawable.image2
                ));
                customAdapter.notifyDataSetChanged();
            }
        });
    }


}