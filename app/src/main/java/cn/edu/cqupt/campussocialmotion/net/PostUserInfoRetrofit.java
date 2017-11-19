package cn.edu.cqupt.campussocialmotion.net;

import cn.edu.cqupt.campussocialmotion.ApiService.UserInfoService;
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

public class PostUserInfoRetrofit {

    private volatile static PostUserInfoRetrofit sInstance;
    private Retrofit retrofit;
    private UserInfoService mUserPostService;

    public PostUserInfoRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_GET_ACTIVITY)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mUserPostService = retrofit.create(UserInfoService.class);
    }

    public static PostUserInfoRetrofit getsInstance() {
        if (sInstance == null) {
            synchronized (PostUserInfoRetrofit.class) {
                if (sInstance == null) {
                    sInstance = new PostUserInfoRetrofit();
                }
            }
        }
        return sInstance;
    }

    public UserInfoService postUserInfoService() {
        return mUserPostService;
    }
}
