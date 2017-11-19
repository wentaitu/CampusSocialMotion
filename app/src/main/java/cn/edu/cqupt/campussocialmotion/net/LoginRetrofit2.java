package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.LoginService2;
import cn.edu.cqupt.campussocialmotion.model.Const;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public class LoginRetrofit2 {
    private volatile static LoginRetrofit2 sInstance;
    private Retrofit retrofit;
    private LoginService2 loginService;

    public LoginRetrofit2() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_POST_USER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        loginService = retrofit.create(LoginService2.class);
    }

    public static LoginRetrofit2 getsInstance2() {
        if (sInstance == null) {
            synchronized (LoginRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new LoginRetrofit2();
                }
            }
        }
        return sInstance;
    }

    public LoginService2 getLoginService2() {
        return loginService;
    }
}
