package com.example.tugasprak7networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    private TextView tvName, tvEmail;
    private CircleImageView ivAvatar;
    private ImageView iv_loading;
    private LinearLayout ll_reload;
    private CardView cv;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        cv = findViewById(R.id.cv);
        progressBar = findViewById(R.id.progressBar);
        iv_loading = findViewById(R.id.loading);
        ll_reload = findViewById(R.id.reload);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        progressBar.setVisibility(View.VISIBLE);
        cv.setVisibility(View.GONE);
        ll_reload.setVisibility(View.GONE);

        fetchAPI(String.valueOf(id));
        iv_loading.setOnClickListener(view -> {
            fetchAPI(String.valueOf(id));
        });
    }
    private void fetchAPI(String id){
        if (NetworkUtil.isNetworkAvailable(this)){
            APIConfig.getApiService().getUserById(id).enqueue(new Callback<ProfileResponse>() {
                @Override
                public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                    if (response.isSuccessful() && response.body() != null){
                        tvName = findViewById(R.id.tv_name);
                        tvEmail = findViewById(R.id.tv_email);
                        ivAvatar = findViewById(R.id.iv_avatar);

                        UserResponse userResponse = response.body().getUser();
                        tvName.setText(userResponse.getFirst_name() + " " + userResponse.getLast_name());
                        tvEmail.setText(userResponse.getEmail());
                        Glide.with(getApplicationContext()).load(userResponse.getAvatarImg()).into(ivAvatar);

                        progressBar.setVisibility(View.GONE);
                        cv.setVisibility(View.VISIBLE);
                        ll_reload.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<ProfileResponse> call, Throwable t) {
//                    Toast.makeText(ProfileActivity.this, "OnFailure " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            ll_reload.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            cv.setVisibility(View.GONE);
        }
    }
}