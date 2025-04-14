package com.example.nextdayassigment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<ObjClass>arrayList;
    Context context;

    public Adapter(Context con, ArrayList<ObjClass>array){
        this.context=con;
        this.arrayList=array;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.display,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.Id.setText(arrayList.get(position).getId());
        holder.Email.setText(arrayList.get(position).getEmail());
        holder.Firstname.setText(arrayList.get(position).getFirstname());
        holder.Lastname.setText(arrayList.get(position).getLastname());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.show();
                dialog.setContentView(R.layout.display_data);
                TextView te_ID = dialog.findViewById(R.id.id);
                TextView te_email = dialog.findViewById(R.id.email);
                TextView te_firstName = dialog.findViewById(R.id.fname);
                TextView te_lastName = dialog.findViewById(R.id.lname);

                te_ID.setText(arrayList.get(position).getId());
                te_email.setText(arrayList.get(position).getEmail());
                te_firstName.setText(arrayList.get(position).getFirstname());
                te_lastName.setText(arrayList.get(position).getLastname());

                ImageView avtar = dialog.findViewById(R.id.imgAvtar);

                Picasso.get().load(arrayList.get(position).getAvatar()).into(avtar);

            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Id,Email,Firstname,Lastname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Id =itemView.findViewById(R.id.id);
            Email=itemView.findViewById(R.id.email);
            Firstname=itemView.findViewById(R.id.fname);
            Lastname=itemView.findViewById(R.id.lname);

        }
    }
}
