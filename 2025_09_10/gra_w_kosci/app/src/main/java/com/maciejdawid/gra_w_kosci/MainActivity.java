package com.maciejdawid.gra_w_kosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView[] diceViews;
    private TextView rollResult, gameResult;
    private Button btnRoll, btnReset;
    private int gameTotal = 0;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceViews = new ImageView[5];
        diceViews[0] = findViewById(R.id.img1);
        diceViews[1] = findViewById(R.id.img2);
        diceViews[2] = findViewById(R.id.img3);
        diceViews[3] = findViewById(R.id.img4);
        diceViews[4] = findViewById(R.id.img5);

        rollResult = findViewById(R.id.lottery_results);
        gameResult = findViewById(R.id.game_result);

        btnRoll = findViewById(R.id.button);
        btnReset = findViewById(R.id.reset_result);

        random = new Random();

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        resetGame();
    }

    private void rollDice() {
        int rollSum = 0;
        for (int i = 0; i < diceViews.length; i++) {
            int value = random.nextInt(6) + 1;
            rollSum += value;
            int resId = getDiceDrawableForValue(value);
            diceViews[i].setImageResource(resId);
        }
        rollResult.setText("Wynik tego losowania: " + rollSum);
        gameTotal += rollSum;
        gameResult.setText("Wynik gry: " + gameTotal);
    }

    private int getDiceDrawableForValue(int value) {
        switch (value) {
            case 1: return R.drawable.k1;
            case 2: return R.drawable.k2;
            case 3: return R.drawable.k3;
            case 4: return R.drawable.k4;
            case 5: return R.drawable.k5;
            case 6: return R.drawable.k6;
            default: return R.drawable.question;
        }
    }

    private void resetGame() {
        for (ImageView iv : diceViews) {
            iv.setImageResource(R.drawable.question);
        }
        gameTotal = 0;
        rollResult.setText("Wynik tego losowania: 0");
        gameResult.setText("Wynik gry: 0");
    }
}