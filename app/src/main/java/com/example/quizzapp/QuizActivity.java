package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;
import com.example.quizzapp.model.ItemDao;
import com.example.quizzapp.model.ItemDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class QuizActivity extends AppCompatActivity {

    private int score;
    private int attempts;
    private Item currentItem;
    private List<Item> randomItems;
    private ItemDao itemDao;
    private com.example.quizzapp.model.ItemDatabase ItemDatabase;
    private ImageView itemImageView;
    private TextView scoreText;
    private TextView timerText;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;

    private List<Button> buttons;
    private String mode;
    private CountDownTimer currenTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View view = findViewById(android.R.id.content);

        score = 0;
        attempts = -1;

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

        if (mode.equals("hard")) {
            nextButton.setOnClickListener(view1 -> setUpHardQuiz());
        } else {
            nextButton.setOnClickListener(view1 -> setUpQuiz());
        }


        Button closeButton = (Button) findViewById(R.id.button5);
        closeButton.setOnClickListener(view12 -> finish());
    }


    private void setUpQuiz() {

        attempts++;

        // Get instance of the database
        ItemDatabase itemDatabase = ItemDatabase.getDatabase(getApplicationContext());

        // Get instance of the DAO
        ItemDao itemDao = itemDatabase.itemDao();

        currentItem = itemDao.getRandomItem();
        itemImageView.setImageBitmap(currentItem.getImage());

        buttons = Arrays.asList(option1Button, option2Button, option3Button);
        resetButtons();
        int correctOptionIndex = new Random().nextInt(3);
        buttons.get(correctOptionIndex).setText(currentItem.getName());

        for (int i = 0; i < buttons.size(); i++) {
            if (i == correctOptionIndex) continue;
            Item randomItem = itemDao.getRandomItem();
            if(itemDao.getAllItems().size() > 1) {
                while (randomItem.getName() == currentItem.getName()) {
                    randomItem = itemDao.getRandomItem();
                }
            }
            buttons.get(i).setText(randomItem.getName());
        }


        scoreText.setText("Score: " + score + " / " + attempts);

        //Checks if the correct button has been clicked and does stuff
        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (((Button) view).getText().toString().equals(currentItem.getName())) {
                        score++;
                    }
                    for (Button b : buttons) {
                        if (b.getText().toString().equals(currentItem.getName())) {
                            b.setBackgroundColor(Color.GREEN);
                        } else {
                            b.setBackgroundColor(Color.RED);
                        }
                        b.setEnabled(false);
                    }

                }
            });
        }


    }

    private void setUpHardQuiz() {
        // Do something for hard mode
        setUpQuiz();

        if (currenTimer != null) {
            currenTimer.cancel();
        }
        currenTimer = new CountDownTimer(30000, 1000) { // 30 seconds countdown, update every second
            public void onTick(long millisUntilFinished) {
                timerText.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                setUpHardQuiz();
            }
        }.start();


    }


    private void resetButtons() {
        for (Button button : buttons) {
            button.setBackgroundColor(androidx.appcompat.R.attr.colorButtonNormal);
            button.setEnabled(true);
        }
    }


}

