package com.example.a20190422_udaykumarchimata_nycschools;

import android.os.Parcel;
import android.os.Parcelable;

public class schoolSatData implements Parcelable {

    public schoolSatData() {

    }

    protected schoolSatData(Parcel in) {
        schoolName = in.readString();
        avgWritingScore = in.readString();
        avgCriticalReadingScore = in.readString();
        avgMathScore = in.readString();
        satTestTakers = in.readString();
    }

    public static final Creator<schoolSatData> CREATOR = new Creator<schoolSatData>() {
        @Override
        public schoolSatData createFromParcel(Parcel in) {
            return new schoolSatData(in);
        }

        @Override
        public schoolSatData[] newArray(int size) {
            return new schoolSatData[size];
        }
    };

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    private String schoolName;

    public String getAvgWritingScore() {
        return avgWritingScore;
    }

    public void setAvgWritingScore(String avgWritingScore) {
        this.avgWritingScore = avgWritingScore;
    }

    private String avgWritingScore;

    public String getAvgCriticalReadingScore() {
        return avgCriticalReadingScore;
    }

    public void setAvgCriticalReadingScore(String avgCriticalReadingScore) {
        this.avgCriticalReadingScore = avgCriticalReadingScore;
    }

    private String avgCriticalReadingScore;

    public String getAvgMathScore() {
        return avgMathScore;
    }

    public void setAvgMathScore(String avgMathScore) {
        this.avgMathScore = avgMathScore;
    }

    private String avgMathScore;

    public String getSatTestTakers() {
        return satTestTakers;
    }

    public void setSatTestTakers(String satTestTakers) {
        this.satTestTakers = satTestTakers;
    }

    private String satTestTakers;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(schoolName);
        dest.writeString(avgWritingScore);
        dest.writeString(avgCriticalReadingScore);
        dest.writeString(avgMathScore);
        dest.writeString(satTestTakers);
    }
}
