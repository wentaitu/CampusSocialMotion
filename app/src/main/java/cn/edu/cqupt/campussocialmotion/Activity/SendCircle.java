package cn.edu.cqupt.campussocialmotion.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.Circle;
import cn.edu.cqupt.campussocialmotion.net.CircleRetrofit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SendCircle extends AppCompatActivity {

    private EditText mood;
    private String content;
    private String id;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_circle);

        mood= (EditText) findViewById(R.id.mood);
        send= (Button) findViewById(R.id.sendbutton);

        final long initTime = System.currentTimeMillis();
        SharedPreferences pref = getSharedPreferences("User",MODE_PRIVATE);

        final String id= pref.getString("stuNum","null");//2016210395
        final String picture ="null";
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(SendCircle.this,"jhhh", Toast.LENGTH_SHORT).show();
                content = mood.getText().toString();
                CircleRetrofit.getsInstance().circleService()
                        .PostCircle(id, content, initTime)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Circle>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Circle circle) {
                                Toast.makeText(SendCircle.this, circle.getMessage(),Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(SendCircle.this,"ERROR!!!", Toast.LENGTH_SHORT).show();
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
