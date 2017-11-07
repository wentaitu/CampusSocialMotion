package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.LoginService;
import cn.edu.cqupt.campussocialmotion.model.Const;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wentai on 17-10-28.
 */

public class GetSportMsgRetrofit {

    private volatile static GetSportMsgRetrofit sInstance;
    private Retrofit retrofit;
    private LoginService loginService;

    public GetSportMsgRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_GET_ACTIVITY)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        loginService = retrofit.create(LoginService.class);
    }

    public static GetSportMsgRetrofit getsInstance() {
        if (sInstance == null) {
            synchronized (GetSportMsgRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new GetSportMsgRetrofit();
                }
            }
        }
        return sInstance;
    }

    public LoginService getLoginService() {
        return loginService;
    }

}
