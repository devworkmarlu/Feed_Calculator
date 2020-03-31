package com.example.feedcalculator;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    Context context;
    String args;

    Double protien1 = 0.0, energy1 = 0.0, calcium1=0.0, phosphorus1 = 0.0;
    Double protien2 = 0.0, energy2 = 0.0, calcium2=0.0, phosphorus2 = 0.0;
    Double protien3 = 0.0, energy3 = 0.0, calcium3=0.0, phosphorus3 = 0.0;
    Double protien4 = 0.0, energy4 = 0.0, calcium4=0.0, phosphorus4 = 0.0;
    Double protien5 = 0.0, energy5 = 0.0, calcium5=0.0, phosphorus5 = 0.0;
    Double protien6 = 0.0, energy6 = 0.0, calcium6=0.0, phosphorus6 = 0.0;
    Double protien7 = 0.0, energy7 = 0.0, calcium7=0.0, phosphorus7 = 0.0;
    Double protien8 = 0.0, energy8 = 0.0, calcium8=0.0, phosphorus8 = 0.0;
    Double protien9 = 0.0, energy9 = 0.0, calcium9=0.0, phosphorus9 = 0.0;
    Double protien10 = 0.0, energy10 = 0.0, calcium10=0.0, phosphorus10 = 0.0;
    Double protien11 = 0.0, energy11 = 0.0, calcium11=0.0, phosphorus11 = 0.0;
    Double protien12 = 0.0, energy12 = 0.0, calcium12=0.0, phosphorus12 = 0.0;
    Double protien13 = 0.0, energy13 = 0.0, calcium13=0.0, phosphorus13 = 0.0;
    Double protien14 = 0.0, energy14 = 0.0, calcium14=0.0, phosphorus14 = 0.0;

    List<String> listDetails;

    public Ingredients(Context c, String a){
        context = c;
        args = a;
    }


    public String getAllIngredients(){
        String allingredients = new String();

        String item1 = "1\tBanana meal (peeled)\t5.35\t2600\t0.03\t0.11";
        String item2 = "2\tBanana meal (unpeeled)\t2.50\t1600\t0.02\t0.01";
        String item3 = "3\tBroken rice\t8\t3100\t0.03\t0.25";
        String item4 = "4\tCassava Meal Peeled\t1.80\t2400\t0.12\t0.10";
        String item5  = "5\tCassava Meal UnPeeled\t2.40\t1680\t0.20\t0.20";
        String item6 = "6\tCopra Meal\t20\t1800\t0.15\t0.60";
        String item7 = "7\tCorn\t8\t3400\t0.07\t0.25";
        String item8 = "8\tCorn Bran\t7.81\t1400\t0.06\t0.33";
        String item9 = "9\tDried Skim Meal\t33\t0\t1.25\t0.90";
        String item10 = "10\tFish Meal 55%\t55\t2700\t5.28\t2.78";
        String item11 = "11\tIpil-ipil leaf meal\t20\t800\t0.35\t0.27";
        String item12 = "12\tMolasses \t2.90\t1960\t0.80\t0.08";
        String item13 = "13\tRice Brand D1\t12.50\t2400\t0.08\t1.60";
        String item14 = "14\tSO Meal (Full Fat)\t38\t3300\t0.25\t0.59";

        allingredients = item1+"/"+item2+"/"+item3+"/"+item4+"/"+item5+"/"+item6+"/"+item7+"/"+item8+"/"+item9+"/"+item10+"/"+item11+"/"+item12+"/"+item13+"/"+item14;

        return allingredients;

    }

    public String getAllVariants(String selected){
        String variantList = new String();
        String allVariant = "";

        if(selected.contains("STARTER")){
            String variant1 = "STARTER - 1 - 2 Weeks:19.2:2750:0.96:0.47";
            String variant2 = "STARTER - 3 - 4 Weeks:19.6:2800:0.98:0.48";
            String variant3 = "STARTER - 5 - 6 Weeks:19.9:2850:1:0.48";

             allVariant = variant1+"/"+variant2+"/"+variant3;

        }
        if(selected.contains("GROWER")){
            String variant1 = "GROWER - 7 - 8 Weeks:15.7:2700:1.13:0.43";
            String variant2 = "GROWER - 9 - 10 Weeks:16:2750:1:0.46";
            String variant3 = "GROWER - 11 - 12 Weeks:16.3:2800:1.18:0.45";
            allVariant = variant1+"/"+variant2+"/"+variant3;

        }

        if(selected.contains("DEVELOPER")){
            String variant1 = "DEVELOPER - 13 - 14 Weeks:14:2650:0.9:0.4";
            String variant2 = "DEVELOPER - 15 - 16 Weeks:14.3:2700:0.95:0.44";
            String variant3 = "DEVELOPER - 17 - 18 Weeks:14.5:2750:0.95:0.45";

            allVariant = variant1+"/"+variant2+"/"+variant3;

        }
        if(selected.contains("LAYER1")){
            String variant1 = "LAYER1 - 19 - 26 Weeks:16.9:2700:3.45:0.42";
            String variant2 = "LAYER1 - 27 - 34 Weeks:17.2:2750:3.5:0.43";
            String variant3 = "LAYER1 - 35 - 42 Weeks:17.5:2800:3.58:0.44";

            allVariant = variant1+"/"+variant2+"/"+variant3;

        }
        if(selected.contains("LAYER2")){
            String variant1 = "LAYER2 - 43 - 44 Weeks:15.9:2700:3.66:0.4";
            String variant2 = "LAYER2 - 45 - 46 Weeks:16.2:2750:3.7:0.41";
            String variant3 = "LAYER2 - 47 - 48 Weeks:16.5:2800:3.8:0.41";

            allVariant = variant1+"/"+variant2+"/"+variant3;

        }
        variantList = allVariant;
        return variantList;
    }


    public void itemCalculations(Integer position, String protien, String energy, String calcium, String phosphorus){

        if (position ==1){
            protien1 = Double.parseDouble(protien);
            energy1 = Double.parseDouble(energy);
            calcium1 = Double.parseDouble(calcium);
            phosphorus1 = Double.parseDouble(phosphorus);
        }

        if (position ==2){
            protien2 = Double.parseDouble(protien);
            energy2 = Double.parseDouble(energy);
            calcium2 = Double.parseDouble(calcium);
            phosphorus2 = Double.parseDouble(phosphorus);
        }

        if (position ==3){
            protien3 = Double.parseDouble(protien);
            energy3 = Double.parseDouble(energy);
            calcium3 = Double.parseDouble(calcium);
            phosphorus3 = Double.parseDouble(phosphorus);
        }

        if (position ==4){
            protien4 = Double.parseDouble(protien);
            energy4 = Double.parseDouble(energy);
            calcium4 = Double.parseDouble(calcium);
            phosphorus4 = Double.parseDouble(phosphorus);
        }

        if (position ==5){
            protien5 = Double.parseDouble(protien);
            energy5 = Double.parseDouble(energy);
            calcium5 = Double.parseDouble(calcium);
            phosphorus5 = Double.parseDouble(phosphorus);
        }

        if (position ==6){
            protien6 = Double.parseDouble(protien);
            energy6 = Double.parseDouble(energy);
            calcium6 = Double.parseDouble(calcium);
            phosphorus6 = Double.parseDouble(phosphorus);
        }

        if (position ==7){
            protien7 = Double.parseDouble(protien);
            energy7 = Double.parseDouble(energy);
            calcium7 = Double.parseDouble(calcium);
            phosphorus7 = Double.parseDouble(phosphorus);
        }

        if (position ==8){
            protien8 = Double.parseDouble(protien);
            energy8 = Double.parseDouble(energy);
            calcium8 = Double.parseDouble(calcium);
            phosphorus8 = Double.parseDouble(phosphorus);
        }

        if (position ==9){
            protien9 = Double.parseDouble(protien);
            energy9 = Double.parseDouble(energy);
            calcium9 = Double.parseDouble(calcium);
            phosphorus9 = Double.parseDouble(phosphorus);
        }

        if (position ==10){
            protien10 = Double.parseDouble(protien);
            energy10 = Double.parseDouble(energy);
            calcium10 = Double.parseDouble(calcium);
            phosphorus10 = Double.parseDouble(phosphorus);
        }

        if (position ==11){
            protien11 = Double.parseDouble(protien);
            energy11 = Double.parseDouble(energy);
            calcium11 = Double.parseDouble(calcium);
            phosphorus11 = Double.parseDouble(phosphorus);
        }

        if (position ==12){
            protien12 = Double.parseDouble(protien);
            energy12 = Double.parseDouble(energy);
            calcium12 = Double.parseDouble(calcium);
            phosphorus12 = Double.parseDouble(phosphorus);
        }

        if (position ==13){
            protien13 = Double.parseDouble(protien);
            energy13 = Double.parseDouble(energy);
            calcium13 = Double.parseDouble(calcium);
            phosphorus13 = Double.parseDouble(phosphorus);
        }

        if (position ==14){
            protien14 = Double.parseDouble(protien);
            energy14 = Double.parseDouble(energy);
            calcium14 = Double.parseDouble(calcium);
            phosphorus14 = Double.parseDouble(phosphorus);
        }

        Double totalProtienResult = protien1+protien2+protien3+protien4+protien5+protien6+protien7+protien8+protien9+protien10+protien11+protien12+protien13+protien14;
        Double totalEnergyResult = energy1+energy2+energy3+energy4+energy5+energy6+energy7+energy8+energy9+energy10+energy11+energy12+energy13+energy14;
        Double totalCalciumResult = calcium1+calcium2+calcium3+calcium4+calcium5+calcium6+calcium7+calcium8+calcium9+calcium10+calcium11+calcium12+calcium13+calcium14;
        Double totalPhosphorusResult = phosphorus1+phosphorus2+phosphorus3+phosphorus4+phosphorus5+phosphorus6+phosphorus7+phosphorus8+phosphorus9+phosphorus10+phosphorus11+phosphorus12+phosphorus13+phosphorus14;

        Main3Activity.getInstance().displayResults(totalProtienResult,totalEnergyResult,totalCalciumResult,totalPhosphorusResult);


    }

    public void addItemstoList(String item){
        listDetails = new ArrayList<String>();

        listDetails.add(item);

    }
}
