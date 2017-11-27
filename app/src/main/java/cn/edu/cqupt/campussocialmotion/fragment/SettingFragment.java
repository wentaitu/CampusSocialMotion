package cn.edu.cqupt.campussocialmotion.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.RedrockApiWrapper;
import cn.edu.cqupt.campussocialmotion.model.User;

public class SettingFragment extends Fragment implements View.OnClickListener{
    private ImageView avatar;
    private TextView nick;
    private TextView xsid;
    private RelativeLayout out;
    RedrockApiWrapper<User> userinfo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View settingLayout = inflater.inflate(R.layout.fragment_setting, container, false);
        return settingLayout;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getData();
        //setListener();

        //editor.putInt("temp", 1);
        nick = (TextView) getView().findViewById(R.id.tv_name);//昵称
        xsid = (TextView) getView().findViewById(R.id.tv_xsid);//id
        out = getView().findViewById(R.id.re_setting5);
        Bundle bundle = getArguments();//从activity传过来的bundle
        if(bundle!=null) {
//            userinfo = (RedrockApiWrapper<User>) bundle.getSerializable("Userinfo");
//
//            nick.setText(userinfo.getData().name);
//            xsid.setText(userinfo.getData().stuNum);

              nick.setText(bundle.getString("name"));
              xsid.setText(bundle.getString("stuNum"));

        }

        //SharedPreferences pref = getSharedPreferences("User",MODE_PRIVATE);

        getView().findViewById(R.id.re_myinfo).setOnClickListener(this);
        getView().findViewById(R.id.re_setting5).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.re_myinfo:
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("Userinfo", userinfo);
                startActivity(intent);

                break;

          case R.id.re_setting5:
              SharedPreferences.Editor editor = getActivity().getSharedPreferences("User", getActivity().MODE_PRIVATE).edit();
              editor.putInt("temp", 0);
              editor.apply();
              ((Activity) getContext()).finish();

                //Toast.makeText(getContext(),"hhh", Toast.LENGTH_SHORT).show();
                break;
 /*
            case R.id.re_setting2:
                break;
            case R.id.re_setting3:
                break;
            case R.id.re_setting4:
                break;
            case R.id.re_setting5:
                break;
*/
        }
    }

}
