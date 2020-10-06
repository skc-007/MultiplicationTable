package com.skc.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tablesListView;

    public void createTable(int progress) {
        ArrayList<Integer> table = new ArrayList();

        for(int i=1; i<=10; i++) {
            table.add(progress * i);
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, table);
        tablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textView = findViewById(R.id.textView);
        tablesListView = findViewById(R.id.tablesListView);
        int max = 20;
        int initialProgress = 1;
        seekBar.setMax(max);
        seekBar.setProgress(initialProgress);

        createTable(initialProgress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(progress == 0) {
                    progress = 1;
                    seekBar.setProgress(progress);
                }

                textView.setText(String.valueOf(progress));
                createTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}