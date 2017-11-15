package cn.edu.cqupt.campussocialmotion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.SportPostMsg;
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

//        final String activityName = name.getText().toString();
//        final int stuNum = Integer.valueOf(getIntent().getStringExtra("stuId"));
//        final String activityIntro = intro.getText().toString();
//        final String activityRemarks = remarks.getText().toString();
//        final long initTime = System.currentTimeMillis();
//        final long startTime = System.currentTimeMillis() + 6000000;
//        final long endTime = System.currentTimeMillis() + 12000000;
//        final String activityLocation = location.getText().toString();
//        final int needsPeople = Integer.parseInt(needs.getText().toString());
//        final String isRace = "active";

        //final String activityName = "來一场网球";
//        final int stuNum = 2016214703;
        //final String activityIntro = "一起嗨皮吧";
        //final String activityRemarks = "每人都带上篮球";
//        final long initTime = System.currentTimeMillis();
//        final long startTime = System.currentTimeMillis() + 6000000;
//        final long endTime = System.currentTimeMillis() + 12000000;
        //final String activityLocation = "灯光篮球场";
       // final String needsPeople = "7";
//        final String isRace = "active";


        uploadMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String activityName = name.getText().toString();
                final int stuNum = Integer.valueOf(getIntent().getStringExtra("stuId"));
                final String activityIntro = intro.getText().toString();
                final String activityRemarks = remarks.getText().toString();
                final long initTime = System.currentTimeMillis();
                final long startTime = System.currentTimeMillis() + 6000000;
                final long endTime = System.currentTimeMillis() + 12000000;
                final String activityLocation = location.getText().toString();
                final int needsPeople = Integer.parseInt(needs.getText().toString());
                final String isRace = "active";

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
