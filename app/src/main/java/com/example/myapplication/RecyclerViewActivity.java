package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {


    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // определяем слушателя нажатия элемента в списке
        StateAdapter2.OnStateClickListener stateClickListener = new StateAdapter2.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {

                Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getName(),
                        Toast.LENGTH_SHORT).show();
            }

            ;
        };
        // создаем адаптер
        StateAdapter2 adapter = new StateAdapter2(this, states, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State ("Норвегия", "Осло", R.drawable.norway));
        states.add(new State ("Швеция", "Стокгольм", R.drawable.sweden));
        states.add(new State ("Дания", "Копенгаген", R.drawable.denmark));
        states.add(new State ("Финляндия", "Хельсинки", R.drawable.finland));
        states.add(new State ("Санкт-Петербург", "Разводной мост", R.drawable.russia));
    }
}