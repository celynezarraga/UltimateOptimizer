package com.example.celynezarraga15.ultimateoptimizer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class DietProblemActivity extends AppCompatActivity {


    SQLiteOpenHelper optimizerDBHelper;
    SQLiteDatabase db;
    HashMap<String,Integer> constants = new HashMap<String, Integer>();
    HashMap<String,ArrayList<String>> chosenFoodDetail = new HashMap<String, ArrayList<String>>();
    public ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8;
    ArrayList<String> chosenFoods;
    ArrayList<String> foodList;
    ArrayList<String> columnHeaders = new ArrayList<String>();
    ArrayList<String> variableNames = new ArrayList<String>();
    boolean infeasible;

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
        foodList.add("Corn Flakes); Kellogg's");
        foodList.add("Raisin Bran); Kellogg's");
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
        foodList.add("New England Clam Chowder");
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

        //initial images
        imageButton1.setImageResource(R.drawable.broccoli);
        imageButton2.setImageResource(R.drawable.carrots);
        imageButton3.setImageResource(R.drawable.celery);
        imageButton4.setImageResource(R.drawable.corn);
        imageButton5.setImageResource(R.drawable.lettuce);
        imageButton6.setImageResource(R.drawable.pepper);
        imageButton7.setImageResource(R.drawable.potato);
        imageButton8.setImageResource(R.drawable.tofu);

        //listeners
        imageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Frozen Broccoli")) {
                    imageButton1.setImageResource(R.drawable.broccoli);
                    chosenFoods.remove("Frozen Broccoli");
//                    System.out.println("frozen broccoli removed");
                }
                else{
                    imageButton1.setImageResource(R.drawable.broccoli1);
                    chosenFoods.add("Frozen Broccoli");
//                    System.out.println("frozen broccoli added");
                }
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Carrots")) {
                    imageButton2.setImageResource(R.drawable.carrots);
                    chosenFoods.remove("Raw Carrots");
//                    System.out.println("Raw Carrots removed");
                }
                else{
                    imageButton2.setImageResource(R.drawable.carrots1);
                    chosenFoods.add("Raw Carrots");
//                    System.out.println("Raw Carrots added");
                }
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Celery")) {
                    imageButton3.setImageResource(R.drawable.celery);
                    chosenFoods.remove("Raw Celery");
//                    System.out.println("Raw Celery removed");
                }
                else{
                    imageButton3.setImageResource(R.drawable.celery1);
                    chosenFoods.add("Raw Celery");
//                    System.out.println("Raw Celery added");
                }
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Frozen Corn")) {
                    imageButton4.setImageResource(R.drawable.corn);
                    chosenFoods.remove("Frozen Corn");
//                    System.out.println("Frozen Corn removed");
                }
                else{
                    imageButton4.setImageResource(R.drawable.corn1);
                    chosenFoods.add("Frozen Corn");
//                    System.out.println("Frozen Corn added");
                }
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Iceberg Lettuce")) {
                    imageButton5.setImageResource(R.drawable.lettuce);
                    chosenFoods.remove("Raw Iceberg Lettuce");
//                    System.out.println("Raw Iceberg Lettuce removed");
                }
                else{
                    imageButton5.setImageResource(R.drawable.lettuce1);
                    chosenFoods.add("Raw Iceberg Lettuce");
//                    System.out.println("Raw Iceberg Lettuce added");
                }
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Raw Sweet Pepper")) {
                    imageButton6.setImageResource(R.drawable.pepper);
                    chosenFoods.remove("Raw Sweet Pepper");
//                    System.out.println("Raw Sweet Pepper removed");
                }
                else{
                    imageButton6.setImageResource(R.drawable.pepper1);
                    chosenFoods.add("Raw Sweet Pepper");
//                    System.out.println("Raw Sweet Pepper added");
                }
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Baked Potatoes")) {
                    imageButton7.setImageResource(R.drawable.potato);
                    chosenFoods.remove("Baked Potatoes");
//                    System.out.println("Baked Potatoes removed");
                }
                else{
                    imageButton7.setImageResource(R.drawable.potato1);
                    chosenFoods.add("Baked Potatoes");
//                    System.out.println("Baked Potatoes added");
                }
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(chosenFoods.contains("Tofu")) {
                    imageButton8.setImageResource(R.drawable.tofu);
                    chosenFoods.remove("Tofu");
//                    System.out.println("Tofu removed");
                }
                else{
                    imageButton8.setImageResource(R.drawable.tofu1);
                    chosenFoods.add("Tofu");
//                    System.out.println("Tofu added");
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
        for(int i=0; i<chosenFoods.size();i++){
            chosenFoodDetail.put(chosenFoods.get(i),getFoodDetails(foodList.indexOf(chosenFoods.get(i))));
        }
        for ( String key : chosenFoodDetail.keySet() ) {
            for(int i=0; i<chosenFoodDetail.get(key).size();i++){
//                System.out.print(chosenFoodDetail.get(key).get(i) + "   ");
            }

//            System.out.println();
        }

        float[][] table = setUpInitialMin();
        printTable(table, columnHeaders);
        while(hasNegative(table) && !(infeasible)){
            table = simplexMethod(table);
            printTable(table, columnHeaders);
        }
        printTable(table,columnHeaders);

        chosenFoods.clear();
        chosenFoodDetail.clear();

        if(infeasible){
            System.out.println("INFEASIBLE");
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

        String solution = "\n\nBasic Solution: \n";
        for(int j=0; j<(columnHeaders.size()-1);j++){     //col
            if(j==columnHeaders.size()-2){
                basicSolution.put(columnHeaders.get(j),table[table.length-1][columnHeaders.size()-1]);
            }
            else{
                basicSolution.put(columnHeaders.get(j),table[table.length-1][j]);
            }
        }

        for(int i=0; i<columnHeaders.size()-1; i++){
            solution = solution.concat("\t" + columnHeaders.get(i) + "=" + String.format("%.4f",basicSolution.get(columnHeaders.get(i))));
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

        for(String key: new TreeSet<String>(chosenFoodDetail.keySet())) {
            columnHeaders.add(key);
            variableNames.add(key);
        }
        columnHeaders.add("Solution");

        int rows = 22 + variableNames.size() + 1;
        int cols = columnHeaders.size();

        float[][] tableu = new float[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                tableu[i][j] = 0;
            }
        }

        for(int i=0; i<(cols-1);i++){
            ArrayList<String> details = chosenFoodDetail.get(chosenFoods.get(i));
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

        for(int i=22; i<rows-1; i++){
            tableu[i][i-22] = 1;
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
}
