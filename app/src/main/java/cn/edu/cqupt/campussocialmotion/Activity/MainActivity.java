package cn.edu.cqupt.campussocialmotion.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.View.ChoosePopupWindow;
import cn.edu.cqupt.campussocialmotion.fragment.FoundFragment;
import cn.edu.cqupt.campussocialmotion.fragment.SettingFragment;
import cn.edu.cqupt.campussocialmotion.fragment.SportFragment;
import cn.edu.cqupt.campussocialmotion.fragment.TrendFragment;
import cn.edu.cqupt.campussocialmotion.model.RedrockApiWrapper;
import cn.edu.cqupt.campussocialmotion.model.User;
import cn.edu.cqupt.campussocialmotion.model.UserPost;
import cn.edu.cqupt.campussocialmotion.net.PostUserInfoRetrofit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.found)
    public ImageView nav_found;
    @BindView(R.id.exercise)
    public ImageView nav_exercise;
    @BindView(R.id.circle)
    public ImageView nav_circle;
    @BindView(R.id.me)
    public ImageView nav_me;
    @BindView(R.id.add)
    public ImageView nav_add;
    RedrockApiWrapper<User> userinfo;
    public String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UltimateBar ultimateBar = new UltimateBar(this);
        //ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.main_back));

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        //SharedPreferences pref = getSharedPreferences("User",MODE_PRIVATE);
        //String pwd = pref.getString("pwd", "null");
        //Toast.makeText(this,pwd, Toast.LENGTH_SHORT).show();

        ButterKnife.bind(this);

        nav_found.setOnClickListener(this);
        nav_exercise.setOnClickListener(this);
        nav_circle.setOnClickListener(this);
        nav_me.setOnClickListener(this);
        nav_add.setOnClickListener(this);

        // FIXME: 17-11-24 userinfo获取异常
        userinfo = (RedrockApiWrapper<User>) getIntent().getSerializableExtra("Userinfo");
        replaceFragment(new FoundFragment());
        nav_found.setImageResource(R.drawable.found_fill);
    }

    @Override
    public void onClick(View view) {
        resetBottomBar();
        switch (view.getId()) {
            case R.id.found :
                nav_found.setImageResource(R.drawable.found_fill);
                replaceFragment(new FoundFragment());
                break;
            case R.id.exercise :
                nav_exercise.setImageResource(R.drawable.exercise_fill);
                replaceFragment(new SportFragment());
                break;
            case R.id.circle :
                nav_circle.setImageResource(R.drawable.circle_fill);
                TrendFragment trendActivity = new TrendFragment();
                replaceFragment(trendActivity);
                break;
            case R.id.me :
                nav_me.setImageResource(R.drawable.me_fill);

                SharedPreferences pref = getSharedPreferences("User",MODE_PRIVATE);
                final String id= pref.getString("stuNum","null");//2016210395
                final String userName = pref.getString("name","null");
                final String gender = pref.getString("gender","null");
                final String password = pref.getString("pwd", "null");;
                final int ability =1;

                SettingFragment settingFragment = new SettingFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Userinfo",userinfo);
                bundle.putString("stuNum",id);
                bundle.putString("name",userName);
                settingFragment.setArguments(bundle);
                replaceFragment(settingFragment);

                PostUserInfoRetrofit.getsInstance().postUserInfoService()
                        .getPostUserInfo(id, userName, gender, password, ability)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<UserPost>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(UserPost userInfo) {
                                Toast.makeText(MainActivity.this, userInfo.getMessage(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(MainActivity.this,"ERROR!!!", Toast.LENGTH_SHORT).show();
                                Log.d("ERROR", "ERROR");
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;

            case R.id.add :
                ChoosePopupWindow mPopupWindow = new ChoosePopupWindow(MainActivity.this, new ChoosePopupWindow.OnPopWindowClickListener() {
                    @Override
                    public void onPopWindowClickListener(View view) {
                        switch (view.getId()){
                            case R.id.iv_push_photo:
                                // TODO: 18-3-20 获取学号信息,登录成功(首次,非首次)获取及存储方案
                                String stuId = "2016214073";  // 测试学号
                                //String stuId = String.valueOf(userinfo.getData().getStuNum());
                                Intent intent1 = new Intent(MainActivity.this, PutSportMsgActivity.class);
                                intent1.putExtra("stuId", stuId);
                                startActivity(intent1);
                                break;
                            case R.id.iv_push_resale:
                                Intent intent2 = new Intent(MainActivity.this, OnlinewaitActivity.class);
                                startActivity(intent2);
                                break;
                        }
                    }
                });
                mPopupWindow.show();
                break;
        }
    }

    public void resetBottomBar() {
        nav_found.setImageResource(R.drawable.found);
        nav_exercise.setImageResource(R.drawable.exercise);
        nav_circle.setImageResource(R.drawable.circle);
        nav_me.setImageResource(R.drawable.me);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.index, fragment);
        transaction.commit();
    }

}
