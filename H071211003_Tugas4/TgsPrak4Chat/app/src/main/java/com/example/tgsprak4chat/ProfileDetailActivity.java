package com.example.tgsprak4chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileDetailActivity extends AppCompatActivity {
    private CircleImageView iv_profile;
    private ImageView iv_back;
    private TextView tv_nama, tv_status, tv_notelp, tv_lastseen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        tv_nama = findViewById(R.id.nama);
        iv_profile = findViewById(R.id.profile);
        tv_notelp = findViewById(R.id.notelp);
        tv_status = findViewById(R.id.status);
        tv_lastseen = findViewById(R.id.lastseen);
        iv_back = findViewById(R.id.btn_back);


        Intent intent = getIntent();
        String name = intent.getStringExtra("varNama");
        int profile = intent.getIntExtra("profile",0);
        String noTelp = intent.getStringExtra("varNotelp");
        String Status = intent.getStringExtra("varStatus");
        String LastSeen = intent.getStringExtra("varLastseen");

        iv_profile.setImageResource(profile);
        tv_nama.setText(name);
        tv_notelp.setText(noTelp);
        tv_status.setText(Status);
        tv_lastseen.setText(LastSeen);

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(ProfileDetailActivity.this, ProfileActivity.class);
                profil.putExtra("profile", profile);
                startActivity(profil);
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = intent.getStringExtra("varNama");
                int profile = intent.getIntExtra("profile",0);

                Intent back = new Intent(ProfileDetailActivity.this, ChatRoomActivity.class);
                back.putExtra("varNama", name);
                back.putExtra("profile", profile);
                finish();
            }
        });
    }
//    public void ButtonBack (View view){
//        Intent backbtn = new Intent(this, ChatRoomActivity.class);
//        startActivity(backbtn);
//    }

}