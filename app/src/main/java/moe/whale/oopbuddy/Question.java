package moe.whale.oopbuddy;

import android.content.Context;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class Question {
    String question;
    String[] candidates;
    int answer;

    public String getQuestion() {
        return this.question;
    }

    public String[] getCandidates() {
        return this.candidates;
    }

    public int getAnswer() {
        return this.answer;
    }

    public static Question[] getQuestionsFromAssets(Context context, String filename) {
        // Code written with assistance from StackOverflow: https://stackoverflow.com/a/13814551
        String questionJsonString;
        Gson gson = new Gson();
        try {
            InputStream input = context.getAssets().open(filename);
            byte[] textBuffer = new byte[input.available()];
            input.read(textBuffer);
            questionJsonString = new String(textBuffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return gson.fromJson(questionJsonString, Question[].class);
    }
}
