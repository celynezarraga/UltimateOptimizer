package com.example.celynezarraga15.ultimateoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void optimizer(View view){
        Intent intent = new Intent(this, OptimizerActivity.class);
        startActivity(intent);
    }

    public void dietSolver(View view){
        Intent intent = new Intent(this, DietProblemActivity.class);
        startActivity(intent);
    }
}
