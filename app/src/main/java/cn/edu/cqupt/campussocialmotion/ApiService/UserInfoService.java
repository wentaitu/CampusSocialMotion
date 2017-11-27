package cn.edu.cqupt.campussocialmotion.ApiService;

import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.UserPost;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public interface UserInfoService {

    //                public String id;//2016210395
    //                public String userName;
    //                public String gender;
    //                public String password;
    //                public int ability;
    @FormUrlEncoded
    @POST(Const.POST_USER)
    Observable<UserPost> getPostUserInfo(@Field("id") String id, @Field("userName") String userName, @Field("gender")String gender,
                                         @Field("password")String password, @Field("ability")int ability);
}
