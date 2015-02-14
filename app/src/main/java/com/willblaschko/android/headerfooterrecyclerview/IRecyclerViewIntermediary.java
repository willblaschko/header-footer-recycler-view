package com.willblaschko.android.headerfooterrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Will on 2/8/2015.
 */
public interface IRecyclerViewIntermediary {
    public int getItemCount();
    public Object getItem(int position);
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int type);
    public int getItemViewType(int position);
    public void populateViewHolder(RecyclerView.ViewHolder viewHolder, int position);
}
