package com.example.tgsprak5fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity().getIntent().getParcelableExtra("user") !=null){
            User user = getActivity().getIntent().getParcelableExtra("user");

            TextView tvUsername = view.findViewById(R.id.tv_userName);
            TextView fullname = view.findViewById(R.id.tv_name);
            CircleImageView ivProfile = view.findViewById(R.id.iv_profile);

            tvUsername.setText(user.getUserName());
            fullname.setText(user.getFullName());
            ivProfile.setImageResource(user.getImageProfile());
        }
    }
}