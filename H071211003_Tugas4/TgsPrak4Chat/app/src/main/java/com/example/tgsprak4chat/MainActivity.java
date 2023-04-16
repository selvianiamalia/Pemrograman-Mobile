package com.example.tgsprak4chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import com.example.tgsprak4chat.databinding.ActivityChatRoomBinding;
import com.example.tgsprak4chat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //setup rv
        binding.rvChat.setLayoutManager(new LinearLayoutManager(this));
        binding.rvChat.addItemDecoration(
                new DividerItemDecoration(binding.rvChat.getContext(), DividerItemDecoration.VERTICAL)
        );

        ChatAdapter adapter = new ChatAdapter(DataSource.chats);
        binding.rvChat.setAdapter(adapter);
    }
}