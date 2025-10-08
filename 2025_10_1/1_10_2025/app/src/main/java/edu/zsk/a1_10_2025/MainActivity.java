package edu.zsk.a1_10_2025;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView sizeValue, quoteText;
    private SeekBar fontSeekBar;
    private Button changeQuoteButton;
    private String[] quotes;
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeValue = findViewById(R.id.sizeValue);
        quoteText = findViewById(R.id.quoteText);
        fontSeekBar = findViewById(R.id.fontSeekBar);
        changeQuoteButton = findViewById(R.id.changeQuoteButton);

        quotes = new String[]{
                getString(R.string.quote_1),
                getString(R.string.quote_2),
                getString(R.string.quote_3)
        };

        fontSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sizeValue.setText(String.valueOf(progress));
                quoteText.setTextSize(progress);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        changeQuoteButton.setOnClickListener(v -> {
            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
            quoteText.setText(quotes[currentQuoteIndex]);
        });
    }
}