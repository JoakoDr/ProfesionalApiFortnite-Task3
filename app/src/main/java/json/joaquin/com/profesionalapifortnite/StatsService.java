package json.joaquin.com.profesionalapifortnite;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import json.joaquin.com.profesionalapifortnite.DTO.PlayerDTO;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatsService {
    @Headers("TRN-Api-Key: 30339b73-e56c-4152-bb52-5c0ed49b50cf")
    @GET("profile/{platform}/{epic-nickname}")
    Observable<PlayerDTO> loadChanges(@Path("platform") String platform, @Path("epic-nickname") String nickname);

    @RequiresApi(api = Build.VERSION_CODES.N)
    static StatsService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(StatsService.class);
    }
}
