package com.example.celynezarraga15.ultimateoptimizer;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class OptimizerActivity extends AppCompatActivity {

    String finalObjFunction;
    String finalVars;
    Integer error = 0;
    Integer iterationNumber = 0;
    Boolean isMaximize = true;
    HashMap<String,Float> variables;
    ArrayList<String> inputConstraints;
    ArrayList<String> evaluatedConstraints;
    ArrayAdapter<String> itemsAdapter;
    ArrayList<String> columnHeaders;
    ArrayList<String> iterations = new ArrayList<String>();
    ArrayList<String> colheaders = new ArrayList<String>();
    ArrayList<String> varNames = new ArrayList<String>();
    ArrayList<String> minConstraints = new ArrayList<String>();
    boolean infeasible;
    String solutionFound = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimizer);

        Switch mySwitch = (Switch) findViewById(R.id.toggleSwitch);

        //set the switch to ON
        mySwitch.setChecked(true);
        //attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isMaximize = true;
                }else{
                    isMaximize = false;
                }

            }
        });

        inputConstraints = new ArrayList<String>();
        evaluatedConstraints = new ArrayList<String>();
        columnHeaders = new ArrayList<String>();
        infeasible = false;

        ListView lvItems = (ListView) findViewById(R.id.listView);
        variables = new HashMap<String, Float>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, inputConstraints);
        lvItems.setAdapter(itemsAdapter);
    }

    public void solve(View view){
        finalObjFunction = "";
        finalVars = "";

        if(inputConstraints.size() == 0){
            Toast.makeText(this, "No constraints!", Toast.LENGTH_LONG).show();
            error = 1;
        }

        parseObjectiveFunction();

        if(error==0){

            if(isMaximize){
                for(int x=0; x<evaluatedConstraints.size(); x++){
                    finalVars = finalVars.concat("\n" + evaluatedConstraints.get(x));
                }

                float[][] maximizeTable = setUpInitialTable();
                printTable(maximizeTable, columnHeaders, "max");

                while(hasNegative(maximizeTable) && !infeasible){
                    maximizeTable = simplexMethod(maximizeTable);
                    printTable(maximizeTable, columnHeaders, "max");
                }
                solutionFound = getBasicSolution(maximizeTable,columnHeaders);
            }
            else{
                for ( String key : variables.keySet() ) {
                    variables.put(key, -1*(variables.get(key)));
                }

                float[][] minimizeTable = setUpInitialMin();
                for(int x=0; x<minConstraints.size(); x++){
                    finalVars = finalVars.concat("\n" + minConstraints.get(x));
                    System.out.println(minConstraints.get(x));
                }
                printTable(minimizeTable, colheaders, "min");

                while(hasNegative(minimizeTable)&& !infeasible){
                    minimizeTable = simplexMethod(minimizeTable);
                    printTable(minimizeTable, colheaders, "min");
                }
                solutionFound = getBasicSolution(minimizeTable,colheaders);
            }

            Intent intent = new Intent(this, OptimizerResult.class);
            Bundle bundle = new Bundle();
            bundle.putString("obj", finalObjFunction);
            bundle.putString("vars", finalVars);
            if(infeasible){
                solutionFound = "Basic Solution: INFEASIBLE";
            }
            bundle.putString("solution", solutionFound);
            bundle.putStringArrayList("iterations", iterations);
            intent.putExtras(bundle);

            startActivity(intent);
        }

        variables.clear();
    }

    public void parseObjectiveFunction(){
        EditText inputobjfunc = (EditText) findViewById(R.id.inputObjectiveFunction);
        String temp1 = inputobjfunc.getText().toString();

        if(temp1.length() == 0){
            Toast.makeText(this,"No Objective Function!", Toast.LENGTH_LONG).show();
            error=1;
        }
        else if(!(temp1.contains("="))){
            Toast.makeText(this,"Invalid Objective Function!", Toast.LENGTH_LONG).show();
        }
        else{
            temp1 = temp1.replaceAll("\\s","");
            temp1 = temp1.replaceAll("-","+-");
            String[] varsFunc = temp1.split("=");

            if(varsFunc[1].length() == 1){
                String temp = varsFunc[1];
                varsFunc[1] = varsFunc[0];
                varsFunc[0] = temp;
            }

//            finalVars = finalVars.concat("Variable to solve = " + varsFunc[0] + "\n");
            finalObjFunction = finalObjFunction.concat(varsFunc[0] + " = ");

            String[] polynomials = varsFunc[1].split("\\+");

            for(int i=0; i<polynomials.length; i++){
                if(i==(polynomials.length-1)){
                    finalObjFunction = finalObjFunction.concat(polynomials[i]);
                }
                else{
                    finalObjFunction = finalObjFunction.concat(polynomials[i] + " + ");
                }

                if(!(variables.containsKey(polynomials[i]))){
                    if((polynomials[i].length() == 1) && (!polynomials[i].matches("^.*[^a-zA-Z].*$"))){
                        variables.put(polynomials[i],1f);
                    }
                    if(polynomials[i].length() > 1){
                        String temp = polynomials[i].substring(polynomials[i].length()-1);
                        polynomials[i] = polynomials[i].substring(0, polynomials[i].length()-1);
                        if((polynomials[i].length() == 1) && (polynomials[i].equalsIgnoreCase("-"))){
                            polynomials[i] = polynomials[i].concat("1");
                        }

                        Float x = Float.parseFloat(polynomials[i]);

                        if(!temp.matches("^.*[^a-zA-Z].*$")){
                            variables.put(temp,x);
                        }
                        else{
                            Toast.makeText(this,"Invalid variable!", Toast.LENGTH_LONG).show();
                            error=1;
                        }
                    }
                }else {
                    Toast.makeText(this, "Duplicate variables in objective function!", Toast.LENGTH_LONG).show();
                    error = 1;
                }

            }

//            for ( String key : variables.keySet() ) {
//                finalVars = finalVars.concat( key + "=" + variables.get(key) + "\n");
//            }
        }
    }

    public Boolean evaluateConstraints(){
        EditText newCons = (EditText) findViewById(R.id.cons);
        String itemText = newCons.getText().toString();
        String[] cons;
        int ch = 0;

        if(itemText.length() == 0){
            Toast.makeText(this, "Empty constraint!", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            itemText = itemText.replaceAll("\\s","");

            if(inputConstraints.contains(itemText)){
                Toast.makeText(this, "Constraint already exists!", Toast.LENGTH_LONG).show();
                return false;
            }

            if(itemText.contains("<=")){
                cons = itemText.split("<=");
            }
            else if(itemText.contains(">=")){
                cons = itemText.split(">=");
                ch = 1;
            }
            else if(itemText.contains("=")){
                cons = itemText.split("=");
            }
            else if(itemText.contains("<")){
                cons = itemText.split("<");
            }
            else if(itemText.contains(">")){
                cons = itemText.split(">");
                ch = 1;
            }
            else{
                Toast.makeText(this, "Invalid constraint", Toast.LENGTH_LONG).show();
                return false;
            }

            if(!cons[0].matches("^.*[^0-9].*$")) {
                String temp = cons[1];
                cons[1] = cons[0];
                cons[0] = temp;
                if(ch==0){
                    ch=1;
                }
                else{
                    ch=0;
                }
            }

            String consVar = "S";
            consVar = consVar.concat(String.valueOf((evaluatedConstraints.size())+1));

            if(ch == 0){
                cons[0] = cons[0].concat("+" + consVar + "=" + cons[1]);
            }
            else{
                cons[0] = cons[0].concat("-" + consVar + "=" + cons[1]);
            }
            evaluatedConstraints.add(cons[0]);

            return true;
        }
    }

    public void addConstraint(View view){

        if(evaluateConstraints() == true){
            EditText newCons = (EditText) findViewById(R.id.cons);
            String itemText = newCons.getText().toString();
            itemText = itemText.replaceAll("\\s","");

            inputConstraints.add(itemText);
            newCons.setText("");
        }
    }

    public float[][] setUpInitialTable(){

        for(String key: new TreeSet<String>(variables.keySet())) {
            columnHeaders.add(key);
        }
        for(int i=0; i<evaluatedConstraints.size();i++){
            columnHeaders.add("S".concat(String.valueOf(i+1)));
        }
        columnHeaders.add(String.valueOf(finalObjFunction.charAt(0)));
        columnHeaders.add("Solution");

        int rows = evaluatedConstraints.size() + 1;
        int cols = variables.size() + 1 + rows;

        float[][] tableu = new float[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                tableu[i][j] = 0;
            }
        }

        for(int i=0; i<rows;i++){
            HashMap<String,Float> coeff;

            if(i==(rows-1)){
                coeff = variables;
            }
            else{
                coeff = getCoefficients(evaluatedConstraints.get(i));
            }

            for(int j=0; j<columnHeaders.size();j++){
                if(coeff.containsKey(columnHeaders.get(j))){
                    tableu[i][j] = coeff.get(columnHeaders.get(j));

                    if(i == (rows-1)){
                        tableu[i][j] = -1 * tableu[i][j];
                    }
                }
                else{
                    tableu[i][j] = 0;
                }
            }
            tableu[rows-1][cols-2] = 1;
        }

        return tableu;
    }

    public HashMap<String,Float> getCoefficients(String eq){
        HashMap<String,Float> coeff = new HashMap<String, Float>();

        String temp1 = eq.replaceAll("-","+-");
        String[] varsFunc = temp1.split("=");
        varsFunc[0] = varsFunc[0].replaceAll("\\++","+");
        varsFunc[1] = varsFunc[1].replaceAll("\\+","");

        coeff.put("Solution",Float.parseFloat(varsFunc[1]));

        if(varsFunc[0].charAt(0)=='+'){
            varsFunc[0] = varsFunc[0].substring(1);
        }

        String[] polynomials = varsFunc[0].split("\\+");
        for(int i=0; i<polynomials.length;i++){
            if(!(coeff.containsKey(polynomials[i]))){
                if((polynomials[i].length() == 1) && (!polynomials[i].matches("^.*[^a-zA-Z].*$"))){
                    coeff.put(polynomials[i],1f);
                }
                else if((polynomials[i].length() > 1) && (polynomials[i].charAt(0)=='S')){
                    coeff.put(polynomials[i],1f);
                }
                else if((polynomials[i].length() > 1) && (polynomials[i].substring(0,2).equalsIgnoreCase("-S"))){
                    coeff.put(polynomials[i].substring(1,3),-1f);
                }
                else{
                    String temp = polynomials[i].substring(polynomials[i].length()-1);
                    polynomials[i] = polynomials[i].substring(0, polynomials[i].length()-1);
                    if((polynomials[i].length() == 1) && (polynomials[i].equalsIgnoreCase("-"))){
                        polynomials[i] = polynomials[i].concat("1");
                    }
                    Float x = Float.parseFloat(polynomials[i]);
                    if(!temp.matches("^.*[^a-zA-Z].*$")){
                        coeff.put(temp,x);
                    }
                    else{
                        Toast.makeText(this,"Invalid variable!", Toast.LENGTH_LONG).show();
                        error=1;
                    }
                }
            }else {
                Toast.makeText(this, "Duplicate variables in constraint!", Toast.LENGTH_LONG).show();
                error = 1;
            }
        }
        return coeff;
    }

    public void printTable(float[][] table, ArrayList<String> columnHeaders, String type){
        String iteration = "";

        iteration = iteration.concat("Iteration " + iterationNumber + ":\n");

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
        if(type.equals("max")){
            iteration = iteration.concat(getBasicSolution(table, columnHeaders));
        }
        else{
            iteration = iteration.concat(getMinSolution(table, columnHeaders));
        }

        iterations.add(iteration);
        iterationNumber++;
    }

    public String getBasicSolution(float[][] table, ArrayList<String> columnHeaders){
       HashMap<String, Float> basicSolution = new HashMap<String, Float>();

       String solution = "\n\nBasic Solution: \n";
       for(int j=0; j<(columnHeaders.size()-1);j++){     //col
           int numofnotzeros = 0;
           int x = -1;

           for(int i=0; i<table.length;i++){    //row
               if(table[i][j] != 0){
                   numofnotzeros++;
                   x = i;
               }
           }

           if(numofnotzeros == 1){
               if((table[x][(table[0].length)-1]) == 0){
                   basicSolution.put(columnHeaders.get(j),0f);
               }
               else{
                   float z = (table[x][(table[0].length)-1]) / (table[x][j]);
                   basicSolution.put(columnHeaders.get(j),z);
               }
           }
           else{
               basicSolution.put(columnHeaders.get(j),0f);
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

    public String evalInputMinimize(String constraint){
        String itemText = constraint;
        String[] cons = {};
        int ch = 0;

        itemText = itemText.replaceAll("\\s","");

        if(itemText.contains("<=")){
            cons = itemText.split("<=");
        }
        else if(itemText.contains(">=")){
            cons = itemText.split(">=");
            ch = 1;
        }
        else if(itemText.contains("=")){
            cons = itemText.split("=");
        }
        else if(itemText.contains("<")){
            cons = itemText.split("<");
        }
        else if(itemText.contains(">")){
            cons = itemText.split(">");
            ch = 1;
        }

            if(!cons[0].matches("^.*[^0-9].*$")) {
                String temp = cons[1];
                cons[1] = cons[0];
                cons[0] = temp;
                if(ch==0){
                    ch=1;
                }
                else{
                    ch=0;
                }
            }
        if(ch==0){
            String[] coeffs = cons[0].split("\\+");

            cons[0] = "";
            for(int i=0; i<coeffs.length; i++){
                if(coeffs[i].length()==1){
                    cons[0] = cons[0].concat("-" + String.valueOf(coeffs[i].charAt(0)));
                }
                else if(coeffs[i].length()==2 && coeffs[i].contains("-")){
                    cons[0] = cons[0].concat(String.valueOf(coeffs[i].charAt(1)));
                }
                else{
                    String substr = coeffs[i].substring(0,coeffs[i].length()-1);
                    cons[0] = cons[0].concat(String.valueOf(Float.parseFloat(substr)*-1)).concat(String.valueOf(coeffs[i].charAt(coeffs[i].length()-1)));
                }

                if(i!=(coeffs.length-1)){
                    cons[0] = cons[0].concat("+");
                }
            }

            cons[1] = String.valueOf(Float.parseFloat(cons[1])*-1);
        }
        cons[0] = cons[0].concat("=" + cons[1]);
        System.out.println(cons[0]);
        return cons[0];
    }

    public float[][] setUpInitialMin(){
        float[][] table = getAugmented();

        table = transposeTable(table);
        table = addTableConstraints(table);

        return table;
    }

    public float[][] getAugmented(){
        colheaders.clear();
//        inputConstraints
        for(String key: new TreeSet<String>(variables.keySet())) {
            colheaders.add(key);
            varNames.add(key);
        }
        colheaders.add("Solution");

        int rows = inputConstraints.size() + 1;
        int cols = colheaders.size();

        float[][] tableu = new float[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                tableu[i][j] = 0;
            }
        }

        for(int i=0; i<rows;i++){
            HashMap<String,Float> coeff;

            if(i==(rows-1)){
                coeff = variables;
            }
            else{
                String con = evalInputMinimize(inputConstraints.get(i));
                coeff = getCoefficients(con);
                minConstraints.add(con);
            }

            for(int j=0; j<colheaders.size();j++){

                if(coeff.containsKey(colheaders.get(j))){
                    tableu[i][j] = coeff.get(colheaders.get(j));
                }
                else{
                    tableu[i][j] = 0;
                }

                if(i==(rows-1) && j!=colheaders.size()-1){
                    tableu[i][j] *= -1;
                }
            }
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

        System.out.println(row + " " + col);

        float[][] minTable = new float[row][(col)+(row)];

        colheaders.clear();

        for(int i=0; i<minTable[0].length; i++){
            if(i==(minTable[0].length-1)){
                colheaders.add("Solution");
            }
            else if(i==(minTable[0].length-2)){
                colheaders.add(String.valueOf(finalObjFunction.charAt(0)));
            }
            else if(i<(minTable[0].length-2-(row-1))){
                colheaders.add("y" + String.valueOf(i+1));
            }
            else{
                colheaders.add(varNames.get(i-(minTable[0].length-2-(row-1))));
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
            if(columnHeaders.get(i).startsWith("y")){

            }
            else{
                solution = solution.concat("\t" + columnHeaders.get(i) + "=" + String.format("%.4f",basicSolution.get(columnHeaders.get(i))));
            }
        }

        return solution;
    }
}
