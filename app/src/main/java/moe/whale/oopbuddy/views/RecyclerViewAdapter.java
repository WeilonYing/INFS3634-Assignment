package moe.whale.oopbuddy.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import moe.whale.oopbuddy.Chapter;
import moe.whale.oopbuddy.R;

import java.util.List;

/**
 * RecyclerViewAdapter
 * Used for displaying chapter titles using Material Card views
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<Chapter> objects;

    /**
     * Construct the adapter using given chapters
     * @param objects A list of chapter objects
     */
    public RecyclerViewAdapter(List<Chapter> objects) {
        super();
        this.objects = objects;
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
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.mTopicText.setText(this.objects.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return this.objects.size();
    }

}
