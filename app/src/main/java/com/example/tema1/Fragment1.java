package com.example.tema1;

import static java.util.Arrays.asList;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;

public class Fragment1 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView animalsListView;
    static ArrayAdapter<String> arrayAdapter;
    SharedPreferences sharedPreferences;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animalsListView = (ListView)view.findViewById(R.id.animals_list_view);

        ArrayList<AnimalModel> animals = new ArrayList<>(Arrays.asList(
                new AnimalModel("Leu", "Europa"),
                new AnimalModel("Leopard", "Asia"),
                new AnimalModel("Panda", "America"),
                new AnimalModel("Elefant", "Africa"),
                new AnimalModel("Kangaroo", "Australia"),
                new AnimalModel("Lup", "Europa"),
                new AnimalModel("Tigru", "Europa"),
                new AnimalModel("Iepure", "Europa"),
                new AnimalModel("Veverita", "Europa"),
                new AnimalModel("Maimuta", "Asia"),
                new AnimalModel("Cangur", "Asia"),
                new AnimalModel("Tigrul Siberian", "Asia"),
                new AnimalModel("Elefant Indian", "Asia"),
                new AnimalModel("Panda Rosie", "Asia"),
                new AnimalModel("Crocodil", "Europa"),
                new AnimalModel("Vulpea Arctică", "Europa"),
                new AnimalModel("Bursuc", "Europa"),
                new AnimalModel("Mistret", "Europa"),
                new AnimalModel("Gorila", "Asia"),
                new AnimalModel("Puma", "Asia"),
                new AnimalModel("Maimuta Capucin", "Asia"),
                new AnimalModel("Urs Polar", "Asia"),
                new AnimalModel("Coyote", "America"),
                new AnimalModel("Lama", "America"),
                new AnimalModel("Jaguar", "America"),
                new AnimalModel("Veverita de copac", "America"),
                new AnimalModel("Zebra", "Africa"),
                new AnimalModel("Rinocer Alb", "Africa"),
                new AnimalModel("Leopardul Africat", "Africa"),
                new AnimalModel("Hipopotam", "Africa"),
                new AnimalModel("Leul African", "Africa"),
                new AnimalModel("Wombat", "Australia"),
                new AnimalModel("Diavolul Tasmanian", "Australia"),
                new AnimalModel("Koala", "Australia"),
                new AnimalModel("Cameleon", "Australia"),
                new AnimalModel("Cainele Dingo", "Australia"),
                new AnimalModel("Girafa", "Africa"),
                new AnimalModel("Mamba Verde", "Africa"),
                new AnimalModel("Sarpele Cobra", "Asia"),
                new AnimalModel("Iepurele de Camp", "Europa"),
                new AnimalModel("Vulpea", "Europa"),
                new AnimalModel("Liliac", "Europa"),
                new AnimalModel("Lupul Rosu", "America"),
                new AnimalModel("Pasarea Calatoare", "America"),
                new AnimalModel("Pisica Salbatica", "America"),
                new AnimalModel("Puma Montezuma", "America"),
                new AnimalModel("Bufnita", "Europa"),
                new AnimalModel("Jderul", "Europa"),
                new AnimalModel("Liliacul Comun", "Europa"),
                new AnimalModel("Tapirul", "America"),
                new AnimalModel("Lupul Cenusiu", "America"),
                new AnimalModel("Tapirul de Munte", "America"),
                new AnimalModel("Vulturul Bald", "America"),
                new AnimalModel("Cangurul Mic", "Australia"),
                new AnimalModel("Cangurul Mare", "Australia"),
                new AnimalModel("Wallaby", "Australia"),
                new AnimalModel("Emu", "Australia"),
                new AnimalModel("Kookaburra", "Australia"),
                new AnimalModel("Casuar", "Australia"),
                new AnimalModel("Vulpea Tasmaniana", "Australia"),
                new AnimalModel("Tursiops", "Europa")

        ));


        ArrayList <String> animalsData = new ArrayList<String>();
        for(int index = 0; index< animals.size(); index++)
        {
            animalsData.add(animals.get(index).displayAnimal());
        }
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, animalsData);
        animalsListView.setAdapter(arrayAdapter);

        animalsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity =(MainActivity)getActivity();
                sharedPreferences = mainActivity.getApplicationContext().getSharedPreferences("com.example.tema1", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("animal", animals.get(i).getName()).apply();
                sharedPreferences.edit().putString("continent", animals.get(i).getContinent()).apply();
                replaceFragment(new Fragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();//getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.i("change", "ok");
    }
}
