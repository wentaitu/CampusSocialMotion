package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.CircleService;
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

public class GetCircleRetrofit {
    private volatile static GetCircleRetrofit sInstance;
    private Retrofit retrofit;
    private CircleService circleService;

    public GetCircleRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_CIRCLE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        circleService = retrofit.create(CircleService.class);
    }

    public static GetCircleRetrofit getsInstance() {
        if (sInstance == null) {
            synchronized (GetCircleRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new GetCircleRetrofit();
                }
            }
        }
        return sInstance;
    }

    public CircleService getCircleService() {
        return circleService;
    }
}
