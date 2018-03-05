package cn.edu.cqupt.campussocialmotion.model;

/**
 * Created by wentai on 17-10-28.
 */

public interface Const {

    public static final String BASE_MSG = "https://wx.idsbllp.cn/";  // 学生登录接口
    public static final String VERIFY = "api/verify";

    public static final String LOGIN_GET = "http://120.78.190.56:8080/Sports/api/user/searchUser/";   // 登录(新)
    public static final String LOGIN_BASE = "http://120.78.190.56:8080/";   // 提交User信息(新)
    public static final String LOGIN_POST = "Sports/api/user/createUser";

    public static final String BASE_GET_ACTIVITY = "http://106.14.188.228:8081/";
    public static final String GET_ACTIVITY = "sports-dating/activity/getActivities";    // 获取活动信息
    public static final String POST_ACTIVITY = "sports-dating/activity/estabActivity";   // 上传活动信息


    public static final String BASE_POST_USER = "http://106.14.188.228:8081/sports-dating/";
    public static final String POST_USER = "user/userLogin";   // 上传用户信息


    public static final String BASE_CIRCLE = "http://106.14.188.228:8081/sports-dating/";
    public static final String GET_CIRCLE = "dynamics/getAll";    // 获取动态
    public static final String SEND_CIRCLE = "dynamics/estab";   // 上传动态




}
