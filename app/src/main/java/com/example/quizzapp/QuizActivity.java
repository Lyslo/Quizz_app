package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class QuizActivity extends AppCompatActivity {

    private int score;
    private int attempts;
    private Item currentItem;
    private List<Item> randomItems;
    private Database database;
    private ArrayList<Item> itemList;
    private ImageView itemImageView;
    private TextView scoreText;
    private TextView timerText;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private String mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View view = findViewById(android.R.id.content);

        score = 0;
        attempts = 0;

        itemImageView = view.findViewById(R.id.imageView);
        scoreText = view.findViewById(R.id.score);
        timerText = view.findViewById(R.id.timer);
        option1Button = view.findViewById(R.id.button1);
        option2Button = view.findViewById(R.id.button2);
        option3Button = view.findViewById(R.id.button3);

        mode = getIntent().getStringExtra("mode");
        if (mode.equals("easy")) {
            // Do something for easy mode
            setUpQuiz();
        } else if (mode.equals("hard")) {
            // Do something for hard mode
            setUpHardQuiz();
        }


        Button nextButton = findViewById(R.id.button4);

        nextButton.setOnClickListener(view1 -> setUpQuiz());

        Button closeButton = (Button) findViewById(R.id.button5);
        closeButton.setOnClickListener(view12 -> finish());
    }


    private void setUpQuiz() {

        database = Database.getInstance(itemList);

        currentItem = database.getRandomItem();
        itemImageView.setImageBitmap(currentItem.getImage());

        List<Button> buttons = Arrays.asList(option1Button, option2Button, option3Button);
        int correctOptionIndex = new Random().nextInt(3);
        buttons.get(correctOptionIndex).setText(currentItem.getName());


        for (int i = 0; i < buttons.size(); i++) {
            if (i == correctOptionIndex) continue;
            Item randomItem = database.getRandomItem();
            while (randomItem.getName() == currentItem.getName()) {
                randomItem = database.getRandomItem();
            }
            buttons.get(i).setText(randomItem.getName());
        }


        scoreText.setText("Score: " + score + " / " + attempts);


    }

    private void setUpHardQuiz(){
        // Do something for hard mode
        setUpQuiz();


            new CountDownTimer(30000, 1000) { // 30 seconds countdown, update every second
                public void onTick(long millisUntilFinished) {
                    timerText.setText("Seconds remaining: " + millisUntilFinished / 1000);
                }

                public void onFinish() {
                    attempts++;
                    setUpHardQuiz();
                }
            }.start();


    }


}

