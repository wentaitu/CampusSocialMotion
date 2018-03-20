package cn.edu.cqupt.campussocialmotion.ApiService;

import java.util.List;
import java.util.Map;

import cn.edu.cqupt.campussocialmotion.model.Const;
import cn.edu.cqupt.campussocialmotion.model.SportMsg;
import cn.edu.cqupt.campussocialmotion.model.SportPostMsg;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by wentai on 17-11-11.
 */

public interface ActivityGetService {

    @GET(Const.GET_ACTIVITY)
    Observable<SportMsg> getSportMsg();

//    @FormUrlEncoded
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@Field("activityName") String active, @Field("initiator") String stuNUm, @Field("content")String intro,
//                                         @Field("remarks")String remarks, @Field("initTime")long initTime, @Field("startTime")long startTime,
//                                         @Field("endTime")long endTime, @Field("location")String location, @Field("peopleNeeds")int needs,
//                                         @Field("activityOrRace")String activeOrRace);


//    @Multipart
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@Part("activityName") String active, @Part("initiator") String stuNUm, @Part("content")String intro,
//                                             @Part("remarks")String remarks, @Part("initTime")long initTime, @Part("startTime")long startTime,
//                                             @Part("endTime")long endTime, @Part("location")String location, @Part("peopleNeeds")int needs,
//                                             @Part("activityOrRace")String activeOrRace, @Part() MultipartBody.Part parts);

//    @Multipart
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@Part("activityName") String actName, @Part("initiator") String stuNUm, @Part("content")String intro,
//                                             @Part("remarks")String remarks, @Part("startTime")String startTime,
//                                             @Part("endTime")String endTime, @Part("location")String location, @Part("peopleNeeds")int needs,
//                                             @Part("activityOrRace")String activeOrRace, @Part MultipartBody.Part file);

//    @Multipart
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@Part("activityName") RequestBody actName, @Part("initiator") RequestBody stuNUm, @Part("content")RequestBody intro,
//                                             @Part("remarks")RequestBody remarks, @Part("startTime")RequestBody startTime,
//                                             @Part("endTime")RequestBody endTime, @Part("location")RequestBody location, @Part("peopleNeeds")RequestBody needs,
//                                             @Part("activityOrRace")RequestBody activeOrRace, @Part MultipartBody.Part file);

//    @Multipart
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@PartMap Map<String, RequestBody> msg, @Part MultipartBody.Part file);

    @Multipart
    @POST(Const.POST_ACTIVITY)
    Observable<SportPostMsg> getPostSportMsg(@PartMap Map<String, RequestBody> msg, @PartMap Map<String, RequestBody> imgs);

//    @Multipart
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@PartMap Map<String, RequestBody> map, @Part MultipartBody.Part file);



//    @Multipart
//    @POST(Const.POST_ACTIVITY)
//    Observable<SportPostMsg> getPostSportMsg(@PartMap("activityName") RequestBody active, @Part("initiator") RequestBody stuNUm, @Part("content")RequestBody intro,
//                                             @Part("remarks")RequestBody remarks, @Part("initTime")RequestBody initTime, @Part("startTime")RequestBody startTime,
//                                             @Part("endTime")RequestBody endTime, @Part("location")RequestBody location, @Part("peopleNeeds")RequestBody needs,
//                                             @Part("activityOrRace")RequestBody activeOrRace, @Part MultipartBody.Part parts);

}                                                                                       // @Part("file\"; filename=\"image.png\"") RequestBody pictures
