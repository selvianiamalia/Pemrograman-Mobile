package com.example.tgsprak5fragment;

import android.content.ClipData;
import android.content.Intent;
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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CardViewHolder> {
//    private ArrayList<Post> users;

    List<Post> postList = new ArrayList<>();

    public PostAdapter(ArrayList<Post> users) {
        this.postList = users;
    }

    @NonNull
    @Override
    public PostAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Post user = postList.get(position);
        holder.tv_caption.setText(user.getCapt());
        Glide.with(holder.itemView.getContext()).load(user.getImage()).into(holder.iv_postphoto);
//        holder.iv_postphoto.setImageURI(user.getImage());
        holder.iv_userphoto.setImageResource(user.getUser().getImageProfile());
        holder.tv_fullname.setText(user.getUser().getFullName());
        holder.tv_username.setText(user.getUser().getUserName());
//        Glide.with(holder.itemView.getContext()).load(user.getImage()).into(holder.iv_postphoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra("user", user);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.postList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        TextView tv_username, tv_fullname, tv_caption;
        ImageView iv_userphoto, iv_postphoto;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_caption = itemView.findViewById(R.id.caption);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            iv_userphoto = itemView.findViewById(R.id.civ_profile);
            iv_postphoto = itemView.findViewById(R.id.imagePost);
        }
    }
}
