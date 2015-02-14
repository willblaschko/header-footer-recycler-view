package com.willblaschko.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.willblaschko.android.headerfooterrecyclerview.IRecyclerViewIntermediary;
import com.willblaschko.android.headerfooterrecyclerview.R;
import com.willblaschko.android.headerfooterrecyclerview.RecyclerViewHeaderFooterAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Will on 2/8/2015.
 */
public class ExampleVerticalLinearLayoutActivity extends Activity {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private RecyclerViewHeaderFooterAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private IRecyclerViewIntermediary mIntermediary;

    private List<String> mStrings = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_example);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setTitle("Vertical Linear Layout");
    }

    private void init(){
        mStrings.clear();
        int count = new Random().nextInt(10)+5;
        for(int i = 0; i < count; i++){
            mStrings.add(Integer.toString(i));
        }
        mIntermediary = new ExampleIntermediary(mStrings);

        mLayoutManager = new LinearLayoutManager(mContext);
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);

        mAdapter = new RecyclerViewHeaderFooterAdapter(mLayoutManager, mIntermediary);

        mAdapter.addHeader(ExampleHeaderFooter.getView(mContext, "Header"));

        mAdapter.addFooter(ExampleHeaderFooter.getView(mContext, "Footer"));

    }

    public void onResume(){
        super.onResume();
        init();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
