package moe.whale.oopbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import moe.whale.oopbuddy.views.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = new String[] {"i", "am", "weilon"};
        RecyclerView recyclerView = findViewById(R.id.topic_recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(Arrays.asList(items));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
