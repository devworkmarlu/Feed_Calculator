package com.example.feedcalculator.SummaryHelper;

public class summary_model {

    private String mealName;
    private String protienAnalist;
    private String enertgyAnalist;
    private String calciumAnalist;
    private String phosphorusAnalist;

    public summary_model(String mealName, String protienAnalist, String enertgyAnalist, String calciumAnalist, String phosphorusAnalist) {
        this.mealName = mealName;
        this.protienAnalist = protienAnalist;
        this.enertgyAnalist = enertgyAnalist;
        this.calciumAnalist = calciumAnalist;
        this.phosphorusAnalist = phosphorusAnalist;
    }

    public String getMealName() {
        return mealName;
    }

    public String getProtienAnalist() {
        return protienAnalist;
    }

    public String getEnertgyAnalist() {
        return enertgyAnalist;
    }

    public String getCalciumAnalist() {
        return calciumAnalist;
    }

    public String getPhosphorusAnalist() {
        return phosphorusAnalist;
    }
}
