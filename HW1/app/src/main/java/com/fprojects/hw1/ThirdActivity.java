package com.fprojects.hw1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Button toMainActBtn;
    Button thirdActPrevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        toMainActBtn = (Button) findViewById(R.id.toMainActBtn);
        toMainActBtn.setOnClickListener(this);

        thirdActPrevBtn = (Button) findViewById(R.id.thirdActPrevBtn);
        initThirdActPrevBtnListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toMainActBtn:
                finish();
                Intent toMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                toMainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(toMainActivity);
                break;
            default:
                break;
        }
    }

    private void initThirdActPrevBtnListener() {
        final Button startPrevActivityBtn = findViewById( R.id.thirdActPrevBtn );
        startPrevActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.thirdActPrevBtn:
                        Intent toPreviousActivity = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(toPreviousActivity);
                        break;
                    default:
                        break;
                }
            }
        });
    }



}