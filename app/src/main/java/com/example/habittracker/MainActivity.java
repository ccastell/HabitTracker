package com.example.habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.Main_add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            // TODO Auto-generated method stub
            Intent intent=new Intent(MainActivity.this, AddHabitActivity.class);
            startActivity(intent);
            }
        });


    }

}
