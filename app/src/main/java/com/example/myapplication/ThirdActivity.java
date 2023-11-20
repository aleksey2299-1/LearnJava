package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EditText nameText = findViewById(R.id.edit_text);

        // Код, если мы не задали android:onClick в .xml файле, иначе public void <название клика>
        Button button = findViewById(R.id.button);
        /* "->" это lambda функция, в данном случае вместо определения View.OnClickListener отдельно
        и передачи его в button.setOnClickListener(View.OnClickListener)
        мы с помощью lambda определили его внутри параметра
         */
        button.setOnClickListener(v -> {
            // Считываем значение поля
            String name = nameText.getText().toString();
            // Формируем "пустое" намерение
            Intent intent = new Intent();
            // Добавляем в намерение данные
            intent.putExtra(MainActivity.NAME, name);
            // Устанавливаем результат
            setResult(RESULT_OK, intent);
            // Закрываем Activity
            finish();
        });
    }
    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }


}