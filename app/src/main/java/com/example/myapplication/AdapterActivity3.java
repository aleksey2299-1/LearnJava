package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class AdapterActivity3 extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter3);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = findViewById(R.id.countriesList);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        states.add(new State ("Норвегия", "Осло", R.drawable.norway));
        states.add(new State ("Швеция", "Стокгольм", R.drawable.sweden));
        states.add(new State ("Дания", "Копенгаген", R.drawable.denmark));
        states.add(new State ("Финляндия", "Хельсинки", R.drawable.finland));
        states.add(new State ("Санкт-Петербург", "Разводной мост", R.drawable.russia));
    }
}