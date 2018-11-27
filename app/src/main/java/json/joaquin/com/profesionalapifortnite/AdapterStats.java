package json.joaquin.com.profesionalapifortnite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import json.joaquin.com.profesionalapifortnite.DTO.ObjectDTO;

public class AdapterStats extends RecyclerView.Adapter<AdapterStats.StatsViewHolder> {


    private List<ObjectDTO> dataStats;

    public AdapterStats(List<ObjectDTO> dataObject) {
        this.dataStats = dataObject;
    }

    @NonNull
    @Override
    public StatsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cv_cell, viewGroup, false);
        StatsViewHolder pvh = new StatsViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(@NonNull StatsViewHolder statsViewHolder, int i) {
        final ObjectDTO obj = dataStats.get(i);
        statsViewHolder.txtTitle.setText(obj.getLabel());
        statsViewHolder.txtValue.setText(obj.getValue());
        statsViewHolder.txtRank.setText(obj.getRank());

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return dataStats.size();
    }

    public class StatsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle, txtValue, txtRank;

        public StatsViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.stats_cv1);
            txtValue = itemView.findViewById(R.id.stats_cv2);
            txtRank = itemView.findViewById(R.id.stats_cv3);
        }
    }
}
