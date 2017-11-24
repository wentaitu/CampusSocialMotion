package cn.edu.cqupt.campussocialmotion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;

/**
 * Created by wentai on 17-11-15.
 */

public class ActivityItemRecyclerAdapter extends RecyclerView.Adapter<ActivityItemRecyclerAdapter.ViewHolder> {

    private List<SportMsg.BodyBean> activits;
    private Context context;

    public ActivityItemRecyclerAdapter(List<SportMsg.BodyBean> activitys, Context context) {
       this.activits = activitys;
       this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activitys, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load("http://106.14.188.228:8081/sports-dating/resources/activities/"
                + String.valueOf(activits.get(position).getActivityId()) + activits.get(position).getActivityPic()).into(holder.activity);
        holder.name.setText(activits.get(position).getActivityName());
        holder.needs.setText(String.valueOf(activits.get(position).getPeopleNeeds()));
        holder.place.setText(activits.get(position).getLocation());
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
        TextView place;

        public ViewHolder(View itemView) {
            super(itemView);
            activity = itemView.findViewById(R.id.activity_img);
            name = itemView.findViewById(R.id.item_name);
            needs = itemView.findViewById(R.id.item_needpeo);
            time = itemView.findViewById(R.id.item_time);
            place = itemView.findViewById(R.id.activity_place);
        }
    }

}
