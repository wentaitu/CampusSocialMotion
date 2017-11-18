package cn.edu.cqupt.campussocialmotion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.GetCircle;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public class GetCircleAdapter extends RecyclerView.Adapter<GetCircleAdapter.ViewHolder> {

    private List<GetCircle.BodyBean> activits;

    public GetCircleAdapter(List<GetCircle.BodyBean> activitys) {
        this.activits = activitys;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.litem_msg, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(activits.get(position).getId());
        holder.msg.setText(activits.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return activits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView msg;


        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);

        }
    }

}