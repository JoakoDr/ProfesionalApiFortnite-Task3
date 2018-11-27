package json.joaquin.com.profesionalapifortnite;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.List;

import io.reactivex.Observable;
import json.joaquin.com.profesionalapifortnite.DTO.PlayerDTO;


@RequiresApi(api = Build.VERSION_CODES.N)
public class RepositoryStats {
    private static RepositoryStats instance;

    private RepositoryStats() {
    }

    public static RepositoryStats getInstance() {
        if (instance == null){
            synchronized (RepositoryStats.class){
                if (instance == null){
                    instance = new RepositoryStats();
                }
            }
        }

        return instance;
    }


    private StatsService apiService = StatsService.create();


    public Observable<PlayerDTO> getChangeData(String platform, String user) {
        return apiService.loadChanges(platform,user);
    }

}
