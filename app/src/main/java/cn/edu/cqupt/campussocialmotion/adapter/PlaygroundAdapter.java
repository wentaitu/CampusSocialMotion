package cn.edu.cqupt.campussocialmotion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.PlaygroundModel;

/**
 * Created by wentai on 18-3-8.
 */

public class PlaygroundAdapter extends RecyclerView.Adapter<PlaygroundAdapter.ViewHolder> {

    private List<PlaygroundModel> mPlaygrounds;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton playgroundImg;
        TextView playgroundName;

        public ViewHolder(View view) {
            super(view);
            playgroundImg = view.findViewById(R.id.playground_img);
            playgroundName = view.findViewById(R.id.playground_name);
        }
    }

    public PlaygroundAdapter(List<PlaygroundModel> mPlaygrounds) {
        this.mPlaygrounds = mPlaygrounds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playground, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlaygroundModel model = mPlaygrounds.get(position);
        holder.playgroundImg.setImageResource(model.getPlaygroundImgId());
        holder.playgroundName.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return mPlaygrounds.size();
    }

}
