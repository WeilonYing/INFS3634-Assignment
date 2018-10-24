package moe.whale.oopbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.mukesh.MarkdownView;

public class ChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Chapter[] chapters = Chapter.getChaptersFromAssets(getApplicationContext());
            final int index = extras.getInt("chapter_index");
            setTitle(chapters[index].getTitle());

            MarkdownView markdownView = findViewById(R.id.chapter_md_view);
            markdownView.loadMarkdownFromAssets(chapters[index].getFilename());
            MaterialButton youtubeButton = findViewById(R.id.youtube_button);
            youtubeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                    intent.putExtra("chapter_index", index);
                    startActivity(intent);
                }
            });
        }
    }
}
