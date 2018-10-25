package moe.whale.oopbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.mukesh.MarkdownView;


public class ChapterActivity extends AppCompatActivity {
    MarkdownView mMarkdownView;
    String[] mLanguages = {
            "English",
            "Spanish",
            "German",
            "Italian",
            "French",
            "Chinese (Simplified)",
            "Japanese",
            "Korean"};
    String[] mLanguageCodes = {
            "en",
            "es",
            "de",
            "it",
            "fr",
            "zh",
            "ja",
            "ko"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMarkdownView = findViewById(R.id.chapter_md_view);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Chapter[] chapters = Chapter.getChaptersFromAssets(getApplicationContext());
            final int index = extras.getInt("chapter_index");
            setTitle(chapters[index].getTitle());
            mMarkdownView.loadMarkdownFromAssets(chapters[index].getFilename());

            MaterialButton youtubeButton = findViewById(R.id.youtube_button);
            youtubeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                    intent.putExtra("chapter_index", index);
                    startActivity(intent);
                }
            });
            MaterialButton translateButton = findViewById(R.id.translate_button);
            translateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChapterActivity.this);
                    builder.setTitle("Select a language");
                    builder.setItems(mLanguages, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int language) {
                            if (language > 0) { // 0 is english
                                new TranslateTask().execute(index, language);
                            } else {
                                // just show the original document
                                mMarkdownView.loadMarkdownFromAssets(chapters[index].getFilename());
                            }
                        }
                    });
                    builder.show();
                }
            });
        }
    }

    class TranslateTask extends AsyncTask<Integer, Void, String> {
        @Override
        protected String doInBackground(Integer... params) {
            int chapter = params[0];
            int language = params[1];
            TranslateOptions options = TranslateOptions.newBuilder()
                    .setApiKey(DeveloperKey.DEVELOPER_KEY)
                    .build();
            Translate translate = options.getService();
            final Translation translation =
                    translate.translate(Chapter.readChapter(getApplicationContext(), chapter),
                            Translate.TranslateOption.targetLanguage(mLanguageCodes[language]));
            return translation.getTranslatedText();
        }

        @Override
        protected void onPostExecute(String translatedText) {
            translatedText = translatedText.replaceAll("#", "");
            System.out.println(translatedText);
            mMarkdownView.setMarkDownText(translatedText);
        }
    }
}
