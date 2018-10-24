package moe.whale.oopbuddy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import moe.whale.oopbuddy.views.RecyclerViewAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * MainActivity.java
 * Entry point for the OOPBuddy app
 */
public class MainActivity extends AppCompatActivity {
    private Context mContext;
    /**
     * Create the main activity
     * @param savedInstanceState The given state of the app if it was opened in the past
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        RecyclerView recyclerView = findViewById(R.id.topic_recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(
                Arrays.asList(Chapter.getChaptersFromAssets(mContext)), mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
