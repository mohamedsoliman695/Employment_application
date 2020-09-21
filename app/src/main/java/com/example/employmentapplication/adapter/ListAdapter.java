package com.example.employmentapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employmentapplication.R;
import com.example.employmentapplication.database.Employeemode;


import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    //private final LinearLayoutManager LayoutManager;
    Context context;
    List<Employeemode> employeemodellist;





    public ListAdapter(Context context, List<Employeemode> employeemodellist) {
        this.context = context;
        this.employeemodellist = employeemodellist;
        //employeemodellist.setHasFixedSize(true);

        // use a linear layout manager
        //LayoutManager = new LinearLayoutManager(this);
        //employeemodellist.setLayoutManager(layoutManager);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_layout,parent,false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {

        holder.nameTextView.setText(employeemodellist.get(position).getName());
        holder.ageTextview.setText( String.valueOf(employeemodellist.get(position).getAge()));
        holder.Jobtitle.setText(employeemodellist.get(position).getJobtitle());
        holder.gender.setText(employeemodellist.get(position).getGender());
       // Log.e( "listsize", String.valueOf(employeemodellist.size()));
    }

    @Override
    public int getItemCount() {
        return employeemodellist.size();
    }
//My holder class
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView,ageTextview,Jobtitle,gender;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

         //   Log.e( "listsize", String.valueOf(employeemodellist.size()));
            Log.e( "listsize", String.valueOf(employeemodellist.size()));
            nameTextView = itemView.findViewById(R.id.textView8);
            ageTextview = itemView.findViewById(R.id.textView9);
            Jobtitle = itemView.findViewById(R.id.textView10);
            gender = itemView.findViewById(R.id.textView11);
        }
    }
}
