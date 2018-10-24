package moe.whale.oopbuddy;

import android.content.Context;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Chapter
 * JSON wrapper class for defining a chapter's title and the path to the file containing the contents
 * of the chapter.
 */
public class Chapter {
    String title;
    String filename;
    String testfile;
    String blurb;
    String youtubeId;

    // Keep one copy of chapters to share across the app.
    private static transient Chapter[] mChapters = null;

    /**
     * Get the title of the chapter
     * @return The title of the chapter
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Get the filename of the chapter
     * @return the filename of the chapter
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Get the filename of the chapter's test (or quiz)
     * @return
     */
    public String getTestfile() {
        return this.testfile;
    }

    public String getBlurb() {
        return this.blurb;
    }

    public String getYoutubeId() {
        return this.youtubeId;
    }

    /**
     * Loads chapter from the chapters asset file
     * @param context The context of the asset directory
     * @return An array of chapters parsed from the chapters asset file
     */
    public static Chapter[] getChaptersFromAssets(Context context) {
        if (mChapters == null) {
            // Code written with assistance from StackOverflow: https://stackoverflow.com/a/13814551
            String chapterJsonString;
            Gson gson = new Gson();
            try {
                InputStream input = context.getAssets().open("Titles.json");
                byte[] textBuffer = new byte[input.available()];
                input.read(textBuffer);
                chapterJsonString = new String(textBuffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            mChapters = gson.fromJson(chapterJsonString, Chapter[].class);
        }

        return mChapters;
    }
}
