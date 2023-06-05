package com.example.tgsprak5fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {

        if(this.users.size() > 0){
            this.users.clear();
        }

        this.users.addAll(users);

    }
    public void clearUsers(){
        this.users.clear();
    }



    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.tv_username.setText(user.getUserName());
        holder.tv_fullname.setText(user.getFullName());
        holder.profile.setImageResource(user.getImageProfile());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent((holder.itemView.getContext()), ProfileActivity.class);
            intent.putExtra("user", user);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profile;
        TextView tv_fullname, tv_username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            tv_username = itemView.findViewById(R.id.tv_username);

        }
    }
}
