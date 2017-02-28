package com.eascs.testrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by chao.wang on 2017/2/28.
 *
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {


    private Context mContext;
    private List<String> mDataSet;
    private AdapterView.OnItemClickListener onItemClickListener;
    private AdapterView.OnLongClickListener onLongClickListener;

    public myAdapter(Context context, List<String> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.ad_home_menu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.text.setText(mDataSet.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, "点击了" + position, Toast.LENGTH_SHORT).show();

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(mContext, "wangchao" , Toast.LENGTH_SHORT).show();

                //这个位置一定要注意，返回值是true 和false是
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        return mDataSet.size();

    }

    public void remove(int position) {

        mDataSet.remove(position);
        notifyItemRemoved(position);

    }

    public void add(String text, int position) {

        mDataSet.add(position, text);
        notifyItemInserted(position);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }


}
