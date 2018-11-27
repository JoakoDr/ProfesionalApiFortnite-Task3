package json.joaquin.com.profesionalapifortnite;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

import json.joaquin.com.profesionalapifortnite.DTO.ObjectDTO;

public class MainActivity extends AppCompatActivity  {
    public List<ObjectDTO> data = new ArrayList<>();
    private FloatingActionButton button;
    private EditText user;
    private Spinner spinner;
    private AdapterStats adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ViewModelStats mainViewModelStats;
    private String platform;
    private String username;

    public MainActivity() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         user = findViewById(R.id.etnickname);
         spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.floatingActionButton);
        changeData("pc","JoakoDR");
        pressButton();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void makeStatsLists(List<ObjectDTO> listStats) {
        recyclerView = findViewById(R.id.rvstats);
        recyclerView.setHasFixedSize(true);
        AdapterStats adapter = new AdapterStats(listStats);
        layoutManager = new GridLayoutManager(this , 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void pressButton(){
        button.setOnClickListener(v -> {
            platform = spinner.getSelectedItem().toString();
            username = user.getText().toString();
            mainViewModelStats.getStats(platform, username);
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void changeData(String platform, String user){
        mainViewModelStats = ViewModelProviders.of(this).get(ViewModelStats.class);
        mainViewModelStats.statsDataMutableLiveData.observe(this, dataObject -> {
        if(dataObject!=null) {
                     makeStatsLists(dataObject);
                }
        });
        mainViewModelStats.getStats(platform, user);
    }


    public FloatingActionButton getButton() {
        return button;
    }

    public void setButton(FloatingActionButton button) {
        this.button = button;
    }
}
