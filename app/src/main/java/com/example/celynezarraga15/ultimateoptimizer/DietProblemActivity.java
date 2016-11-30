package com.example.celynezarraga15.ultimateoptimizer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class DietProblemActivity extends AppCompatActivity {


    SQLiteOpenHelper optimizerDBHelper;
    SQLiteDatabase db;
    HashMap<String,Integer> constants = new HashMap<String, Integer>();
    HashMap<String,ArrayList<String>> chosenFoodDetail = new HashMap<String, ArrayList<String>>();
    public ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8;
    public ImageButton imageButton9, imageButton10, imageButton11, imageButton12, imageButton13, imageButton14, imageButton15, imageButton16;
    public ImageButton imageButton17, imageButton18, imageButton19, imageButton20, imageButton21, imageButton22, imageButton23, imageButton24;
    public ImageButton imageButton25, imageButton26, imageButton27, imageButton28, imageButton29, imageButton30, imageButton31, imageButton32;
    public ImageButton imageButton33, imageButton34, imageButton35, imageButton36, imageButton37, imageButton38, imageButton39, imageButton40;
    public ImageButton imageButton41, imageButton42, imageButton43, imageButton44, imageButton45, imageButton46, imageButton47, imageButton48;
    public ImageButton imageButton49, imageButton50, imageButton51, imageButton52, imageButton53, imageButton54, imageButton55, imageButton56;
    public ImageButton imageButton57, imageButton58, imageButton59, imageButton60, imageButton61, imageButton62, imageButton63, imageButton64;
    ArrayList<String> chosenFoods;
    ArrayList<String> foodList;
    ArrayList<String> columnHeaders = new ArrayList<String>();
    ArrayList<String> variableNames = new ArrayList<String>();
    boolean infeasible;
    String solutionFound;
    Float optimalsolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_problem);

        infeasible = false;

        try{
            optimizerDBHelper = new OptimizerDatabaseHelper(this);
            db = optimizerDBHelper.getReadableDatabase();

            chosenFoods = new ArrayList<String>();
            foodList = new ArrayList<String>();
            setUpFoodList();
            setConstants();
            setUpButtons();

//            getFoodDetails(1);
        }
        catch(SQLiteException e){

        }
    }

    private void setUpFoodList(){
        foodList.add("Food");
        foodList.add("Frozen Broccoli");
        foodList.add("Raw Carrots");
        foodList.add("Raw Celery");
        foodList.add("Frozen Corn");
        foodList.add("Raw Iceberg Lettuce");
        foodList.add("Raw Sweet Pepper");
        foodList.add("Baked Potatoes");
        foodList.add("Tofu");
        foodList.add("Roasted Chicken");
        foodList.add("Spaghetti with Sauce");
        foodList.add("Tomato");
        foodList.add("Apple");
        foodList.add("Banana");
        foodList.add("Grapes");
        foodList.add("Kiwifruit");
        foodList.add("Oranges");
        foodList.add("Bagels");
        foodList.add("Wheat Bread");
        foodList.add("White Bread");
        foodList.add("Oatmeal Cookies");
        foodList.add("Apple Pie");
        foodList.add("Chocolate Chip Cookies");
        foodList.add("Regular Butter");
        foodList.add("Cheddar Cheese");
        foodList.add("3.3% Fat Whole Milk");
        foodList.add("2% Lowfat Milk");
        foodList.add("Skim Milk");
        foodList.add("Poached Eggs");
        foodList.add("Scrambled Eggs");
        foodList.add("Turkey Bologna");
        foodList.add("Frankfurter Beef");
        foodList.add("Extra Lean Sliced Ham");
        foodList.add("Kielbassa Pork");
        foodList.add("Cap'N Crunch");
        foodList.add("Cheerios");
        foodList.add("Corn Flakes, Kellogg's");
        foodList.add("Raisin Bran, Kellogg's");
        foodList.add("Rice Krispies");
        foodList.add("Special K");
        foodList.add("Oatmeal");
        foodList.add("Malt-O-Meal Chocolate");
        foodList.add("Pizza with Pepperoni");
        foodList.add("Taco");
        foodList.add("Hamburger with Toppings");
        foodList.add("Hotdog");
        foodList.add("Couscous");
        foodList.add("White Rice");
        foodList.add("Macaroni");
        foodList.add("Peanut Butter");
        foodList.add("Pork");
        foodList.add("Sardines in Oil");
        foodList.add("White Tuna in Water");
        foodList.add("Air-Popped Popcorn");
        foodList.add("Potato Chips Barbecue Flavor");
        foodList.add("Pretzels");
        foodList.add("Tortilla Chip");
        foodList.add("Chicken Noodle Soup");
        foodList.add("Split Pea and Ham Soup");
        foodList.add("Vegetable Beef Soup");
        foodList.add("New England Clam Chowder");
        foodList.add("Tomato Soup");
        foodList.add("New England Clam Chowder with Milk");
        foodList.add("Cream Mushroom Soup");
        foodList.add("Bean with Bacon Soup");
    }

    private void setUpButtons(){
        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButton33 = (ImageButton) findViewById(R.id.imageButton33);
        imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButton35 = (ImageButton) findViewById(R.id.imageButton35);
        imageButton36 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton37 = (ImageButton) findViewById(R.id.imageButton37);
        imageButton38 = (ImageButton) findViewById(R.id.imageButton38);
        imageButton39 = (ImageButton) findViewById(R.id.imageButton39);
        imageButton40 = (ImageButton) findViewById(R.id.imageButton40);
        imageButton41 = (ImageButton) findViewById(R.id.imageButton41);
        imageButton42 = (ImageButton) findViewById(R.id.imageButton42);
        imageButton43 = (ImageButton) findViewById(R.id.imageButton43);
        imageButton44 = (ImageButton) findViewById(R.id.imageButton44);
        imageButton45 = (ImageButton) findViewById(R.id.imageButton45);
        imageButton46 = (ImageButton) findViewById(R.id.imageButton46);
        imageButton47 = (ImageButton) findViewById(R.id.imageButton47);
        imageButton48 = (ImageButton) findViewById(R.id.imageButton48);
        imageButton49 = (ImageButton) findViewById(R.id.imageButton49);
        imageButton50 = (ImageButton) findViewById(R.id.imageButton50);
        imageButton51 = (ImageButton) findViewById(R.id.imageButton51);
        imageButton52 = (ImageButton) findViewById(R.id.imageButton52);
        imageButton53 = (ImageButton) findViewById(R.id.imageButton53);
        imageButton54 = (ImageButton) findViewById(R.id.imageButton54);
        imageButton55 = (ImageButton) findViewById(R.id.imageButton55);
        imageButton56 = (ImageButton) findViewById(R.id.imageButton56);
        imageButton57 = (ImageButton) findViewById(R.id.imageButton57);
        imageButton58 = (ImageButton) findViewById(R.id.imageButton58);
        imageButton59 = (ImageButton) findViewById(R.id.imageButton59);
        imageButton60 = (ImageButton) findViewById(R.id.imageButton60);
        imageButton61 = (ImageButton) findViewById(R.id.imageButton61);
        imageButton62 = (ImageButton) findViewById(R.id.imageButton62);
        imageButton63 = (ImageButton) findViewById(R.id.imageButton63);
        imageButton64 = (ImageButton) findViewById(R.id.imageButton64);


        //initial images
        imageButton1.setImageResource(R.drawable.broccoli);
        imageButton2.setImageResource(R.drawable.carrots);
        imageButton3.setImageResource(R.drawable.celery);
        imageButton4.setImageResource(R.drawable.corn);
        imageButton5.setImageResource(R.drawable.lettuce);
        imageButton6.setImageResource(R.drawable.pepper);
        imageButton7.setImageResource(R.drawable.potato);
        imageButton8.setImageResource(R.drawable.tofu);
        imageButton9.setImageResource(R.drawable.chicken);
        imageButton10.setImageResource(R.drawable.spaghetti);
        imageButton11.setImageResource(R.drawable.tomato);
        imageButton12.setImageResource(R.drawable.apple);
        imageButton13.setImageResource(R.drawable.banana);
        imageButton14.setImageResource(R.drawable.grapes);
        imageButton15.setImageResource(R.drawable.kiwi);
        imageButton16.setImageResource(R.drawable.orange);
        imageButton17.setImageResource(R.drawable.bagel);
        imageButton18.setImageResource(R.drawable.wheatbread);
        imageButton19.setImageResource(R.drawable.whitebread);
        imageButton20.setImageResource(R.drawable.oatmealcookies);
        imageButton21.setImageResource(R.drawable.applepie);
        imageButton22.setImageResource(R.drawable.chocolatecookie);
        imageButton23.setImageResource(R.drawable.butter);
        imageButton24.setImageResource(R.drawable.cheese);
        imageButton25.setImageResource(R.drawable.wholemilk);
        imageButton26.setImageResource(R.drawable.lowfat);
        imageButton27.setImageResource(R.drawable.skimmilk);
        imageButton28.setImageResource(R.drawable.poachedegg);
        imageButton29.setImageResource(R.drawable.scrambledegg);
        imageButton30.setImageResource(R.drawable.bolognaturkey);
        imageButton31.setImageResource(R.drawable.frankfurter);
        imageButton32.setImageResource(R.drawable.slicedham);
        imageButton33.setImageResource(R.drawable.kielbassa);
        imageButton34.setImageResource(R.drawable.capncrunch);
        imageButton35.setImageResource(R.drawable.cheerios);
        imageButton36.setImageResource(R.drawable.cornflakes);
        imageButton37.setImageResource(R.drawable.raisinbran);
        imageButton38.setImageResource(R.drawable.ricekrispies);
        imageButton39.setImageResource(R.drawable.specialk);
        imageButton40.setImageResource(R.drawable.oatmeal);
        imageButton41.setImageResource(R.drawable.maltomeal);
        imageButton42.setImageResource(R.drawable.pepperoni);
        imageButton43.setImageResource(R.drawable.taco);
        imageButton44.setImageResource(R.drawable.burger);
        imageButton45.setImageResource(R.drawable.hotdog);
        imageButton46.setImageResource(R.drawable.couscous);
        imageButton47.setImageResource(R.drawable.whiterice);
        imageButton48.setImageResource(R.drawable.macaroni);
        imageButton49.setImageResource(R.drawable.peanutbutter);
        imageButton50.setImageResource(R.drawable.pork);
        imageButton51.setImageResource(R.drawable.sardines);
        imageButton52.setImageResource(R.drawable.whitetuna);
        imageButton53.setImageResource(R.drawable.popcorn);
        imageButton54.setImageResource(R.drawable.potatochips);
        imageButton55.setImageResource(R.drawable.pretzel);
        imageButton56.setImageResource(R.drawable.tortillachips);
        imageButton57.setImageResource(R.drawable.chickensoup);
        imageButton58.setImageResource(R.drawable.splitpeaandham);
        imageButton59.setImageResource(R.drawable.vegetbeef);
        imageButton60.setImageResource(R.drawable.newengclamchowder);
        imageButton61.setImageResource(R.drawable.tomatosoup);
        imageButton62.setImageResource(R.drawable.clamchowderwithmilk);
        imageButton63.setImageResource(R.drawable.creamofmushroom);
        imageButton64.setImageResource(R.drawable.beanbacon);

        //listeners
        imageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Frozen Broccoli")) {
                    imageButton1.setImageResource(R.drawable.broccoli);
                    chosenFoods.remove("Frozen Broccoli");
                }
                else{
                    imageButton1.setImageResource(R.drawable.broccoli1);
                    chosenFoods.add("Frozen Broccoli");
                }
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Carrots")) {
                    imageButton2.setImageResource(R.drawable.carrots);
                    chosenFoods.remove("Raw Carrots");
                }
                else{
                    imageButton2.setImageResource(R.drawable.carrots1);
                    chosenFoods.add("Raw Carrots");
                }
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Celery")) {
                    imageButton3.setImageResource(R.drawable.celery);
                    chosenFoods.remove("Raw Celery");
                }
                else{
                    imageButton3.setImageResource(R.drawable.celery1);
                    chosenFoods.add("Raw Celery");
                }
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Frozen Corn")) {
                    imageButton4.setImageResource(R.drawable.corn);
                    chosenFoods.remove("Frozen Corn");
                }
                else{
                    imageButton4.setImageResource(R.drawable.corn1);
                    chosenFoods.add("Frozen Corn");
                }
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Iceberg Lettuce")) {
                    imageButton5.setImageResource(R.drawable.lettuce);
                    chosenFoods.remove("Raw Iceberg Lettuce");
                }
                else{
                    imageButton5.setImageResource(R.drawable.lettuce1);
                    chosenFoods.add("Raw Iceberg Lettuce");
                }
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Sweet Pepper")) {
                    imageButton6.setImageResource(R.drawable.pepper);
                    chosenFoods.remove("Raw Sweet Pepper");
                }
                else{
                    imageButton6.setImageResource(R.drawable.pepper1);
                    chosenFoods.add("Raw Sweet Pepper");
                }
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Baked Potatoes")) {
                    imageButton7.setImageResource(R.drawable.potato);
                    chosenFoods.remove("Baked Potatoes");
                }
                else{
                    imageButton7.setImageResource(R.drawable.potato1);
                    chosenFoods.add("Baked Potatoes");
                }
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Tofu")) {
                    imageButton8.setImageResource(R.drawable.tofu);
                    chosenFoods.remove("Tofu");
                }
                else{
                    imageButton8.setImageResource(R.drawable.tofu1);
                    chosenFoods.add("Tofu");
                }
            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Roasted Chicken")) {
                    imageButton9.setImageResource(R.drawable.chicken);
                    chosenFoods.remove("Roasted Chicken");
                }
                else{
                    imageButton9.setImageResource(R.drawable.chicken1);
                    chosenFoods.add("Roasted Chicken");
                }
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Spaghetti with Sauce")) {
                    imageButton10.setImageResource(R.drawable.spaghetti);
                    chosenFoods.remove("Spaghetti with Sauce");
                }
                else{
                    imageButton10.setImageResource(R.drawable.spaghetti1);
                    chosenFoods.add("Spaghetti with Sauce");
                }
            }
        });
        imageButton11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Tomato")) {
                    imageButton11.setImageResource(R.drawable.tomato);
                    chosenFoods.remove("Tomato");
                }
                else{
                    imageButton11.setImageResource(R.drawable.tomato1);
                    chosenFoods.add("Tomato");
                }
            }
        });
        imageButton12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Apple")) {
                    imageButton12.setImageResource(R.drawable.apple);
                    chosenFoods.remove("Apple");
                }
                else{
                    imageButton12.setImageResource(R.drawable.apple1);
                    chosenFoods.add("Apple");
                }
            }
        });
        imageButton13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Banana")) {
                    imageButton13.setImageResource(R.drawable.banana);
                    chosenFoods.remove("Banana");
                }
                else{
                    imageButton13.setImageResource(R.drawable.banana1);
                    chosenFoods.add("Banana");
                }
            }
        });
        imageButton14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Grapes")) {
                    imageButton14.setImageResource(R.drawable.grapes);
                    chosenFoods.remove("Grapes");
                }
                else{
                    imageButton14.setImageResource(R.drawable.grapes1);
                    chosenFoods.add("Grapes");
                }
            }
        });
        imageButton15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Kiwifruit")) {
                    imageButton15.setImageResource(R.drawable.kiwi);
                    chosenFoods.remove("Kiwifruit");
                }
                else{
                    imageButton15.setImageResource(R.drawable.kiwi1);
                    chosenFoods.add("Kiwifruit");
                }
            }
        });
        imageButton16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Oranges")) {
                    imageButton16.setImageResource(R.drawable.orange);
                    chosenFoods.remove("Oranges");
                }
                else{
                    imageButton16.setImageResource(R.drawable.orange1);
                    chosenFoods.add("Oranges");
                }
            }
        });
        imageButton17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Bagels")) {
                    imageButton17.setImageResource(R.drawable.bagel);
                    chosenFoods.remove("Bagels");
                }
                else{
                    imageButton17.setImageResource(R.drawable.bagel1);
                    chosenFoods.add("Bagels");
                }
            }
        });
        imageButton18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Wheat Bread")) {
                    imageButton18.setImageResource(R.drawable.wheatbread);
                    chosenFoods.remove("Wheat Bread");
                }
                else{
                    imageButton18.setImageResource(R.drawable.wheatbread1);
                    chosenFoods.add("Wheat Bread");
                }
            }
        });
        imageButton19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("White Bread")) {
                    imageButton19.setImageResource(R.drawable.whitebread);
                    chosenFoods.remove("White Bread");
                }
                else{
                    imageButton19.setImageResource(R.drawable.whitebread1);
                    chosenFoods.add("White Bread");
                }
            }
        });
        imageButton20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Oatmeal Cookies")) {
                    imageButton20.setImageResource(R.drawable.oatmealcookies);
                    chosenFoods.remove("Oatmeal Cookies");
                }
                else{
                    imageButton20.setImageResource(R.drawable.oatmealcookies1);
                    chosenFoods.add("Oatmeal Cookies");
                }
            }
        });
        imageButton21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Apple Pie")) {
                    imageButton21.setImageResource(R.drawable.applepie);
                    chosenFoods.remove("Apple Pie");
                }
                else{
                    imageButton21.setImageResource(R.drawable.applepie1);
                    chosenFoods.add("Apple Pie");
                }
            }
        });
        imageButton22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Chocolate Chip Cookies")) {
                    imageButton22.setImageResource(R.drawable.chocolatecookie);
                    chosenFoods.remove("Chocolate Chip Cookies");
                }
                else{
                    imageButton22.setImageResource(R.drawable.chocolatecookie1);
                    chosenFoods.add("Chocolate Chip Cookies");
                }
            }
        });
        imageButton23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Regular Butter")) {
                    imageButton23.setImageResource(R.drawable.butter);
                    chosenFoods.remove("Regular Butter");
                }
                else{
                    imageButton23.setImageResource(R.drawable.butter1);
                    chosenFoods.add("Regular Butter");
                }
            }
        });
        imageButton24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Cheddar Cheese")) {
                    imageButton24.setImageResource(R.drawable.cheese);
                    chosenFoods.remove("Cheddar Cheese");
                }
                else{
                    imageButton24.setImageResource(R.drawable.cheese1);
                    chosenFoods.add("Cheddar Cheese");
                }
            }
        });
        imageButton25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("3.3% Fat Whole Milk")) {
                    imageButton25.setImageResource(R.drawable.wholemilk);
                    chosenFoods.remove("3.3% Fat Whole Milk");
                }
                else{
                    imageButton25.setImageResource(R.drawable.wholemilk1);
                    chosenFoods.add("3.3% Fat Whole Milk");
                }
            }
        });
        imageButton26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("2% Lowfat Milk")) {
                    imageButton26.setImageResource(R.drawable.lowfat);
                    chosenFoods.remove("2% Lowfat Milk");
                }
                else{
                    imageButton26.setImageResource(R.drawable.lowfatmilk1);
                    chosenFoods.add("2% Lowfat Milk");
                }
            }
        });
        imageButton27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Skim Milk")) {
                    imageButton27.setImageResource(R.drawable.skimmilk);
                    chosenFoods.remove("Skim Milk");
                }
                else{
                    imageButton27.setImageResource(R.drawable.skimmilk1);
                    chosenFoods.add("Skim Milk");
                }
            }
        });
        imageButton28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Poached Eggs")) {
                    imageButton28.setImageResource(R.drawable.poachedegg);
                    chosenFoods.remove("Poached Eggs");
                }
                else{
                    imageButton28.setImageResource(R.drawable.poachedegg1);
                    chosenFoods.add("Poached Eggs");
                }
            }
        });
        imageButton29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Scrambled Eggs")) {
                    imageButton29.setImageResource(R.drawable.scrambledegg);
                    chosenFoods.remove("Scrambled Eggs");
                }
                else{
                    imageButton29.setImageResource(R.drawable.scrambledegg1);
                    chosenFoods.add("Scrambled Eggs");
                }
            }
        });
        imageButton30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Turkey Bologna")) {
                    imageButton30.setImageResource(R.drawable.bolognaturkey);
                    chosenFoods.remove("Turkey Bologna");
                }
                else{
                    imageButton30.setImageResource(R.drawable.bolognaturkey1);
                    chosenFoods.add("Turkey Bologna");
                }
            }
        });
        imageButton31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Frankfurter Beef")) {
                    imageButton31.setImageResource(R.drawable.frankfurter);
                    chosenFoods.remove("Frankfurter Beef");
                }
                else{
                    imageButton31.setImageResource(R.drawable.frankfurter1);
                    chosenFoods.add("Frankfurter Beef");
                }
            }
        });
        imageButton32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Extra Lean Sliced Ham")) {
                    imageButton32.setImageResource(R.drawable.slicedham);
                    chosenFoods.remove("Extra Lean Sliced Ham");
                }
                else{
                    imageButton32.setImageResource(R.drawable.slicedham1);
                    chosenFoods.add("Extra Lean Sliced Ham");
                }
            }
        });
        imageButton33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Kielbassa Pork")) {
                    imageButton33.setImageResource(R.drawable.kielbassa);
                    chosenFoods.remove("Kielbassa Pork");
                }
                else{
                    imageButton33.setImageResource(R.drawable.kielbassa1);
                    chosenFoods.add("Kielbassa Pork");
                }
            }
        });
        imageButton34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Cap'N Crunch")) {
                    imageButton34.setImageResource(R.drawable.capncrunch);
                    chosenFoods.remove("Cap'N Crunch");
                }
                else{
                    imageButton34.setImageResource(R.drawable.capncrunch1);
                    chosenFoods.add("Cap'N Crunch");
                }
            }
        });
        imageButton35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Cheerios")) {
                    imageButton35.setImageResource(R.drawable.cheerios);
                    chosenFoods.remove("Cheerios");
                }
                else{
                    imageButton35.setImageResource(R.drawable.cheerios1);
                    chosenFoods.add("Cheerios");
                }
            }
        });
        imageButton36.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Corn Flakes, Kellogg's")) {
                    imageButton36.setImageResource(R.drawable.cornflakes);
                    chosenFoods.remove("Corn Flakes, Kellogg's");
                }
                else{
                    imageButton36.setImageResource(R.drawable.cornflakes1);
                    chosenFoods.add("Corn Flakes, Kellogg's");
                }
            }
        });
        imageButton37.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raisin Bran, Kellogg's")) {
                    imageButton37.setImageResource(R.drawable.raisinbran);
                    chosenFoods.remove("Raisin Bran, Kellogg's");
                }
                else{
                    imageButton37.setImageResource(R.drawable.raisinbran1);
                    chosenFoods.add("Raisin Bran, Kellogg's");
                }
            }
        });
        imageButton38.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Rice Krispies")) {
                    imageButton38.setImageResource(R.drawable.ricekrispies);
                    chosenFoods.remove("Rice Krispies");
                }
                else{
                    imageButton38.setImageResource(R.drawable.ricekrispies1);
                    chosenFoods.add("Rice Krispies");
                }
            }
        });
        imageButton39.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Special K")) {
                    imageButton39.setImageResource(R.drawable.specialk);
                    chosenFoods.remove("Special K");
                }
                else{
                    imageButton39.setImageResource(R.drawable.specialk1);
                    chosenFoods.add("Special K");
                }
            }
        });
        imageButton40.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Oatmeal")) {
                    imageButton40.setImageResource(R.drawable.oatmeal1);
                    chosenFoods.remove("Oatmeal");
                }
                else{
                    imageButton40.setImageResource(R.drawable.oatmeal1);
                    chosenFoods.add("Oatmeal");
                }
            }
        });
        imageButton41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Malt-O-Meal Chocolate")) {
                    imageButton41.setImageResource(R.drawable.maltomeal);
                    chosenFoods.remove("Malt-O-Meal Chocolate");
                }
                else{
                    imageButton41.setImageResource(R.drawable.maltomeal1);
                    chosenFoods.add("Malt-O-Meal Chocolate");
                }
            }
        });
        imageButton42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Pizza with Pepperoni")) {
                    imageButton42.setImageResource(R.drawable.pepperoni);
                    chosenFoods.remove("Pizza with Pepperoni");
                }
                else{
                    imageButton42.setImageResource(R.drawable.pepperoni1);
                    chosenFoods.add("Pizza with Pepperoni");
                }
            }
        });
        imageButton43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Taco")) {
                    imageButton43.setImageResource(R.drawable.taco);
                    chosenFoods.remove("Taco");
                }
                else{
                    imageButton43.setImageResource(R.drawable.taco1);
                    chosenFoods.add("Taco");
                }
            }
        });
        imageButton44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Hamburger with Toppings")) {
                    imageButton44.setImageResource(R.drawable.burger);
                    chosenFoods.remove("Hamburger with Toppings");
                }
                else{
                    imageButton44.setImageResource(R.drawable.burger1);
                    chosenFoods.add("Hamburger with Toppings");
                }
            }
        });
        imageButton45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Hotdog")) {
                    imageButton45.setImageResource(R.drawable.hotdog);
                    chosenFoods.remove("Hotdog");
                }
                else{
                    imageButton45.setImageResource(R.drawable.hotdog1);
                    chosenFoods.add("Hotdog");
                }
            }
        });
        imageButton46.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Couscous")) {
                    imageButton46.setImageResource(R.drawable.couscous);
                    chosenFoods.remove("Couscous");
                }
                else{
                    imageButton46.setImageResource(R.drawable.couscous1);
                    chosenFoods.add("Couscous");
                }
            }
        });
        imageButton47.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("White Rice")) {
                    imageButton47.setImageResource(R.drawable.whiterice);
                    chosenFoods.remove("White Rice");
                }
                else{
                    imageButton47.setImageResource(R.drawable.whiterice1);
                    chosenFoods.add("White Rice");
                }
            }
        });
        imageButton48.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Macaroni")) {
                    imageButton48.setImageResource(R.drawable.macaroni);
                    chosenFoods.remove("Macaroni");
                }
                else{
                    imageButton48.setImageResource(R.drawable.macaroni1);
                    chosenFoods.add("Macaroni");
                }
            }
        });
        imageButton49.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Peanut Butter")) {
                    imageButton49.setImageResource(R.drawable.peanutbutter);
                    chosenFoods.remove("Peanut Butter");
                }
                else{
                    imageButton49.setImageResource(R.drawable.peanutbutter1);
                    chosenFoods.add("Peanut Butter");
                }
            }
        });
        imageButton50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Pork")) {
                    imageButton50.setImageResource(R.drawable.pork);
                    chosenFoods.remove("Pork");
                }
                else{
                    imageButton50.setImageResource(R.drawable.pork1);
                    chosenFoods.add("Pork");
                }
            }
        });
        imageButton51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Sardines in Oil")) {
                    imageButton51.setImageResource(R.drawable.sardines);
                    chosenFoods.remove("Sardines in Oil");
                }
                else{
                    imageButton51.setImageResource(R.drawable.sardines1);
                    chosenFoods.add("Sardines in Oil");
                }
            }
        });
        imageButton52.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("White Tuna in Water")) {
                    imageButton52.setImageResource(R.drawable.whitetuna);
                    chosenFoods.remove("White Tuna in Water");
                }
                else{
                    imageButton52.setImageResource(R.drawable.whitetuna1);
                    chosenFoods.add("White Tuna in Water");
                }
            }
        });
        imageButton53.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Air-Popped Popcorn")) {
                    imageButton53.setImageResource(R.drawable.popcorn);
                    chosenFoods.remove("Air-Popped Popcorn");
                }
                else{
                    imageButton53.setImageResource(R.drawable.popcorn1);
                    chosenFoods.add("Air-Popped Popcorn");
                }
            }
        });
        imageButton54.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Potato Chips Barbecue Flavor")) {
                    imageButton54.setImageResource(R.drawable.potatochips);
                    chosenFoods.remove("Potato Chips Barbecue Flavor");
                }
                else{
                    imageButton54.setImageResource(R.drawable.potatochips1);
                    chosenFoods.add("Potato Chips Barbecue Flavor");
                }
            }
        });
        imageButton55.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Pretzels")) {
                    imageButton55.setImageResource(R.drawable.pretzel);
                    chosenFoods.remove("Pretzels");
                }
                else{
                    imageButton55.setImageResource(R.drawable.pretzel1);
                    chosenFoods.add("Pretzels");
                }
            }
        });
        imageButton56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Tortilla Chip")) {
                    imageButton56.setImageResource(R.drawable.tortillachips);
                    chosenFoods.remove("Tortilla Chip");
                }
                else{
                    imageButton56.setImageResource(R.drawable.tortillachips1);
                    chosenFoods.add("Tortilla Chip");
                }
            }
        });
        imageButton57.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Chicken Noodle Soup")) {
                    imageButton57.setImageResource(R.drawable.chickensoup);
                    chosenFoods.remove("Chicken Noodle Soup");
                }
                else{
                    imageButton57.setImageResource(R.drawable.chickensoup1);
                    chosenFoods.add("Chicken Noodle Soup");
                }
            }
        });
        imageButton58.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Split Pea and Ham Soup")) {
                    imageButton58.setImageResource(R.drawable.splitpeaandham);
                    chosenFoods.remove("Split Pea and Ham Soup");
                }
                else{
                    imageButton58.setImageResource(R.drawable.splitpeaandham1);
                    chosenFoods.add("Split Pea and Ham Soup");
                }
            }
        });
        imageButton59.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Vegetable Beef Soup")) {
                    imageButton59.setImageResource(R.drawable.vegetbeef);
                    chosenFoods.remove("Vegetable Beef Soup");
                }
                else{
                    imageButton59.setImageResource(R.drawable.vegetbeef1);
                    chosenFoods.add("Vegetable Beef Soup");
                }
            }
        });
        imageButton60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("New England Clam Chowder")) {
                    imageButton60.setImageResource(R.drawable.newengclamchowder);
                    chosenFoods.remove("New England Clam Chowder");
                }
                else{
                    imageButton60.setImageResource(R.drawable.newengclamchowder1);
                    chosenFoods.add("New England Clam Chowder");
                }
            }
        });
        imageButton61.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Tomato Soup")) {
                    imageButton61.setImageResource(R.drawable.tomatosoup);
                    chosenFoods.remove("Tomato Soup");
                }
                else{
                    imageButton61.setImageResource(R.drawable.tomatosoup1);
                    chosenFoods.add("Tomato Soup");
                }
            }
        });
        imageButton62.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("New England Clam Chowder with Milk")) {
                    imageButton62.setImageResource(R.drawable.clamchowderwithmilk);
                    chosenFoods.remove("New England Clam Chowder with Milk");
                }
                else{
                    imageButton62.setImageResource(R.drawable.clamchowderwithmilk1);
                    chosenFoods.add("New England Clam Chowder with Milk");
                }
            }
        });
        imageButton63.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Cream Mushroom Soup")) {
                    imageButton63.setImageResource(R.drawable.creamofmushroom);
                    chosenFoods.remove("Cream Mushroom Soup");
                }
                else{
                    imageButton63.setImageResource(R.drawable.creamofmushroom1);
                    chosenFoods.add("Cream Mushroom Soup");
                }
            }
        });
        imageButton64.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Bean with Bacon Soup")) {
                    imageButton64.setImageResource(R.drawable.beanbacon);
                    chosenFoods.remove("Bean with Bacon Soup");
                }
                else{
                    imageButton64.setImageResource(R.drawable.beanbacon1);
                    chosenFoods.add("Bean with Bacon Soup");
                }
            }
        });
    }

    private void setConstants(){
        constants.put("MIN_CALORIES", 2000);
        constants.put("MAX_CALORIES", 2250);
        constants.put("MIN_CHOLESTEROL", 0);
        constants.put("MAX_CHOLESTEROL", 300);
        constants.put("MIN_TOTAL_FAT", 0);
        constants.put("MAX_TOTAL_FAT", 65);
        constants.put("MIN_SODIUM", 0);
        constants.put("MAX_SODIUM", 2400);
        constants.put("MIN_CARBOHYDRATES", 0);
        constants.put("MAX_CARBOHYDRATES", 300);
        constants.put("MIN_DIETARY_FIBER", 25);
        constants.put("MAX_DIETARY_FIBER", 100);
        constants.put("MIN_PROTEIN", 50);
        constants.put("MAX_PROTEIN", 100);
        constants.put("MIN_VITAMIN_A", 5000);
        constants.put("MAX_VITAMIN_A", 50000);
        constants.put("MIN_VITAMIN_C", 50);
        constants.put("MAX_VITAMIN_C", 20000);
        constants.put("MIN_CALCIUM", 800);
        constants.put("MAX_CALCIUM", 1600);
        constants.put("MIN_IRON", 10);
        constants.put("MAX_IRON", 30);
        constants.put("FOOD",0);
        constants.put("PRICE",1);
        constants.put("SERVING_SIZE",2);
        constants.put("CALORIES",3);
        constants.put("CHOLESTEROL",4);
        constants.put("TOTAL_FAT",5);
        constants.put("SODIUM",6);
        constants.put("CARBOHYDRATES",7);
        constants.put("DIETARY_FIBER",8);
        constants.put("PROTEIN",9);
        constants.put("VIT_A",10);
        constants.put("VIT_C",11);
        constants.put("CALCIUM",12);
        constants.put("IRON",13);
    }

    private ArrayList<String> getFoodDetails(int id){
        ArrayList<String> foodDetails = new ArrayList<String>();
        try{
            Cursor cursor = db.query("NUTRITIONAL_VALUES",
                    new String[]{"FOOD","PRICE","SERVING_SIZE","CALORIES","CHOLESTEROL","TOTAL_FAT","SODIUM","CARBOHYDRATES","DIETARY_FIBER","PROTEIN","VIT_A","VIT_C","CALCIUM","IRON"},
//                    new String[]{"_id","FOOD"},
                    "_id = ?",
                    new String[]{Integer.toString(id)},
                    null,null,null);

            if(cursor.moveToFirst()){
                for(int i=0; i<14; i++){
                    foodDetails.add(cursor.getString(i));
                }
            }

            cursor.close();
        }
        catch(SQLiteException e){

        }

        return foodDetails;
    }

    public void solve(View view){
        if(chosenFoods.size() != 0){
            for(int i=0; i<chosenFoods.size();i++){
                chosenFoodDetail.put(chosenFoods.get(i),getFoodDetails(foodList.indexOf(chosenFoods.get(i))));
            }
                    for ( String key : chosenFoodDetail.keySet() ) {
                        for(int i=0; i<chosenFoodDetail.get(key).size();i++){
                            System.out.print(chosenFoodDetail.get(key).get(i) + "   ");
                        }

                        System.out.println();
                    }

            float[][] table = setUpInitialMin();
//            printTable(table, columnHeaders);
            while(hasNegative(table) && !(infeasible)){
                table = simplexMethod(table);
//                printTable(table, columnHeaders);
            }
//            printTable(table,columnHeaders);

            solutionFound = getPrintableResult(table, columnHeaders);

            Intent intent = new Intent(this, DietProblemResult.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("foods", chosenFoods);
            if(infeasible){
                bundle.putString("solution", "INFEASIBLE");
            }
            else{
                bundle.putString("solution", solutionFound);
            }
            bundle.putFloat("optimalsolution", table[table.length-1][table[0].length-1]);
            intent.putExtras(bundle);

            startActivity(intent);

            chosenFoods.clear();
            chosenFoodDetail.clear();
        }
        else{
            Toast.makeText(this, "No food selected!", Toast.LENGTH_LONG).show();
        }


    }

    public void printTable(float[][] table, ArrayList<String> columnHeaders){
        String iteration = "";

//        iteration = iteration.concat("Iteration " + iterationNumber + ":\n");

        for(int i=0; i<columnHeaders.size();i++){
            if(i==(columnHeaders.size() -1)){
                iteration = iteration.concat("" + columnHeaders.get(i));
            }
            else if(i==0 || i==1 || i==(columnHeaders.size() -2)){
                if(columnHeaders.get(i).length() == 1){
                    iteration = iteration.concat("    " + columnHeaders.get(i) + "    \t");
                }
                else{
                    iteration = iteration.concat("   " + columnHeaders.get(i) + "   \t");
                }
            }
            else{
                if(columnHeaders.get(i).length() == 1){
                    iteration = iteration.concat("    " + columnHeaders.get(i) + "    \t");
                }
                else{
                    iteration = iteration.concat("   " + columnHeaders.get(i) + "   \t");
                }
            }

            if(i != (columnHeaders.size() -1)){
                iteration = iteration.concat("|\t");
            }
        }
        for(float[] row : table) {
            iteration = iteration.concat("\n");
            for(int i=0; i<row.length; i++){
                if(row[i] < 0){
                    iteration = iteration.concat(String.format("%.2f",row[i]) + "\t");
                }
                else{
                    iteration = iteration.concat(" " + String.format("%.2f",row[i]) + "\t");
                }
                if(i != (row.length -1)){
                    iteration = iteration.concat("|\t");
                }
            }
        }
        iteration = iteration.concat(getMinSolution(table,columnHeaders));
        System.out.println(iteration);
    }

    public String getMinSolution(float[][] table, ArrayList<String> columnHeaders){
        HashMap<String, Float> basicSolution = new HashMap<String, Float>();

        String solution = "";
        for(int j=0; j<(columnHeaders.size()-1);j++){     //col
            if(j==columnHeaders.size()-2){
                basicSolution.put(columnHeaders.get(j),table[table.length-1][columnHeaders.size()-1]);
            }
            else{
                basicSolution.put(columnHeaders.get(j),table[table.length-1][j]);
            }
        }

        for(int i=0; i<columnHeaders.size()-1; i++){
            if(basicSolution.get(columnHeaders.get(i))==0 || columnHeaders.get(i).startsWith("y")){

            }
            else{
                solution = solution.concat("\n" + columnHeaders.get(i) + "=" + String.format("%.2f",basicSolution.get(columnHeaders.get(i))));
            }
        }

        return solution;
    }

    public float[][] simplexMethod(float[][] table){

        int row = table.length;
        int col = table[0].length;

        //get pivot column
        float minNegative = 0;
        int pivotColumn = -1;
        for(int i=0; i<(col-1);i++){
            if((table[row-1][i] < 0) && (table[row-1][i] < minNegative)){
                minNegative = table[row-1][i];
                pivotColumn = i;
            }
        }

        //get pivot row
        float minRatio = 9999999;
        int pivotRow = -1;
        for(int i=0; i<(row-1);i++){
            if(table[i][pivotColumn] > 0){
                float x = table[i][col-1] / table[i][pivotColumn];
                if((minRatio > x) && (x>=0)){
                    minRatio = x;
                    pivotRow = i;
                }
            }
        }
        if(!(pivotColumn==-1) && !(pivotRow==-1)){
            table = gaussJordan(table,pivotRow,pivotColumn);
        }
        else{
            infeasible=true;
        }

        return table;
    }

    public float[][] gaussJordan(float[][] table, int pivotRow, int pivotColumn){
        int row = table.length;
        int col = table[0].length;
        float[] sRow = new float[col];
        float pivotElement = table[pivotRow][pivotColumn];

        //normalize
        for(int i=0; i<col; i++){
            table[pivotRow][i] = table[pivotRow][i] / pivotElement;
        }

        for(int i=0; i<row; i++){
            if(i!=pivotRow) {
                for (int x = 0; x < sRow.length; x++) {
                    sRow[x] = table[pivotRow][x] * table[i][pivotColumn];
                }

                for (int j = 0; j < col; j++) {
                    table[i][j] = table[i][j] - sRow[j];
                }
            }
        }

        return table;
    }

    public Boolean hasNegative(float[][] table){
        int row = table.length;
        int col = table[0].length;

        for(int i=0; i<(col-1);i++){
            if((table[row-1][i] < 0)){
                return true;
            }
        }

        return false;
    }

    public float[][] setUpInitialMin(){
        float[][] table = getAugmented();

        table = transposeTable(table);
        table = addTableConstraints(table);

        return table;
    }

    public float[][] getAugmented(){
        columnHeaders.clear();

        for(int i=0; i<chosenFoods.size();i++) {
            columnHeaders.add(chosenFoods.get(i));
            variableNames.add(chosenFoods.get(i));
        }
        columnHeaders.add("Solution");

        int rows = 22 + variableNames.size() + variableNames.size() + 1;
        int cols = columnHeaders.size();

        float[][] tableu = new float[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                tableu[i][j] = 0;
            }
        }

        for(int i=0; i<(cols-1);i++){
//            System.out.println(chosenFoods.get(i));
            ArrayList<String> details = chosenFoodDetail.get(chosenFoods.get(i));
//            System.out.println(details);
            for(int j=0; j<22; j++){
                if(j<11){
                    tableu[j][i] = Float.parseFloat(details.get(j+3));
                }
                else{
                    tableu[j][i] = Float.parseFloat(details.get(j+3-11));
                }
            }
            tableu[rows-1][i] = Float.parseFloat(details.get(1));
        }
        for(int i=22; i<rows; i++){
            tableu[i][cols-1] = 0;
        }
        tableu[0][cols-1] = constants.get("MIN_CALORIES");
        tableu[1][cols-1] = constants.get("MIN_CHOLESTEROL");
        tableu[2][cols-1] = constants.get("MIN_TOTAL_FAT");
        tableu[3][cols-1] = constants.get("MIN_SODIUM");
        tableu[4][cols-1] = constants.get("MIN_CARBOHYDRATES");
        tableu[5][cols-1] = constants.get("MIN_DIETARY_FIBER");
        tableu[6][cols-1] = constants.get("MIN_PROTEIN");
        tableu[7][cols-1] = constants.get("MIN_VITAMIN_A");
        tableu[8][cols-1] = constants.get("MIN_VITAMIN_C");
        tableu[9][cols-1] = constants.get("MIN_CALCIUM");
        tableu[10][cols-1] = constants.get("MIN_IRON");
        tableu[11][cols-1] = constants.get("MAX_CALORIES");
        tableu[12][cols-1] = constants.get("MAX_CHOLESTEROL");
        tableu[13][cols-1] = constants.get("MAX_TOTAL_FAT");
        tableu[14][cols-1] = constants.get("MAX_SODIUM");
        tableu[15][cols-1] = constants.get("MAX_CARBOHYDRATES");
        tableu[16][cols-1] = constants.get("MAX_DIETARY_FIBER");
        tableu[17][cols-1] = constants.get("MAX_PROTEIN");
        tableu[18][cols-1] = constants.get("MAX_VITAMIN_A");
        tableu[19][cols-1] = constants.get("MAX_VITAMIN_C");
        tableu[20][cols-1] = constants.get("MAX_CALCIUM");
        tableu[21][cols-1] = constants.get("MAX_IRON");

        for(int i=0; i<variableNames.size(); i++){
            tableu[i+22][i] = 1;
        }

        for(int i=0; i<variableNames.size(); i++){
            tableu[i+22+variableNames.size()][i] = -1;
        }

        for(int i=11; i<22; i++){
            for(int j=0; j<cols; j++){
//                System.out.println(tableu[i][j]);
                if(tableu[i][j] != 0){
                    tableu[i][j] *= -1;
                }
            }
        }

        for(int i=22+variableNames.size(); i<rows-1;i++){
            tableu[i][cols-1] = -10;
        }

        return tableu;
    }

    public float[][] transposeTable(float[][] table){
        int row = table.length;
        int col = table[0].length;

        float[][] tableT = new float[col][row];

        for(int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                tableT[j][i] = table[i][j];
            }
        }

        return tableT;
    }

    public float[][] addTableConstraints(float[][] table){
        int row = table.length;
        int col = table[0].length;

        float[][] minTable = new float[row][(col)+(row)];

        columnHeaders.clear();

        for(int i=0; i<minTable[0].length; i++){
            if(i==(minTable[0].length-1)){
                columnHeaders.add("Solution");
            }
            else if(i==(minTable[0].length-2)){
                columnHeaders.add("Total Cost");
            }
            else if(i<(minTable[0].length-2-(row-1))){
                columnHeaders.add("y" + String.valueOf(i+1));
            }
            else{
                columnHeaders.add(variableNames.get(i-(minTable[0].length-2-(row-1))));
            }
        }

        for(int i=0; i<minTable.length; i++){
            for(int j=0; j<minTable[0].length; j++){
                if(j<col-1){
                    minTable[i][j] = table[i][j];
                }
                else if(j==(minTable[0].length-1)){
                    minTable[i][j] = table[i][col-1];
                }
                else{
                    minTable[i][j] = 0;
                }
            }
        }

        for(int i=0; i<minTable.length; i++) {
            minTable[i][(col-1) + i] = 1;
        }

        for(int j=0; j<minTable[0].length-2; j++){
            if(minTable[minTable.length-1][j] != 0){
                minTable[minTable.length-1][j] *= -1;
            }
        }
        return minTable;
    }

    public String getPrintableResult(float[][] table, ArrayList<String> colheaders){
        String str = "\t\t\t\t    #     |    Food\n\n\t";
        HashMap<String,Float> values = new HashMap<String, Float>();

        String[] temp2 = getMinSolution(table,colheaders).split("\\n");

        for(int i=0; i<temp2.length-1; i++){
            if(temp2[i].length() > 5){
                String[] eq = temp2[i].split("=");
                values.put(eq[0],Float.parseFloat(eq[1]));

                //quantity
                if(Float.parseFloat(eq[1]) == 10){
                    str = str.concat("\t\t\t" + eq[1] + " \t|");
                }
                else{
                    str = str.concat("\t\t\t " + eq[1] + "\t\t|");
                }

                //food
                str = str.concat("\t\t" + eq[0]);
                str = str.concat("($" + chosenFoodDetail.get(eq[0]).get(1) + ")" );
            }
            else{
                continue;
            }
            str = str.concat("\n\t");
        }


        return str;
    }
}
