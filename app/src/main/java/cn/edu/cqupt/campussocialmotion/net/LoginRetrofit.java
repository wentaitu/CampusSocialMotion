package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.LoginService;
import cn.edu.cqupt.campussocialmotion.model.Const;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wentai on 17-10-28.
 */

public class LoginRetrofit {

    private volatile static LoginRetrofit sInstance;
    private Retrofit retrofit;
    private LoginService loginService;

    public LoginRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_MSG)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        loginService = retrofit.create(LoginService.class);
    }

    public static LoginRetrofit getsInstance() {
        if (sInstance == null) {
            synchronized (LoginRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new LoginRetrofit();
                }
            }
        }
        return sInstance;
    }

    public LoginService getLoginService() {
        return loginService;
    }

}
