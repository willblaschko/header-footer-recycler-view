# header-footer-recycler-view
This library adds header/footer functionality to vertical and horizontal RecyclerView (for all 3 built-in types--linear, staggered-grid, grid) and abstract RecyclerView.Adapter into an interface for easier usage of multiple ViewHolder types.
<h2>Dependencies</h2>
<ul>
<li>App Compat v7: com.android.support:appcompat-v7:21.0.0 or higher</li>
<li>RecyclerView v7: com.android.support:recyclerview-v7:21.0.0 or higher</li>
</ul>
<h2>Setup Instructions</h2>
<ul>
<li>Set up the project dependencies</li>
</ul>
<h2>Sample Implementation</h2>
<b>Activity/Fragment</b>
```
for(int i = 0; i < count; i++){
	mStrings.add(Integer.toString(i));
}
mIntermediary = new ExampleIntermediary(mStrings);
mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
mAdapter = new RecyclerViewHeaderFooterAdapter(mLayoutManager, mIntermediary);
mAdapter.addHeader(ExampleHeaderFooter.getView(mContext, "Header"));
mAdapter.addFooter(ExampleHeaderFooter.getView(mContext, "Footer"));
mRecyclerView.setLayoutManager(mLayoutManager);
mRecyclerView.setAdapter(mAdapter);
```
<b>IRecyclerViewIntermediary - ExampleIntermediary</b>
```
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
        switch (type){
           ... //based on the type (getItemViewType), return the correct view holder
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 4; //any logic can go here
    }

    @Override
    public void populateViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (getItemViewType(position){
           ...
        }
    }


}
```