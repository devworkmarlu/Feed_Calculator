package com.example.feedcalculator;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.feedcalculator.Database.DB;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    Button btn_menu1, btn_menu2,btn_menu3,btn_menu4,btn_menu5;
    DB database;
    Ingredients ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new DB(MainActivity.this);
        ingredients = new Ingredients(MainActivity.this,"forInitialLoad");
        btn_menu1 = findViewById(R.id.btn_menu1);
        btn_menu2 = findViewById(R.id.btn_menu2);
        btn_menu3 = findViewById(R.id.btn_menu3);
        btn_menu4 = findViewById(R.id.btn_menu4);
        btn_menu5 = findViewById(R.id.btn_menu5);

        addInitialData();

        btn_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(),   Main3Activity.class);
                myIntent.putExtra("SELECTED_VARIANT", btn_menu1.getText().toString().trim());
                startActivity(myIntent);
            }
        });

        btn_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(),   Main3Activity.class);
                myIntent.putExtra("SELECTED_VARIANT", btn_menu2.getText().toString().trim());
                startActivity(myIntent);

            }
        });

        btn_menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(),   Main3Activity.class);
                myIntent.putExtra("SELECTED_VARIANT", btn_menu3.getText().toString().trim());
                startActivity(myIntent);
            }
        });

        btn_menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(),   Main3Activity.class);
                myIntent.putExtra("SELECTED_VARIANT", btn_menu4.getText().toString().trim());
                startActivity(myIntent);


            }
        });

        btn_menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(),   Main3Activity.class);
                myIntent.putExtra("SELECTED_VARIANT", btn_menu5.getText().toString().trim());
                startActivity(myIntent);

            }
        });

    }

    private void addInitialData(){
        database.InsertUpdateDelete("DELETE FROM ingredientData");
        String ingredientsData = ingredients.getAllIngredients();

        String[] str = ingredientsData.split("/");
        int listSize = str.length;

        for(int i =0; i<listSize;i++){
            String[] str2 = str[i].split("\t");
            String values = "'0',"+"'"+str2[0]+"','"+str2[1]+"','0','0','0','0'";
            String query = "INSERT INTO ingredientData (stat,number,name,protien,energy,calcium,phosphorus) VALUES ("+values+")";
            database.InsertUpdateDelete(query);

            /*new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Query")
                    .setContentText(query)
                    .setConfirmText("Ok man i got it!")
                    .show();*/
        }

    }

    private void checkAllData(){
        Cursor cursor = database.ingredientsAll();
        if (cursor.moveToFirst()) {
            do {

                    String name=cursor.getString(cursor.getColumnIndex("name"));

                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Query")
                        .setContentText(name)
                        .setConfirmText("Ok man i got it!")
                        .show();


            } while (cursor.moveToNext());
        }

        cursor.close();
    }
}
