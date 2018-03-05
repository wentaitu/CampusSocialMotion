package cn.edu.cqupt.campussocialmotion.ApiService;

import java.io.File;

import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.LoginFormAppServer;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wentai on 18-3-4.
 */

public interface LoginPostService {

    @FormUrlEncoded
    @POST(Const.LOGIN_POST)
    Observable<LoginFormAppServer> postUserMsg(@Field("id") String id, @Field("userName") String username,
                                               @Field("gender") String gender, @Field("password") String password,
                                               @Field("nickName") String nickname, @Field("college") String college);

}
