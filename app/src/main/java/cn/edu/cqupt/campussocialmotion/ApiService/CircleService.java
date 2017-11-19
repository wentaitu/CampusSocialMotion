package cn.edu.cqupt.campussocialmotion.ApiService;

import cn.edu.cqupt.campussocialmotion.model.Circle;
import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.GetCircle;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author Administrator
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public interface CircleService {

    @GET(Const.GET_CIRCLE)
    Observable<GetCircle> getCircle();

    @FormUrlEncoded
    @POST(Const.SEND_CIRCLE)
    Observable<Circle> PostCircle(@Field("userId") String id, @Field("content")String content, @Field("initTime")long initTime);
}
