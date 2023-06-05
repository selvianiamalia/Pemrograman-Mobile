package com.example.tugasprak7networking;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder>{

    private final ArrayList<UserResponse> users = new ArrayList<>();

    public void addUser (List<UserResponse> users) {
        this.users.addAll(users);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(UserResponse user){
            TextView tv_name = itemView.findViewById(R.id.tv_name);
            TextView tv_email = itemView.findViewById(R.id.tv_email);
            CircleImageView civ_profile = itemView.findViewById(R.id.civ_profile);

            tv_name.setText(user.getFirst_name() + " " + user.getLast_name());
            tv_email.setText(user.getEmail());
            Glide.with(itemView.getContext()).load(user.getAvatarImg()).into(civ_profile);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = user.getId();
                    Intent intent = new Intent(itemView.getContext(), ProfileActivity.class);
                    intent.putExtra("id", id);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}