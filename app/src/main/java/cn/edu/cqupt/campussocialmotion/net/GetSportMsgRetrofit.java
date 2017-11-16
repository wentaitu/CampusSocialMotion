package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.ActivityGetService;
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
    private ActivityGetService activityService;

    public GetSportMsgRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_GET_ACTIVITY)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        activityService = retrofit.create(ActivityGetService.class);
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

    public ActivityGetService getActivityService() {
        return activityService;
    }

}
