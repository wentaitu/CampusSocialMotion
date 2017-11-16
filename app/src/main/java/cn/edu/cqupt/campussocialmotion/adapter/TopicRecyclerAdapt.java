package cn.edu.cqupt.campussocialmotion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.edu.cqupt.campussocialmotion.R;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public class TopicRecyclerAdapt extends RecyclerView.Adapter<TopicRecyclerAdapt.ViewHolder> {

    private int[] topic;

    public TopicRecyclerAdapt (int[] activitys) {
        this.topic = activitys;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mtopic.setImageResource(topic[position]);
    }

    @Override
    public int getItemCount() {
        return topic.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mtopic;

        public ViewHolder(View itemView) {
            super(itemView);
            mtopic = itemView.findViewById(R.id.item_topic);
        }
    }
}