package cn.edu.cqupt.campussocialmotion.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.User;
import cn.edu.cqupt.campussocialmotion.model.UserPost;
import cn.edu.cqupt.campussocialmotion.net.LoginRetrofit;
import cn.edu.cqupt.campussocialmotion.net.LoginRetrofit2;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_id)
    public EditText loginId;
    @BindView(R.id.login_pwd)
    public EditText loginPwd;
    @BindView(R.id.login_btn)
    public Button loginBtn;
    public int temp;

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
        temp = pref.getInt("temp", 0);

        if(temp==1){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            startActivity(intent);
            finish();
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String id = loginId.getText().toString();
                String pwd = loginPwd.getText().toString();
                //String status =null;


                if(temp==0) {
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

                                        SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();
                                        editor.putInt("temp", 1);
                                        editor.putString("stuNum", userWrapper.getData().stuNum);
                                        editor.putString("pwd", loginPwd.getText().toString());
                                        editor.putString("name", userWrapper.getData().name);
                                        editor.putString("college", userWrapper.getData().college);
                                        editor.putString("gender", userWrapper.getData().gender);
                                        editor.apply();
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_LONG).show();
                                    progressDialog.dismiss();
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                }else {
                    LoginRetrofit2.getsInstance2().getLoginService2()
                            .verify(id, pwd)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<UserPost>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(UserPost userPost) {

                                    Toast.makeText(LoginActivity.this, "hhhh", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    SharedPreferences.Editor editor = getSharedPreferences("User", MODE_PRIVATE).edit();

                                    startActivity(intent);

                                }

                                @Override
                                public void onError(Throwable e) {
                                    Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_LONG).show();
                                    progressDialog.dismiss();
                                }

                                @Override
                                public void onComplete() {

                                }
                            });

                }

            }
        });

    }

}
