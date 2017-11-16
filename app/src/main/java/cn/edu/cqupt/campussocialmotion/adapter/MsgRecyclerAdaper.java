package cn.edu.cqupt.campussocialmotion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.Contact;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public class MsgRecyclerAdaper extends RecyclerView.Adapter<MsgRecyclerAdaper.ViewHolder> {

    private List<Contact> mContacts;


    public MsgRecyclerAdaper(List<Contact> contacts) {
        this.mContacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trend, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.activity.setImageResource(activitys[position]);
       // holder.activity.
        Contact man = mContacts.get(position);
        holder.name.setText(man.getName());
        holder.msg.setText(man.getMsg());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView tou;
        TextView name;
        TextView msg;

        public ViewHolder(View itemView) {
            super(itemView);
            //activity = itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);


        }
    }
}