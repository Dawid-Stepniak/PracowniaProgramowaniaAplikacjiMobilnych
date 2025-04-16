package com.example.zad_5_03_2025;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] imageResIds = {
            R.drawable.kot1, R.drawable.kot2, R.drawable.kot3, R.drawable.kot4,
            R.drawable.kot5, R.drawable.kot6, R.drawable.kot7, R.drawable.kot8,
            R.drawable.kot9, R.drawable.kot10, R.drawable.kot11, R.drawable.kot12,
            R.drawable.kot13, R.drawable.kot14, R.drawable.kot15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = findViewById(R.id.image_container);

        for (int resId : imageResIds) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resId);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 300);
            params.setMarginEnd(16);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setOnClickListener(v -> {
                ImageDialogFragment dialog = ImageDialogFragment.newInstance(resId);
                dialog.show(getSupportFragmentManager(), "image_dialog");
            });

            container.addView(imageView);
        }
    }
}