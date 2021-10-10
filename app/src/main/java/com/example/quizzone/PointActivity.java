package com.example.quizzone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PointActivity extends AppCompatActivity {

    private TextView pointText;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TOTALPOINTKEY = TAG + "TotalPoint";
    private static final String POINTKEY = TAG + "Point";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        Intent i = getIntent();
        pointText = findViewById(R.id.pointText);

        int result = i.getIntExtra(POINTKEY, 0);
        int totalPoint = i.getIntExtra(TOTALPOINTKEY, 0);

        String text = result + " / " + totalPoint;

        pointText.setText(text);

    }
}
