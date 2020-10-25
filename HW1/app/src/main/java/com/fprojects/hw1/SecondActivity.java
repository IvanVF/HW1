package com.fprojects.hw1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button secondActNextBtn;
    Button secondActPrevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondd);

        secondActNextBtn = (Button) findViewById(R.id.secondActNextBtn);
        secondActNextBtn.setOnClickListener(this);

        secondActPrevBtn = (Button) findViewById(R.id.secondActPrevBtn);
        initSecondActPrevBtnListener();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.secondActNextBtn:
                Intent toThirdActivity = new Intent(this, ThirdActivity.class);
                startActivity(toThirdActivity);
                break;
            default:
                break;
        }
    }

    private void initSecondActPrevBtnListener() {
        final Button startPrevActivityBtn = findViewById( R.id.secondActPrevBtn );
        startPrevActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.secondActPrevBtn:
                        Intent toPreviousActivity = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(toPreviousActivity);
                        break;
                    default:
                        break;
                }
            }
        });
    }

}