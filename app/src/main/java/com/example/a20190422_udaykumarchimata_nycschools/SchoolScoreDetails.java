package com.example.a20190422_udaykumarchimata_nycschools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SchoolScoreDetails extends AppCompatActivity {

    private TextView schoolScoreDetailsHeadline;
    private TextView satTestTakers;
    private TextView avgMathScore;
    private TextView avgCriticalReadingScore;
    private TextView avgWritingScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_sat_details);
        Intent intent = getIntent();
        schoolSatData schoolSatData = intent.getParcelableExtra(getString(R.string.school_sat_data));
        schoolScoreDetailsHeadline = findViewById(R.id.school_score_details_headline);
        satTestTakers = findViewById(R.id.tv_sat_test_takers);
        avgMathScore = findViewById(R.id.tv_avg_math_score);
        avgCriticalReadingScore = findViewById(R.id.tv_avg_critical_reading_score);
        avgWritingScore = findViewById(R.id.tv_avg_writing_score);
        schoolScoreDetailsHeadline.setText(getString(R.string.school_sat_headline, schoolSatData.getSchoolName()));
        satTestTakers.setText(schoolSatData.getSatTestTakers());
        avgMathScore.setText(schoolSatData.getAvgMathScore());
        avgCriticalReadingScore.setText(schoolSatData.getAvgCriticalReadingScore());
        avgWritingScore.setText(schoolSatData.getAvgWritingScore());
    }
}
