package com.example.a20190422_udaykumarchimata_nycschools;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class SchoolListFetchViewModel extends ViewModel {
    private MutableLiveData<ArrayList<schoolSatData>> schoolArrayListLiveData;

    public LiveData<ArrayList<schoolSatData>> getUsers() {
        if (schoolArrayListLiveData == null) {
            schoolArrayListLiveData = new MutableLiveData<>();
            loadUsers();
        }
        return schoolArrayListLiveData;
    }

    private void loadUsers() {
        // do async operation to fetch users
        NetworkCall networkCall = new NetworkCall(schoolArrayListLiveData);
        Thread networkCallThread = new Thread(networkCall);
        networkCallThread.start();
    }

}
