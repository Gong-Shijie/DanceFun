package com.example.dancefun30.pre;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.dancefun30.R;
import com.example.dancefun30.model.Loog;

import java.net.URI;
import java.util.List;


 public class LoogAdapter extends RecyclerView.Adapter<LoogAdapter.ViewHolder> {
    private List<Loog> loogList;
    Context context;

    public LoogAdapter(List<Loog> looglist,Context context) {
        this.loogList = looglist;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        final  ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Loog loog = loogList.get(position);
        Glide.with(context)
                .load(Uri.parse(loog.getPhoto()))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.imageView);
        holder.textView.setText(loog.getContent());

    }

    @Override
    public int getItemCount() {
        return loogList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View loogview;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loogview = itemView.findViewById(R.id.loog_view);
            imageView = itemView.findViewById(R.id.log_photo);
            textView = itemView.findViewById(R.id.log_content);
        }
    }

}
