package cn.edu.cqupt.campussocialmotion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        activityList = findViewById(R.id.activity_list);

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
                        adapter = new ActivityItemRecyclerAdapter(sportsList);
                        Toast.makeText(ShowActivity.this, sportMsg.getBody().get(0).toString(), Toast.LENGTH_SHORT).show();
                        activityList.setLayoutManager(new LinearLayoutManager(ShowActivity.this));
                        activityList.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ShowActivity.this, "ERROR!!!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
