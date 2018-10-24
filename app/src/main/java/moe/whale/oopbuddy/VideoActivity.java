package moe.whale.oopbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity {
    private YouTubePlayer mYouTubePlayer;
    private YouTubePlayerView mYouTubePlayerView;
    private boolean mWasCued;
    private String mVideoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Chapter[] chapters = Chapter.getChaptersFromAssets(getApplicationContext());
            int index = extras.getInt("chapter_index");
            mVideoId = chapters[index].getYoutubeId();
            YouTubePlayerView mYouTubePlayerView = findViewById(R.id.youtube_player_view);
            mYouTubePlayerView.initialize(DeveloperKey.DEVELOPER_KEY, new YouTubeInitializationListener());
        }
    }

    class YouTubeInitializationListener implements YouTubePlayer.OnInitializedListener {
        @Override
        public void onInitializationSuccess(
                YouTubePlayer.Provider provider,
                final YouTubePlayer youTubePlayer,
                boolean wasRestored) {
            if (!wasRestored && !mWasCued) {
                mYouTubePlayer = youTubePlayer;
                youTubePlayer.cueVideo(mVideoId);
                mWasCued = true;
            }

            youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                @Override
                public void onLoading() {
                    // do nothing
                }

                @Override
                public void onLoaded(String s) {
                    youTubePlayer.play();
                }

                @Override
                public void onAdStarted() {
                    // do nothing
                }

                @Override
                public void onVideoStarted() {
                    // do nothing
                }

                @Override
                public void onVideoEnded() {
                    // do nothing
                }

                @Override
                public void onError(YouTubePlayer.ErrorReason errorReason) {
                    Toast.makeText(
                            getApplicationContext(),
                            "YouTube Player Error: " + errorReason.toString(),
                            Toast.LENGTH_LONG)
                        .show();
                }
            });
        }

        @Override
        public void onInitializationFailure(
                YouTubePlayer.Provider provider,
                YouTubeInitializationResult youTubeInitializationResult) {
            Snackbar.make(mYouTubePlayerView, "Unable to load video", Snackbar.LENGTH_LONG);
        }
    }
}
