package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.LoginPostService;
import cn.edu.cqupt.campussocialmotion.ApiService.LoginService;
import cn.edu.cqupt.campussocialmotion.model.Const;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wentai on 17-10-28.
 */

public class LoginPostUserMsgRetrofit {

    private volatile static LoginPostUserMsgRetrofit sInstance;
    private Retrofit retrofit;
    private LoginPostService loginService;

    public LoginPostUserMsgRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.LOGIN_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        loginService = retrofit.create(LoginPostService.class);
    }

    public static LoginPostUserMsgRetrofit getsInstance() {
        if (sInstance == null) {
            synchronized (LoginPostUserMsgRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new LoginPostUserMsgRetrofit();
                }
            }
        }
        return sInstance;
    }

    public LoginPostService getLoginService() {
        return loginService;
    }

}
