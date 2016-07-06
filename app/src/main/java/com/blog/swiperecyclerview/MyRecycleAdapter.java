package com.blog.swiperecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jingling on 16/6/30.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mList;
    private LayoutInflater mInflater;

    public MyRecycleAdapter(Context context, List<String> data){
        this.mContext = context;
        this.mList = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTvItemContent.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout mLlItem;
        public TextView mTvItemContent;
        public TextView mTvItemDelete;


        public MyViewHolder(View itemView) {
            super(itemView);
            mLlItem = (LinearLayout)itemView.findViewById(R.id.ll_item);
            mTvItemContent = (TextView)itemView.findViewById(R.id.tv_item_content);
            mTvItemDelete = (TextView)itemView.findViewById(R.id.tv_item_delete);
        }
    }
}
