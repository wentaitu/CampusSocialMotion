package cn.edu.cqupt.campussocialmotion.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
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
import cn.edu.cqupt.campussocialmotion.net.LoginRetrofit;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        User.UserWrapper userWrapper =new User.UserWrapper();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String id = loginId.getText().toString();
                String pwd = loginPwd.getText().toString();


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
            }
        });

    }

}
