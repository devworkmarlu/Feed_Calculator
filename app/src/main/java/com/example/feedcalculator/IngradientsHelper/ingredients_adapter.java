package com.example.feedcalculator.IngradientsHelper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.feedcalculator.Database.DB;
import com.example.feedcalculator.Ingredients;
import com.example.feedcalculator.Main3Activity;
import com.example.feedcalculator.R;

import java.util.List;

public class ingredients_adapter extends RecyclerView.Adapter<ingredients_adapter.IngredientsHolderView> {

    private Context mCtx;
    private List<ingredients_model> ingredientsModelList;
    private OnitemsListener mOnitemListener;

    Ingredients ingred;
    DB db;

    public ingredients_adapter(Context mCtx, List<ingredients_model> ingredientsModelList, OnitemsListener onitemsListener) {
        this.mCtx = mCtx;
        this.ingredientsModelList = ingredientsModelList;
        this.mOnitemListener = onitemsListener;
    }

    @NonNull
    @Override
    public ingredients_adapter.IngredientsHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.ingredients_recyler, null);
        return new ingredients_adapter.IngredientsHolderView(view, mOnitemListener);

    }

    @Override
    public void onBindViewHolder(@NonNull final ingredients_adapter.IngredientsHolderView holder, int position) {
        final ingredients_model item = ingredientsModelList.get(position);
        ingred = new Ingredients(mCtx,"forCalculations");

        db = new DB(mCtx);
            holder.card_meal.setVisibility(View.GONE);
            holder.cb_meal.setText(String.valueOf(item.getMealName()));

            holder.cb_meal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.cb_meal.isChecked()){
                        holder.card_meal.setVisibility(View.VISIBLE);
                        Main3Activity.getInstance().selectedCheckBox("checked");
                        //notifyDataSetChanged();
                    }
                    else{
                        holder.tv_meal_distribution.setText("0");
                        holder.tv_meal_unitcost.setText("0");
                        holder.tv_meal_qty.setText("0");
                        holder.tv_meal_totalcost.setText("0");

                        holder.tv_meal_protien_result.setText("0");
                        holder.tv_meal_energy_result.setText("0");
                        holder.tv_meal_calcium_result.setText("0");
                        holder.tv_meal_phosphorus_result.setText("0");

                        String query = "UPDATE ingredientData SET stat = '0', protien = '"+ holder.tv_meal_protien_result.getText().toString() +"', energy = '"+holder.tv_meal_energy_result.getText().toString()+"', calcium = '"+holder.tv_meal_calcium_result.getText().toString()+"', phosphorus = '"+holder.tv_meal_phosphorus_result.getText().toString()+"' WHERE number = '"+String.valueOf(item.getMealNumber()+"'");
                        db.InsertUpdateDelete(query);

                        Main3Activity.getInstance().selectedCheckBox("unchecked");

                        holder.card_meal.setVisibility(View.GONE);
                        ingred.itemCalculations(Integer.parseInt(String.valueOf(item.getMealNumber())),holder.tv_meal_protien_result.getText().toString().trim(),holder.tv_meal_energy_result.getText().toString().trim(),holder.tv_meal_calcium_result.getText().toString().trim(),holder.tv_meal_phosphorus_result.getText().toString().trim());
                        Main3Activity.getInstance().getAllDistributionandUnitCost(Integer.parseInt(String.valueOf(item.getMealNumber())),Double.parseDouble(holder.tv_meal_distribution.getText().toString().trim()),Double.parseDouble(holder.tv_meal_totalcost.getText().toString().trim()),Double.parseDouble(holder.tv_meal_qty.getText().toString().trim()));
                    }
                }
            });


            holder.card_meal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  final Dialog  myDialog = new Dialog(mCtx);
                    myDialog.setContentView(R.layout.custom_alert);
                    myDialog.setCanceledOnTouchOutside(false);
                    final Button btnClose = myDialog.findViewById(R.id.btn_cancel);
                    final Button btnOk = myDialog.findViewById(R.id.btn_ok);
                    final TextView alertTitle = myDialog.findViewById(R.id.tv_alert_title_meal);
                    final EditText et_input_distribution = myDialog.findViewById(R.id.et_input_distribution);
                    final EditText et_input_unitcost = myDialog.findViewById(R.id.et_input_unitcost);
                    final TextView tv_asof_totaldistribution = myDialog.findViewById(R.id.tv_asof_totaldistribution);
                    alertTitle.setText(String.valueOf(item.getMealName()));

                    et_input_distribution.setText(holder.tv_meal_distribution.getText().toString().trim());
                    et_input_unitcost.setText(holder.tv_meal_unitcost.getText().toString().trim());

                    tv_asof_totaldistribution.setText(Main3Activity.getInstance().getAsofTotalDistribution());


                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            holder.tv_meal_distribution.setText(et_input_distribution.getText().toString().trim());
                            holder.tv_meal_unitcost.setText(et_input_unitcost.getText().toString().trim());

                            Double nContributionProtien = Double.parseDouble(String.valueOf(item.getProtienAnalist())) * Double.parseDouble(holder.tv_meal_distribution.getText().toString())/100;
                            Double nContributionMEKCAL = (Double.parseDouble(holder.tv_meal_distribution.getText().toString())* Double.parseDouble(String.valueOf(item.getEnertgyAnalist())) /100)/1000;
                            Double nContributionCalcium = Double.parseDouble(holder.tv_meal_distribution.getText().toString()) * Double.parseDouble(String.valueOf(item.getCalciumAnalist())) /100;
                            Double nContributionPhosphorus = Double.parseDouble(holder.tv_meal_distribution.getText().toString()) * Double.parseDouble(String.valueOf(item.getPhosphorusAnalist())) /100;
                            Double QuantityNeeded = Double.parseDouble(holder.tv_meal_distribution.getText().toString()) /2 ;
                            Double totalInPesos = QuantityNeeded * Double.parseDouble(holder.tv_meal_unitcost.getText().toString());

                            holder.tv_meal_totalcost.setText(totalInPesos.toString());
                            holder.tv_meal_qty.setText(QuantityNeeded.toString());
                            holder.tv_meal_protien_result.setText(nContributionProtien.toString());
                            holder.tv_meal_energy_result.setText(nContributionMEKCAL.toString());
                            holder.tv_meal_calcium_result.setText(nContributionCalcium.toString());
                            holder.tv_meal_phosphorus_result.setText(nContributionPhosphorus.toString());

                            String query = "UPDATE ingredientData SET stat = '1', protien = '"+ holder.tv_meal_protien_result.getText().toString() +"', energy = '"+holder.tv_meal_energy_result.getText().toString()+"', calcium = '"+holder.tv_meal_calcium_result.getText().toString()+"', phosphorus = '"+holder.tv_meal_phosphorus_result.getText().toString()+"' WHERE number = '"+String.valueOf(item.getMealNumber()+"'");
                            db.InsertUpdateDelete(query);
                            ingred.itemCalculations(Integer.parseInt(String.valueOf(item.getMealNumber())),holder.tv_meal_protien_result.getText().toString().trim(),holder.tv_meal_energy_result.getText().toString().trim(),holder.tv_meal_calcium_result.getText().toString().trim(),holder.tv_meal_phosphorus_result.getText().toString().trim());
                            Main3Activity.getInstance().getAllDistributionandUnitCost(Integer.parseInt(String.valueOf(item.getMealNumber())),Double.parseDouble(holder.tv_meal_distribution.getText().toString().trim()),Double.parseDouble(holder.tv_meal_totalcost.getText().toString().trim()),Double.parseDouble(holder.tv_meal_qty.getText().toString().trim()));

                            myDialog.dismiss();
                        }
                    });

                    btnClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            myDialog.dismiss();
                        }
                    });

                    myDialog.show();
                }
            });







    }

    @Override
    public int getItemCount() {
        return ingredientsModelList.size();
    }

     class IngredientsHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_meal_protien_result,tv_meal_energy_result,tv_meal_calcium_result,tv_meal_phosphorus_result, tv_meal_distribution, tv_meal_unitcost,tv_meal_qty,tv_meal_totalcost;
        CheckBox cb_meal;
        CardView card_meal;

         OnitemsListener onitemsListener;
       public final View view;

        public IngredientsHolderView(View view,OnitemsListener onitemsListener) {
            super(view);
                this.view = view;
                    tv_meal_protien_result  = view.findViewById(R.id.tv_meal_protien_result);
                    tv_meal_energy_result = view.findViewById(R.id.tv_meal_energy_result);
                    tv_meal_calcium_result = view.findViewById(R.id.tv_meal_calcium_result);
                    tv_meal_phosphorus_result = view.findViewById(R.id.tv_meal_phosphorus_result);
                    tv_meal_distribution = view.findViewById(R.id.tv_meal_distribution);
                    tv_meal_unitcost = view.findViewById(R.id.tv_meal_unitcost);
                    tv_meal_qty = view.findViewById(R.id.tv_meal_qty);
                    tv_meal_totalcost = view.findViewById(R.id.tv_meal_totalcost);

                    card_meal = view.findViewById(R.id.card_meal);

                    cb_meal = view.findViewById(R.id.cb_meal);

                    this.onitemsListener = onitemsListener;
                    itemView.setOnClickListener(this);
        }

         @Override
         public void onClick(View view) {
                onitemsListener.onitemClick(getAdapterPosition());
         }
     }

    public interface OnitemsListener{
        void onitemClick(int position);

    }
}
