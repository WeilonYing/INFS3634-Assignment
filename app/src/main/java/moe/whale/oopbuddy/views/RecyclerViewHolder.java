package moe.whale.oopbuddy.views;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import moe.whale.oopbuddy.R;

/**
 * RecyclerViewHolder
 * Provides programming logic for each RecyclerView item for displaying Material Card views
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    MaterialCardView mCardView;
    TextView mTopicText;

    /**
     * Constructor for the RecyclerViewHolder, given an item view.
     * @param itemView the item view provided by the recycler view adapter
     */
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mView = itemView;
        mTopicText = itemView.findViewById(R.id.topic_text);
    }

    /**
     * Defines logic to be run when the holder's view has been tapped/clicked
     * @param view The view being tapped/clicked on.
     */
    @Override
    public void onClick(View view) {
        // TODO: Implement this
        Toast.makeText(
                view.getContext(),
                Integer.toString(this.getAdapterPosition()) + " has been clicked.",
                Toast.LENGTH_LONG)
            .show();
    }
}
