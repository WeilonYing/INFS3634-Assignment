package moe.whale.oopbuddy.views;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import moe.whale.oopbuddy.Chapter;
import moe.whale.oopbuddy.ChapterActivity;
import moe.whale.oopbuddy.R;

import java.util.List;

/**
 * RecyclerViewAdapter
 * Used for displaying chapter titles using Material Card views
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private @NonNull final Context mContext;
    private List<Chapter> mObjects;

    /**
     * Construct the adapter using given chapters
     * @param objects A list of chapter objects
     */
    public RecyclerViewAdapter(List<Chapter> objects, Context context) {
        super();
        mObjects = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.topic_card_view, viewGroup, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, final int i) {
        recyclerViewHolder.mTopicText.setText(mObjects.get(i).getTitle());
        recyclerViewHolder.mOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ChapterActivity.class);
                intent.putExtra("chapter_index", i);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

}
