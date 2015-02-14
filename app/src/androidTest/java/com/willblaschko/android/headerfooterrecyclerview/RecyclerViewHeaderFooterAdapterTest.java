package com.willblaschko.android.headerfooterrecyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.test.InstrumentationTestCase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Will on 2/8/2015.
 */
public class RecyclerViewHeaderFooterAdapterTest extends InstrumentationTestCase {

    private Context mContext;
    private int mCount;
    private int mHeaderCount;
    private int mFooterCount;
    List<String> mStrings;

    @Override
    public void setUp(){
        mContext = getInstrumentation().getContext();
        mCount = new Random().nextInt(100)+1;
        mHeaderCount = new Random().nextInt(10)+1;
        mFooterCount = new Random().nextInt(10)+1;
        mStrings = getStrings(mCount);
    }

    public void testLinearLayoutManager() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        TestIntermediary mIntermeditary = new TestIntermediary(mStrings);
        RecyclerViewHeaderFooterAdapter mAdapter = new RecyclerViewHeaderFooterAdapter(mLayoutManager, mIntermeditary);

        for(int i = 0; i < mHeaderCount; i++){
            assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + i);
            mAdapter.addHeader(new View(mContext));
        }
        for(int i = 0; i < mFooterCount; i++){
            assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + mHeaderCount + i);
            mAdapter.addFooter(new View(mContext));
        }

        assertEquals("Wrong LayoutManager", mAdapter.getManagerType(), RecyclerViewHeaderFooterAdapter.TYPE_MANAGER_LINEAR);
        assertEquals("Item List length is wrong size", mStrings.size(), mIntermeditary.getItemCount());
        assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + mHeaderCount + mFooterCount);
        assertEquals("Wrong header layout span count", mAdapter.getGridSpan(mHeaderCount-1), 1);
        assertEquals("Wrong object layout span count", mAdapter.getGridSpan(mHeaderCount), 1);
        assertEquals("Wrong footer layout span count", mAdapter.getGridSpan(mHeaderCount+mCount), 1);
    }

    public void testGridLayoutMananger() {
        int span = new Random().nextInt(4)+1;
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, span);
        TestIntermediary mIntermeditary = new TestIntermediary(mStrings);
        RecyclerViewHeaderFooterAdapter mAdapter = new RecyclerViewHeaderFooterAdapter(mLayoutManager, mIntermeditary);

        for(int i = 0; i < mHeaderCount; i++){
            assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + i);
            mAdapter.addHeader(new View(mContext));
        }
        for(int i = 0; i < mFooterCount; i++){
            assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + mHeaderCount + i);
            mAdapter.addFooter(new View(mContext));
        }

        assertEquals("Wrong LayoutManager", mAdapter.getManagerType(), RecyclerViewHeaderFooterAdapter.TYPE_MANAGER_GRID);
        assertEquals("Item List length is wrong size", mStrings.size(), mIntermeditary.getItemCount());
        assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + mHeaderCount + mFooterCount);
        assertEquals("Wrong header layout span count", mAdapter.getGridSpan(mHeaderCount-1), span);
        assertEquals("Wrong object layout span count", mAdapter.getGridSpan(mHeaderCount), 1);
        assertEquals("Wrong footer layout span count", mAdapter.getGridSpan(mHeaderCount+mCount), span);
    }

    public void testStaggeredGridLayoutManager() {
        int span = new Random().nextInt(4)+1;
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(span, StaggeredGridLayoutManager.VERTICAL);
        TestIntermediary mIntermeditary = new TestIntermediary(mStrings);
        RecyclerViewHeaderFooterAdapter mAdapter = new RecyclerViewHeaderFooterAdapter(mLayoutManager, mIntermeditary);

        for(int i = 0; i < mHeaderCount; i++){
            assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + i);
            mAdapter.addHeader(new View(mContext));
        }
        for(int i = 0; i < mFooterCount; i++){
            assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + mHeaderCount + i);
            mAdapter.addFooter(new View(mContext));
        }

        assertEquals("Wrong LayoutManager", mAdapter.getManagerType(), RecyclerViewHeaderFooterAdapter.TYPE_MANAGER_STAGGERED_GRID);
        assertEquals("Item List length is wrong size", mStrings.size(), mIntermeditary.getItemCount());
        assertEquals("Wrong item count (items + header + footer)", mAdapter.getItemCount(), mStrings.size() + mHeaderCount + mFooterCount);
        assertEquals("Wrong header layout span count", mAdapter.getGridSpan(mHeaderCount-1), span);
        assertEquals("Wrong object layout span count", mAdapter.getGridSpan(mHeaderCount), 1);
        assertEquals("Wrong footer layout span count", mAdapter.getGridSpan(mHeaderCount+mCount), span);
    }

    private List<String> getStrings(int length){
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < length; i++){
            strings.add(Integer.toString(i));
        }
        return strings;
    }

    private class TestIntermediary implements IRecyclerViewIntermediary {

        private List<String> mItems;

        public TestIntermediary(List<String> items){
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
            return new TestViewHolder(new TextView(mContext));
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
                this.mTextView = (TextView) itemView;
            }
        }
    };
}
