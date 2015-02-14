package com.willblaschko.example;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.willblaschko.android.headerfooterrecyclerview.IRecyclerViewIntermediary;
import com.willblaschko.android.headerfooterrecyclerview.R;

import java.util.List;

/**
 * Created by Will on 2/8/2015.
 */
public class ExampleIntermediary implements IRecyclerViewIntermediary {

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
        View v;
        switch (type){
            case 1:
                v = View.inflate(viewGroup.getContext(), R.layout.item_string_1, null);
                break;
            case 2:
                v = View.inflate(viewGroup.getContext(), R.layout.item_string_2, null);
                break;
            case 3:
                v = View.inflate(viewGroup.getContext(), R.layout.item_string_3, null);
                break;
            default:
                v = View.inflate(viewGroup.getContext(), R.layout.item_string_4, null);
                break;
        }
        return new TestViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 4;  //any logic can go here
    }

    @Override
    public void populateViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((TestViewHolder) viewHolder).mTextView.setText(mItems.get(position));
    }

    private class TestViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        ImageView mImageView;
        public TestViewHolder(View itemView) {
            super(itemView);
            this.mTextView = (TextView) itemView.findViewById(R.id.text);
            this.mImageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
