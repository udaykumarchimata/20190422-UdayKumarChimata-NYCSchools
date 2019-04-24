package com.example.a20190422_udaykumarchimata_nycschools;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<schoolSatData> schoolArrayList;
    private SchoolListAdapter schoolListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        initRecyclerView();
        SchoolListFetchViewModel schoolListFetchViewModel = ViewModelProviders.of(this).get(SchoolListFetchViewModel.class);
        schoolListFetchViewModel.getUsers().observe(this, new Observer<ArrayList<schoolSatData>>() {
            @Override
            public void onChanged(@Nullable ArrayList<schoolSatData> schoolSatData) {
                schoolArrayList = schoolSatData;
                populateRecyclerView();
            }
        });


    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        schoolListAdapter = new SchoolListAdapter(getApplicationContext(), this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
    }


    private void populateRecyclerView() {
        schoolListAdapter.setSchoolArrayList(schoolArrayList);
        recyclerView.setAdapter(schoolListAdapter);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.school_name_layout) {
            int position = (int) v.getTag();
            Intent intent = new Intent(this, SchoolScoreDetails.class);
            intent.putExtra(getString(R.string.school_sat_data), schoolArrayList.get(position));
            startActivity(intent);
        }
    }
}
