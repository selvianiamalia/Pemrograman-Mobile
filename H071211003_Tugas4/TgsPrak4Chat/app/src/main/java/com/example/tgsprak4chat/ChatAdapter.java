package com.example.tgsprak4chat;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tgsprak4chat.databinding.ItemCardChatBinding;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<Chat> chats;
    private ClickListener clickListener;

    public ChatAdapter(ArrayList<Chat> chats) {
        this.chats = chats;
    }


    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardChatBinding binding = ItemCardChatBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(chats.get(position));

        holder.binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int viewProfile = chats.get(holder.getAdapterPosition()).getProfile();
                String name = chats.get(holder.getAdapterPosition()).getName();

                Intent intent = new Intent(holder.binding.profile.getContext(), ProfileActivity.class);
                intent.putExtra("profile", viewProfile);
                intent.putExtra("varNama", name);
                holder.binding.profile.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = chats.get(holder.getAdapterPosition()).getName();
                int profile = chats.get(holder.getAdapterPosition()).getProfile();
                String notelp = chats.get(holder.getAdapterPosition()).getNotelp();
                String status = chats.get(holder.getAdapterPosition()).getStatus();
                String lastseen = chats.get(holder.getAdapterPosition()).getLastseen();
                String chat = chats.get(holder.getAdapterPosition()).getChat();
                String time = chats.get(holder.getAdapterPosition()).getTime();

                Intent intent = new Intent(holder.itemView.getContext(), ChatRoomActivity.class);

                intent.putExtra("varNama", nama);
                intent.putExtra("varNotelp", notelp);
                intent.putExtra("profile", profile);
                intent.putExtra("varStatus", status);
                intent.putExtra("varLastseen", lastseen);
                intent.putExtra("varChat", chat);
                intent.putExtra("varTime", time);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCardChatBinding binding;

        public ViewHolder(@NonNull ItemCardChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(Chat chat) {
            binding.getRoot().setOnClickListener(view -> {
                clickListener.onChatClicked(chat);
            });
            binding.nama.setText(chat.getName());
            binding.textchat.setText(chat.getChat());
            binding.time.setText(chat.getTime());
            binding.profile.setImageResource(chat.getProfile());
        }
    }

    interface ClickListener {
        void onChatClicked(Chat chat);
    }
}


