package edu.zsk.a2025_10_8;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText user_input;
    Button buttonAdd;
    ListView listViewNotes;
    ArrayList<String> notes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_input = findViewById(R.id.user_input);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewNotes = findViewById(R.id.listViewNotes);

        notes = new ArrayList<>();
        notes.add("Zakupy, chleb, masło, ser");
        notes.add("Do zrobienia: obiad, umyć podłog");
        notes.add("Weekend: kino, spacer z psem");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listViewNotes.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = user_input.getText().toString().trim();
                if (!text.isEmpty()) {
                    notes.add(text);
                    adapter.notifyDataSetChanged();
                    user_input.setText("");
                }
            }
        });
    }
}