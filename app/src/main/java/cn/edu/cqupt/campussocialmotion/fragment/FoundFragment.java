package cn.edu.cqupt.campussocialmotion.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oragee.banners.BannerView;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.campussocialmotion.Activity.ShowActivity;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.adapter.PopActivityRecyclerAdapter;
import cn.edu.cqupt.campussocialmotion.adapter.PopCompetitionRecyclerAdapter;

/**
 * Created by wentai on 17-10-30.
 */

public class FoundFragment extends Fragment {

    private TextView searchShow;
    private Button button;
    private BannerView banner;  // 最顶上轮播
    private int[] imgs = {R.drawable.banner1,R.drawable.banner2,R.drawable.banner1,R.drawable.banner2};
    private List<View> viewList;
    RecyclerView popActivitys;
    RecyclerView popCOmpetition;

    SearchFragment searchFragment = SearchFragment.newInstance();

    private ImageView showActivitys;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_found, container, false);

        banner = view.findViewById(R.id.banner);
        popActivitys = view.findViewById(R.id.pop_activity);
        popCOmpetition = view.findViewById(R.id.pop_competition);
        searchShow = view.findViewById(R.id.search_show);
        searchShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        //这里处理逻辑

                    }
                });
                searchFragment.show(getActivity().getSupportFragmentManager(),SearchFragment.TAG);
            }
        });

        showActivitys = view.findViewById(R.id.show_activitys);
        showActivitys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShowActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView image = new ImageView(getContext());
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置显示格式
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setImageResource(imgs[i]);
            viewList.add(image);
        }
        banner.setLoopInterval(2500);
        banner.startLoop(true);

        banner.setViewList(viewList);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), TestActivity.class);
//                startActivity(intent);
//            }
//        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popActivitys.setLayoutManager(linearLayoutManager);
        int[] imgs = {R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3, R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3, R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3, R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3, R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3};
        popActivitys.setAdapter(new PopActivityRecyclerAdapter(imgs));

        popCOmpetition.setLayoutManager(new LinearLayoutManager(getActivity()));
        int[] imgs2 = {R.drawable.pop_competition, R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3, R.drawable.pop_competition, R.drawable.pop_competition, R.drawable.pop_activity1, R.drawable.pop_activity2, R.drawable.pop_activity3, R.drawable.pop_competition};
        popCOmpetition.setAdapter(new PopCompetitionRecyclerAdapter(imgs2));

    }
}
