package com.wjc.testretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ${万嘉诚} on 2016/11/28.
 * WeChat：wjc398556712
 * Function：创建业务请求接口
 */

public interface GetWeatherService {
    /**
     * @GET注解就表示get请求，@Query表示请求参数，将会以key=value的方式拼接在url后面
     * @param city
     * @return
     */
    @GET("weather_mini")
    Call<WeatherEntity> getMessage(@Query("city") String city);
}
