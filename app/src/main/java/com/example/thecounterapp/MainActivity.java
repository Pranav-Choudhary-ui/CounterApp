package com.example.thecounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    Here variables and functions can be defined before use as in other languages like C/C++
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView counter = findViewById(R.id.textView2);
        Button myBtn = findViewById(R.id.button);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Simply calling the function crashes the app because th setText() accepts the string
//                but the increaseCounter() returns the int value
//                counter.setText(""+increaseCounter());
                counter.setText(String.valueOf(increaseCounter()));
//                Instead of this we can also use this syntax -> counter.setText(String.valueOf(increaseCounter()));
            }
        });
    }

    public int increaseCounter(){
        return ++value;
    }

}