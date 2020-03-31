package com.example.feedcalculator.IngradientsHelper;

public class ingredients_model {

    private String mealNumber;
    private String mealName;
    private String protienAnalist;
    private String enertgyAnalist;
    private String calciumAnalist;
    private String phosphorusAnalist;



    public ingredients_model(String mealNumber,String mealName, String protienAnalist, String enertgyAnalist, String calciumAnalist, String phosphorusAnalist) {
        this.mealNumber = mealNumber;
        this.mealName = mealName;
        this.protienAnalist = protienAnalist;
        this.enertgyAnalist = enertgyAnalist;
        this.calciumAnalist = calciumAnalist;
        this.phosphorusAnalist = phosphorusAnalist;
    }


    public String getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getProtienAnalist() {
        return protienAnalist;
    }

    public void setProtienAnalist(String protienAnalist) {
        this.protienAnalist = protienAnalist;
    }

    public String getEnertgyAnalist() {
        return enertgyAnalist;
    }

    public void setEnertgyAnalist(String enertgyAnalist) {
        this.enertgyAnalist = enertgyAnalist;
    }

    public String getCalciumAnalist() {
        return calciumAnalist;
    }

    public void setCalciumAnalist(String calciumAnalist) {
        this.calciumAnalist = calciumAnalist;
    }

    public String getPhosphorusAnalist() {
        return phosphorusAnalist;
    }

    public void setPhosphorusAnalist(String phosphorusAnalist) {
        this.phosphorusAnalist = phosphorusAnalist;
    }
}
