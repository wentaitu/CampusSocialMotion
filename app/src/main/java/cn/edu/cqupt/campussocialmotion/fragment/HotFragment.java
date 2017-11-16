package cn.edu.cqupt.campussocialmotion.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.adapter.TopicRecyclerAdapt;
import cn.edu.cqupt.campussocialmotion.adapter.TrendRecyclerAdaper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment {
    RecyclerView hotActivitys;
    RecyclerView hotTrend;
    ImageView good;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false);
       // hotActivitys = (RecyclerView) getView().findViewById(R.id.rlist);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hotActivitys = (RecyclerView) getView().findViewById(R.id.rlist);
        hotTrend = (RecyclerView) getView().findViewById(R.id.rlist1);
        //good = (ImageView) getView().findViewById(R.id.good1);
        //onClick1(getView());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hotActivitys.setLayoutManager(linearLayoutManager);
        int[] imgs = {R.drawable.left, R.drawable.right, R.drawable.left, R.drawable.right,R.drawable.left, R.drawable.right};
        hotActivitys.setAdapter(new TopicRecyclerAdapt(imgs));
        hotActivitys.setNestedScrollingEnabled(false);

        hotTrend.setLayoutManager(new LinearLayoutManager(getActivity()));
        int[] imgs2 = { R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3,  R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3,R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3};
        hotTrend.setAdapter(new TrendRecyclerAdaper(getContext(),imgs2));
        hotTrend.setNestedScrollingEnabled(false);
        /*good = (ImageView) getView().findViewById(R.id.good1);
        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                good.setImageResource(R.drawable.good2);
            }
        });*/

    }


}
