package cn.edu.cqupt.campussocialmotion.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.fragment.HotFragment;
import cn.edu.cqupt.campussocialmotion.fragment.MessageFragment;

public class TrendActivity extends Fragment implements View.OnClickListener{


    private MessageFragment messageFragment;

    private HotFragment hotFragment;

    private View hot;
    private View message;

    private TextView messageText;

    private TextView hotText;
    private ImageView good;
    private ImageView sendmood;

    private FragmentManager fragmentManager;
    //@Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend);
        // 初始化布局元素
        initViews();
        replaceFragment(new HotFragment());
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trend, container, false);

        //initViews();
        replaceFragment(new HotFragment());
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        message = getView().findViewById(R.id.message_layout);
        hot = getView().findViewById(R.id.hot_layout);

        messageText = (TextView) getView().findViewById(R.id.message_text);
        hotText = (TextView) getView().findViewById(R.id.contacts_text);

        sendmood = getView().findViewById(R.id.sendmood);
        sendmood.setOnClickListener(this);
        message.setOnClickListener(this);
        hot.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.hot_layout:
                hotFragment = new HotFragment();
                replaceFragment(hotFragment);
                break;

            case R.id.message_layout:
                messageFragment = new MessageFragment();
                replaceFragment(messageFragment);
                break;

            case R.id.sendmood:
                Intent intent = new Intent(getActivity(), SendCircle.class);
                startActivity(intent);
                break;


        }
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content1, fragment);
        transaction.commit();
    }


}
