package com.example.tgsprak5fragment;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.sql.DataSource;

public class PostFragment extends Fragment {
    private ImageView iv_pict;
    private EditText et_caption;
    private Button btn_post;
    PostAdapter postAdapter;
    Post user;
    private ArrayList<Post> PhotoPost;
    private ActivityResultLauncher<Intent> launcherIntentPhotos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        user = new Post();
        user.setUser(new User("Selviani Amalia", "selvianiaml", R.drawable.profilepict));

        launcherIntentPhotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK){
                        Intent resultIntent = result.getData();
                        if (resultIntent !=null){
                            Uri selectedImagePost = resultIntent.getData();
                            user.setImage(selectedImagePost);

                            iv_pict.setImageURI(selectedImagePost);
                        }
                    }
                }
        );

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv_pict = view.findViewById(R.id.iv_pict);
        et_caption = view.findViewById(R.id.et_capt);
        btn_post = view.findViewById(R.id.btn_uploud);

        PhotoPost = new ArrayList<>();
        postAdapter = new PostAdapter(PhotoPost);

        iv_pict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);intent.setType( "image/*");
                launcherIntentPhotos.launch(Intent.createChooser(intent, "Choose Photo"));
            }
        });

        btn_post.setOnClickListener(view1 -> {
            user.setCapt(et_caption.getText().toString());
            if (user.getImage()!=null){
                HomeFragment.dataSource.addUsers(user);

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.navigateFragment(new HomeFragment());

                Toast.makeText(getActivity(), "Berhasil post foto!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getActivity(), "Uploud your photo dulu yah!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}