package com.example.tgsprak4chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tgsprak4chat.databinding.ItemBubbleChatBinding;

import java.util.ArrayList;

public class RoomChatAdapter extends RecyclerView.Adapter<RoomChatAdapter.ViewHolder>{

    private final ArrayList<Chat> chatlist;

    private ClickListener clickListener;

    public RoomChatAdapter(ArrayList<Chat> chatList) {
        this.chatlist = chatList;
    }

    @NonNull
    @Override
    public RoomChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBubbleChatBinding binding = ItemBubbleChatBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomChatAdapter.ViewHolder holder, int position) {
        holder.onBind(chatlist.get(position));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String chat1 = chatlist.get(holder.getAdapterPosition()).getChat();
//                String time2 = chatlist.get(holder.getAdapterPosition()).getTime();
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return chatlist.size();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemBubbleChatBinding binding;

        public ViewHolder(@NonNull ItemBubbleChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(Chat chatfield) {
            binding.getRoot().setOnClickListener(view -> {
                clickListener.onChatClicked(chatfield);
            });
            binding.textchata.setText(chatfield.getTextchat1());
            binding.timea.setText(chatfield.getTime1());
            binding.textchatb.setText(chatfield.getTextchat2());
            binding.timeb.setText(chatfield.getTime2());
        }
    }
    interface ClickListener {
        void onChatClicked(Chat chatlist);
    }
}
