package com.example.tugasprak3quiz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    TextView question;
    TextView tv_totalQuestion;
    Button opsi1, opsi2, opsi3, opsi4;
    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    User user;
    Photo fotolagi;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = findViewById(R.id.tv_question);
        tv_totalQuestion = findViewById(R.id.totalquestion);
        opsi1 = findViewById(R.id.option1);
        opsi2 = findViewById(R.id.option2);
        opsi3 = findViewById(R.id.option3);
        opsi4 = findViewById(R.id.option4);


        opsi1.setOnClickListener(this);
        opsi2.setOnClickListener(this);
        opsi3.setOnClickListener(this);
        opsi4.setOnClickListener(this);

        user = getIntent().getParcelableExtra("user");
        fotolagi = getIntent().getParcelableExtra("fotoback");

        loadNewQuestion();
    }

    public void onClick(View view) {
        Button clickedButton = (Button) view;
        String selectedAnswer = ((Button) view).getText().toString().trim();
        if (selectedAnswer.equalsIgnoreCase(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
            clickedButton.setBackgroundColor(getResources().getColor(R.color.CORRECT));
            score += 130;
        } else {
            clickedButton.setBackgroundColor(getResources().getColor(R.color.WRONG));
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentQuestionIndex++;
                loadNewQuestion();
            }
        }, 1000);

    }

    private void loadNewQuestion() {
        if (currentQuestionIndex < totalQuestion) {
            tv_totalQuestion.setText(String.format("Quiz %d of %d", currentQuestionIndex + 1, totalQuestion));
            opsi1.setBackgroundColor(getResources().getColor(R.color.white));
            opsi2.setBackgroundColor(getResources().getColor(R.color.white));
            opsi3.setBackgroundColor(getResources().getColor(R.color.white));
            opsi4.setBackgroundColor(getResources().getColor(R.color.white));

            question.setText(QuestionAnswer.question[currentQuestionIndex]);
            opsi1.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
            opsi2.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
            opsi3.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
            opsi4.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
        } else {
            Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("user", user);
            intent.putExtra("fotolagi", fotolagi);
            startActivity(intent);
        }
    }
}

