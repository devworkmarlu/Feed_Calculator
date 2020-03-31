package com.example.feedcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.feedcalculator.Database.DB;
import com.example.feedcalculator.IngradientsHelper.ingredients_adapter;
import com.example.feedcalculator.IngradientsHelper.ingredients_model;
import com.example.feedcalculator.SummaryHelper.summary_adapter;
import com.example.feedcalculator.SummaryHelper.summary_model;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Main3Activity extends AppCompatActivity implements ingredients_adapter.OnitemsListener {

    RecyclerView ingredientsRecycler;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ingredients_model> itemListActivity;
    ingredients_adapter ingredientsAdapter;

    private List<summary_model> summaryList;
    summary_adapter summaryAdapter;

    Ingredients ingredients;
    String items;

    Button btn_summary,btn_proceed;
    Spinner spinner1;

    TextView tv_total_distritbution,tv_total_cost,tv_total_qty,tv_recommended_protien,tv_recommended_energy,tv_recommended_calcium,tv_recommended_phosphorus;
    TextView tv_protien_result, tv_energy_result, tv_calcium_result, tv_phosphorus_result, tv_variant_selected;

    Double meal1 = 0.0,meal2 = 0.0,meal3 = 0.0,meal4 = 0.0,meal5 = 0.0,meal6 = 0.0,meal7 = 0.0,meal8 = 0.0,meal9 = 0.0,meal10 = 0.0,meal11 = 0.0,meal12 = 0.0,meal13 = 0.0,meal14 = 0.0;
    Double cost1 = 0.0,cost2 = 0.0,cost3 = 0.0,cost4 = 0.0,cost5 = 0.0,cost6 = 0.0,cost7 = 0.0,cost8 = 0.0,cost9 = 0.0,cost10 = 0.0,cost11 = 0.0,cost12 = 0.0,cost13 = 0.0,cost14 = 0.0;
    Double qty1=0.0,qty2=0.0,qty3=0.0,qty4=0.0,qty5=0.0,qty6=0.0,qty7=0.0,qty8=0.0,qty9=0.0,qty10=0.0,qty11=0.0,qty12=0.0,qty13=0.0,qty14=0.0;

    Integer counter = 0;

    public String selectedVariant = "";
    public String selectedVariantDetails = "";
    public String selectedIngredients = "";

    private static Main3Activity instance;

    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ingredientsRecycler = findViewById(R.id.rv_ingredients);

        spinner1 = findViewById(R.id.spinner1);

        btn_summary = findViewById(R.id.btn_summary);
        btn_proceed = findViewById(R.id.btn_proceed);
        tv_total_distritbution = findViewById(R.id.tv_total_distritbution);
        tv_total_cost = findViewById(R.id.tv_total_cost);
        tv_total_qty = findViewById(R.id.tv_total_qty);
        tv_variant_selected = findViewById(R.id.tv_variant_selected);

        tv_recommended_protien = findViewById(R.id.tv_recommended_protien);
        tv_recommended_energy = findViewById(R.id.tv_recommended_energy);
        tv_recommended_calcium = findViewById(R.id.tv_recommended_calcium);
        tv_recommended_phosphorus = findViewById(R.id.tv_recommended_phosphorus);

        tv_protien_result = findViewById(R.id.tv_protien_result);
        tv_energy_result = findViewById(R.id.tv_energy_result);
        tv_calcium_result = findViewById(R.id.tv_calcium_result);
        tv_phosphorus_result = findViewById(R.id.tv_phosphorus_result);

        ingredientsRecycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(Main3Activity.this);
        db = new DB(Main3Activity.this);
        ingredientsRecycler.setLayoutManager(mLayoutManager);
        itemListActivity = new ArrayList<>();

        ingredientsRecycler.setItemViewCacheSize(14);
        ingredients = new Ingredients(Main3Activity.this,"fetchIngredients");
        instance = this;

        selectedVariant = getIntent().getStringExtra("SELECTED_VARIANT");
        tv_variant_selected.setText(selectedVariant);
        loadVariantinSpinner();
        spinnerListener();
        loadIngredients();



        btn_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkAllData();
            }
        });

        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter>=3){
                    Toast.makeText(Main3Activity.this, "PROCEED", Toast.LENGTH_SHORT).show();
                }else{
                    new SweetAlertDialog(Main3Activity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops...")
                            .setContentText("You must atleast select 3 MEALS!")
                            .show();
                }
            }
        });
    }


    private void loadIngredients(){
        itemListActivity.clear();
        String[] str = ingredients.getAllIngredients().split("/");

            for (int i =0; i<14;i++){
                String localitem = str[i].trim();

                   String[] detail = localitem.split("\t");

                    ingredients_model item = new ingredients_model(

                            detail[0], detail[1],detail[2],detail[3],detail[4],detail[5]

                    );

                itemListActivity.add(item);
            }

        ingredientsAdapter = new ingredients_adapter(Main3Activity.this, itemListActivity,Main3Activity.this);
        ingredientsRecycler.setAdapter(ingredientsAdapter);

    }

    @Override
    public void onitemClick(int position) {

        Log.d("MainActivity3Click", "onitemClick: "+position);

    }

    public void getAllDistributionandUnitCost(Integer position, Double distribution, Double cost, Double qty){


        if (position==1){
            meal1 = distribution;
            cost1 = cost;
            qty1 = qty;
        }

        if (position==2){
            meal2 = distribution;
            cost2 = cost;
            qty2 = qty;
        }

        if (position==3){
            meal3 = distribution;
            cost3 = cost;
            qty3 = qty;
        }

        if (position==4){
            meal4 = distribution;
            cost4 = cost;
            qty4 = qty;
        }

        if (position==5){
            meal5 = distribution;
            cost5 = cost;
            qty5 = qty;
        }

        if (position==6){
            meal6 = distribution;
            cost6 = cost;
            qty6 = qty;
        }

        if (position==7){
            meal7 = distribution;
            cost7 = cost;
            qty7 = qty;
        }

        if (position==8){
            meal8 = distribution;
            cost8 = cost;
            qty8 = qty;
        }

        if (position==9){
            meal9 = distribution;
            cost9 = cost;
            qty9 = qty;
        }

        if (position==10){
            meal10 = distribution;
            cost10 = cost;
            qty10 = qty;
        }

        if (position==11){
            meal11 = distribution;
            cost11 = cost;
            qty11 = qty;
        }

        if (position==12){
            meal12 = distribution;
            cost12 = cost;
            qty12 = qty;
        }

        if (position==13){
            meal13 = distribution;
            cost13 = cost;
            qty13 = qty;
        }

        if (position==14){
            meal14 = distribution;
            cost14 = cost;
            qty14 = qty;
        }


        Double totalDistribution = meal1 +meal2 +meal3+meal4+meal5+meal6+meal7+meal8+meal9+meal10+meal11+meal12+meal13+meal14;
        Double totalCost = cost1+cost2+cost3+cost4+cost5+cost6+cost7+cost8+cost9+cost10+cost11+cost12+cost13+cost14;
        Double totalQty = qty1+qty2+qty3+qty4+qty5+qty6+qty7+qty8+qty9+qty10+qty11+qty12+qty13+qty14;
        tv_total_distritbution.setText(totalDistribution.toString());
        tv_total_cost.setText(totalCost.toString());
        tv_total_qty.setText(totalQty.toString());

    }

    public String getAsofTotalDistribution(){
        String totalDistribution = tv_total_distritbution.getText().toString().trim();
        return  totalDistribution;
    }

    public void displayResults(Double protien, Double energy, Double calcium, Double phosphorus){

        tv_protien_result.setText(String.format("%.2f", protien));
        tv_energy_result.setText(String.format("%.2f", energy));
        tv_calcium_result.setText(String.format("%.2f", calcium));
        tv_phosphorus_result.setText(String.format("%.2f", phosphorus));
    }

    public static Main3Activity getInstance() {
        return instance;
    }

    private void loadVariantinSpinner(){

       String variants =  ingredients.getAllVariants(selectedVariant);
        selectedVariantDetails = variants;
        List<String> list = new ArrayList<String>();
            String[] sep = variants.split("/");
        for (int i = 0; i<=2; i++){
            String[] variantName = sep[i].split(":");
            list.add(variantName[0]);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    private void spinnerListener(){
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {


                String[] str = selectedVariantDetails.split("/");

                for(int i =0; i<=2;i++){
                    if (str[i].contains(String.valueOf(spinner1.getSelectedItem()))){
                        String[] str2 = str[i].split(":");
                        tv_recommended_protien.setText(str2[1]);
                        tv_recommended_energy.setText(str2[2]);
                        tv_recommended_calcium.setText(str2[3]);
                        tv_recommended_phosphorus.setText(str2[4]);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void selectedCheckBox(String todo){

        if(todo=="checked"){
            counter++;
        }
        if(todo=="unchecked"){
            counter--;
        }

    }

    private void checkAllData(){

        String selectedData = "";

        Cursor cursor = db.ingredientsAll();
        if (cursor.moveToFirst()) {
            do {

                String name=cursor.getString(cursor.getColumnIndex("name"));
                String protien=cursor.getString(cursor.getColumnIndex("protien"));
                String energy=cursor.getString(cursor.getColumnIndex("energy"));
                String calcium=cursor.getString(cursor.getColumnIndex("calcium"));
                String phosphorus=cursor.getString(cursor.getColumnIndex("phosphorus"));


                selectedData += name+":"+protien+":"+energy+":"+calcium+":"+phosphorus+"/";
            } while (cursor.moveToNext());
        }

        cursor.close();

        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Query")
                .setContentText(selectedData)
                .setConfirmText("Ok man i got it!")
                .show();

        displaySummary(selectedData);

    }

    private void displaySummary(String selectedItems){

        final Dialog myDialog = new Dialog(Main3Activity.this);
        myDialog.setContentView(R.layout.custom_summary);
        myDialog.setCanceledOnTouchOutside(false);
        final RecyclerView rv_summary = myDialog.findViewById(R.id.rv_summary);
        final Button btn_summary_finish = myDialog.findViewById(R.id.btn_summary_finish);
        final TextView tv_summary_totalcost = myDialog.findViewById(R.id.tv_summary_totalcost);
        final TextView tv_summary_totalqty = myDialog.findViewById(R.id.tv_summary_totalqty);

        rv_summary.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(Main3Activity.this);
        db = new DB(Main3Activity.this);
        rv_summary.setLayoutManager(mLayoutManager);
        summaryList = new ArrayList<>();
        rv_summary.setItemViewCacheSize(14);


        tv_summary_totalcost.setText(tv_total_cost.getText().toString().trim());
        tv_summary_totalqty.setText(tv_total_qty.getText().toString().trim());

        summaryList.clear();
        String[] str = selectedItems.split("/");
        Integer selectedCounter = str.length;

        for (int i =0; i<selectedCounter;i++){
            String localitem = str[i].trim();

            String[] detail = localitem.split(":");

            summary_model item = new summary_model(

                    detail[0], detail[1],detail[2],detail[3],detail[4]

            );

            summaryList.add(item);
        }

        summaryAdapter = new summary_adapter(Main3Activity.this, summaryList);
        rv_summary.setAdapter(summaryAdapter);

        btn_summary_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.show();

    }
}
