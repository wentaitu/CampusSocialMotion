package cn.edu.cqupt.campussocialmotion.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.RedrockApiWrapper;
import cn.edu.cqupt.campussocialmotion.model.User;


public class ProfileActivity extends AppCompatActivity {

    private TextView name;
    private TextView xsid;
    private TextView sex;
    private TextView region;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_info);
        RedrockApiWrapper<User> userinfo = (RedrockApiWrapper<User>) getIntent().getSerializableExtra("Userinfo");
        name=(TextView) findViewById(R.id.tv_name);
        xsid=(TextView) findViewById(R.id.tv_xsid);
        sex=(TextView) findViewById(R.id.tv_sex);
        region=(TextView) findViewById(R.id.tv_region);

        name.setText(userinfo.getData().name);
        xsid.setText(userinfo.getData().stuNum);
        sex.setText(userinfo.getData().gender);
        region.setText(userinfo.getData().college);
    }

}
