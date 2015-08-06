package com.michael.stealth.toprssfeeds;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Stealth on 7/30/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<RssDataParser.Item> mDataset;

    public RecyclerAdapter(Context context, ArrayList<RssDataParser.Item> dataset) {
        this.mContext = context;
        this.mDataset = dataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView rssTitle, rssDescription;
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            rssTitle = (TextView) view.findViewById(R.id.item_title);
            rssDescription = (TextView) view.findViewById(R.id.item_description);
        }
    }

    public void add(int position, RssDataParser.Item item) {
        mDataset.add(position, item);
        notifyItemChanged(position);
    }

    public void remove(RssDataParser.Item item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mDataset.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_feed_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final RssDataParser.Item item = mDataset.get(position);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewHolder.cardView.getContext(), position+"",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(item.link));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        viewHolder.rssTitle.setText(item.title);
        viewHolder.rssDescription.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
