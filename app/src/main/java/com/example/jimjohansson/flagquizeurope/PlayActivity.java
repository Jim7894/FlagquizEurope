package com.example.jimjohansson.flagquizeurope;

import android.icu.text.StringSearch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private ImageView IV;
    private Button b1;
    private Button b2;
    private Button b3;
    private int current_image;


    int[] images = {R.drawable.swedish_flag, R.drawable.estonian_flag, R.drawable.polish_flag, R.drawable.luxembourg_flag, R.drawable.ireland_flag};
    String[] answers = {"Sweden", "Estonia", "Poland", "Luxembourg", "Ireland"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        IV = (ImageView) findViewById(R.id.imageView4);
        //note a single Random object is reused here
        Random randomGenerator = new Random();

        int randomFlagIndex = randomGenerator.nextInt(images.length);

        IV.setImageResource(images[randomFlagIndex]);

        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button6);
        b3 = (Button) findViewById(R.id.button7);

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);

        int randomButtonIndex = randomGenerator.nextInt(buttons.size());

        Button rightButton = buttons.get(randomButtonIndex);
        buttons.remove(rightButton);
        rightButton.setText(answers[randomFlagIndex]);


        for (Button button : buttons) {

            int i;
            // loopa tills vi får ett felaktigt svar
            do {
                i = randomGenerator.nextInt(answers.length);
            } while (answers[i] == answers[randomFlagIndex]);

            button.setText(answers[i]);
        }

        //buttonclick();
    }

/*
    public void buttonclick()
    {

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        //current_image++;
                       //current_image=current_image % images.length;
                       //IV.setImageResource(images[current_image]);
                    }
                }
        );

    }
    */

    }




