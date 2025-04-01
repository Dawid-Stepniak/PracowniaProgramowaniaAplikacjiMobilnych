package com.example.zad_5_02_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        button4 = findViewById(R.id.button4);

        button4.setOnClickListener(v -> {
            Intent intent = new Intent(Activity3.this, MainActivity.class);
            startActivity(intent);
        });
    }
}