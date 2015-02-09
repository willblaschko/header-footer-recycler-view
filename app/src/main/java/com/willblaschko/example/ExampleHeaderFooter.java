package com.willblaschko.example;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Will on 2/8/2015.
 */
public class ExampleHeaderFooter {
    public static View getView(Context context, String title){
        TextView view = new TextView(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setGravity(Gravity.CENTER);
        view.setTextSize(30);
        view.setPadding(12, 12, 12, 12);
        view.setBackgroundColor(0x777777);
        view.setText(title);
        return view;
    }

}
