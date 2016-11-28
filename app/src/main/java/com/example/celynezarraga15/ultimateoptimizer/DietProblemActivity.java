package com.example.celynezarraga15.ultimateoptimizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DietProblemActivity extends AppCompatActivity {

    int MIN_CALORIES = 2000;
    int MAX_CALORIES = 2250;
    int MIN_CHOLESTEROL = 0;
    int MAX_CHOLESTEROL = 300;
    int MIN_TOTAL_FAT = 0;
    int MAX_TOTAL_FAT = 65;
    int MIN_SODIUM = 0;
    int MAX_SODIUM = 2400;
    int MIN_CARBOHYDRATES = 0;
    int MAX_CARBOHYDRATES = 300;
    int MIN_DIETARY_FIBER = 25;
    int MAX_DIETARY_FIBER = 100;
    int MIN_PROTEIN = 50;
    int MAX_PROTEIN = 100;
    int MIN_VITAMIN_A = 5000;
    int MAX_VITAMIN_A = 50000;
    int MIN_VITAMIN_C = 50;
    int MAX_VITAMIN_C = 20000;
    int MIN_CALCIUM = 800;
    int MAX_CALCIUM = 1600;
    int MIN_IRON = 10;
    int MAX_IRON = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_problem);
    }
}
