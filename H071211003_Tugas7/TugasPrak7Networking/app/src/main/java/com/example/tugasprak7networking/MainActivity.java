package com.example.tugasprak7networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_user;
    private AdapterUser adapter_user;
    private LinearLayout ll_reload;
    private ImageView iv_loading;

    private TextView tv_alert;

    private ProgressBar pb_loading;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_reload = findViewById(R.id.reload);
        iv_loading = findViewById(R.id.loading);
        tv_alert = findViewById(R.id.tv_alert);
        rv_user = findViewById(R.id.rv_user);
        pb_loading = findViewById(R.id.progressBar);

        adapter_user = new AdapterUser();

//        ll_reload.setVisibility(View.GONE);

        fetchAPI();
        iv_loading.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Berhasil klik ", Toast.LENGTH_SHORT).show();
            fetchAPI();
        });

    }
    private void fetchAPI(){
//        if (NetworkUtil.isNetworkAvailable(this)){
            showLoading();
            APIConfig.getApiService().getUsers("12").enqueue(new Callback<UsersResponse>() {
                @Override
                public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                    if (response.isSuccessful() && response.body() != null){

                        adapter_user.addUser(response.body().getUsers());
                        rv_user.setAdapter(adapter_user);
                        rv_user.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        Log.d("users", response.body().toString());
                        hideLoading();
                    }
                    else {
                        showAlert();
                    }
                }

                @Override
                public void onFailure(Call<UsersResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "OnFailure " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    showAlert();
                }
            });
        }
//        else {
////            ll_reload.setVisibility(View.VISIBLE);
////            rv_user.setVisibility(View.VISIBLE);
//            showAlert();
//        }
//    }

    public void showAlert() {
        tv_alert.setVisibility(View.VISIBLE);
        iv_loading.setVisibility(View.VISIBLE);
        rv_user.setVisibility(View.INVISIBLE);
        pb_loading.setVisibility(View.INVISIBLE);
    }

    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
        tv_alert.setVisibility(View.INVISIBLE);
        iv_loading.setVisibility(View.INVISIBLE);
        rv_user.setVisibility(View.INVISIBLE);
    }

    public void hideLoading() {
        pb_loading.setVisibility(View.INVISIBLE);
        tv_alert.setVisibility(View.INVISIBLE);
        iv_loading.setVisibility(View.INVISIBLE);
        rv_user.setVisibility(View.VISIBLE);
    }
}
