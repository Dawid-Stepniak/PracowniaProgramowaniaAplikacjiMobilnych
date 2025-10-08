package edu.zsk.a24_09_2025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editPralka;
    private Button buttonZatwierdz, buttonOdkurzacz;
    private TextView textNumerPrania, textOdkurzacz;
    private boolean odkurzaczWlaczony = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPralka = findViewById(R.id.editPralka);
        buttonZatwierdz = findViewById(R.id.buttonZatwierdz);
        textNumerPrania = findViewById(R.id.textNumerPrania);

        buttonOdkurzacz = findViewById(R.id.buttonOdkurzacz);
        textOdkurzacz = findViewById(R.id.textOdkurzacz);

        buttonZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numer = editPralka.getText().toString().trim();

                if (numer.isEmpty()) {
                    textNumerPrania.setText("Numer prania: nie podano");
                } else {
                    int n = Integer.parseInt(numer);
                    if (n >= 1 && n <= 12) {
                        textNumerPrania.setText("Numer prania: " + n);
                    } else {
                        textNumerPrania.setText("Numer prania: niepoprawny");
                    }
                }
            }
        });

        buttonOdkurzacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odkurzaczWlaczony = !odkurzaczWlaczony;

                if (odkurzaczWlaczony) {
                    buttonOdkurzacz.setText("Wyłącz");
                    textOdkurzacz.setText("Odkurzacz włączony");
                } else {
                    buttonOdkurzacz.setText("Włącz");
                    textOdkurzacz.setText("Odkurzacz wyłączony");
                }
            }
        });
    }
}