package cn.edu.cqupt.campussocialmotion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Observable;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.SportPostMsg;
import cn.edu.cqupt.campussocialmotion.net.GetSportMsgRetrofit;
import cn.edu.cqupt.campussocialmotion.net.PostSportMsgRetrofit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PutSportMsgActivity extends AppCompatActivity {

    @BindView(R.id.activity_name) public EditText name;
    @BindView(R.id.activity_intro) public EditText intro;
    @BindView(R.id.remarks) public EditText remarks;
    @BindView(R.id.location) public EditText location;
    @BindView(R.id.people_needs) public EditText needs;
    @BindView(R.id.choose_activity) public RadioButton chooseActivity;
    @BindView(R.id.choose_competition) public RadioButton chooseCompetition;

    @BindView(R.id.upload_msg) public Button uploadMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_sport_msg);

        ButterKnife.bind(this);

        final String activityName = "打羽毛球";
        final int stuNum = 2016214073;
        final String activityIntro = "一起嗨皮";
        final String activityRemarks = "带上必备品";
        final long initTime = System.currentTimeMillis();
        final long startTime = System.currentTimeMillis() + 9000;
        final long endTime = System.currentTimeMillis() + 1800;
        final String activityLocation = "风雨操场";
        final String needsPeople = "17";
        final String isRace = "active";

        uploadMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostSportMsgRetrofit.getsInstance().postActivityService()
                        .getPostSportMsg(activityName, stuNum, activityIntro, activityRemarks,
                                initTime, startTime, endTime, activityLocation, needsPeople, isRace)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<SportPostMsg>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(SportPostMsg sportPostMsg) {
                                Toast.makeText(PutSportMsgActivity.this, sportPostMsg.getMessage(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(PutSportMsgActivity.this,"ERROR!!!", Toast.LENGTH_SHORT).show();
                                Log.d("ERROR", "ERROR");
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }

}
