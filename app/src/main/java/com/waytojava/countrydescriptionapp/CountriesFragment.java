package com.waytojava.countrydescriptionapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountriesFragment extends Fragment {


    private Context context;
    private ListView listView;
    private String[] countries;
    private MainActivity mainActivity;
    private OnCountrySelectedListener onCountrySelectedListener;

    public CountriesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        mainActivity.getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        listView = view.findViewById(R.id.listViewCountries);

        context = getContext();
        mainActivity = (MainActivity) context;
        countries = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> countriesNameAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(countriesNameAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (onCountrySelectedListener != null) {
                    onCountrySelectedListener.onCountrySelected(countries[position]);
                }
            }
        });
        return view;
    }

    public void setOnCountrySelectedListener(OnCountrySelectedListener onCountrySelectedListener) {
        this.onCountrySelectedListener = onCountrySelectedListener;
    }

}
