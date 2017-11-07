package cn.edu.cqupt.campussocialmotion.found;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;
import cn.edu.cqupt.campussocialmotion.net.GetSportMsgRetrofit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.send_get) public Button sendGetSportMsg;
    @BindView(R.id.show_msg) public TextView show_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);

        sendGetSportMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetSportMsgRetrofit.getsInstance().getLoginService().getSportMsg()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<SportMsg>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(SportMsg sportMsg) {
                                show_msg.setText(sportMsg.getMessage());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }
}
