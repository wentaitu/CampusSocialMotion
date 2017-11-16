package cn.edu.cqupt.campussocialmotion.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public class TrendRecyclerAdaper extends RecyclerView.Adapter<TrendRecyclerAdaper.ViewHolder> {
    private OnItemClickListener mOnItemClickListener = null;
    private int[] activitys;
    private List<Boolean> isClicks;//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色
    private int i=0;
    private Context mContext;
    //public ReceptionAapter

    public TrendRecyclerAdaper(Context context,int[] activitys) {
        this.activitys = activitys;
        this.mContext = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trend, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //i = holder.getAdapterPosition();
                //isClicks.set(holder.getAdapterPosition(),true);
                SharedPreferences.Editor editor = mContext.getSharedPreferences("good",Context.MODE_PRIVATE).edit();
                editor.apply();

                SharedPreferences pref = mContext.getSharedPreferences("good",Context.MODE_PRIVATE);
                //SharedPreferences pref1 = mContext.getSharedPreferences("good1",Context.MODE_PRIVATE);
                int j = pref.getInt("good",0);

                if(j==0){
                    holder.good.setImageResource(R.drawable.good2);
                    editor.putInt("good",1);
                    editor.apply();
                    j = pref.getInt("good",0);

                }else {
                    holder.good.setImageResource(R.drawable.good1);
                    editor.putInt("good",0);
                    editor.apply();
                    j = pref.getInt("good",1);

                }

               // Toast.makeText(view.getContext(),j, Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.activity.setImageResource(activitys[position]);
        //isClicks.set(position,true);
   /*     SharedPreferences pref = mContext.getSharedPreferences("good",Context.MODE_PRIVATE);
        i = pref.getInt("good",0);
        if(i==1){
            holder.good.setImageResource(R.drawable.good2);
        }else {
            holder.good.setImageResource(R.drawable.good1);
        }

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0; i <isClicks.size();i++){
                        isClicks.set(i,false);
                    }
                    isClicks.set(i,true);
                    notifyDataSetChanged();
                    mOnItemClickListener.onItemClick(holder.,holder.good, i);
                }
            });
        }
*/
    }

    @Override
    public int getItemCount() {
        return activitys.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ar;
        ImageView good;
        View mview;
        ImageView activity;

        public ViewHolder(View itemView) {
            super(itemView);
            good = itemView.findViewById(R.id.good1);
            mview = itemView;
            activity = itemView.findViewById(R.id.pic);
        }
    }



    public interface OnItemClickListener {
        void onItemClick(View view, TextView textView, int position);
    }
}