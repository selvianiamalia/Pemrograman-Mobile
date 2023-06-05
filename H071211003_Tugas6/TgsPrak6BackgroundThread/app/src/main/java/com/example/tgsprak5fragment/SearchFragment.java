package com.example.tgsprak5fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {
    private SearchView svSearch;
    private RecyclerView rvUser;
    private ProgressBar progressBar;

    private SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUser = view.findViewById(R.id.rv_user);
        progressBar = view.findViewById(R.id.progressBar);
        svSearch = view.findViewById(R.id.sv_search);

        searchAdapter = new SearchAdapter();
        rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        rvUser.setAdapter(searchAdapter);

        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                progressBar.setVisibility(View.VISIBLE);
                rvUser.setVisibility(View.GONE);

                Executor executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());

                executor.execute(() -> {
                    try {
                        Thread.sleep(1000);

                        handler.post(() -> {
                            progressBar.setVisibility(View.GONE);
                            rvUser.setVisibility(View.VISIBLE);
                        });
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                });
                if (newText.isEmpty()){
                    searchAdapter.clearUsers();
                }else {
                    searchAdapter.setUsers(HomeFragment.dataSource.getUsersByQuery(newText));
                }
                searchAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }


}