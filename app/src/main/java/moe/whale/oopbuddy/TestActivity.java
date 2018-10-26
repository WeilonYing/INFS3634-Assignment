package moe.whale.oopbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = TestActivity.class.getSimpleName();
    private int mQuestionIndex = 0;
    private int mNumCorrect = 0;

    private Question[] mQuestions = null;
    private int[] mResponses = null;

    private LinearLayout mCandidateAnswers;

    /**
     * Creates the TestActivity. Requires that a chapter index be passed in from another context.
     * @param savedInstanceState Saved instance state. Not used for this activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Setup finish button
        MaterialButton finishButton = findViewById(R.id.finish_test_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // close the activity
            }
        });

        // Setup questions
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Chapter[] chapters = Chapter.getChaptersFromAssets(getApplicationContext());
            int index = extras.getInt("chapter_index");
            setTitle(chapters[index].getTitle());
            mQuestions = Question.getQuestionsFromAssets(
                    getApplicationContext(), chapters[index].getTestfile());
            mResponses = new int[mQuestions.length];
            mCandidateAnswers = findViewById(R.id.layout_candidate_answers);
        } else {
            Log.e(TAG, "Unable to load test. No chapter index provided");
        }

        loadQuestion();
        Log.v(TAG, "Activity loaded");
    }

    /**
     * Load a question from the mQuestions array. Requires mQuestionIndex be set first.
     */
    private void loadQuestion() {
        setQuestionText();
        setCandidateAnswers();
        setProgressText();
        Log.v(TAG, "Question " + mQuestionIndex + " loaded");
    }

    /**
     * Loads the buttons for candidate answers for a question given by mQuestionIndex
     */
    private void setCandidateAnswers() {
        mCandidateAnswers.removeAllViews();
        String[] candidates = mQuestions[mQuestionIndex].getCandidates();
        for (int i = 0; i < candidates.length; i++) {
            View v = LayoutInflater
                    .from(mCandidateAnswers.getContext())
                    .inflate(
                            R.layout.answer_button_view, mCandidateAnswers, false);
            MaterialButton button = v.findViewById(R.id.candidate_button);

            final int answer = i;
            final int index = mQuestionIndex;
            button.setText(candidates[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer(answer);
                    mResponses[index] = answer;
                }
            });

            mCandidateAnswers.addView(v);
        }
    }

    /**
     * Checks whether the given candidate index matches that of the actual answer
     * @param answer The index of the candidate answer
     */
    private void checkAnswer(int answer) {
        Log.v(TAG, "User answered with answer number " + answer);
        if (mQuestions[mQuestionIndex].answer == answer) {
            Snackbar.make(mCandidateAnswers, "Correct!", Snackbar.LENGTH_SHORT).show();
            mNumCorrect++;
        } else {
            Snackbar.make(mCandidateAnswers, "Incorrect!", Snackbar.LENGTH_SHORT).show();
        }

        if (mQuestionIndex + 1 < mQuestions.length) { // if there's another question...
            mQuestionIndex++;
            loadQuestion();
        } else { // otherwise finish up
            showResults();
            Log.v(TAG, "Finished test with result: " + mNumCorrect + " out of " + mQuestions.length);
        }
    }

    /**
     * Sets the progress text that informs the user of how many questions they got correct.
     */
    private void setProgressText() {
        TextView progressText = findViewById(R.id.progress_text);
        String text = "You got " + mNumCorrect + " out of " + mQuestions.length + " questions correct";
        progressText.setText(text);
    }

    /**
     * Sets the question's text for a question given by mQuestionIndex
     */
    private void setQuestionText() {
        if (mQuestions == null || mQuestionIndex > mQuestions.length) {
            return;
        }
        TextView questionText = findViewById(R.id.question_text);
        questionText.setText(mQuestions[mQuestionIndex].getQuestion());
    }

    private void showResults() {
        String text; // "Holder" variable for setting text in text views.
        // Hide the questions layout
        LinearLayout questionLayoutView = findViewById(R.id.question_layout_view);
        questionLayoutView.setVisibility(View.GONE);

        // Show the results layout
        LinearLayout resultLayoutView = findViewById(R.id.results_layout_view);
        resultLayoutView.setVisibility(View.VISIBLE);

        // Show the overall result of the test
        TextView resultText = findViewById(R.id.result_text);
        text = "You got " + mNumCorrect + " out of " + mQuestions.length + " questions correct!";
        resultText.setText(text);

        // Show the questions, responses and the answers to each question
        LinearLayout resultCardView = findViewById(R.id.results_card_view);
        for (int i = 0; i < mQuestions.length; i++) {
            View v = LayoutInflater
                    .from(resultLayoutView.getContext())
                    .inflate(
                            R.layout.result_answer_card_view, resultLayoutView, false);
            // result_question_text, result_response_text, result_answer_text
            Question curQuestion = mQuestions[i];
            TextView questionText = v.findViewById(R.id.result_question_text);
            TextView responseText = v.findViewById(R.id.result_response_text);
            TextView answerText   = v.findViewById(R.id.result_answer_text);

            questionText.setText(curQuestion.getQuestion());
            text = "Your response: " + curQuestion.getCandidates()[mResponses[i]];
            responseText.setText(text);
            text = "Answer: " + curQuestion.getCandidates()[curQuestion.getAnswer()];
            answerText.setText(text);
            resultCardView.addView(v);
        }
    }
}
