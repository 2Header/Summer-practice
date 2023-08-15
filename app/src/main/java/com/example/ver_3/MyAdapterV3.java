package com.example.ver_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*public class MyAdapterV3 extends RecyclerView.Adapter<MyAdapterV3.MyViewHolder> {

    Context context;
    ArrayList<Calendar> calendar;

    public MyAdapterV3(Fragment_1 context, ArrayList<Calendar> p){

        calendar = p;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(calendar.get(position).getName());
        Picasso.get().load(calendar.get(position).getImage()).into(holder.profilePic);

    }

    @Override
    public int getItemCount() {
        return calendar.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView profilePic;
       //View mView;
        public MyViewHolder(View itemView){

            super(itemView);
            //mView = itemView;

            name = (TextView) itemView.findViewById(R.id.name);
            profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
        }
    }


*/
