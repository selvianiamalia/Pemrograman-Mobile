package com.example.tgsprak5fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView btn_home, btn_add, btn_profile, btn_search;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_home = findViewById(R.id.homebutton);
        btn_add = findViewById(R.id.addbutton);
        btn_profile = findViewById(R.id.personbutton);
        btn_search = findViewById(R.id.searchbutton);

        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)){
            navigateFragment(new HomeFragment());
        }

        btn_home.setOnClickListener(view -> {
            navigateFragment(new HomeFragment());
        });

        btn_search.setOnClickListener(view -> {
            navigateFragment(new SearchFragment());
        });

        btn_add.setOnClickListener(view -> {
            navigateFragment(new PostFragment());
        });

        btn_profile.setOnClickListener(view -> {
            navigateFragment(new ProfileFragment());
        });
    }

    public void navigateFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.frame_main, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}