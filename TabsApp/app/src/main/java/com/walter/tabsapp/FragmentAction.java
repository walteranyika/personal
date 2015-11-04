package com.walter.tabsapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentAction extends Fragment {

    public FragmentAction() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_fragment_action, container, false);
        TextView tv= (TextView) rootView.findViewById(R.id.tv_action);
        tv.setText("Horror movies from 1990");
        return rootView;
    }


}
