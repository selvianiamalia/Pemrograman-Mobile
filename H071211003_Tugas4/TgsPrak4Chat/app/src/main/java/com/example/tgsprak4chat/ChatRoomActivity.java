package com.example.tgsprak4chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tgsprak4chat.databinding.ActivityChatRoomBinding;
import com.example.tgsprak4chat.databinding.ActivityMainBinding;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatRoomActivity extends AppCompatActivity {

    private ActivityChatRoomBinding binding;
    private ActivityMainBinding mainBinding;
    private ArrayList<Chat> chatArrayList = new ArrayList<>();
    private TextView tv_nama, tv_status, tv_notelp, tv_lastseen, tv_lastchat, tv_lasttime;
    private ImageView iv_backicon;
    private CircleImageView iv_profile;
    String nama, notelp, lastseen, status;
    int profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tv_nama = findViewById(R.id.nama);
        iv_profile = findViewById(R.id.profile);
        tv_lastseen = findViewById(R.id.lastseen);
        tv_notelp = findViewById(R.id.notelp);
        tv_status = findViewById(R.id.status);
        iv_backicon = findViewById(R.id.backbutton);
        tv_lastchat = findViewById(R.id.tv_last);
        tv_lasttime = findViewById(R.id.timelast);

        Intent intent = getIntent();
        nama = intent.getStringExtra("varNama");
        profile = intent.getIntExtra("profile", 0);
        lastseen = intent.getStringExtra("varLastseen");
        notelp = intent.getStringExtra("varNotelp");
        status = intent.getStringExtra("varStatus");
        String chat = intent.getStringExtra("varChat");
        String time = intent.getStringExtra("varTime");

        tv_nama.setText(nama);
        tv_lastchat.setText(chat);
        tv_lasttime.setText(time);
        System.out.println(chat);
        System.out.println(time);
        iv_profile.setImageResource(profile);
        chatArrayList.addAll(DataSource.getLastChat());
        chatArrayList.add(new Chat(chat, time));

        binding.rvRoomChat.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.rvChat.setLayoutManager(new LinearLayoutManager(this));

        RoomChatAdapter Roomadapter = new RoomChatAdapter(DataSource.chatlist);
        ChatAdapter Chatadapter = new ChatAdapter(DataSource.chats);

        binding.rvRoomChat.setAdapter(Roomadapter);
        mainBinding.rvChat.setAdapter(Chatadapter);
    }

    public void openProfileDetail(View view) {
        Intent click = new Intent(this, ProfileDetailActivity.class);
        click.putExtra("varNama", nama);
        click.putExtra("profile", profile);
        click.putExtra("varNotelp", notelp);
        click.putExtra("varStatus", status);
        click.putExtra("varLastseen", lastseen);
        startActivity(click);
    }

    public void clickBackButton(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
}