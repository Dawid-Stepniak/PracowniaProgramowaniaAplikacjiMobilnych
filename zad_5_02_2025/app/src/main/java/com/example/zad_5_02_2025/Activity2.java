package com.example.zad_5_02_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}