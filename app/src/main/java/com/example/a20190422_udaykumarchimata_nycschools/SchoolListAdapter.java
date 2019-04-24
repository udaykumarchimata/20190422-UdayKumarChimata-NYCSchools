package com.example.a20190422_udaykumarchimata_nycschools;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolNameViewHolder> {

    private Context context;
    private ArrayList<schoolSatData> schoolArrayList;
    private View.OnClickListener onClickListener;

    protected SchoolListAdapter(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
    }

    protected void setSchoolArrayList(ArrayList<schoolSatData> schoolArrayList) {
        this.schoolArrayList = schoolArrayList;
    }


    @NonNull
    @Override
    public SchoolNameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedLayoutResource = inflater.inflate(R.layout.school_name, viewGroup, false);
        SchoolNameViewHolder schoolNameViewHolder = new SchoolNameViewHolder(inflatedLayoutResource);
        return schoolNameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolNameViewHolder schoolNameViewHolder, int i) {
        schoolNameViewHolder.setSchoolName(i);
    }

    @Override
    public int getItemCount() {
        return schoolArrayList.size();
    }

    public class SchoolNameViewHolder extends RecyclerView.ViewHolder {
        private TextView schoolName;
        private RelativeLayout schoolLayout;

        public SchoolNameViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.school_name_text);
            schoolLayout = itemView.findViewById(R.id.school_name_layout);
        }

        private void setSchoolName(int position) {
            schoolName.setText(schoolArrayList.get(position).getSchoolName());
            schoolLayout.setTag(position);
            schoolLayout.setOnClickListener(onClickListener);
        }

    }

}
