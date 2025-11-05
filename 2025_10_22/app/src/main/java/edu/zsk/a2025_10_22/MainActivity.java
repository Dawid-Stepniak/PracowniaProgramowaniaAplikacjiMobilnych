package edu.zsk.a2025_10_22;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText ownerEdit;
    ListView speciesList;
    SeekBar ageSeek;
    TextView ageValue;
    EditText purposeEdit;
    TextView timeField;
    Button okButton;
    TextView resultText;
    String selectedSpecies = "";
    int hour = 16;
    int minute = 0;

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

        ownerEdit = findViewById(R.id.ownerEdit);
        speciesList = findViewById(R.id.speciesList);
        ageSeek = findViewById(R.id.ageSeek);
        ageValue = findViewById(R.id.ageValue);
        purposeEdit = findViewById(R.id.purposeEdit);
        timeField = findViewById(R.id.timeField);
        okButton = findViewById(R.id.okButton);
        resultText = findViewById(R.id.resultText);

        String[] species = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, species);
        speciesList.setAdapter(adapter);

        speciesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSpecies = species[position];
                if (selectedSpecies.equals("Pies")) {
                    ageSeek.setMax(18);
                } else if (selectedSpecies.equals("Kot")) {
                    ageSeek.setMax(20);
                } else {
                    ageSeek.setMax(9);
                }
                if (ageSeek.getProgress() > ageSeek.getMax()) {
                    ageSeek.setProgress(ageSeek.getMax());
                }
                ageValue.setText(String.valueOf(ageSeek.getProgress()));
            }
        });

        ageSeek.setMax(20);
        ageSeek.setProgress(0);
        ageValue.setText("0");

        ageSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        timeField.setText(formatTime(hour, minute));
        timeField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int h, int m) {
                        hour = h;
                        minute = m;
                        timeField.setText(formatTime(hour, minute));
                    }
                }, hour, minute, false);
                dialog.show();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String owner = ownerEdit.getText().toString();
                String speciesText = selectedSpecies;
                String ageText = ageValue.getText().toString();
                String purpose = purposeEdit.getText().toString();
                String time = timeField.getText().toString();
                String result = owner + ", " + speciesText + ", " + ageText + ", " + purpose + ", " + time;
                resultText.setText(result);
            }
        });
    }

    String formatTime(int h, int m) {
        int hour12 = h % 12;
        if (hour12 == 0) hour12 = 12;
        String ampm = h < 12 ? "AM" : "PM";
        return String.format(Locale.getDefault(), "%d:%02d %s", hour12, m, ampm);
    }
}