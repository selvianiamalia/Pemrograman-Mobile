package com.example.tugas2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tugas2calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    int inputan;
    String proses;
    String operator;
    int inputMasuk;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "0");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "1");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "2");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "3");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "4");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "5");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "6");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "7");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "8");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses = binding.process.getText().toString();
                binding.process.setText(proses + "9");
                if(operator != null){
                    inputan++;
                }
            }
        });

        binding.btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.process.setText("");
                binding.result.setText("");
                inputan = 0;
                binding.btnBagi.setEnabled(true);
                binding.btnTambah.setEnabled(true);
                binding.btnKurang.setEnabled(true);
                binding.btnKali.setEnabled(true);
                inputMasuk = 0;
                operator = null;
            }
        });

        binding.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delete = binding.process.getText().toString();
                int operasi = delete.length();
                if (operasi > 0){
                    binding.process.setText(delete.substring(0, operasi-1));
                } if (inputan == 0){
                    operator = null;
                    inputan = 0;
                    binding.btnBagi.setEnabled(true);
                    binding.btnTambah.setEnabled(true);
                    binding.btnKurang.setEnabled(true);
                    binding.btnKali.setEnabled(true);
                } else {
                    inputan--;
                }
            }
        });

        binding.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMasuk == 0) {
                    proses = binding.process.getText().toString();
                    if (operator == null) {
                        binding.process.setText(proses + "+");
                    } else {
                        binding.process.setText(proses.substring(0, proses.length() - 1) + "+");
                    }
                    operator = "+";
                } else {
                    binding.btnBagi.setEnabled(false);
                    binding.btnKurang.setEnabled(false);
                    binding.btnKali.setEnabled(false);
                }
            }
        });

        binding.btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMasuk == 0) {
                    proses = binding.process.getText().toString();
                    if (operator == null) {
                        binding.process.setText(proses + "-");
                    } else {
                        binding.process.setText(proses.substring(0, proses.length() - 1) + "-");
                    }
                    operator = "-";
                } else {
                    binding.btnBagi.setEnabled(false);
                    binding.btnTambah.setEnabled(false);
                    binding.btnKali.setEnabled(false);
                }
            }
        });

        binding.btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMasuk == 0) {
                    proses = binding.process.getText().toString();
                    if (operator == null) {
                        binding.process.setText(proses + "x");
                    } else {
                        binding.process.setText(proses.substring(0, proses.length() - 1) + "x");
                    }
                    operator = "*";
                } else {
                    binding.btnBagi.setEnabled(false);
                    binding.btnTambah.setEnabled(false);
                    binding.btnKurang.setEnabled(false);
                }
            }
        });

        binding.btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMasuk == 0) {
                    proses = binding.process.getText().toString();
                    if (operator == null) {
                        binding.process.setText(proses + "/");
                    } else {
                        binding.process.setText(proses.substring(0, proses.length() - 1) + "/");
                    }
                    operator = "/";
                } else {
                    binding.btnKali.setEnabled(false);
                    binding.btnTambah.setEnabled(false);
                    binding.btnKurang.setEnabled(false);
                }
            }
        });


        binding.btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 double first = 0;
                 int second = 0;
                 proses = binding.process.getText().toString();
                 String hasil[] = proses.split("[x+-/]");

                try {
                    System.out.println(hasil[1]);
                    double satu = Integer.parseInt(hasil[0]);
                    double dua = Integer.parseInt(hasil[1]);

                    if(operator == "*"){
                        second = (int) satu * (int) dua;
                        System.out.println(second);
                        binding.result.setText(String.valueOf(second));
                    }
                    else if (operator == "+"){
                        second = (int) satu + (int) dua;
                        binding.result.setText(String.valueOf(second));
                    }
                    else if (operator == "-"){
                        second = (int) satu - (int) dua;
                        binding.result.setText(String.valueOf(second));
                    }
                    else if (operator == "/"){
                        first = satu / dua;
                        DecimalFormat format = new DecimalFormat("0.#");
                        String last = (format.format(first));
                        binding.result.setText(last);
                    }
                } catch (Exception e){

                }
            }
        });

    }
}

