package com.example.prince.cakeassignment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CakeListAdapter extends RecyclerView.Adapter<CakeListAdapter.CakeViewHolder> {

    List<Cake> dataset;
    private View.OnClickListener listener;

    public CakeListAdapter(List<Cake> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public CakeListAdapter.CakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cakelayout, parent, false);
        CakeViewHolder cvh = new CakeViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CakeListAdapter.CakeViewHolder holder, int position) {
        final Cake cake = dataset.get(position);

        String imgURL = cake.getImage();
        Picasso.get().load(imgURL).fit().into((ImageView) holder.img.findViewById(R.id.cake_img));
        holder.title.setText(cake.getTitle());
        holder.description.setText(cake.getDesc());
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    void setWords(List<Cake> cakes){
        dataset = cakes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    class CakeViewHolder extends RecyclerView.ViewHolder{
        View layout;
        ImageView img;
        TextView title, description;

        public CakeViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.root_view);
            img = itemView.findViewById(R.id.cake_img);
            title = itemView.findViewById(R.id.cake_title);
            description = itemView.findViewById(R.id.cake_description);
        }
    }
}