package moe.whale.oopbuddy;

import android.os.Bundle;
import android.app.Activity;

public class ChapterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
