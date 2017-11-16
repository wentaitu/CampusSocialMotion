package cn.edu.cqupt.campussocialmotion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.edu.cqupt.campussocialmotion.R;

/**
 * Created by wentai on 17-11-11.
 */

public class PopCompetitionRecyclerAdapter extends RecyclerView.Adapter<PopCompetitionRecyclerAdapter.ViewHolder> {

    private int[] activitys;

    public PopCompetitionRecyclerAdapter(int[] activitys) {
        this.activitys = activitys;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pop_competition, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.activity.setImageResource(activitys[position]);
    }

    @Override
    public int getItemCount() {
        return activitys.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView activity;

        public ViewHolder(View itemView) {
            super(itemView);
            activity = itemView.findViewById(R.id.item_pop_competition);
        }
    }
}
