package com.example.tugasprak8localdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    EditText et_title, et_desc;
    MaterialButton btn_submit, btn_delete;
    public static final String EXTRA_NOTES = "extra_notes";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private NotesHelper notesHelper;
    private Note note;
    private boolean isEdit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_title = findViewById(R.id.et_title);
        et_desc = findViewById(R.id.et_description);
        btn_submit = findViewById(R.id.btn_submit);
        btn_delete = findViewById(R.id.btn_delete);

        btn_delete.setVisibility(View.GONE);

        notesHelper = NotesHelper.getInstance(getApplicationContext());
        notesHelper.open();

        note = getIntent().getParcelableExtra(EXTRA_NOTES);

        if (note !=null){
            isEdit = true;
        }else {
            note = new Note();
        }

        String actionBarTitle;
        String buttonTitle;

        if  (isEdit){
            actionBarTitle = "Change";
            buttonTitle = "Update";
            if (note !=null){
                et_title.setText(note.getTitle());
                et_desc.setText(note.getDescription());
            }
            btn_delete.setVisibility(View.VISIBLE);
        }else {
            actionBarTitle ="Add";
            buttonTitle = "Save";
        }

        btn_submit.setText(buttonTitle);
        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        btn_submit.setOnClickListener(view -> save());
        btn_delete.setOnClickListener(view -> delete());

    }

    private void save(){
        String title = et_title.getText().toString().trim();
        String description = et_desc.getText().toString().trim();

        if (title.isEmpty()) {
            et_title.setError("Please fill this field");
            return;
        }
        if (description.isEmpty()) {
            et_desc.setError("Please fill this field");
            return;
        }
        note.setTitle(title);
        note.setDescription(description);

        Date currentDate = new Date();
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern, Locale.getDefault());
        String createdAt = "CreatedAt " + df.format(currentDate);

        // Membuat Intent untuk mengirim data kembali ke Activity sebelumnya
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra(EXTRA_NOTES, note);
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NotesColumn.TITLE, title);
        values.put(DatabaseContract.NotesColumn.DESCRIPTION, description);

        if (isEdit) {// Jika dalam mode edit, update data di database
            String editAt = "EditedAt " + df.format(currentDate);
            values.put(DatabaseContract.NotesColumn.DATE, editAt);
            long result = notesHelper.update(String.valueOf(note.getId()), values);
            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {// Jika dalam mode tambah data, tambahkan data baru ke database
            values.put(DatabaseContract.NotesColumn.DATE, createdAt);
            long result = notesHelper.insert(values);
            if (result > 0) {
                note.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void delete() {// Fungsi untuk menghapus data
        long result = notesHelper.deleteById(String.valueOf(note.getId()));
        if (result > 0) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            setResult(RESULT_DELETE, intent);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }
}