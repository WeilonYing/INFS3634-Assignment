package moe.whale.oopbuddy;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.mukesh.MarkdownView;

public class ChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Chapter[] chapters = Chapter.getChaptersFromAssets(getApplicationContext());
            int index = extras.getInt("chapter_index");
            setTitle(chapters[index].getTitle());

            MarkdownView markdownView = findViewById(R.id.chapter_md_view);
            markdownView.loadMarkdownFromAssets(chapters[index].getFilename());
        }
    }
}
