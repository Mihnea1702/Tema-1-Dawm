package com.example.tema1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences;
        MainActivity mainActivity = (MainActivity) getActivity();
        sharedPreferences = mainActivity.getApplicationContext().getSharedPreferences("com.example.tema1", Context.MODE_PRIVATE);
        String animal = sharedPreferences.getString("animal", "animal");
        String continent = sharedPreferences.getString("continent", "continent");

        TextView nameTextView = mainActivity.findViewById(R.id.name);
        TextView continentTextView = mainActivity.findViewById(R.id.continent);
        TextView lineTextView = mainActivity.findViewById(R.id.lineTextView);
        FrameLayout frameLayout = mainActivity.findViewById(R.id.background);

        if(continent.equals("Europa")) {
            frameLayout.setBackgroundColor(Color.parseColor("#B2F0B1"));
            lineTextView.setActivated(false);
            lineTextView.setVisibility(View.INVISIBLE);
            nameTextView.setGravity(Gravity.RIGHT);
            continentTextView.setGravity(Gravity.RIGHT);
        }
        if(continent.equals("Africa")) {
            frameLayout.setBackgroundColor(Color.parseColor("#FBFF00"));
            nameTextView.setGravity(Gravity.RIGHT);
            continentTextView.setGravity(Gravity.RIGHT);
        }

        if(continent.equals("Asia")) {
            frameLayout.setBackgroundColor(Color.parseColor("#FAE0DB"));
            lineTextView.setRotation(90);
            nameTextView.setGravity(Gravity.LEFT);
            continentTextView.setGravity(Gravity.RIGHT);
        }
        if(continent.equals("America")) {
            frameLayout.setBackgroundColor(Color.parseColor("#9DBFEE"));
            lineTextView.setActivated(false);
            lineTextView.setVisibility(View.INVISIBLE);
            nameTextView.setGravity(Gravity.RIGHT);
            continentTextView.setGravity(Gravity.RIGHT);
        }
        if(continent.equals("Australia")) {
            frameLayout.setBackgroundColor(Color.parseColor("#FEAF48"));
            lineTextView.setActivated(false);
            lineTextView.setVisibility(View.INVISIBLE) ;
            nameTextView.setGravity(Gravity.CENTER);
            continentTextView.setGravity(Gravity.CENTER);
        }




        Log.i("animal 3", animal);
        Log.i("continent", continent);
        nameTextView.setText(animal);
        continentTextView.setText(continent);
    }
}