package com.example.tgsprak1bangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private TextView hasil;
    private EditText jaribola, jarikerucut, tkerucut, pbalok, lbalok, tbalok;
    private Button hitung;
    private Spinner spinner;
    private String choose;
    private ViewFlipper viewFlipper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        jaribola = findViewById(R.id.editTextNumber);
        jarikerucut = findViewById(R.id.editTextNumber2);
        tkerucut = findViewById(R.id.editTextNumber3);
        pbalok = findViewById(R.id.editTextNumber4);
        lbalok = findViewById(R.id.editTextNumber5);
        tbalok = findViewById(R.id.editTextNumber6);
        hitung = findViewById(R.id.hitungbtn);
        hasil = findViewById(R.id.hasil);
        viewFlipper = findViewById(R.id.viewFlipper);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.geometry, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choose = spinner.getSelectedItem().toString();
//                if (choose.equals("Bola")){
//                    viewFlipper.setDisplayedChild(0);
//                } else if (choose.equals("Kerucut")) {
//                    viewFlipper.setDisplayedChild(1);
//                } else if (choose.equals("Balok")) {
//                    viewFlipper.setDisplayedChild(2);
//                }else {
//                    viewFlipper.setDisplayedChild(0);
//                }
                viewFlipper.setDisplayedChild(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choose.equals("Bola")) {
                    try {
                        if (jaribola.getText().toString().isEmpty()) {
                            jaribola.setError("field ini tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan jari-jari bola!", Toast.LENGTH_SHORT).show();
                        }else {
                            int Jari = Integer.valueOf(jaribola.getText().toString());
                            double Hasilnya = 4.0 / 3.0 * Jari * Jari * Jari * 3.14;

                            hasil.setText(String.format("%.2f", Hasilnya));
                        }
                    }catch (NumberFormatException ex) {
                        Toast.makeText(MainActivity.this, "inputan terlalu besar", Toast.LENGTH_SHORT).show();
                    }
                } else if (choose.equals("Kerucut")) {
                    try {
                        boolean isEmpty = false;
                        if (tkerucut.getText().toString().isEmpty()) {
                            tkerucut.setError("field tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan tinggi kerucut!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (jarikerucut.getText().toString().isEmpty()) {
                            jarikerucut.setError("field tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan jari-jari kerucut!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (!isEmpty) {
                            Long Tinggi = Long.valueOf(tkerucut.getText().toString());
                            Long Jari = Long.valueOf(jarikerucut.getText().toString());
                            double Hasil = 1.0 / 3.0  * Jari * Jari * Tinggi * 3.14;
                            hasil.setText(String.format("%.2f", Hasil));
                        }
                    }catch (NumberFormatException ex) {
                        Toast.makeText(MainActivity.this, "inputan terlalu besar", Toast.LENGTH_SHORT).show();
                    }
                } else if (choose.equals("Balok")) {
                    try {
                        boolean isEmpty = false;
                        if (pbalok.getText().toString().isEmpty()){
                            pbalok.setError("field tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Panjang Balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (lbalok.getText().toString().isEmpty()) {
                            lbalok.setError("field tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Lebar Balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (tbalok.getText().toString().isEmpty()) {
                            tbalok.setError("field tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan Tinggi Balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }
                        if (!isEmpty) {
                            int Panjang = Integer.valueOf(pbalok.getText().toString());
                            int Lebar = Integer.valueOf(lbalok.getText().toString());
                            int Tinggi = Integer.valueOf(tbalok.getText().toString());

                            int Hasil = Panjang * Lebar * Tinggi;
                            hasil.setText(String.valueOf(Hasil));
                        }
                    }catch (NumberFormatException ex) {
                        Toast.makeText(MainActivity.this, "inputan terlalu besar!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
