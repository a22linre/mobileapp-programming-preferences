package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);

        Button btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity);
        tvData = findViewById(R.id.tvData);

        btnOpenSecondActivity.setOnClickListener(view -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Read data from SharedPreferences
        String data = sharedPreferences.getString("data", "");
        tvData.setText(data);
    }
}
