package com.example.project;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);

        EditText etData = findViewById(R.id.etData);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> {
            // Write data to SharedPreferences
            String data = etData.getText().toString();
            sharedPreferences.edit().putString("data", data).apply();
            finish();
        });
    }
}
