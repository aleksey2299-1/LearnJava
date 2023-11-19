package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }
    public void handleClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data
    ) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Пользователь вышел из ThirdActivity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        TextView name = findViewById(R.id.text);
                        name.setText("Hello, " + text + "!");
                    }
                }
            }
        }
    }
}
