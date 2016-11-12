package com.example.dmitriy.shedule_new.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmitriy.shedule_new.MainActivity;
import com.example.dmitriy.shedule_new.R;

import java.util.Objects;

import static com.example.dmitriy.shedule_new.MainActivity.spinner;

public class monday extends Fragment {

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.monday, container,false);
        TextView textView = (TextView)rootView.findViewById(R.id.textView1);
        //if (Objects.equals(spinner.getSelectedItem().toString(), "ПС-1501")) textView.setText("PS1");
        //else textView.setText("PS000");
        return rootView;
    }
}
