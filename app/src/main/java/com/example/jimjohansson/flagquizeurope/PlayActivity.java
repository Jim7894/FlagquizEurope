package com.example.jimjohansson.flagquizeurope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private ImageView flagView;
    private Button b1;
    private Button b2;
    private Button b3;
    private TextView pointview;

    private int current_image;
    static int points = 0;


    static List<Integer> images = new ArrayList(Arrays.asList(R.drawable.swedish_flag, R.drawable.estonian_flag, R.drawable.polish_flag, R.drawable.luxembourg_flag, R.drawable.ireland_flag, R.drawable.hungarian_flag, R.drawable.belarusian_flag, R.drawable.russian_flag, R.drawable.slovenian_flag, R.drawable.greek_flag, R.drawable.moldavian_flag, R.drawable.monaco_flag));
    static List<String> answers = new ArrayList(Arrays.asList("Sweden", "Estonia", "Poland", "Luxembourg", "Ireland", "Hungary", "Belarus", "Russia", "Slovenia", "Greece", "Moldova", "Manoco"));
    List<String> answersOnButtons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        pointview = findViewById(R.id.textView3);
        flagView = (ImageView) findViewById(R.id.imageView4);
        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button6);
        b3 = (Button) findViewById(R.id.button7);

        fillScreen();

    }

    private void fillScreen() {
        pointview.setText(String.valueOf(points));
        //note a single Random object is reused here
        Random randomGenerator = new Random();

        final int rightAnswerIndex = randomGenerator.nextInt(images.size());

        flagView.setImageResource(images.get(rightAnswerIndex));

        ArrayList<Button> buttons = new ArrayList<>();

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

        int rightButtonIndex = randomGenerator.nextInt(buttons.size());

        final Button rightButton = buttons.get(rightButtonIndex);
        buttons.remove(rightButton);
        rightButton.setText(answers.get(rightAnswerIndex));
        answersOnButtons.add(answers.get(rightAnswerIndex));


        //wrong buttons
        for (Button button : buttons) {
            int wrongAnswerIndex;
            // loop till we get wrong answer
            do {
                wrongAnswerIndex = randomGenerator.nextInt(answers.size());
            } while (answersOnButtons.contains(answers.get(wrongAnswerIndex)));

            button.setText(answers.get(wrongAnswerIndex));
            answersOnButtons.add(answers.get(wrongAnswerIndex));


            button.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            fillScreen();

                        }
                    }


            );

        }

        rightButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      
                        points++;
                        fillScreen();

                        /*Intent myIntent = new Intent(PlayActivity.this,
                                PlayActivity.class);
                        startActivity(myIntent);*/


                    }
                }
        );

        images.remove(rightAnswerIndex);
        answers.remove(rightAnswerIndex);


    }


}









