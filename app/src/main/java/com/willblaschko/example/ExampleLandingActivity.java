package com.willblaschko.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.willblaschko.android.headerfooterrecyclerview.R;

/**
 * Created by Will on 2/8/2015.
 */
public class ExampleLandingActivity extends Activity{

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_landing);

        findViewById(R.id.ll_h).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExampleHorizontalLinearLayoutActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.ll_v).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExampleVerticalLinearLayoutActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.sg_h).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExampleHorizontalStaggeredGridActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.sg_v).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExampleVerticalStaggeredGridActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.g_h).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExampleHorizontalGridActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.g_v).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExampleVerticalGridActivity.class);
                startActivity(i);
            }
        });
    }
}
