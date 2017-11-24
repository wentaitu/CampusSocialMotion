package cn.edu.cqupt.campussocialmotion.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wentai on 17-11-18.
 */

public class DateStringToTimeStamp {

    // 将字符串转为时间戳
    public static String getTimeStamp(String timeStamp) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d;
        try {
            d = sdf.parse(timeStamp);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }


    // 将时间戳转为字符串
    public static String getTimeString(String timeString) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        long lcc_time = Long.valueOf(timeString);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

}
