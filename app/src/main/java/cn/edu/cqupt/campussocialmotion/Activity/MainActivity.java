package cn.edu.cqupt.campussocialmotion.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.fragment.FoundFragment;
import cn.edu.cqupt.campussocialmotion.fragment.SettingFragment;
import cn.edu.cqupt.campussocialmotion.model.RedrockApiWrapper;
import cn.edu.cqupt.campussocialmotion.model.User;

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

        ButterKnife.bind(this);

        nav_found.setOnClickListener(this);
        nav_exercise.setOnClickListener(this);
        nav_circle.setOnClickListener(this);
        nav_me.setOnClickListener(this);
        nav_add.setOnClickListener(this);

        userinfo = (RedrockApiWrapper<User>) getIntent().getSerializableExtra("Userinfo");
        Toast.makeText(this,userinfo.data.toString(), Toast.LENGTH_SHORT).show();

        //replaceFragment(new FoundFragment());

    }

    @Override
    public void onClick(View view) {
        resetBottomBar();
        switch (view.getId()) {
            case R.id.found :

                Toast.makeText(MainActivity.this, "发现", Toast.LENGTH_SHORT).show();
                nav_found.setImageResource(R.drawable.found_fill);
                replaceFragment(new FoundFragment());
                break;
            case R.id.exercise :

                Toast.makeText(MainActivity.this, "运动", Toast.LENGTH_SHORT).show();
                nav_exercise.setImageResource(R.drawable.exercise_fill);
                break;
            case R.id.circle :

                Toast.makeText(MainActivity.this, "圈子", Toast.LENGTH_SHORT).show();
                nav_circle.setImageResource(R.drawable.circle_fill);
                Intent intent = new Intent(MainActivity.this, TrendActivity.class);
                startActivity(intent);
                //finish();
                break;
            case R.id.me :

                Toast.makeText(MainActivity.this, "我的", Toast.LENGTH_SHORT).show();
                nav_me.setImageResource(R.drawable.me_fill);

                SettingFragment settingFragment = new SettingFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Userinfo",userinfo);
                settingFragment.setArguments(bundle);
                replaceFragment(settingFragment);


                break;
            case R.id.add :

                Toast.makeText(MainActivity.this, "发布", Toast.LENGTH_SHORT).show();
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
