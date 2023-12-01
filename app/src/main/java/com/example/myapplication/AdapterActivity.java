package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AdapterActivity extends AppCompatActivity {

    // набор данных, которые свяжем со списком(вариант для кода, можно в values.xml)
    String[] countries = { "Норвегия", "Дания", "Швеция", "Финляндия", "Санкт-Петербург"};

    // можно, это все определить в xml страницы через android:entries
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        TextView selection = findViewById(R.id.selection);
        // получаем элемент ListView
        ListView countriesList = findViewById(R.id.choiceList);
        //для values.xml(убрать если string определен в коде)
        String[] countries = getResources().getStringArray(R.array.countries);

        /* создаем адаптер для выделения 1 эдлемента
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, countries);
         */
        // создаем адаптер для мультивыбора
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, countries);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
        /* обработчик кликов для выбора 1
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {

                TextView textView = (TextView) v;
                selection.setText(textView.getText());

                // по позиции получаем выбранный элемент
                // String selectedItem = (String)parent.getItemAtPosition(position);
                String selectedItem = countries[position];
                // установка текста элемента TextView
                selection.setText(selectedItem);
            }
        });
        */
        // обработчик кликов при мультивыборе
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                SparseBooleanArray selected=countriesList.getCheckedItemPositions();

                String selectedItems="";
                for(int i=0;i < countries.length;i++)
                {
                    if(selected.get(i))
                        selectedItems+=countries[i]+",";
                }
                // установка текста элемента TextView
                selection.setText("Выбрано: " + selectedItems);
            }
        });
    }
}