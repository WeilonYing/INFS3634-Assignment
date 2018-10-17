package moe.whale.oopbuddy.views;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import moe.whale.oopbuddy.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    MaterialCardView mCardView;
    TextView mTopicText;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mView = itemView;

        //mCardView = itemView.findViewById(R.id.topic_card_view);
        mTopicText = itemView.findViewById(R.id.topic_text);
        mTopicText.setText("blah");
    }

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
