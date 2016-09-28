package com.example.habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddHabitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        Button doneButton = (Button) findViewById(R.id.AddPage_done_button);
        Button repeatButton = (Button) findViewById(R.id.AddPage_repeat_button);


        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        repeatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(AddHabitActivity.this, RepeatPageActivity.class);
                startActivity(intent);
            }
        });

    }

}
