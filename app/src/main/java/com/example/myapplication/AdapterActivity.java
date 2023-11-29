package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdapterActivity extends AppCompatActivity {

    /* набор данных, которые свяжем со списком(вариант для кода, можно в values.xml)
    String[] countries = { "Норвегия", "Дания", "Швеция", "Финляндия", "Санкт-Петербург"};

    а можно, это все определить в xml страницы через android:entries
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        /*
        // получаем элемент ListView
        ListView countriesList = findViewById(R.id.choiceList);
        //для values.xml(убрать если string определен в коде)
        String[] countries = getResources().getStringArray(R.array.countries);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, countries);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);

         */
    }
}