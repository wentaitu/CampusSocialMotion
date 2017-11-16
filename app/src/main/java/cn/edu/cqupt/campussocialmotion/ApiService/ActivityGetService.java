package cn.edu.cqupt.campussocialmotion.ApiService;

import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;
import cn.edu.cqupt.campussocialmotion.model.SportPostMsg;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wentai on 17-11-11.
 */

public interface ActivityGetService {

    @GET(Const.GET_ACTIVITY)
    Observable<SportMsg> getSportMsg();

    @FormUrlEncoded
    @POST(Const.POST_ACTIVITY)
    Observable<SportPostMsg> getPostSportMsg(@Field("activityName") String active, @Field("initiator") int stuNUm, @Field("content")String intro,
                                         @Field("remarks")String remarks, @Field("initTime")long initTime, @Field("startTime")long startTime,
                                         @Field("endTime")long endTime, @Field("location")String location, @Field("peopleNeeds")int needs,
                                         @Field("activityOrRace")String activeOrRace);



}
