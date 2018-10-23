package moe.whale.oopbuddy;

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

    /**
     * Create the main activity
     * @param savedInstanceState The given state of the app if it was opened in the past
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String chapterString = loadStringFromAsset("Titles.json");
        System.out.println(chapterString);
        Gson gson = new Gson();
        Chapter[] chapters = gson.fromJson(chapterString, Chapter[].class);
        RecyclerView recyclerView = findViewById(R.id.topic_recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(Arrays.asList(chapters));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * Loads string from a given asset text file
     * @param filePath The path to the text file from src.main.assets
     * @return A string containing the text read from the file
     */
    private String loadStringFromAsset(String filePath) {
        // Code written with assistance from StackOverflow: https://stackoverflow.com/a/13814551
        try {
            InputStream input = getApplicationContext().getAssets().open(filePath);
            byte[] textBuffer = new byte[input.available()];
            input.read(textBuffer);
            return new String(textBuffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
