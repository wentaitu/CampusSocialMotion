package cn.edu.cqupt.campussocialmotion.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.fragment.HotFragment;
import cn.edu.cqupt.campussocialmotion.fragment.MessageFragment;

public class TrendActivity extends AppCompatActivity implements View.OnClickListener{


    private MessageFragment messageFragment;

    private HotFragment hotFragment;

    private View hot;
    private View message;

    private TextView messageText;

    private TextView hotText;

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend);
        // 初始化布局元素
        initViews();
        fragmentManager = getSupportFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);

    }

    private void initViews() {
        message = findViewById(R.id.message_layout);
        hot = findViewById(R.id.hot_layout);

        messageText = (TextView) findViewById(R.id.message_text);
        hotText = (TextView) findViewById(R.id.contacts_text);

        message.setOnClickListener(this);
        hot.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(1);
                break;
            case R.id.hot_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(0);
                break;
            default:
                break;
        }
    }

    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                //messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.BLACK);
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            case 0:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                //contactsImage.setImageResource(R.drawable.contacts_selected);
                hotText.setTextColor(Color.BLACK);
                if (hotFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    hotFragment = new HotFragment();
                    transaction.add(R.id.content, hotFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(hotFragment);
                }
                break;
        }
        transaction.commit();
    }



    private void clearSelection() {
        // messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#6F44CC"));
        //contactsImage.setImageResource(R.drawable.contacts_unselected);
        hotText.setTextColor(Color.parseColor("#6F44CC"));
        //newsImage.setImageResource(R.drawable.news_unselected);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (hotFragment != null) {
            transaction.hide(hotFragment);
        }
    }

}
