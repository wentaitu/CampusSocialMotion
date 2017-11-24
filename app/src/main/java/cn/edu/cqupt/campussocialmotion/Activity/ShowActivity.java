package cn.edu.cqupt.campussocialmotion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.oragee.banners.BannerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.adapter.ActivityItemRecyclerAdapter;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;
import cn.edu.cqupt.campussocialmotion.net.GetSportMsgRetrofit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShowActivity extends AppCompatActivity {

    private List<SportMsg.BodyBean> sportsList;
    private ActivityItemRecyclerAdapter adapter;
    private RecyclerView activityList;

    private BannerView banner;
    private List<View> viewList;
    private int[] imgs = {R.drawable.banner1,R.drawable.banner2,R.drawable.banner1,R.drawable.banner2};

    private ImageView back_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        activityList = findViewById(R.id.activity_list);
        activityList.setNestedScrollingEnabled(false);
        banner = findViewById(R.id.activity_banner);
        back_activity = findViewById(R.id.back_act_activity);
        back_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        viewList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView image = new ImageView(this);
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置显示格式
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setImageResource(imgs[i]);
            viewList.add(image);
        }
        banner.setLoopInterval(2500);
        banner.startLoop(true);
        banner.setViewList(viewList);

        GetSportMsgRetrofit.getsInstance().getActivityService()
                .getSportMsg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SportMsg>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SportMsg sportMsg) {
                        sportsList = sportMsg.getBody();
                        adapter = new ActivityItemRecyclerAdapter(sportsList , ShowActivity.this);
                        Toast.makeText(ShowActivity.this, sportMsg.getBody().get(0).toString(), Toast.LENGTH_SHORT).show();
                        activityList.setLayoutManager(new LinearLayoutManager(ShowActivity.this));
                        activityList.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ShowActivity.this, "ERROR!!!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
