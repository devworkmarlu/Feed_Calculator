package com.example.feedcalculator;

import android.content.Context;

public class Calculation {

    Context context;
    String id;

    public Calculation(Context c, String args){
        context = c;
        id = args;
    }


    public String calculate1Meal(Integer mealNumber, String distribution, String unitCost){
        String result = new String();
        Double result1 = 0.0,result2 = 0.0,result3 = 0.0,result4 = 0.0;

        if (mealNumber==1){
            result1 = 5.35 * Double.parseDouble(distribution)/100;
            result2 = (Double.parseDouble(distribution)* 2600 /100)/1000;
            result3 = Double.parseDouble(distribution) * 0.03 /100;
            result4 = Double.parseDouble(distribution) * 0.11 /100;
        }

        result = result1.toString() + "/" + result2.toString() + "/"+result3.toString()+"/"+result4.toString();

        return result;
    }
}
