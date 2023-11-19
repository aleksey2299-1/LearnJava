package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(10, getColor(R.color.black));
        gradientDrawable.setCornerRadius(50);

        ScrollView scrollView = new ScrollView(this);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(10,10,10,10);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setClickable(true);
        linearLayout1.setBackground(gradientDrawable);
        linearLayout1.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView textView = new TextView(this);
        textView.setText("Заголовок");
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


        View view = new View(this);
        view.setBackgroundColor(getColor(R.color.black));
        view.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, 5));


        TextView textView1 = new TextView(this);
        textView1.setText("Вся информация, желательно на несколько строк");
        textView1.setTextSize(50);
        textView1.setPadding(15,0,15, 15);
        textView.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


        linearLayout1.addView(textView);
        linearLayout1.addView(view);
        linearLayout1.addView(textView1);

        linearLayout.addView(linearLayout1);

        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}