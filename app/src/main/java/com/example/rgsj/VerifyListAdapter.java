package com.example.rgsj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerifyListAdapter extends RecyclerView.Adapter<VerifyListAdapter.MyViewHolder> {

    private ArrayList<VerifyModel> mData;
    private LayoutInflater mInflater;
    private View.OnClickListener itemClick;
    private Context context ;
    private int id = 0;

    public VerifyListAdapter(Verify verify, ArrayList<VerifyModel> imageIDs, View.OnClickListener itemClick) {
        this.mInflater = LayoutInflater.from(verify);
        this.mData = imageIDs;
        this.context = verify;
    }

    @Override
    public VerifyListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_verify, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerifyListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(mData.get(position).getImg());

        holder.itemView.setOnClickListener(itemClick);
        holder.itemView.setTag(position);

      /*  if (mData.get(position).isSelected() == true){
            holder.checedImage.setVisibility(View.VISIBLE);
        }else if (mData.get(position).isSelected() == false){
            holder.checedImage.setVisibility(View.GONE);
        }*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checedImage.getVisibility() == View.GONE){
                    holder.checedImage.setVisibility(View.VISIBLE);
                    id = id + mData.get(position).getid();
                    ((Verify)context).getid(id);
                }else if (holder.checedImage.getVisibility() == View.VISIBLE){
                    holder.checedImage.setVisibility(View.GONE);
                    id = id - mData.get(position).getid();
                    ((Verify)context).getid(id);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, checedImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            checedImage = itemView.findViewById(R.id.imgcheck);
        }
    }
}
