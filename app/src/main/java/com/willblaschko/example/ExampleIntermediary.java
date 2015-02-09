package com.willblaschko.example;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.willblaschko.android.headerfooterrecyclerview.R;
import com.willblaschko.android.headerfooterrecyclerview.RecyclerViewIntermediary;

import java.util.List;

/**
 * Created by Will on 2/8/2015.
 */
public class ExampleIntermediary implements RecyclerViewIntermediary {

    private List<String> mItems;

    public ExampleIntermediary(List<String> items){
        mItems=items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int type) {
        View v = View.inflate(viewGroup.getContext(), R.layout.item_string, null);
        return new TestViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void populateViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((TestViewHolder) viewHolder).mTextView.setText(mItems.get(position));
    }

    private class TestViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public TestViewHolder(View itemView) {
            super(itemView);
            this.mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
