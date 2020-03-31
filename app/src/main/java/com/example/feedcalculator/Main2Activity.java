package com.example.feedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Main2Activity extends AppCompatActivity {

    Spinner spinner1;
    TextView tv_meal1_distribution,tv_meal2_distribution,tv_meal3_distribution,tv_meal4_distribution,tv_meal5_distribution,tv_meal6_distribution,tv_meal7_distribution,tv_meal8_distribution,tv_meal9_distribution;
    TextView tv_meal1_unitcost,tv_meal2_unitcost,tv_meal3_unitcost,tv_meal4_unitcost,tv_meal5_unitcost,tv_meal6_unitcost,tv_meal7_unitcost,tv_meal8_unitcost, tv_meal9_unitcost;
    TextView tv_recommended_crude_protien,tv_recommended_calcium,tv_recommended_energy,tv_recommended_phosphorus;
    TextView tv_total_distributionholder,tv_total_unitcostholder,tv_total_crude_protien,tv_total_calcium,tv_total_energy,tv_total_phosphorus;
    TextView tv_meal1_protien,tv_meal2_protien,tv_meal3_protien,tv_meal4_protien,tv_meal5_protien,tv_meal6_protien,tv_meal7_protien,tv_meal8_protien,tv_meal9_protien;
    TextView tv_meal1_energy,tv_meal2_energy,tv_meal3_energy,tv_meal4_energy,tv_meal5_energy,tv_meal6_energy,tv_meal7_energy,tv_meal8_energy,tv_meal9_energy;
    TextView tv_meal1_calcium,tv_meal2_calcium,tv_meal3_calcium,tv_meal4_calcium,tv_meal5_calcium,tv_meal6_calcium,tv_meal7_calcium,tv_meal8_calcium,tv_meal9_calcium;
    TextView tv_meal1_phosphorus,tv_meal2_phosphorus,tv_meal3_phosphorus,tv_meal4_phosphorus,tv_meal5_phosphorus,tv_meal6_phosphorus,tv_meal7_phosphorus,tv_meal8_phosphorus,tv_meal9_phosphorus;
    CheckBox cb_meal1,cb_meal2,cb_meal3,cb_meal4,cb_meal5,cb_meal6,cb_meal7,cb_meal8, cb_meal9;
    CardView card_meal1,card_meal2,card_meal3,card_meal4,card_meal5,card_meal6,card_meal7,card_meal8, card_meal9;
    Integer counter;
    Button btn_proceed;
    Double meal1Protien = 0.0,meal2Protien = 0.0,meal3Protien = 0.0,meal4Protien = 0.0,meal5Protien = 0.0,meal6Protien = 0.0,meal7Protien = 0.0,meal8Protien = 0.0,meal9Protien = 0.0;
    Double meal1Calcium = 0.0,meal2Calcium = 0.0,meal3Calcium = 0.0,meal4Calcium = 0.0,meal5Calcium = 0.0,meal6Calcium = 0.0,meal7Calcium = 0.0,meal8Calcium = 0.0,meal9Calcium = 0.0;
    Double meal1Energy = 0.0,meal2Energy = 0.0,meal3Energy = 0.0,meal4Energy = 0.0,meal5Energy = 0.0,meal6Energy = 0.0,meal7Energy = 0.0,meal8Energy = 0.0,meal9Energy = 0.0;
    Double meal1Phosphorus = 0.0,meal2Phosphorus = 0.0,meal3Phosphorus = 0.0,meal4Phosphorus = 0.0,meal5Phosphorus = 0.0,meal6Phosphorus = 0.0,meal7Phosphorus = 0.0,meal8Phosphorus = 0.0,meal9Phosphorus = 0.0;

    Calculation calculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calculation = new Calculation(Main2Activity.this,"forCalculate");

        tv_total_distributionholder = findViewById(R.id.tv_total_distributionholder);
        tv_total_unitcostholder = findViewById(R.id.tv_total_unitcostholder);
        tv_total_crude_protien = findViewById(R.id.tv_total_crude_protien);
        tv_total_calcium = findViewById(R.id.tv_total_calcium);
        tv_total_energy = findViewById(R.id.tv_total_energy);
        tv_total_phosphorus = findViewById(R.id.tv_total_phosphorus);

        tv_meal1_distribution = findViewById(R.id.tv_meal1_distribution);
        tv_meal2_distribution = findViewById(R.id.tv_meal2_distribution);
        tv_meal3_distribution = findViewById(R.id.tv_meal3_distribution);
        tv_meal4_distribution = findViewById(R.id.tv_meal4_distribution);
        tv_meal5_distribution = findViewById(R.id.tv_meal5_distribution);
        tv_meal6_distribution = findViewById(R.id.tv_meal6_distribution);
        tv_meal7_distribution = findViewById(R.id.tv_meal7_distribution);
        tv_meal8_distribution = findViewById(R.id.tv_meal8_distribution);
        tv_meal9_distribution = findViewById(R.id.tv_meal9_distribution);

        tv_meal1_unitcost = findViewById(R.id.tv_meal1_unitcost);
        tv_meal2_unitcost = findViewById(R.id.tv_meal2_unitcost);
        tv_meal3_unitcost = findViewById(R.id.tv_meal3_unitcost);
        tv_meal4_unitcost = findViewById(R.id.tv_meal4_unitcost);
        tv_meal5_unitcost = findViewById(R.id.tv_meal5_unitcost);
        tv_meal6_unitcost = findViewById(R.id.tv_meal6_unitcost);
        tv_meal7_unitcost = findViewById(R.id.tv_meal7_unitcost);
        tv_meal8_unitcost = findViewById(R.id.tv_meal8_unitcost);
        tv_meal9_unitcost = findViewById(R.id.tv_meal9_unitcost);

        btn_proceed = findViewById(R.id.btn_proceed);

        tv_recommended_crude_protien = findViewById(R.id.tv_recommended_crude_protien);
        tv_recommended_calcium = findViewById(R.id.tv_recommended_calcium);
        tv_recommended_energy = findViewById(R.id.tv_recommended_energy);
        tv_recommended_phosphorus = findViewById(R.id.tv_recommended_phosphorus);

        cb_meal1 = findViewById(R.id.cb_meal1);
        cb_meal2 = findViewById(R.id.cb_meal2);
        cb_meal3 = findViewById(R.id.cb_meal3);
        cb_meal4 = findViewById(R.id.cb_meal4);
        cb_meal5 = findViewById(R.id.cb_meal5);
        cb_meal6 = findViewById(R.id.cb_meal6);
        cb_meal7 = findViewById(R.id.cb_meal7);
        cb_meal8 = findViewById(R.id.cb_meal8);
        cb_meal9 = findViewById(R.id.cb_meal9);

        spinner1 = findViewById(R.id.spinner1);
        card_meal1 = findViewById(R.id.card_meal1);
        card_meal2 = findViewById(R.id.card_meal2);
        card_meal3 = findViewById(R.id.card_meal3);
        card_meal4 = findViewById(R.id.card_meal4);
        card_meal5 = findViewById(R.id.card_meal5);
        card_meal6 = findViewById(R.id.card_meal6);
        card_meal7 = findViewById(R.id.card_meal7);
        card_meal8 = findViewById(R.id.card_meal8);
        card_meal9 = findViewById(R.id.card_meal9);

        counter = 0;
        BindTextView();
        hideAllCards();
        checkerListener();
        spinnerListener();
        cardsListener();



       btn_proceed.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(counter < 3){
                   new SweetAlertDialog(Main2Activity.this, SweetAlertDialog.ERROR_TYPE)
                           .setTitleText("Oops...")
                           .setContentText("You must atleast select 3 MEALS!")
                           .show();
               }
               else{

                   new SweetAlertDialog(Main2Activity.this, SweetAlertDialog.WARNING_TYPE)
                           .setTitleText("Are you sure?")
                           .setContentText("Won't be able to recover this file!")
                           .setCancelText("No,cancel plx!")
                           .setConfirmText("Yes,delete it!")
                           .showCancelButton(true)
                           .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                               @Override
                               public void onClick(SweetAlertDialog sDialog) {
                                   sDialog.cancel();
                               }
                           })
                           .show();
               }
           }
       });
    }

    private void BindTextView(){

        tv_meal1_protien = findViewById(R.id.tv_meal1_protien); tv_meal1_energy = findViewById(R.id.tv_meal1_energy); tv_meal1_calcium = findViewById(R.id.tv_meal1_calcium); tv_meal1_phosphorus = findViewById(R.id.tv_meal1_phosphorus);
        tv_meal2_protien = findViewById(R.id.tv_meal2_protien); tv_meal2_energy = findViewById(R.id.tv_meal2_energy); tv_meal2_calcium = findViewById(R.id.tv_meal2_calcium); tv_meal2_phosphorus = findViewById(R.id.tv_meal2_phosphorus);
        tv_meal3_protien = findViewById(R.id.tv_meal3_protien); tv_meal3_energy = findViewById(R.id.tv_meal3_energy); tv_meal3_calcium = findViewById(R.id.tv_meal3_calcium); tv_meal3_phosphorus = findViewById(R.id.tv_meal3_phosphorus);
        tv_meal4_protien = findViewById(R.id.tv_meal4_protien); tv_meal4_energy = findViewById(R.id.tv_meal4_energy); tv_meal4_calcium = findViewById(R.id.tv_meal4_calcium); tv_meal4_phosphorus = findViewById(R.id.tv_meal4_phosphorus);
        tv_meal5_protien = findViewById(R.id.tv_meal5_protien); tv_meal5_energy = findViewById(R.id.tv_meal5_energy); tv_meal5_calcium = findViewById(R.id.tv_meal5_calcium); tv_meal5_phosphorus = findViewById(R.id.tv_meal5_phosphorus);
        tv_meal6_protien = findViewById(R.id.tv_meal6_protien); tv_meal6_energy = findViewById(R.id.tv_meal6_energy); tv_meal6_calcium = findViewById(R.id.tv_meal6_calcium); tv_meal6_phosphorus = findViewById(R.id.tv_meal6_phosphorus);
        tv_meal7_protien = findViewById(R.id.tv_meal7_protien); tv_meal7_energy = findViewById(R.id.tv_meal7_energy); tv_meal7_calcium = findViewById(R.id.tv_meal7_calcium); tv_meal7_phosphorus = findViewById(R.id.tv_meal7_phosphorus);
        tv_meal8_protien = findViewById(R.id.tv_meal8_protien); tv_meal8_energy = findViewById(R.id.tv_meal8_energy); tv_meal8_calcium = findViewById(R.id.tv_meal8_calcium); tv_meal8_phosphorus = findViewById(R.id.tv_meal8_phosphorus);
        tv_meal9_protien = findViewById(R.id.tv_meal9_protien); tv_meal9_energy = findViewById(R.id.tv_meal9_energy); tv_meal9_calcium = findViewById(R.id.tv_meal9_calcium); tv_meal9_phosphorus = findViewById(R.id.tv_meal9_phosphorus);



    }

    private void spinnerListener(){
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(String.valueOf(spinner1.getSelectedItem()).contains("1 - 2")){
                    tv_recommended_crude_protien.setText("15.90");
                    tv_recommended_calcium.setText("2700");
                    tv_recommended_energy.setText("3.66");
                    tv_recommended_phosphorus.setText("0.40");
                }

                if(String.valueOf(spinner1.getSelectedItem()).contains("3 - 4")){
                    tv_recommended_crude_protien.setText("16.20");
                    tv_recommended_calcium.setText("2750");
                    tv_recommended_energy.setText("3.70");
                    tv_recommended_phosphorus.setText("0.41");
                }

                if(String.valueOf(spinner1.getSelectedItem()).contains("5 - 6")){
                    tv_recommended_crude_protien.setText("16.50");
                    tv_recommended_calcium.setText("2800");
                    tv_recommended_energy.setText("3.80");
                    tv_recommended_phosphorus.setText("0.41");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    private void hideAllCards(){

        card_meal1.setVisibility(View.GONE);
        card_meal2.setVisibility(View.GONE);
        card_meal3.setVisibility(View.GONE);
        card_meal4.setVisibility(View.GONE);
        card_meal5.setVisibility(View.GONE);
        card_meal6.setVisibility(View.GONE);
        card_meal7.setVisibility(View.GONE);
        card_meal8.setVisibility(View.GONE);
        card_meal9.setVisibility(View.GONE);

    }


    private void checkerListener(){

        cb_meal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal1.isChecked()){
                    counter ++;
                    card_meal1.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal1_distribution.setText("0"); tv_meal1_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal1.setVisibility(View.GONE);
                }
            }
        });

        cb_meal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal2.isChecked()){
                    counter ++;
                    card_meal2.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal2_distribution.setText("0"); tv_meal2_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal2.setVisibility(View.GONE);
                }
            }
        });

        cb_meal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal3.isChecked()){
                    counter ++;
                    card_meal3.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal3_distribution.setText("0"); tv_meal3_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal3.setVisibility(View.GONE);
                }
            }
        });

        cb_meal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal4.isChecked()){
                    counter ++;
                    card_meal4.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal4_distribution.setText("0"); tv_meal4_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal4.setVisibility(View.GONE);
                }
            }
        });

        cb_meal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal5.isChecked()){
                    counter ++;
                    card_meal5.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal5_distribution.setText("0"); tv_meal5_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal5.setVisibility(View.GONE);
                }
            }
        });

        cb_meal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal6.isChecked()){
                    counter ++;
                    card_meal6.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal6_distribution.setText("0"); tv_meal6_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal6.setVisibility(View.GONE);
                }
            }
        });

        cb_meal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal7.isChecked()){
                    counter ++;
                    card_meal7.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal7_distribution.setText("0"); tv_meal7_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal7.setVisibility(View.GONE);
                }
            }
        });

        cb_meal8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal8.isChecked()){
                    counter ++;
                    card_meal8.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal8_distribution.setText("0"); tv_meal8_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal8.setVisibility(View.GONE);
                }
            }
        });

        cb_meal9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_meal9.isChecked()){
                    counter ++;
                    card_meal9.setVisibility(View.VISIBLE);
                }else{
                    counter --;
                    tv_meal9_distribution.setText("0"); tv_meal9_unitcost.setText("0");
                    totalDistributionAndCost();
                    card_meal9.setVisibility(View.GONE);
                }
            }
        });


    }

    private void totalDistributionAndCost(){

        Double totalDistribution,totalCost;

        totalDistribution = Double.parseDouble(tv_meal1_distribution.getText().toString()) + Double.parseDouble(tv_meal2_distribution.getText().toString()) + Double.parseDouble(tv_meal3_distribution.getText().toString()) + Double.parseDouble(tv_meal4_distribution.getText().toString()) + Double.parseDouble(tv_meal5_distribution.getText().toString()) + Double.parseDouble(tv_meal6_distribution.getText().toString()) + Double.parseDouble(tv_meal7_distribution.getText().toString()) + Double.parseDouble(tv_meal8_distribution.getText().toString()) + Double.parseDouble(tv_meal9_distribution.getText().toString());
        totalCost = Double.parseDouble(tv_meal1_unitcost.getText().toString()) + Double.parseDouble(tv_meal2_unitcost.getText().toString()) + Double.parseDouble(tv_meal3_unitcost.getText().toString()) + Double.parseDouble(tv_meal4_unitcost.getText().toString()) + Double.parseDouble(tv_meal5_unitcost.getText().toString()) + Double.parseDouble(tv_meal6_unitcost.getText().toString()) + Double.parseDouble(tv_meal7_unitcost.getText().toString()) + Double.parseDouble(tv_meal8_unitcost.getText().toString()) + Double.parseDouble(tv_meal9_unitcost.getText().toString());
        //Double todisplay = totalDistribution / Double.parseDouble(counter.toString()) *100;

        tv_total_distributionholder.setText(totalDistribution.toString());
        tv_total_unitcostholder.setText(totalCost.toString());

    }

    private void cardsListener(){

        card_meal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL1");
            }
        });

        card_meal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL2");
            }
        });

        card_meal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL3");
            }
        });

        card_meal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL4");
            }
        });

        card_meal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL5");
            }
        });

        card_meal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL6");
            }
        });

        card_meal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL7");
            }
        });

        card_meal8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL8");
            }
        });

        card_meal9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert("MEAL9");
            }
        });

    }

    private void showCustomAlert(final String requestingform){

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.custom_alert, null);
        final EditText et_input_distribution = alertLayout.findViewById(R.id.et_input_distribution);
        final EditText et_input_unitcost = alertLayout.findViewById(R.id.et_input_unitcost);
        final TextView tv_asof_totaldistribution = alertLayout.findViewById(R.id.tv_asof_totaldistribution);


        tv_asof_totaldistribution.setText(tv_total_distributionholder.getText().toString());

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Info");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });


            if(requestingform =="MEAL1"){
                et_input_distribution.setText(tv_meal1_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal1_unitcost.getText().toString());
            }

            if(requestingform =="MEAL2"){
                et_input_distribution.setText(tv_meal2_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal2_unitcost.getText().toString());
            }
            if(requestingform =="MEAL3"){
                et_input_distribution.setText(tv_meal3_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal3_unitcost.getText().toString());
            }
            if(requestingform =="MEAL4"){
                et_input_distribution.setText(tv_meal4_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal4_unitcost.getText().toString());
            }
            if(requestingform =="MEAL5"){
                et_input_distribution.setText(tv_meal5_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal5_unitcost.getText().toString());
            }
            if(requestingform =="MEAL6"){
                et_input_distribution.setText(tv_meal6_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal6_unitcost.getText().toString());
            }
            if(requestingform =="MEAL7"){
                et_input_distribution.setText(tv_meal7_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal7_unitcost.getText().toString());
            }
            if(requestingform =="MEAL8"){
                et_input_distribution.setText(tv_meal8_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal8_unitcost.getText().toString());
            }
            if(requestingform =="MEAL9"){
                et_input_distribution.setText(tv_meal9_distribution.getText().toString());
                et_input_unitcost.setText(tv_meal9_unitcost.getText().toString());
            }


        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                    if(requestingform=="MEAL1"){
                        tv_meal1_distribution.setText(et_input_distribution.getText().toString().trim());
                        tv_meal1_unitcost.setText(et_input_unitcost.getText().toString().trim());
                        calculateMeal1();
                        getTotalNutrients();
                    }
                    if(requestingform=="MEAL2"){
                        tv_meal2_distribution.setText(et_input_distribution.getText().toString().trim());
                        tv_meal2_unitcost.setText(et_input_unitcost.getText().toString().trim());
                        calculateMeal2();
                        getTotalNutrients();
                    }
                if(requestingform=="MEAL3"){
                    tv_meal3_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal3_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal3();
                    getTotalNutrients();
                }
                if(requestingform=="MEAL4"){
                    tv_meal4_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal4_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal4();
                    getTotalNutrients();
                }
                if(requestingform=="MEAL5"){
                    tv_meal5_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal5_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal5();
                    getTotalNutrients();
                }
                if(requestingform=="MEAL6"){
                    tv_meal6_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal6_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal6();
                    getTotalNutrients();
                }
                if(requestingform=="MEAL7"){
                    tv_meal7_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal7_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal7();
                    getTotalNutrients();
                }
                if(requestingform=="MEAL8"){
                    tv_meal8_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal8_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal8();
                    getTotalNutrients();
                }

                if(requestingform=="MEAL9"){
                    tv_meal9_distribution.setText(et_input_distribution.getText().toString().trim());
                    tv_meal9_unitcost.setText(et_input_unitcost.getText().toString().trim());
                    calculateMeal9();
                    getTotalNutrients();
                }

                totalDistributionAndCost();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void calculateMeal1(){

        //meal1Protien = 0.0; meal1Calcium = 0.0; meal1Energy = 0.0; meal1Phosphorus = 0.0;
        String modularResult = calculation.calculate1Meal(1,tv_meal1_distribution.getText().toString(),tv_meal1_unitcost.getText().toString());


        Double nContributionProtien = 5.35 * Double.parseDouble(tv_meal1_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal1_distribution.getText().toString())* 2600 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal1_distribution.getText().toString()) * 0.03 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal1_distribution.getText().toString()) * 0.11 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal1_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal1_unitcost.getText().toString());

        tv_meal1_protien.setText(nContributionProtien.toString()); tv_meal1_energy.setText(nContributionMEKCAL.toString()); tv_meal1_calcium.setText(nContributionCalcium.toString()); tv_meal1_phosphorus.setText(nContributionPhosphorus.toString());



    }

    private void calculateMeal2(){

        //meal2Protien = 0.0; meal2Calcium = 0.0; meal2Energy = 0.0; meal2Phosphorus = 0.0;

        Double nContributionProtien = 20 * Double.parseDouble(tv_meal2_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal2_distribution.getText().toString())* 1800 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal2_distribution.getText().toString()) * 0.15 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal2_distribution.getText().toString()) * 0.6 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal2_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal2_unitcost.getText().toString());

        tv_meal2_protien.setText(nContributionProtien.toString()); tv_meal2_energy.setText(nContributionMEKCAL.toString()); tv_meal2_calcium.setText(nContributionCalcium.toString()); tv_meal2_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal3(){

        //meal3Protien = 0.0; meal3Calcium = 0.0; meal3Energy = 0.0; meal3Phosphorus = 0.0;

        Double nContributionProtien = 33 * Double.parseDouble(tv_meal3_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal3_distribution.getText().toString())* 0 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal3_distribution.getText().toString()) * 1.25 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal3_distribution.getText().toString()) * 0.9 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal3_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal3_unitcost.getText().toString());

        tv_meal3_protien.setText(nContributionProtien.toString()); tv_meal3_energy.setText(nContributionMEKCAL.toString()); tv_meal3_calcium.setText(nContributionCalcium.toString()); tv_meal3_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal4(){

        //meal4Protien = 0.0; meal4Calcium = 0.0; meal4Energy = 0.0; meal4Phosphorus = 0.0;

        Double nContributionProtien = 55 * Double.parseDouble(tv_meal4_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal4_distribution.getText().toString())* 2700 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal4_distribution.getText().toString()) * 5.28 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal4_distribution.getText().toString()) * 2.78 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal4_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal4_unitcost.getText().toString());

        tv_meal4_protien.setText(nContributionProtien.toString()); tv_meal4_energy.setText(nContributionMEKCAL.toString()); tv_meal4_calcium.setText(nContributionCalcium.toString()); tv_meal4_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal5(){

        //meal5Protien = 0.0; meal5Calcium = 0.0; meal5Energy = 0.0; meal5Phosphorus = 0.0;

        Double nContributionProtien = 20 * Double.parseDouble(tv_meal5_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal5_distribution.getText().toString())* 800 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal5_distribution.getText().toString()) * 0.35 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal5_distribution.getText().toString()) * 0.27 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal5_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal5_unitcost.getText().toString());

        tv_meal5_protien.setText(nContributionProtien.toString()); tv_meal5_energy.setText(nContributionMEKCAL.toString()); tv_meal5_calcium.setText(nContributionCalcium.toString()); tv_meal5_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal6(){

        //meal6Protien = 0.0; meal6Calcium = 0.0; meal6Energy = 0.0; meal6Phosphorus = 0.0;

        Double nContributionProtien = 2.9 * Double.parseDouble(tv_meal6_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal6_distribution.getText().toString())* 1960 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal6_distribution.getText().toString()) * 0.8 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal6_distribution.getText().toString()) * 0.08 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal6_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal6_unitcost.getText().toString());

        tv_meal6_protien.setText(nContributionProtien.toString()); tv_meal6_energy.setText(nContributionMEKCAL.toString()); tv_meal6_calcium.setText(nContributionCalcium.toString()); tv_meal6_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal7(){

        //meal7Protien = 0.0; meal7Calcium = 0.0; meal7Energy = 0.0; meal7Phosphorus = 0.0;

        Double nContributionProtien = 12.5 * Double.parseDouble(tv_meal7_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal7_distribution.getText().toString())* 2400 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal7_distribution.getText().toString()) * 0.08 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal7_distribution.getText().toString()) * 1.6 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal7_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal7_unitcost.getText().toString());

        tv_meal7_protien.setText(nContributionProtien.toString()); tv_meal7_energy.setText(nContributionMEKCAL.toString()); tv_meal7_calcium.setText(nContributionCalcium.toString()); tv_meal7_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal8(){

        //meal8Protien = 0.0; meal8Calcium = 0.0; meal8Energy = 0.0; meal8Phosphorus = 0.0;

        Double nContributionProtien = 38 * Double.parseDouble(tv_meal8_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal8_distribution.getText().toString())* 3300 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal8_distribution.getText().toString()) * 0.25 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal8_distribution.getText().toString()) * 0.59 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal8_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal8_unitcost.getText().toString());

        tv_meal8_protien.setText(nContributionProtien.toString()); tv_meal8_energy.setText(nContributionMEKCAL.toString()); tv_meal8_calcium.setText(nContributionCalcium.toString()); tv_meal8_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void calculateMeal9(){

        //meal9Protien = 0.0; meal9Calcium = 0.0; meal9Energy = 0.0; meal9Phosphorus = 0.0;

        Double nContributionProtien = 8 * Double.parseDouble(tv_meal9_distribution.getText().toString())/100;
        Double nContributionMEKCAL = (Double.parseDouble(tv_meal9_distribution.getText().toString())* 3400 /100)/1000;
        Double nContributionCalcium = Double.parseDouble(tv_meal9_distribution.getText().toString()) * 0.07 /100;
        Double nContributionPhosphorus = Double.parseDouble(tv_meal9_distribution.getText().toString()) * 0.25 /100;
        Double QuantityNeeded = Double.parseDouble(tv_meal9_distribution.getText().toString()) /2 ;
        Double totalInPesos = QuantityNeeded * Double.parseDouble(tv_meal9_unitcost.getText().toString());

        tv_meal9_protien.setText(nContributionProtien.toString()); tv_meal9_energy.setText(nContributionMEKCAL.toString()); tv_meal9_calcium.setText(nContributionCalcium.toString()); tv_meal9_phosphorus.setText(nContributionPhosphorus.toString());

    }

    private void getTotalNutrients(){


        Double totalProtien = Double.parseDouble(tv_meal1_protien.getText().toString()) + Double.parseDouble(tv_meal2_protien.getText().toString()) + Double.parseDouble(tv_meal3_protien.getText().toString()) + Double.parseDouble(tv_meal4_protien.getText().toString()) + Double.parseDouble(tv_meal5_protien.getText().toString()) + Double.parseDouble(tv_meal6_protien.getText().toString()) + Double.parseDouble(tv_meal7_protien.getText().toString()) + Double.parseDouble(tv_meal8_protien.getText().toString())+ Double.parseDouble(tv_meal9_protien.getText().toString());
        Double totalEnergy = Double.parseDouble(tv_meal1_energy.getText().toString()) + Double.parseDouble(tv_meal2_energy.getText().toString()) + Double.parseDouble(tv_meal3_energy.getText().toString()) + Double.parseDouble(tv_meal4_energy.getText().toString()) +Double.parseDouble(tv_meal5_energy.getText().toString()) +Double.parseDouble(tv_meal6_energy.getText().toString()) +Double.parseDouble(tv_meal7_energy.getText().toString()) +Double.parseDouble(tv_meal8_energy.getText().toString())+ Double.parseDouble(tv_meal9_energy.getText().toString());
        Double totalCalcium = Double.parseDouble(tv_meal1_calcium.getText().toString()) + Double.parseDouble(tv_meal2_calcium.getText().toString()) + Double.parseDouble(tv_meal3_calcium.getText().toString()) + Double.parseDouble(tv_meal4_calcium.getText().toString()) +Double.parseDouble(tv_meal5_calcium.getText().toString()) + Double.parseDouble(tv_meal6_calcium.getText().toString()) + Double.parseDouble(tv_meal7_calcium.getText().toString()) + Double.parseDouble(tv_meal8_calcium.getText().toString()) + Double.parseDouble(tv_meal9_calcium.getText().toString());
        Double totalPhosphorus = Double.parseDouble(tv_meal1_phosphorus.getText().toString()) + Double.parseDouble(tv_meal2_phosphorus.getText().toString()) + Double.parseDouble(tv_meal3_phosphorus.getText().toString()) + Double.parseDouble(tv_meal4_phosphorus.getText().toString()) + Double.parseDouble(tv_meal5_phosphorus.getText().toString()) + Double.parseDouble(tv_meal6_phosphorus.getText().toString()) + Double.parseDouble(tv_meal7_phosphorus.getText().toString())+ Double.parseDouble(tv_meal8_phosphorus.getText().toString())+ Double.parseDouble(tv_meal9_phosphorus.getText().toString());

        tv_total_crude_protien.setText(totalProtien.toString()); tv_total_energy.setText(totalEnergy.toString()); tv_total_calcium.setText(totalCalcium.toString()); tv_total_phosphorus.setText(totalPhosphorus.toString());
    }
}
