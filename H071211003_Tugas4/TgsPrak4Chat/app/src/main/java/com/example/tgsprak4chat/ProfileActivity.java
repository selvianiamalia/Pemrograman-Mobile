package com.example.tgsprak4chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private ImageView iv_profile;
    private TextView tv_name;
    private ImageView iv_btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        iv_profile = findViewById(R.id.profile);
        iv_btnback = findViewById(R.id.backbutton);
        tv_name = findViewById(R.id.nama);

        Intent intent = getIntent();
        String name = intent.getStringExtra("varNama");
        int profile = intent.getIntExtra("profile",0);
        String noTelp = intent.getStringExtra("varNotelp");
        String Status = intent.getStringExtra("varStatus");
        String LastSeen = intent.getStringExtra("varLastseen");

        iv_profile.setImageResource(profile);
        tv_name.setText(name);


        iv_btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(ProfileActivity.this, ProfileDetailActivity.class);
                back.putExtra("varNama", name);
                back.putExtra("profile", profile);
                back.putExtra("varNotelp", noTelp);
                back.putExtra("varStatus", Status);
                back.putExtra("varLastseen", LastSeen);
                finish();
            }
        });
    }
}