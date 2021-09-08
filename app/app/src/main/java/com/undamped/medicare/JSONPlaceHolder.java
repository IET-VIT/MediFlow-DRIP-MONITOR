package com.undamped.medicare;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolder {

    @GET("feeds.json?results=6")
    Call<Feeds> getFeeds();
}
