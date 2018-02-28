package com.example.android.dictionaryawesome;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    private static final String[] WORDS = {
            "mediocre", "Berkeley University",
            "uderachiever", "Stanford A- student",
            "jerk", "Marty Stepp"
    };

    private Map<String,String > dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        for (int i = 0; i<WORDS.length;i+=2){
            dictionary.put(WORDS[i],WORDS[i + 1]);
        }

        final ListView list = findViewById(R.id.word_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // activity
                android.R.layout.simple_list_item_1, // Layout,
                new ArrayList<>(dictionary.keySet()) // array
        );

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String word = list.getItemAtPosition(position).toString()  ;
                String defn = dictionary.get(word);
                toast(defn);
            }
        });
    }
}
