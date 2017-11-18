package cn.edu.cqupt.campussocialmotion.model;

/**
 * Created by wentai on 17-10-28.
 */

public interface Const {

    public static final String BASE_MSG = "https://wx.idsbllp.cn/";  // 学生登录接口
    public static final String VERIFY = "api/verify";

    public static final String BASE_GET_ACTIVITY = "http://106.14.188.228:8081/sports-dating/";
    public static final String GET_ACTIVITY = "activity/getActivities";    // 获取活动信息
    public static final String POST_ACTIVITY = "activity/estabActivity";   // 上传活动信息


    public static final String BASE_POST_USER = "http://106.14.188.228:8081/sports-dating/";
    public static final String POST_USER = "user/userLogin";   // 上传用户信息


    public static final String BASE_CIRCLE = "http://106.14.188.228:8081/sports-dating/";
    public static final String GET_CIRCLE = "dynamics/getAll";    // 获取动态
    public static final String SEND_CIRCLE = "dynamics/estab";   // 上传动态




}
