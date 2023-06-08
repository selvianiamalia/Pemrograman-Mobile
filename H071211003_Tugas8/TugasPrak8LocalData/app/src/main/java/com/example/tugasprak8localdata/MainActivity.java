package com.example.tugasprak8localdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_user;
    AdapterUser adapterUser;
    private ImageView iv_add;
    private SearchView sv_user;
    private ArrayList<Note> note;
    private NotesHelper notesHelper;
    TextView tv_tetxt;
    Executor executor;
    Handler handler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_user =findViewById(R.id.rv_notes);
        iv_add = findViewById(R.id.iv_add);
        sv_user = findViewById(R.id.sv_User);
        tv_tetxt = findViewById(R.id.test);

        sv_user.setFocusable(true);
        sv_user.setIconified(false);
        sv_user.requestFocus();

        adapterUser = new AdapterUser();

        notesHelper = NotesHelper.getInstance(this);
        notesHelper.open();

        rv_user.setAdapter(adapterUser);
        rv_user.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        if (rv_user !=null){
            iv_add.setVisibility(View.VISIBLE);
        }
        new LoadStudentsAsync(this, notes -> {
            if (notes.size() > 0){
                note = notes;
            }else {
                note = null;
            }
            if (note != null) {
                showCurrentUser(note);
            }
            else {
                showCurrentUser(new ArrayList<>());
            }
        }).execute();

        sv_user.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchData(s);
                return true;
            }
        });
    }
    private void showCurrentUser(ArrayList<Note> notes1) {
        adapterUser.setNotes(notes1);
        if (notes1.size() > 0){
            tv_tetxt.setVisibility(View.GONE);
        }
        else {
            tv_tetxt.setVisibility(View.VISIBLE);
        }
    }

    private static class LoadStudentsAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadStudentsCallback> weakCallback;

        private LoadStudentsAsync(Context context, LoadStudentsCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }
        void execute(){
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                NotesHelper notesHelper = NotesHelper.getInstance(context);
                notesHelper.open();
                ArrayList<Note> notee = notesHelper.getAllNotes();
                notesHelper.close();
                handler.post(() -> weakCallback.get().postExecute(notee));
            });
        }
    }
    interface LoadStudentsCallback{
        void postExecute(ArrayList<Note> notes);
    }

    private void searchData(String searchText) {
        if (!TextUtils.isEmpty(searchText)) {
            ArrayList<Note> searchResults = notesHelper.searchNotes(searchText);
            adapterUser.setNotes(searchResults);
        } else {
            // Jika teks pencarian kosong, tampilkan semua data
            showCurrentUser(note);
        }
    }

}