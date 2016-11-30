package com.example.celynezarraga15.ultimateoptimizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DietProblemResult extends AppCompatActivity {

    TextView foodSelected;
    TextView results;
    String selectFood;
    String solutionFound;
    String solutionToPrint;
    ArrayList<String> chosenFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_problem_result);

        Bundle b=this.getIntent().getExtras();
        chosenFoods = b.getStringArrayList("foods");
        solutionFound = b.getString("solution");
        Float optimalSolution = b.getFloat("optimalsolution");

        selectFood = "You selected " + chosenFoods.size() + " foods to consider for your diet.\n\n\n";
        String temp = "The cost of this optimal diet is $" + String.format("%.2f",optimalSolution) + " per day.";
        foodSelected = (TextView) findViewById(R.id.chosenFoodText);
        for(int i=1; i<=chosenFoods.size();i++){
            selectFood = selectFood.concat("\t" + chosenFoods.get(i-1));
            if(i!=chosenFoods.size()){
                selectFood = selectFood.concat(",");
            }
            if(i%3==0){
                selectFood = selectFood.concat("\n");
            }
        }
        foodSelected.setText(selectFood);

        results = (TextView) findViewById(R.id.resultText);
        if(solutionFound.equals("INFEASIBLE")){
            results.setText("Solution: \n\t\t\t\t" + solutionFound);
        }
        else{
            results.setText("Solution: \n" + solutionFound + "\n\n" + temp);
        }

    }
}
