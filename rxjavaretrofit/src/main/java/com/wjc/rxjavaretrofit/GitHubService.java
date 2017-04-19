package com.wjc.rxjavaretrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${JokerWan} on 2017/4/19.
 * WeChat：wjc398556712
 * Function：
 */

public interface GitHubService {

    String BASEURL = "https://api.github.com";

    @GET("users/{user}")
    Call<String> getData(@Path("user") String user);

    @GET("users/{user}")
    Call<GitModel> getUserInfo(@Path("user") String user);

    @GET("users/{user}")
    Call<ResponseBody> getResponseBody(@Path("user") String user);

    @GET("users/{user}")
    Observable<GitModel> rxUser(@Path("user") String user);
}
