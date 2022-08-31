package com.example.javatest;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class CheckBoxFragment extends Fragment implements View.OnClickListener {

    private ViewGroup rootView;
    private CheckBox big_cb, cb_1, cb_2, cb_3;
    private Button nextB;


    public CheckBoxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_check_box, container, false);

        allAgreeCheckBox();
        threeCheckBox();
        nextPage();

        return rootView;
    }

    public void allAgreeCheckBox() {
        big_cb = rootView.findViewById(R.id.checkBox_big);
        cb_1 = rootView.findViewById(R.id.checkBox_1);
        cb_2 = rootView.findViewById(R.id.checkBox_2);
        cb_3 = rootView.findViewById(R.id.checkBox_3);
        nextB = rootView.findViewById(R.id.button);

        nextB.setEnabled(false);

        big_cb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cb_1.setChecked(true);
                cb_2.setChecked(true);
                cb_3.setChecked(true);
                nextB.setEnabled(true);
            } else {
                cb_1.setChecked(false);
                cb_2.setChecked(false);
                cb_3.setChecked(false);
                nextB.setEnabled(false);
            }
        });
    }

    public void threeCheckBox() {
        big_cb = rootView.findViewById(R.id.checkBox_big);
        cb_1 = rootView.findViewById(R.id.checkBox_1);
        cb_2 = rootView.findViewById(R.id.checkBox_2);
        cb_3 = rootView.findViewById(R.id.checkBox_3);
        nextB = rootView.findViewById(R.id.button);

        cb_1.setOnClickListener(this);
        cb_2.setOnClickListener(this);
        cb_3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int total = 0;

        if (cb_1.isChecked()) {
            total += 1;
        } else { total -=1; }

        if (cb_2.isChecked()) {
            total += 1;
        } else { total -=1; }

        if (cb_3.isChecked()) {
            total += 1;
        } else { total -=1; }

        if (total == 3) {
            big_cb.setChecked(true);
        } else {
            big_cb.setChecked(false);
        }
    }


    public void nextPage() {
        nextB = rootView.findViewById(R.id.button);
        nextB.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return null;
    }
}