package com.example.zad_12_02_2025;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    int amountOfClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(savedInstanceState != null){
        amountOfClicks = savedInstanceState.getInt("savedCount");
        }
        TextView userNameInput = findViewById(R.id.userNameInput);
        TextView userEmailInput = findViewById(R.id.userEmailInput);
        TextView greeting = findViewById(R.id.txt1);
        TextView clickerCounter = findViewById(R.id.txt2);
        Button button = findViewById(R.id.button);
        clickerCounter.setText("Kliknąłeś przycisk " + amountOfClicks + " razy");

        button.setOnClickListener(l->{
            if(!userNameInput.getText().toString().isEmpty()&&  !userEmailInput.getText().toString().isEmpty())
            {
                greeting.setText("Witaj " + userNameInput.getText() + "! Twój adres e-mail to: " + userEmailInput.getText());
                amountOfClicks++;
                clickerCounter.setText("Kliknąłeś przycisk "+ amountOfClicks +" razy");
            }
            else
            {
                Toast.makeText(this,"Najpierw uzupełnij swoje dane", Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("savedCount",amountOfClicks);
        super.onSaveInstanceState(savedInstanceState);
    }


}