package com.creative.myrecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    class Person {
        String name;
        String age;
        int photoId;

        Person(String name, String age, int photoId) {
            this.name = name;
            this.age = age;
            this.photoId = photoId;
        }
    }

    private List<Person> persons;

    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Tom", "32 years old", R.drawable.sample));
        persons.add(new Person("Kai", "52 years old", R.drawable.sample));
        persons.add(new Person("Wu", "82 years old", R.drawable.sample));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        // Need layout manager to position items in recyclerview
        // Linear, Grid or StaggeredGrid
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        // ArrayList with some data
        initializeData();

        // To use adapter
        RVAdapter adapater = new RVAdapter(persons);
        rv.setAdapter(adapater);
    }
}

