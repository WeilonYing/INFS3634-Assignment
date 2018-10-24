package moe.whale.oopbuddy.views;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import moe.whale.oopbuddy.ChapterActivity;
import moe.whale.oopbuddy.R;

/**
 * RecyclerViewHolder
 * Provides programming logic for each RecyclerView item for displaying Material Card views
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    View mView;
    //final MaterialCardView mCardView;
    final TextView mTopicText;
    final ImageView mImageView;
    final MaterialButton mOpenButton;
    final MaterialButton mTestButton;

    /**
     * Constructor for the RecyclerViewHolder, given an item view.
     * @param itemView the item view provided by the recycler view adapter
     */
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        mTopicText = itemView.findViewById(R.id.topic_text);
        mImageView = itemView.findViewById(R.id.chapter_image);
        mOpenButton = itemView.findViewById(R.id.open_chapter_button);
        mTestButton = itemView.findViewById(R.id.test_chapter_button);

        Picasso.get().load("https://http.cat/100.jpg").into(mImageView);
    }
}
