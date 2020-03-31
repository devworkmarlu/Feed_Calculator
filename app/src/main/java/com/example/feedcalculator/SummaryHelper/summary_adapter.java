package com.example.feedcalculator.SummaryHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feedcalculator.IngradientsHelper.ingredients_model;
import com.example.feedcalculator.R;

import java.util.List;

public class summary_adapter extends RecyclerView.Adapter<summary_adapter.SummaryHolder> {

    private Context mctx;
    private List<summary_model> summaryList;

    public summary_adapter(Context mctx, List<summary_model> summaryList) {
        this.mctx = mctx;
        this.summaryList = summaryList;
    }

    @NonNull
    @Override
    public summary_adapter.SummaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.summary_recycler,null);
        return new summary_adapter.SummaryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull summary_adapter.SummaryHolder holder, int position) {
        final summary_model item = summaryList.get(position);

        holder.tv_summary_ingredient.setText(String.valueOf(item.getMealName()));
        holder.tv_summary_protien.setText(String.valueOf(item.getProtienAnalist()));
        holder.tv_summary_energy.setText(String.valueOf(item.getEnertgyAnalist()));
        holder.tv_summary_calcium.setText(String.valueOf(item.getCalciumAnalist()));
        holder.tv_summary_phosphorus.setText(String.valueOf(item.getPhosphorusAnalist()));


    }

    @Override
    public int getItemCount() {
       return summaryList.size();
    }


     class SummaryHolder extends RecyclerView.ViewHolder {

        TextView tv_summary_ingredient,tv_summary_energy, tv_summary_calcium, tv_summary_phosphorus, tv_summary_protien, tv_summary_quantity, tv_summary_totalcost;


        public SummaryHolder(View itemView){
            super(itemView);

            tv_summary_ingredient = itemView.findViewById(R.id.tv_summary_ingredient);
            tv_summary_energy = itemView.findViewById(R.id.tv_summary_energy);
            tv_summary_calcium = itemView.findViewById(R.id.tv_summary_calcium);
            tv_summary_phosphorus = itemView.findViewById(R.id.tv_summary_phosphorus);
            tv_summary_protien = itemView.findViewById(R.id.tv_summary_protien);
            tv_summary_quantity = itemView.findViewById(R.id.tv_summary_quantity);
            tv_summary_totalcost = itemView.findViewById(R.id.tv_summary_totalcost);

        }
    }
}
