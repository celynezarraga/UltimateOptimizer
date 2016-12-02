package com.example.celynezarraga15.ultimateoptimizer;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OptimizerResult extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter adapter;
    ArrayList<String> iterations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimizer_result);

        Bundle b=this.getIntent().getExtras();
        String finalObjFunction = b.getString("obj");
        String finalVars = b.getString("vars");
        String solution = b.getString("solution");

        iterations = b.getStringArrayList("iterations");

        TextView objfunc = (TextView) findViewById(R.id.objfunction);
        objfunc.setText(finalObjFunction);
        TextView vars = (TextView) findViewById(R.id.var);
        vars.setText(finalVars);
        TextView finalSol = (TextView) findViewById(R.id.finalSolution);
        String[] trimText = solution.split(":");
        String[] solFound = trimText[1].split("\\s");
        String temp = "Final Solution: ";
        for(int i=1; i<solFound.length;i++){
            if(solFound[i].length()>2 && !solFound[i].startsWith("S") && !solFound[i].startsWith("y")){
                temp = temp.concat("\n\t\t\t" + solFound[i]);
            }
        }
//        finalSol.setText(temp);
        int position = 0;

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(OptimizerResult.this, iterations);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
