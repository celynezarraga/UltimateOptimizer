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

        iterations = b.getStringArrayList("iterations");

        TextView objfunc = (TextView) findViewById(R.id.objfunction);
        objfunc.setText(finalObjFunction);
        TextView vars = (TextView) findViewById(R.id.var);
        vars.setText(finalVars);

        int position = 0;

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(OptimizerResult.this, iterations);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
