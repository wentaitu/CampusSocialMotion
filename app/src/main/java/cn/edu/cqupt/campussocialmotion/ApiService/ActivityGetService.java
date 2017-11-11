package cn.edu.cqupt.campussocialmotion.ApiService;

import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wentai on 17-11-11.
 */

public interface ActivityGetService {

    @POST()

    @GET(Const.GET_ACTIVITY)
    Observable<SportMsg> getSportMsg();
}
