package com.example.a20190422_udaykumarchimata_nycschools;

import android.arch.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkCall implements Runnable {

    private MutableLiveData<ArrayList<schoolSatData>> schoolArrayListLiveData;

    public NetworkCall(MutableLiveData<ArrayList<schoolSatData>> schoolArrayListLiveData) {
        this.schoolArrayListLiveData = schoolArrayListLiveData;
    }


    @Override
    public void run() {
        try {
            String url = "https://data.cityofnewyork.us/resource/f9bf-2cp4.json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONArray jsonArray = new JSONArray(response.toString());

            final ArrayList<schoolSatData> schoolArrayList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                schoolSatData schoolSatData = new schoolSatData();
                schoolSatData.setAvgCriticalReadingScore(jsonObject.getString("sat_critical_reading_avg_score"));
                schoolSatData.setAvgMathScore(jsonObject.getString("sat_math_avg_score"));
                schoolSatData.setAvgWritingScore(jsonObject.getString("sat_writing_avg_score"));
                schoolSatData.setSchoolName(jsonObject.getString("school_name"));
                schoolSatData.setSatTestTakers(jsonObject.getString("num_of_sat_test_takers"));
                schoolArrayList.add(schoolSatData);
            }

            schoolArrayListLiveData.postValue(schoolArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
