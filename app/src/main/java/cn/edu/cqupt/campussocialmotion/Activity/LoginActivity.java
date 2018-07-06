package cn.edu.cqupt.campussocialmotion.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;


//import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.ApiService.LoginPostService;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.LoginFormAppServer;
import cn.edu.cqupt.campussocialmotion.model.User;
import cn.edu.cqupt.campussocialmotion.model.UserPost;
import cn.edu.cqupt.campussocialmotion.net.LoginPostUserMsgRetrofit;
import cn.edu.cqupt.campussocialmotion.net.LoginRetrofit;
import cn.edu.cqupt.campussocialmotion.net.LoginRetrofit2;
import cn.edu.cqupt.campussocialmotion.util.MyHttpURL;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_id)
    public EditText loginId;
    @BindView(R.id.login_pwd)
    public EditText loginPwd;
    @BindView(R.id.login_btn)
    public Button loginBtn;
    public int temp;
    public boolean finishLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //异常
//        Drawable drawable=getResources().getDrawable(R.drawable.login1_1);
//        drawable.setBounds(0,0,40,40);
//        loginId.setCompoundDrawables(null,null,drawable,null);
//        Drawable drawable2=getResources().getDrawable(R.drawable.login2_1);
//        drawable.setBounds(0,0,40,40);
//        loginId.setCompoundDrawables(null,null,drawable,null);


        ButterKnife.bind(this);
        final User.UserWrapper userWrapper =new User.UserWrapper();

        SharedPreferences pref = getSharedPreferences("User",MODE_PRIVATE);
        // temp = pref.getInt("temp", 0);  服务器未设置好先置为0
        temp = 0;
/*
        if(temp==1){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            startActivity(intent);
            finish();
        }*/
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();    // FIXME: 18-3-19 为何这里报错

                final String id = loginId.getText().toString();
                final String pwd = loginPwd.getText().toString();
                //String status =null;

                MyHttpURL.get(Const.LOGIN_GET + id + "/" + pwd, new MyHttpURL.Callback() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        LoginFormAppServer loginMsg = gson.fromJson(response, LoginFormAppServer.class);
                        //if (loginMsg.getMessage().equals("ERROR#用户不存在")) { // 服务器挂,绕过
                        if ("ERROR#用户不存在".equals("ERROR#用户不存在")) {
                            LoginRetrofit.getsInstance().getLoginService()
                                    .verify(id, pwd)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<User.UserWrapper>() {
                                        @Override
                                        public void onSubscribe(Disposable d) {

                                        }

                                        @Override
                                        public void onNext(User.UserWrapper userWrapper) {
                                            progressDialog.dismiss();
                                            if (userWrapper.info.equals("success")) {
                                                Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_succ), Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                intent.putExtra("Userinfo", userWrapper);

                                                Log.d("LoginActivity", userWrapper.getData().getStuNum() + ":" + userWrapper.getData().getName() + ":" + userWrapper.getData().getGender() + ":" + userWrapper.getData().getIdNum() + ":" + userWrapper.getData().getName() + ":" + userWrapper.getData().getCollege());

                                                // 此时用户为首次登录App,开始发送数据*********************************************
                                                LoginPostUserMsgRetrofit.getsInstance().getLoginService()
                                                        .postUserMsg(userWrapper.getData().getStuNum(), userWrapper.getData().getName(), userWrapper.getData().getGender(), userWrapper.getData().getIdNum(), userWrapper.getData().getName(), userWrapper.getData().getCollege())
                                                        .subscribeOn(Schedulers.io())
                                                        .observeOn(AndroidSchedulers.mainThread())
                                                        .subscribe(new Observer<LoginFormAppServer>() {
                                                            @Override
                                                            public void onSubscribe(Disposable d) {

                                                            }

                                                            @Override
                                                            public void onNext(LoginFormAppServer loginFormAppServer) {
                                                                loginFormAppServer.toString();
                                                            }

                                                            @Override
                                                            public void onError(Throwable e) {
                                                                Log.d("LoginActivity", "onError: 数据发送异常");
                                                                if(e instanceof HttpException){
                                                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                                                    try {
                                                                        Log.d("LoginActivity", body.string());
                                                                    } catch (IOException IOe) {
                                                                        IOe.printStackTrace();
                                                                    }
                                                                }
                                                            }

                                                            @Override
                                                            public void onComplete() {

                                                            }
                                                        });
                                                // *********************************************

                                                SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
                                                editor.putInt("temp", 1);
                                                editor.putString("stuNum", userWrapper.getData().stuNum);
                                                editor.putString("pwd", loginPwd.getText().toString());
                                                editor.putString("name", userWrapper.getData().name);
                                                editor.putString("college", userWrapper.getData().college);
                                                editor.putString("gender", userWrapper.getData().gender);
                                                editor.apply();

                                                startActivity(intent);
                                            } else {
                                                Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
                                                finishLogin = false;
                                            }
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_LONG).show();
                                            progressDialog.dismiss();
                                        }


                                        @Override
                                        public void onComplete() {
                                            if (finishLogin == true) {
                                                finish();
                                            }
                                        }
                                    });
                        } else if (loginMsg.getMessage().equals("ERROR#密码错误")) {
                            Toast.makeText(LoginActivity.this ,"密码错误", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else if (loginMsg.getMessage().equals("OK#成功返回")) {
                            SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
                            editor.putInt("temp", 1);
                            editor.putString("stuNum", String.valueOf(loginMsg.getBody().getId()));
                            editor.putString("pwd", loginMsg.getBody().getPassword());
                            editor.putString("name", loginMsg.getBody().getUserName());
                            editor.putString("college", loginMsg.getBody().getCollege());
                            editor.putString("gender", loginMsg.getBody().getGender());
                            editor.apply();
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_succ), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });

//                if(temp==0) {
//                   LoginRetrofit.getsInstance().getLoginService()
//                            .verify(id, pwd)
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Observer<User.UserWrapper>() {
//                                @Override
//                                public void onSubscribe(Disposable d) {
//
//                                }
//
//                                @Override
//                                public void onNext(User.UserWrapper userWrapper) {
//                                    progressDialog.dismiss();
//                                    if (userWrapper.info.equals("success")) {
//                                        Log.d("LoginActivity", userWrapper.toString());
//                                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_succ), Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                        intent.putExtra("Userinfo", userWrapper);
//
//                                        SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
//                                        editor.putInt("temp", 1);
//                                        editor.putString("stuNum", userWrapper.getData().stuNum);
//                                        editor.putString("pwd", loginPwd.getText().toString());
//                                        editor.putString("name", userWrapper.getData().name);
//                                        editor.putString("college", userWrapper.getData().college);
//                                        editor.putString("gender", userWrapper.getData().gender);
//                                        editor.apply();
//
//                                        startActivity(intent);
//                                    } else {
//                                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
//                                        finishLogin = false;
//                                    }
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//                                    Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_LONG).show();
//                                    progressDialog.dismiss();
//                                }
//
//
//                                @Override
//                                public void onComplete() {
//                                    if (finishLogin == true) {
//                                        finish();
//                                    }
//                                }
//                            });
//                } else {
//                    LoginRetrofit2.getsInstance2().getLoginService2()
//                            .verify(id, pwd)
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Observer<UserPost>() {
//                                @Override
//                                public void onSubscribe(Disposable d) {
//
//                                }
//
//                                @Override
//                                public void onNext(UserPost userPost) {
//
//                                    Toast.makeText(LoginActivity.this, "hhhh", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                    SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
//
//                                    startActivity(intent);
//
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//                                    Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_LONG).show();
//                                    progressDialog.dismiss();
//                                }
//
//                                @Override
//                                public void onComplete() {
//                                    finish();
//                                }
//                            });
//
//                }

            }
        });

    }

}
