package edu.zsk.a2025_10_15;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button like = findViewById(R.id.like);
        Button delete = findViewById(R.id.delete);
        TextView counter_str = findViewById(R.id.counter);

        like.setOnClickListener(v -> {
            counter++;
            counter_str.setText(counter + " polubień");
        });

        delete.setOnClickListener(v -> {
            if (counter > 0) counter--;
            counter_str.setText(counter + " polubień");
        });

    }
}