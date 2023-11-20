package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 100;
    static final String NAME="NAME";

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            TextView textView = findViewById(R.id.text);
            if (result.getResultCode() == Activity.RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Пользователь вышел из ThirdActivity", Toast.LENGTH_SHORT).show();
            } else if (result.getResultCode() == Activity.RESULT_OK){
                Intent intent = result.getData();
                String name = intent.getStringExtra(NAME);
                textView.setText("Hello, " + name + "!");
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void loginClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void resultTest(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        mStartForResult.launch(intent);
    }
}
