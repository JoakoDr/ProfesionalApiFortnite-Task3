package json.joaquin.com.profesionalapifortnite;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import json.joaquin.com.profesionalapifortnite.DTO.ObjectDTO;
import json.joaquin.com.profesionalapifortnite.DTO.P2DTO;
import json.joaquin.com.profesionalapifortnite.DTO.PlayerDTO;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public class ViewModelStats extends ViewModel {

        private RepositoryStats repository = RepositoryStats.getInstance();
        public MutableLiveData<List<ObjectDTO>> statsDataMutableLiveData = new MutableLiveData<List<ObjectDTO>>();
        public List<ObjectDTO> data = new ArrayList<>();




        // fun getStatsDataMutableLiveData() = statsDataMutableLiveData
        public MutableLiveData<List<ObjectDTO>> getStatsDataMutableLiveData() {
            return statsDataMutableLiveData;
        }

        public void getStats(String platform, String user ) {
            repository.getChangeData(platform, user)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<PlayerDTO>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(PlayerDTO playerDTO) {
                            data.clear();
                            P2DTO p2DTO = playerDTO.getStats().getP2();
                            data.add(p2DTO.getScore());
                            data.add(p2DTO.getTrnRating());
                            data.add(p2DTO.getTop1());
                            data.add(p2DTO.getTop3());
                            statsDataMutableLiveData.postValue(data);

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }}



