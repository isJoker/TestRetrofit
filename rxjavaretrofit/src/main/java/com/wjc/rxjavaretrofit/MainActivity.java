package com.wjc.rxjavaretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //可以用你自己GitHub上的用户名
        String myGithubName = "isJoker";

//        rxRetrofit(myGithubName);
//        responseBodyRetrofit(myGithubName);
        stringRetrofit(myGithubName);
//        jsonRetrofit(myGithubName);
    }

    /**
     * 结合RxJava
     * @param myGithubName
     */
    private void rxRetrofit(String myGithubName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        gitHubService.rxUser(myGithubName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GitModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "----onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(GitModel gitModel) {
                        Log.d(TAG, "----onNext: name--->" + gitModel.getName());
                        Log.d(TAG, "----onNext: email--->" + gitModel.getEmail());
                        Log.d(TAG, "----onNext: blog--->" + gitModel.getBlog());
                    }
                });
    }

    /**
     * Retrofit 底层使用的 也是OkHttp，所以我们的请求完全也可以使用
     * OkHttp 的 Response 对象 中的 ResponseBody 对象来处理返回数据。
     * @param myGithubName
     */
    private void responseBodyRetrofit(String myGithubName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<ResponseBody> bodyCall = gitHubService.getResponseBody(myGithubName);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    /**
     * 返回String
     * @param myGithubName
     */
    private void stringRetrofit(String myGithubName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<String> stringCall = gitHubService.getData(myGithubName);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    /**
     * 返回json
     * @param myGithubName
     */
    private void jsonRetrofit(String myGithubName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())// 添加Json转换器支持
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<GitModel> modelCall = gitHubService.getUserInfo(myGithubName);
        modelCall.enqueue(new Callback<GitModel>() {
            @Override
            public void onResponse(Call<GitModel> call, Response<GitModel> response) {
                Log.d(TAG, "onResponse: " + response.body().getName());
            }

            @Override
            public void onFailure(Call<GitModel> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
}
