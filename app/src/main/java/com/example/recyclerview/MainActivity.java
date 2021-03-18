package com.example.recyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                // add a new word to the wordList
                mWordList.addLast("+ Word " + wordListSize);
                // notify the adapter, that the data has changed
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // scroll to the bottom
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        // populate mWorldList
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }

        // get a handle to the recyclerview
        mRecyclerView = findViewById(R.id.recyclerview);
        // create an adapter and supply the data to be displayed
        mAdapter = new WordListAdapter(this, mWordList);
        // connect the adapter with the recycler view
        mRecyclerView.setAdapter(mAdapter);
        // give the recycler view a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_reset) {
            // reset the wordList to its original state
            mWordList.clear();
            for (int i = 0; i < 20; i++) {
                mWordList.addLast("Word " + i);
            }
            // notify the adapter, that the data has changed
            mRecyclerView.getAdapter().notifyDataSetChanged();
            // scroll to the top
            mRecyclerView.smoothScrollToPosition(0);
        }

        return super.onOptionsItemSelected(item);
    }
}