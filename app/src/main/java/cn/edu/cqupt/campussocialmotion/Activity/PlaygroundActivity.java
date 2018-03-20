package cn.edu.cqupt.campussocialmotion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.adapter.PlaygroundAdapter;
import cn.edu.cqupt.campussocialmotion.model.PlaygroundModel;

public class PlaygroundActivity extends AppCompatActivity {

    private List<PlaygroundModel> mPlaygrounds;
    private RecyclerView playgroundRecycler;
    private static final String TAG = "PlaygroundActivity";
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);
        back = findViewById(R.id.back_playground_activity);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mPlaygrounds = new ArrayList<>();
        mPlaygrounds.add(new PlaygroundModel(R.drawable.fenghua1, "风华运动场"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.taiji1, "太极运动场"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.youyong3, "游泳池"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.dengguang1, "灯光篮球场"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.wangqiu1, "中心网球场"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.ziwei1, "紫薇篮球场"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.guihua1, "桂花篮球场"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.jiaozhi1, "教职工运动场(保卫处旁)"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.jianshen1, "健身房(体育学院)"));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.fengyu_pingpang1, "乒乓球馆(风雨操场) "));
        mPlaygrounds.add(new PlaygroundModel(R.drawable.fengyu_lanqiu1, "篮球/排球馆(风雨操场)"));


        playgroundRecycler = findViewById(R.id.playground_recycler);
        playgroundRecycler.setLayoutManager(new LinearLayoutManager(this));
        PlaygroundAdapter adapter = new PlaygroundAdapter(mPlaygrounds);
        playgroundRecycler.setAdapter(adapter);
    }
}
