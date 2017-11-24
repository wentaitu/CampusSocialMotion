package cn.edu.cqupt.campussocialmotion.net;

import android.graphics.Interpolator;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by wentai on 17-11-19.
 */

public class CodeInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        Log.d("TEST", "intercept: "+response.code()+"\n");
        return response;
    }
}
