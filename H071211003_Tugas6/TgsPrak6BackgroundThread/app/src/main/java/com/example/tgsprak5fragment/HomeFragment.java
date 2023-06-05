package com.example.tgsprak5fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rv_home;
    static final DataSource dataSource = new DataSource();
    static final PostAdapter adapter = new PostAdapter(dataSource.getUsers());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvAddPost = view.findViewById(R.id.tv_addpostfirst);
        rv_home = view.findViewById(R.id.rv_postingan);
        //        setup rv
        rv_home.setHasFixedSize(true);
        rv_home.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_home.setAdapter(adapter);

        if (adapter.getItemCount() > 0){
            tvAddPost.setVisibility(View.GONE);
        }
//
//        Bundle bundle = getArguments();
//        if (bundle !=null){
//            user = bundle.getParcelable("PhotoPost");
//            postingan.add((Post) user);
//        }
    }

}