package cn.edu.cqupt.campussocialmotion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;

/**
 * Created by wentai on 17-11-15.
 */

public class ActivityItemRecyclerAdapter extends RecyclerView.Adapter<ActivityItemRecyclerAdapter.ViewHolder> {

    private List<SportMsg.BodyBean> activits;

    public ActivityItemRecyclerAdapter(List<SportMsg.BodyBean> activitys) {
       this.activits = activitys;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activitys, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(activits.get(position).getActivityName());
        holder.needs.setText(String.valueOf(activits.get(position).getPeopleNeeds()));
    }

    @Override
    public int getItemCount() {
        return activits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView activity;
        TextView name;
        TextView needs;
        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            activity = itemView.findViewById(R.id.act_img);
            name = itemView.findViewById(R.id.item_name);
            needs = itemView.findViewById(R.id.item_needpeo);
            time = itemView.findViewById(R.id.item_time);
        }
    }

}
