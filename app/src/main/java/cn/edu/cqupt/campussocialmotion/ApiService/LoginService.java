package cn.edu.cqupt.campussocialmotion.ApiService;



import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.User;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wentai on 17-10-28.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST(Const.VERIFY)
    Observable<User.UserWrapper> verify(@Field("stuNum") String stuNum, @Field("idNum") String idNum);

}
