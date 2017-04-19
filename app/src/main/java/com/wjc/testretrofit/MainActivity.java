package com.wjc.testretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络接口的使用为查询天气的接口
 * http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "WJC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOnlyRetrofit();
    }

    /**
     * 只有Retrofit的联网请求
     */
    private void initOnlyRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wthrcdn.etouch.cn/")//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .build();
        GetWeatherService weatherService = retrofit.create(GetWeatherService.class);
        //调用请求方法，并得到Call实例
        // Call其实在Retrofit中就是行使网络请求并处理返回值的类，调用的时候会把需要拼接的参数传递进去
        Call<WeatherEntity> call = weatherService.getMessage("北京");
        call.enqueue(new Callback<WeatherEntity>() {//异步请求 同步：call.execute().body()
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                Log.e(TAG, "response == " + response.body().getData().getGanmao());
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {
                Log.e(TAG, "Throwable : " + t);
            }
        });
    }
}
