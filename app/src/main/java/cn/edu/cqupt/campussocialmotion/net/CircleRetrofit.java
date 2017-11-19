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

public class CircleRetrofit {
    private volatile static CircleRetrofit sInstance;
    private Retrofit retrofit;
    private CircleService circleService;

    public CircleRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_CIRCLE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        circleService = retrofit.create(CircleService.class);
    }

    public static CircleRetrofit getsInstance() {
        if (sInstance == null) {
            synchronized (CircleRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new CircleRetrofit();
                }
            }
        }
        return sInstance;
    }

    public CircleService circleService() {
        return circleService;
    }
}
